package com.web.mavenBoardTest.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeboardService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selectAllFreeBoard(Map<String, Object> map){
		return sqlSessionTemplate.selectList("selectAllFreeBoard", map);
	}
	
	public int getCountFreeBoard(Map<String, Object> map){
		return sqlSessionTemplate.selectOne("getCountFreeBoard", map);
	}
	
	public List<Map<String, Object>> getDecodeByCode(Map<String, Object> map){
		return sqlSessionTemplate.selectList("getDecodeByCode", map);
	}
	
	public int insertFreeBoard(Map<String, Object> map){
		int re = 0;
		try{
			re = sqlSessionTemplate.insert("insertFreeBoard", map);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public Map<String, Object> getFreeBoardByNum(int num){
		return sqlSessionTemplate.selectOne("getFreeBoardByNum", num);
	}
	
	public int updateFreeBoard(Map<String, Object> map){
		int re = 0;
		try{
			re = sqlSessionTemplate.update("updateFreeBoard", map);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int deleteFreeBoard(int num){
		int re = 0;
		try{
			re = sqlSessionTemplate.delete("deleteFreeBoard", num);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
}
