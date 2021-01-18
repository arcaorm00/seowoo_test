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
	
	public int getCountFreeBoard(){
		return sqlSessionTemplate.selectOne("getCountFreeBoard");
	}
}
