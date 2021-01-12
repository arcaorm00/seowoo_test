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
	public ModelAndView authorityTableDetail(@RequestParam String check){
		ModelAndView mav = new ModelAndView("authorityTableDetail");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", check);
		List<AuthorityDto> objectList = authorityService.selectObjectTableList();
		List<AuthorityDto> mappingList = authorityService.selectMappingTableListByGroupId(map);
		
		for (AuthorityDto authorityDto : objectList){
			for (AuthorityDto mappingDto : mappingList){
				if (authorityDto.getObjId().toString().equals(mappingDto.getObjId().toString())){
					authorityDto.setUseYn("사용중");
				}else{
					authorityDto.setUseYn("미사용");
				}
			}
		}
		mav.addObject("groupId", check);
		mav.addObject("objectList", objectList);
		return mav;
	}
	
	@RequestMapping("/registerMappingTable.ino")
	@ResponseBody
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int registerMappingTable(HttpServletRequest request, @RequestBody List<Map<String, Object>> list){
		int re = 0;
		
		System.out.println("list ::" + list);
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
			
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
//		int re = authorityService.insertMappingTable(row);
		return re;
	}
}
