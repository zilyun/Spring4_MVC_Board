package com.naver.myhome4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome4.domain.Member;
import com.naver.myhome4.mybatis.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper dao;
	
	@Autowired
	public MemberServiceImpl(MemberMapper dao) {
		this.dao = dao;
	}
	
	
	@Override
	public int isId(String id, String pass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int isId(String id) {
		Member rmember = dao.isId(id);
		return (rmember==null) ? -1 : 1; // -1은 아이디가 존재하지 않는 경우
										 //  1은 아이디가 존재하는 경우 
	}

	@Override
	public Member member_info(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> getSearchList(int index, String search_word, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSearchListCount(int index, String search_word) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
