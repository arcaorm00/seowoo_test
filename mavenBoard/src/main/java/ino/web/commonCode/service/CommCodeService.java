package ino.web.commonCode.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int insertDetailCode(List<Map<String, Object>> codeList){
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		int re = 0;
		try{
			Map<String, Object> code = new HashMap<String, Object>();
			code.put("codeList", codeList);
			re += sqlSessionTemplate.insert("insertDecode", code);
			System.out.println("SERVICE INSERT RE :: " + re);
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		return re;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateDetailCode(List<Map<String, Object>> codeList){
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		int re = 0;
		System.out.println(codeList);
		try{
			for(Map<String, Object> code : codeList){
				re += sqlSessionTemplate.update("updateDecode", code);
			}
			System.out.println("SERVICE UPDATE RE :: " + re);
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		return re;
	}
}
