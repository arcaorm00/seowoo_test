package ino.web.members.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertMember(Map<String, Object> map){
		int re = 0;
		try{
			re = sqlSessionTemplate.insert("insertMember", map);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public Map<String, Object> isExistMember(String id){
		return sqlSessionTemplate.selectOne("isExistMember", id);
	}
	
	public List<Map<String, Object>> getMappingObjectByID(Map<String, Object> map){
		return sqlSessionTemplate.selectList("getMappingObjectByID", map);
	}

}
