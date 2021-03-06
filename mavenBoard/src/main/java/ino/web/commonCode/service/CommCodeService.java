package ino.web.commonCode.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

@Service
public class CommCodeService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private PlatformTransactionManager transactionManager;

	public List<HashMap<String, Object>> selectCommonCodeList() {
		return sqlSessionTemplate.selectList("selectCommonCodeList");
	}
	
	public List<HashMap<String, Object>> selectDetailCodeList(Map<String, Object> codeMap){
		return sqlSessionTemplate.selectList("selectCode", codeMap);
	}
	
	public List<HashMap<String, Object>> selectByCode(Map<String, Object> map){
		return sqlSessionTemplate.selectList("selectByCode", map);
	}
	
	public int isExistCode(List<Map<String, Object>> codeList){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("codeList", codeList);
		return sqlSessionTemplate.selectOne("isExistCode", map);
	}
	
	public int insertDetailCode(List<Map<String, Object>> codeList){
		int re = 0;
		re = sqlSessionTemplate.insert("insertDecode", codeList);
		System.out.println("SERVICE INSERT RESULT :: " + re);

		return re;
	}
	
	public int updateDetailCode(List<Map<String, Object>> codeList){
		int re = sqlSessionTemplate.update("updateDecode", codeList);
		System.out.println("SERVICE UPDATE RESULT :: " + re);

		return re;
	}
	
	public int deleteDetailCode(List<Map<String, Object>> codeList){
		int re = 0;
		re = sqlSessionTemplate.delete("deleteDecode", codeList);
		System.out.println("SERVICE DELETE RESULT :: " + re);
		return re;
	}
}
