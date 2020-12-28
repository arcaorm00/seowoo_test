package ino.web.freeBoard.service;

import ino.web.freeBoard.dto.FreeBoardDto;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<FreeBoardDto> freeBoardList(Map<String, Object> search){
//		System.out.println("HERE IS SERVICE: " + search.get("keyword"));
		List<FreeBoardDto> list = sqlSessionTemplate.selectList("freeBoardGetList", search);
		return list;
	}
	
	
	public int freeBoardInsertPro(FreeBoardDto dto){
		int re = 0;
		
		try{
			re = sqlSessionTemplate.insert("freeBoardInsertPro", dto);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	
	public FreeBoardDto getDetailByNum(int num){
		return sqlSessionTemplate.selectOne("freeBoardDetailByNum", num);
	}
	
	public int getNewNum(){
		return sqlSessionTemplate.selectOne("freeBoardNewNum");
	}
	
	public int freeBoardModify(FreeBoardDto dto){
		int re = 0;
		
		try{
			re = sqlSessionTemplate.update("freeBoardModify", dto);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}

	public int FreeBoardDelete (int num) {
		int re = 0;
		try{
			re = sqlSessionTemplate.delete("freeBoardDelete", num);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
}
