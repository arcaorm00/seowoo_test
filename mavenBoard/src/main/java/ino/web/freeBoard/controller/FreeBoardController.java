package ino.web.freeBoard.controller;

import ino.web.freeBoard.common.util.Pagination;
import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.service.FreeBoardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
//	@RequestMapping(value={"/main.ino", "/mainSearch.ino"}, method=RequestMethod.GET, produces="application/json; charset=utf-8")
//	@ResponseBody
//	public Object main(HttpServletRequest request, @RequestParam Map<String, String> searchJson){
//		ModelAndView mav = new ModelAndView();
//		System.out.println("searchJson:" + searchJson);
//
//		List<FreeBoardDto> list = freeBoardService.freeBoardList(searchJson);
//		
//		System.out.println("LIST: "+list);
//		System.out.println("request.getServletPath(): " + (request.getServletPath().equals("/main.ino")));
//		
//		if (request.getServletPath().equals("/main.ino")){
//			mav.setViewName("boardMain");
//			mav.addObject("freeBoardList", list);
//			return mav;
//		}
//		return list;
//	}
	
	@RequestMapping(value="/main.ino", produces="application/json; charset=utf-8")
	@ResponseBody
	public ModelAndView main(HttpServletRequest request, 
			@RequestParam(defaultValue="") String searchField, 
			@RequestParam(defaultValue="") String keyword, Pagination page){
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchField", searchField);
		map.put("keyword", keyword);
		map.put("page", page);
		
		List<FreeBoardDto> list = freeBoardService.freeBoardList(map);
		System.out.println("LIST: "+list);
		
		mav.setViewName("boardMain");
		mav.addObject("freeBoardList", list);

		page.setEndPage(list.size()+1);
		page.setUrl("/mavenBoard/main.ino");
		System.out.println("page ::: " + page.getPagination());
		mav.addObject("page", page.getPagination());
		
		return mav;
	}
	
	@RequestMapping(value="/mainSearch.ino", produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> mainSearch(HttpServletRequest request, 
			@RequestParam(defaultValue="") String searchField,
			@RequestParam(defaultValue="") String keyword){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchField", searchField);
		map.put("keyword", keyword);
		
		List<FreeBoardDto> list = freeBoardService.freeBoardList(map);
		System.out.println("LIST: "+list);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("input", list);
		
		return returnMap;
	}
	
	@RequestMapping("/freeBoardInsert.ino")
	public String freeBoardInsert(){
		return "freeBoardInsert";
	}
	
	@RequestMapping("/freeBoardInsertPro.ino")
	@ResponseBody
	public Map<String, Object> freeBoardInsertPro(HttpServletRequest request, FreeBoardDto dto){
		Map<String, Object> insertMap = new HashMap<String, Object>();
		insertMap.put("dto", dto);
		int re = freeBoardService.freeBoardInsertPro(insertMap);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("re", re);
		map.put("num", dto.getNum());
		map.put("list", mainSearch(request, "", "").get("list"));
		
		return map;
	}
	
	@RequestMapping("/freeBoardDetail.ino")
	public ModelAndView freeBoardDetail(HttpServletRequest request, FreeBoardDto dto){
		ModelAndView mav = new ModelAndView("freeBoardDetail");
		FreeBoardDto fb = freeBoardService.getDetailByNum(dto.getNum());
		mav.addObject("freeBoardDto", fb);
		return mav;
	}
	
	@RequestMapping(value="/freeBoardModify.ino", method=RequestMethod.GET)
	public ModelAndView freeBoardModify(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("freeBoardModify");
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto fb = freeBoardService.getDetailByNum(num);
		
		if(fb.getCodeType().equals("자유")){fb.setCodeType("01");}
		else if(fb.getCodeType().equals("익명")){fb.setCodeType("02");}
		else if(fb.getCodeType().equals("QnA")){fb.setCodeType("03");}
		System.out.println(fb);
		 
		mav.addObject("freeBoardDto", fb);
		return mav;
	}
	
	@RequestMapping(value="/freeBoardModifyPro.ino", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> freeBoardModify(HttpServletRequest request, FreeBoardDto fb){
		int num = fb.getNum();
		System.out.println(fb);
		
		Map<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("dto", fb);
		int re = freeBoardService.freeBoardModify(updateMap);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("re", re);
		map.put("num", num);
		map.put("list", mainSearch(request, "", "").get("list"));
		
		return map;
	}
	
		
	@RequestMapping("/freeBoardDelete.ino")
	@ResponseBody
	public Map<String, Object> FreeBoardDelete(HttpServletRequest request, int num){
		int re = freeBoardService.FreeBoardDelete(num);
//		return "redirect:/main.ino";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("re", re);
		map.put("list", mainSearch(request, "", "").get("list"));
		
		return map;
	}
}