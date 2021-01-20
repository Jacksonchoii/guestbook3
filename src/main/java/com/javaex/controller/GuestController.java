package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value = "/gbc")
public class GuestController {

	//리스트
	
	@RequestMapping("/addList")
	public String addList(Model model) {
		System.out.println("addList");
		
		//dao에서 데이터 가져오기
		GuestDao guestDao = new GuestDao();
		List<GuestVo> guestList = guestDao.getGuestList();
		System.out.println(guestList.toString());
		
		//데이터 넘기기 --> model
		model.addAttribute("gList", guestList);
		
		return "addList";
	}
	
	// 등록
	
	@RequestMapping("/add")
	public String add(@ModelAttribute GuestVo guestVo) { /* name,password,content */
		System.out.println("add");
		
		//spring에서 자동으로 해주는 vo 값 확인
		System.out.println(guestVo.toString());
		
		//dao 저장
		GuestDao guestDao = new GuestDao();
		guestDao.guestInsert(guestVo);
		
		
		return "redirect:/gbc/addList";
	}
	
	//삭제폼
	
	@RequestMapping("/deleteForm")
	public String deleteForm() {
		System.out.println("deleteForm");
		
		
		return "deleteForm";
	}
	
	//삭제
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestVo guestVo, Model model) { /* no와 password */
		System.out.println("delete");
		
		System.out.println(guestVo.toString());
		
		//dao 삭제 
		GuestDao guestDao = new GuestDao();
		int count = guestDao.guestDelete(guestVo);
		
		if(count == 1) { //삭제 성공하면 리스트로
			return "redirect:/gbc/addList";
		} else { // 삭제 실패시  다시 시도하라고 알려주고 싶음 --> 어떻게?? 
			
			return "deleteForm";
		}
		
		
	}
}
