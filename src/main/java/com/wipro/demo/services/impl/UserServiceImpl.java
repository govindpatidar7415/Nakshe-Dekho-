package com.wipro.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.UserDtls;
import com.wipro.demo.repository.UserRepository;
import com.wipro.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Save Normal User
    @Override
    public UserDtls saveUser(UserDtls user) {
        user.setRole("ROLE_USER");
        user.setIsEnable(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Save Admin User
    @Override
    public UserDtls saveAdmin(UserDtls user) {
        user.setRole("ROLE_ADMIN");
        user.setIsEnable(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDtls getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDtls> getUsers(String role) {
        return userRepository.findByRole(role);
    }

	@Override
	public Boolean updateAccountStatus(Integer id, Boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increaseFailedAttempt(UserDtls user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userAccountLock(UserDtls user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean unlockAccountTimeExpired(UserDtls user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetAttempt(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserResetToken(String email, String resetToken) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDtls getUserByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDtls updateUser(UserDtls user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDtls updateUserProfile(UserDtls user, MultipartFile img) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existsEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

    // Other methods can remain as they are
}
