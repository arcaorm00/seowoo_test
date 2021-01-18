package com.web.mavenBoardTest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.mavenBoardTest.service.FreeboardService;
import com.web.mavenBoardTest.util.Pagination;

@Controller
public class FreeboardController {

	@Autowired
	private FreeboardService freeBoardService;
	
	@RequestMapping("/main.ino")
	public ModelAndView mainFreeBoard(HttpServletRequest request, 
			@RequestParam(defaultValue = "1")int page){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freeBoardMain");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Pagination pageUtil = new Pagination(page, freeBoardService.getCountFreeBoard());
		System.out.println(pageUtil);
		
		map.put("startPage", pageUtil.getStartPage());
		map.put("endPage", pageUtil.getEndPage());
		
		mav.addObject("list", freeBoardService.selectAllFreeBoard(map));
		mav.addObject("pagination", pageUtil);
		return mav;
	}
	
	
	@RequestMapping("/mainSearch.ino")
	@ResponseBody
	public Map<String, Object> mainSearch(HttpServletRequest request,
			@RequestParam(defaultValue="") String searchField,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue = "1")int page){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("searchField: " + searchField + " / " + "keyword: " + keyword);
		
		Pagination pageUtil = new Pagination(page, freeBoardService.getCountFreeBoard());
		map.put("searchField", searchField);
		map.put("keyword", keyword);
		map.put("startPage", pageUtil.getStartPage());
		map.put("endPage", pageUtil.getEndPage());
		List<Map<String, Object>> list = freeBoardService.selectAllFreeBoard(map);
		System.out.println("list :: " + list);
		map.put("list", list);
		return map;
	}
}
