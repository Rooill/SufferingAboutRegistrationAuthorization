package ru.sso_server_real.controllers;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import jakarta.servlet.http.HttpServletRequest;
import ru.sso_server_real.AuthUser;
import ru.sso_server_real.service.ResponseRegistration;
import ru.sso_server_real.service.UserService;
import org.json.*;
@RestController
public class RegistrationController{

	@Autowired
	public UserService us;
	@PostMapping(path="/registration", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<ResponseRegistration> registration(HttpServletRequest request) throws JsonMappingException, JsonProcessingException, JSONException {
	    Enumeration<String> params = request.getParameterNames();
	    String json = params.nextElement();
	    JSONObject obj = new JSONObject(json);
	    AuthUser au = new AuthUser(obj.getString("email"), obj.getString("username"), obj.getString("password"), obj.getString("role"));
		ResponseRegistration respReg = us.registrate(au);
		return ResponseEntity.ok(respReg);
    }
	
	@PostMapping(path="/post-login",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<ResponseAuthentification> postLogin(HttpServletRequest request) throws JSONException {
		Enumeration<String> params = request.getParameterNames();
		String json = params.nextElement();
		JSONObject obj = new JSONObject(json);
		AuthUser au = new AuthUser(obj.getString("email"), null, obj.getString("password"), null);
		ResponseAuthentification respAuth = us.authentificate(au);
		return ResponseEntity.ok(respAuth);
    }
}