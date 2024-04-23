package com.naver.myhome4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.myhome4.domain.Comment;
import com.naver.myhome4.service.CommentService;

@RestController // @Controller + @ResponseBody
@RequestMapping(value="/comment")
public class CommentController2 {
	
	private CommentService commentService;
	
	@Autowired
	public CommentController2(CommentService commentService) {
		this.commentService = commentService;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController2.class);
	
	@PostMapping(value = "/add")
	public int CommentAdd(Comment co) {
		return commentService.commentsInsert(co);
	}
}
