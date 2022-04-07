package lab.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.model.SearchVO;
import lab.spring.model.UserVO;
import lab.spring.model.UserValidator;
import lab.spring.service.UserService;

@Controller
public class UserManageController {
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public  String form(){
		return "login";
	}
	
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public ModelAndView  login(@RequestParam("userid")String uid, 
			                    @RequestParam("userpwd")String upwd) {
		ModelAndView mav = new ModelAndView();	
		UserVO vo = null;
		vo = service.login(uid,  upwd);
		if(vo!=null){	
			mav.addObject("user", vo);
			mav.setViewName("loginSuccess");
		}else{
			mav.addObject("userid", uid);
			mav.setViewName("loginFail");
		}
		return mav;
	}
	
	@RequestMapping(value = "/list.do", method=RequestMethod.GET)
	public ModelAndView  listUser() {
		ModelAndView mav = new ModelAndView();
		List<UserVO> userList = null;
		userList = service.findUserList();
		mav.addObject("users", userList);
		mav.setViewName("user_list");
		System.out.println("usercontroller�� listUser() ����");
		return mav;
	}
	
	@ModelAttribute("searchConditionList")
	public ArrayList<SearchVO> makeSearchConditionList(){
		ArrayList<SearchVO> searchConditionList = new  ArrayList<SearchVO>();
		 searchConditionList.add(new SearchVO("userid", "���̵�"));
		 searchConditionList.add(new SearchVO("username", "�̸�"));
		 searchConditionList.add(new SearchVO("email", "�̸���"));
		return searchConditionList;
	}
	
	@RequestMapping(value = "/search.do", method=RequestMethod.GET)
	public ModelAndView search(@RequestParam("searchCondition")String condition, 
            @RequestParam("searchKeyword")String keyword){
		ModelAndView mav = new ModelAndView();	
		List<UserVO> userList = null;
		userList = service.searchUser(condition, keyword);
		mav.addObject("users", userList);
		mav.setViewName("user_list");
		return mav;
	}
	
	@RequestMapping(value = "/join.do", method=RequestMethod.GET)
	public String getUserForm() {
		return "user_form";
	}
	
	
	@RequestMapping(value = "/join.do", method=RequestMethod.POST)		
	public ModelAndView addUser(@ModelAttribute("user") UserVO vo, BindingResult rs) {
		ModelAndView mav = new ModelAndView();
		//��ȿ�� üũ 
		new UserValidator().validate(vo, rs);		
		//������ �����ϸ� user_form���� ������ ����
		if(rs.hasErrors()){
			mav.setViewName("user_form");			
		}else if (service.registUser(vo)>0) {  //������ ������ service.registUser() ~
			mav.setViewName("redirect:/list.do");
		}else {
			mav.setViewName("redirect:/login.do");
		}		
		return mav;
	}
	
	//사용자 상세 화면 이동 및 조회
	@RequestMapping(value = "/view.do", method=RequestMethod.GET)
	public ModelAndView getUserDetail(@RequestParam("userid")String uid ) {
		
		ModelAndView mav = new ModelAndView();
		
		UserVO userDetail = service.findUser(uid);
		mav.addObject("userInfo", userDetail);
		mav.setViewName("user_detail");		
		return mav;
	}
	
	//사용자 삭제.
	@RequestMapping(value = "/delete.do", method=RequestMethod.POST)		
	public ModelAndView delUser(@ModelAttribute("user") UserVO vo, BindingResult rs) {
		ModelAndView mav = new ModelAndView();
		//��ȿ�� üũ 
		//new UserValidator().validate(vo, rs);		
		//������ �����ϸ� user_form���� ������ ����
		int result = service.removeUser(vo.getUserid());
		if (result > 0) {  //������ ������ service.registUser() ~
			mav.setViewName("redirect:/list.do");
		}else {
			mav.setViewName("redirect:/view.do");
		}		
		return mav;
	}
	
	//사용자 상세 화면 이동 및 조회
	@RequestMapping(value = "/modifyForm.do", method=RequestMethod.GET)
	public ModelAndView setUserForm(@RequestParam("userid")String uid ) {
		
		ModelAndView mav = new ModelAndView();
		
		UserVO userDetail = service.findUser(uid);
		mav.addObject("userInfo", userDetail);
		mav.setViewName("user_modify");		
		return mav;
	}
	
	//사용자 수정.
	@RequestMapping(value = "/modify.do", method=RequestMethod.POST)		
	public ModelAndView setUser(@ModelAttribute("user") UserVO vo, BindingResult rs) {
		ModelAndView mav = new ModelAndView();
		//��ȿ�� üũ 
		//new UserValidator().validate(vo, rs);		
		//������ �����ϸ� user_form���� ������ ����
		int result = service.updateUser(vo);
		if (result > 0) {  //������ ������ service.registUser() ~
			mav.setViewName("redirect:/view.do");
		}else {
			mav.setViewName("redirect:/view.do");
		}		
		return mav;
	}
			                         
}













