package ino.web.commonCode.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/detailCodeIsExist.ino")
	@ResponseBody
	public int isExistCode(HttpServletRequest request,
			@RequestParam String code,
			@RequestParam String detailcode){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("decode", detailcode);
		int cnt = commCodeService.isExistCode(map);
		return cnt;
	}
	
	@RequestMapping(value="/insertDetailCode.ino")
	@ResponseBody
	public boolean insertDetailCode(HttpServletRequest request, @RequestParam String codeList) throws Exception{
		boolean isInserted = false;
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Map<String, Object>> list = mapper.readValue(codeList, ArrayList.class);
		System.out.println("파싱 List: " + list.size());
		int re = commCodeService.insertDetailCode(list);
		if(re == list.size()){
			isInserted = true;
		}
		return isInserted;
	}
	
}
