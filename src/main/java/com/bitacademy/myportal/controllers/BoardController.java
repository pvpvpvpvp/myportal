package com.bitacademy.myportal.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.BoardVo;
import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.BoardService;

import oracle.net.aso.b;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardServiceImpl;
	
	@RequestMapping({"","/","/list"})
	public String list(Model model) {
		List<BoardVo> list = boardServiceImpl.getList();
		model.addAttribute("list",list);
		return "board/list";
	}
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String writeForm(HttpSession session) {
//		로그인 사용자 확인
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser==null)
		{
			System.err.println("로그인 사용자가 아님");
			return "redirect:/";
		}
		
		return "board/write";
	}
//	게시물 작성
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo, 
						HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if(authUser==null)
		{
			return "redirect:/";
		}
		boardVo.setUserNo(authUser.getNo());
		boardServiceImpl.write(boardVo);
		return "redirect:/board/list";	
	}
	//이거는 조회수+ 글눌렀을때 뷰로 이동 게시글 컨텐츠 보기
	@RequestMapping(value="/view/{no}", method = RequestMethod.GET)
	public String view(@PathVariable("no") Long no, Model model) {
		BoardVo boardVo = boardServiceImpl.getContentHit(no);
		System.out.println(boardVo);
		model.addAttribute("content",boardVo);
		return "board/view";
	}
	
	@RequestMapping(value="/modify/{no}", method = RequestMethod.GET)
	public String modify(@PathVariable("no") Long no,Model model,
						HttpSession session) {
		
		BoardVo boardVo = boardServiceImpl.getContent(no);
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		model.addAttribute("content",boardVo);
		boolean sameUser =false;
		try {
			sameUser = authUser.getName().equals(boardVo.getUserName())
				? true:false;
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("아이디 판별:"+sameUser);
		if(sameUser)
		{
		return "board/modify";
		}
		else
		{
			return "redirect:/board/list";
		}
	}
	//지정 게시글 수정
	@RequestMapping(value="/modify/{no}", method = RequestMethod.POST)
	public String updateContent(@ModelAttribute BoardVo boardVo)
	{
			boolean bSuccess = boardServiceImpl.update(boardVo);
			if(bSuccess)
			{
				return "redirect:/board/view/"+boardVo.getNo();
			}
	
		return "";
	}
	
	@RequestMapping(value="/delete/{no}", method = RequestMethod.GET)
	public String deleteContent(@PathVariable("no") Long no, HttpSession session)
	{
		UserVo authUser = (UserVo)session.getAttribute("authUser");

		BoardVo boardVo = boardServiceImpl.getContent(no);
		boolean sameUser =false;
		boolean bSuccess = false;
		try {
			sameUser = authUser.getName().equals(boardVo.getUserName())
				? true:false;
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(sameUser)
			bSuccess = boardServiceImpl.delete(no);
		if(bSuccess)
		{
			return "redirect:/board/list";
		}
		return "redirect:/board/list";
	}
}