package ino.web.authorityTable.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ino.web.authorityTable.dto.AuthorityDto;

@Service
public class AuthorityService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> getGroupList(){
		return sqlSessionTemplate.selectList("selectGroupTableList");
	}

	public List<Map<String, Object>> selectObjectTableList() {
		return sqlSessionTemplate.selectList("selectObjectTableList");
	}
	
	public List<Map<String, Object>> selectMappingTableListByGroupId(Map<String, Object> map){
		return sqlSessionTemplate.selectList("selectMappingTableListByGroupId", map);
	}
	
	public int insertMappingTable(List<Map<String, Object>> list){
		return sqlSessionTemplate.insert("insertMappingTable", list);
	}
	
	public int deleteMappingTable(List<Map<String, Object>> list){
		return sqlSessionTemplate.delete("deleteMappingTable", list);
	}
}
