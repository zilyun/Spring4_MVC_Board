package com.naver.myhome4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome4.domain.Comment;
import com.naver.myhome4.mybatis.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentMapper dao;
	
	@Autowired
	public CommentServiceImpl(CommentMapper dao) {
		this.dao = dao;
	}
	
	@Override
	public int getListCount(int board_num) {
		return dao.getListCount(board_num);
	}

	@Override
	public List<Comment> getCommentList(int board_num, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int commentsInsert(Comment c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsDelete(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsUpdate(Comment co) {
		// TODO Auto-generated method stub
		return 0;
	}

}
