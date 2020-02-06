package tk.ocb.main.service;

import tk.ocb.main.dto.model.UserDao;

public interface LoginUserService {
	UserDao takePasswordNEmailReturnUser(String email, String password);
}
