package ino.web.authorityTable.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ino.web.authorityTable.dto.AuthorityDto;
import ino.web.authorityTable.service.AuthorityService;

@Controller
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@RequestMapping("/authorityMain.ino")
	public ModelAndView authorityTableMain(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("authorityTableMain");	
		mav.addObject("list", authorityService.getGroupList());
		return mav;
	}
	
	@RequestMapping("/authorityDetail.ino")
	@ResponseBody
	public List<AuthorityDto> authorityTableDetail(@RequestParam String groupId){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", groupId);
		List<AuthorityDto> objectList = authorityService.selectObjectTableList();
		List<AuthorityDto> mappingList = authorityService.selectMappingTableListByGroupId(map);
		
		System.out.println("objectList ::: " + objectList);
		System.out.println("mappingList ::: " + mappingList);
		
		for (AuthorityDto authorityDto : objectList){
			if (mappingList.size() <= 0){
				authorityDto.setUseYn("미사용");
			}else{
				for (AuthorityDto mappingDto : mappingList){
					System.out.println("authorityDto.getObjId().toString() :: " + authorityDto.getObjId().toString());
					System.out.println("mappingDto.getObjId().toString() :: " + mappingDto.getObjId().toString());
					if (authorityDto.getObjId().toString().equals(mappingDto.getObjId().toString())){
						authorityDto.setUseYn("사용중");
					}else if (!authorityDto.getObjId().toString().equals(mappingDto.getObjId().toString()) && authorityDto.getUseYn() == null){
						authorityDto.setUseYn("미사용");
					}
				}
			}
			
		}
		return objectList;
	}
	
	@RequestMapping("/registerMappingTable.ino")
	@ResponseBody
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean registerMappingTable(HttpServletRequest request, @RequestBody List<Map<String, Object>> list){
		
		boolean isRegisted = false;
		int re = 0;
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		List<Map<String, Object>> insertList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> deleteList = new ArrayList<Map<String, Object>>();
		
		for (Map<String, Object> authority : list){
			if (authority.get("FLAG").equals("I")){
				insertList.add(authority);
			}else if (authority.get("FLAG").equals("D")){
				deleteList.add(authority);
			}
		}
		
		System.out.println("INSERT LIST ::: " + insertList);
		System.out.println("DELETE LIST ::: " + deleteList);
		
		try{
			if (insertList.size() > 0){
				re += authorityService.insertMappingTable(insertList);
			}
			if (deleteList.size() > 0){
				re += authorityService.deleteMappingTable(deleteList);
			}
			transactionManager.commit(status);			
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		
		if (list.size() != 0 && re == list.size()){
			isRegisted = true;
		}
		return isRegisted;
	}
}
