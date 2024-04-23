package com.naver.myhome4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.naver.myhome4.domain.Member;
import com.naver.myhome4.mybatis.mapper.MemberMapper;

@SpringBootTest
public class Test1_member {
	
	private static final Logger logger = LoggerFactory.getLogger(Test1_member.class);
	
	@Autowired
	private MemberMapper dao;
	
	//@Test
	public void insertMember() {
		Member member = new Member();
		member.setEmail("B1234@hta.com");
		member.setName("고길동");
		member.setId("B1234");
		member.setGender("남");
		member.setAge(30);
		member.setPassword("1234");
		
		dao.insert(member);
		
		logger.info("=== 삽입 완료 ===");
	}
	
	//@Test
	public void getSearchListCount() {
		Map<String, String> map = new HashMap<String, String>();
		
		int count = dao.getSearchListCount(map);
		logger.info("=== " + count + "개 있어요 ===");
	}
	
	//@Test
	public void getSearchListCount2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("search_field", "id");
		map.put("search_word", "%z%");
		int count = dao.getSearchListCount(map);
		logger.info("=== " + count + "개 있어요 ===");
	}
	
	//@Test
	public void getSearchList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("end", 10);
		
		List<Member> list = dao.getSearchList(map);
		for(Member member : list) {
			logger.info("==================");
			logger.info(member.getId());
			logger.info(member.getEmail());
			logger.info(member.getGender());
			logger.info(member.getName());
			logger.info(member.getAge() + "");
			logger.info(member.getPassword());
		}
	}
	
	@Test
	public void getSearchList2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search_field", "id");
		map.put("search_word", "%z%");
		map.put("start", 1);
		map.put("end", 10);
		
		List<Member> list = dao.getSearchList(map);
		for(Member member : list) {
			logger.info("==================");
			logger.info(member.getId());
			logger.info(member.getEmail());
			logger.info(member.getGender());
			logger.info(member.getName());
			logger.info(member.getAge() + "");
			logger.info(member.getPassword());
		}
	}
}
