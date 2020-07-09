package yeong.spring.web.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeong.spring.web.user.UserVO;
import yeong.spring.web.user.impl.UserDAO;
import yeong.spring.web.user.service.LoginUserService;

@Service
public class LoginUserServiceImpl implements LoginUserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO login(UserVO vo) {
		
		
		
		return null;
	}

}
