package ino.web.commonCode.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import ino.web.commonCode.service.CommCodeService;

@Controller
public class CommCodeController {
	
	@Autowired 
	private CommCodeService commCodeService;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@RequestMapping("/commonCode.ino")
	public ModelAndView commonCode(HttpServletRequest req){
		
		ModelAndView mav = new ModelAndView();
		
		List<HashMap<String,Object>> list = commCodeService.selectCommonCodeList();
		
		mav.addObject("list" , list);
		mav.setViewName("commonCodeMain");
		
		return mav;
	}
	
	@RequestMapping("/commonCodeInsert.ino")
	public ModelAndView insertCommCode(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("commonCodeInsert");
		return mav;
	}
	
	@RequestMapping("/commonCodeDetail.ino")
	public ModelAndView detailCommCode(HttpServletRequest request,
			@RequestParam String num){
		ModelAndView mav = new ModelAndView("commonCode/commonCodeDetail");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("codeType", num);
		List<HashMap<String, Object>> list = commCodeService.selectByCode(map);
		
		mav.addObject("list", list);
		mav.addObject("code", num);
		return mav;
	}
	
	@RequestMapping(value="/detailCodeIsExist.ino")
	@ResponseBody
	public int isExistCode(HttpServletRequest request, @RequestBody List<Map<String, Object>> codeList) throws Exception{
		System.out.println("DETAIL CODE IS EXIST ::: ");
		System.out.println(codeList.toString());
		int cnt = commCodeService.isExistCode(codeList);
		return cnt;
	}
	
	@RequestMapping(value="/registerDetailCode.ino")
	@ResponseBody
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean registerDetailCode(HttpServletRequest request, 
			@RequestBody List<Map<String, Object>> codeList){
		boolean isInserted = false;
		
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		List<Map<String, Object>> insertList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> updateList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> deleteList = new ArrayList<Map<String, Object>>();
		
//		ObjectMapper mapper = new ObjectMapper();
//		ArrayList<Map<String, Object>> list = mapper.readValue(newCodeList, ArrayList.class);
		
		for (Map<String, Object> codeMap : codeList){
			if (codeMap.get("FLAG").equals("I")){
				insertList.add(codeMap);
			}else if (codeMap.get("FLAG").equals("U")){
				updateList.add(codeMap);
			}else if (codeMap.get("FLAG").equals("D")){
				deleteList.add(codeMap);
			}
		}
		
		System.out.println("insertList ::: " + insertList);
		System.out.println("updateList ::: " + updateList);
		System.out.println("deleteList ::: " + deleteList);
		
		try{
			if (insertList.size() > 0){
				commCodeService.insertDetailCode(insertList);
			}
			if (updateList.size() > 0){
				commCodeService.updateDetailCode(updateList);
			}
			if (deleteList.size() > 0){
				commCodeService.deleteDetailCode(deleteList);
			}
			transactionManager.commit(status);
			isInserted = true;
		}catch (Exception e) {
			isInserted = false;
			transactionManager.rollback(status);
		}

//		int re = commCodeService.insertDetailCode(codeList);
		return isInserted;
	}
	
}
