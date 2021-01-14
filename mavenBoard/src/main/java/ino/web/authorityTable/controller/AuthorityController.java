package ino.web.authorityTable.controller;

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
		System.out.println("authorityService.getGroupList() ::: " + authorityService.getGroupList());
		return mav;
	}
	
	@RequestMapping("/authorityDetail.ino")
	@ResponseBody
	public Map<String, Object> authorityTableDetail(@RequestParam String groupId){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", groupId);
		List<Map<String, Object>> objectList = authorityService.selectObjectTableList();
		List<Map<String, Object>> mappingList = authorityService.selectMappingTableListByGroupId(map);
		
//		for (AuthorityDto authorityDto : objectList){
//			if (mappingList.size() <= 0){
//				authorityDto.setUseYn("미사용");
//			}else{
//				for (AuthorityDto mappingDto : mappingList){
//					if (authorityDto.getObjId().toString().equals(mappingDto.getObjId().toString())){
//						authorityDto.setUseYn("사용중");
//					}else if (!authorityDto.getObjId().toString().equals(mappingDto.getObjId().toString()) && authorityDto.getUseYn() == null){
//						authorityDto.setUseYn("미사용");
//					}
//				}
//			}
//			
//		}
		
		map.put("objectList", objectList);
		map.put("mappingList", mappingList);
		return map;
	}
	
	@RequestMapping("/registerMappingTable.ino")
	@ResponseBody
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean registerMappingTable(HttpServletRequest request, 
			@RequestBody Map<String, List<Map<String, Object>>> parameterMap){
		
		boolean isRegisted = false;
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		System.out.println("INSERT LIST ::: " + parameterMap.get("insertList"));
		System.out.println("DELETE LIST ::: " + parameterMap.get("deleteList"));
		
		List<Map<String, Object>> insertList = parameterMap.get("insertList");
		List<Map<String, Object>> deleteList = parameterMap.get("deleteList");
		
		try{
			if (insertList.size() > 0){
				authorityService.insertMappingTable(insertList);
			}
			if (deleteList.size() > 0){
				authorityService.deleteMappingTable(deleteList);
			}
			transactionManager.commit(status);
			isRegisted = true;
		}catch (Exception e) {
			isRegisted = false;
			transactionManager.rollback(status);
		}

		return isRegisted;
	}
}
