package yeong.spring.web.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import yeong.spring.web.user.UserVO;
import yeong.spring.web.user.dao.UserDAO;

public class JdbcUserDAO implements UserDAO{
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return template.queryForObject("SELECT * FROM myuser WHERE id = ? and password = ?", (rs, row) -> {
			UserVO user = new UserVO();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setRole(rs.getString("role"));
			return user;
		}, vo.getId(), vo.getPassword());
	}
}
