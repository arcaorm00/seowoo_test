package com.web.mavenBoardTest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.mavenBoardTest.service.FreeboardService;

@Controller
public class FreeboardController {

	@Autowired
	private FreeboardService freeBoardService;
	
	@RequestMapping("/main.ino")
	public ModelAndView mainFreeBoard(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freeBoardMain");
		//mav.addObject("list", freeBoardService.selectAllFreeBoard());
		return mav;
	}
}
