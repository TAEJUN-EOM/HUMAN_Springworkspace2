package lab.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.dao.UserDAO;
import lab.spring.model.UserVO;
 

@Service("userService") 
public class UserServiceImpl implements UserService {
	
	private UserDAO dao;	 
	 
	public UserServiceImpl() {
		super();
	}	
	
	@Autowired
	public void setDao(UserDAO userDao) {
		this.dao = userDao;
	}  
	
	@Override
	public int registUser(UserVO user) {		 
		return dao.insertMember(user);
	}
		
	public int updateUser(UserVO user) {	
		return dao.updateUser(user);
	}
	
	public int removeUser(String uid) {		 
		return dao.removeUser(uid);
	}
	
	public UserVO findUser(String uid) {		 
		return dao.findUser(uid);
	}
	
	public List<UserVO> findUserList() {		 
		return  dao.findUserList();
	}
	
	public UserVO login(String uid, String upwd) {	
		return  dao.loginProc(uid, upwd);
	}
	
	@Override
	public List<UserVO> searchUser(String condition, String keyword) {		
		return dao.searchUser(condition, keyword);
	}

	
}



