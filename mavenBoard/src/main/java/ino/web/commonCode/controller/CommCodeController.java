package ino.web.commonCode.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		ModelAndView mav = new ModelAndView("commonCodeDetatil");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("codeType", num);
		List<HashMap<String, Object>> list = commCodeService.selectByCode(map);
		return mav;
	}
	
}
