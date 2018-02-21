package com.pdsu.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pdsu.ssm.bean.User;
import com.pdsu.ssm.service.UserService;

@Controller
@RequestMapping(value="/user")
public class userAction {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user,HttpServletRequest request,HttpServletResponse response) throws IOException {
		User u=userService.isExist(user.getName());
		if(u == null) {
			int result=userService.regist(user);
			if(result>0) {
				return "users/login";
			}else {
				return "users/regist";
			}
		}else {
			return "users/regist";
		}
		
	}
	

	@RequestMapping(value="/isExist",method=RequestMethod.POST)
	public String isExist(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//从ajax获取值
		String uname=request.getParameter("uname");
		User u=userService.isExist(uname);
		response.setContentType("application/json;charset=utf-8");
		if(u == null) {
			response.getWriter().write("{\"status\" : 1,\"key\" : \"用户名可用\"}");
			return null;
		}else {
			response.getWriter().write("{\"status\" : \"0\",\"key\" : \"用户名已存在\"}");
			return null;
		}
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpSession session) {
		User u=userService.login(user.getName(), user.getPassword());
		System.out.println(user.getName());
		if(u!=null) {
			session.setAttribute("name", user.getName());
			return "redirect:/users/manager.jsp";
		}else {
			return "users/login";
		}
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public ModelAndView findAll() {
		List<User> list=userService.findAll();
		Map model=new HashMap();
		model.put("list",list);
		//传值到页面
		ModelAndView mv=new ModelAndView("/users/select",model);
		return mv;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
	public String update(User user) {
		User exist = userService.isExist(user.getName());
		if(exist == null) {
			int i=userService.update(user);
			if(i>0) {
				return "redirect:/user/findAll";
			}else {
				return "users/update";
			}
		}else {
			return "users/update";
		}
		
		
	}
	
	@RequestMapping(value="/toupdate",method=RequestMethod.GET)
	public ModelAndView toupdate(String id) {
		System.out.println(id);
		User user = userService.findById(id);
		System.out.println(user.getName());
		ModelAndView modelAndView = new ModelAndView("users/update");
		modelAndView.addObject("id", id);
		//回显数据到页面
		modelAndView.addObject("name", user.getName());
		modelAndView.addObject("password", user.getPassword());
	    return modelAndView;
		
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(User user) {
		int i = userService.delete(user);
		if(i>0) {
			return "redirect:/user/findAll";
		}else {
			return "redirect:/user/findAll";
		}
	}
}
