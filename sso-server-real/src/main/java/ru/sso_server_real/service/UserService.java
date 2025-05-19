package ru.sso_server_real.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.sso_server_real.AuthUser;
import ru.sso_server_real.Role;
import ru.sso_server_real.controllers.ResponseAuthentification;
import ru.sso_server_real.repository.RoleRepository;
import ru.sso_server_real.repository.UserRepository;

@Service
public class UserService {

	@PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
//    
    public ResponseRegistration registrate(AuthUser au) {
    	boolean successful;
    	String cause = "success";
    	if(!hasUser(au)) {
    		userRepository.save(au);
    		successful = true;
    	}
    	else{
    		cause = "Acount with this email (" + au.getEmail() + ") is exist now";
    		successful = false;
    	};
    	return new ResponseRegistration(successful, cause);
    }
    
	public ResponseAuthentification authentificate(AuthUser au) {
		return new ResponseAuthentification(isAuthentificated(au));
	}
    
	public boolean isAuthentificated(AuthUser au) {
		AuthUser found =  userRepository.findByEmail(au.getEmail());
		return  found != null && au.getPassword().equals(found.getPassword());
	}
	
    public boolean hasUser(AuthUser au) {
    	AuthUser found =  userRepository.findByEmail(au.getEmail());
    	return found != null;
    }
}
