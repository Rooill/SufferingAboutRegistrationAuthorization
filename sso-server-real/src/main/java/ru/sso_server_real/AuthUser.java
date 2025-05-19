package ru.sso_server_real;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;


@Getter
@Setter
@ToString 
@EqualsAndHashCode
@Entity
public class AuthUser {
	
	public AuthUser() {}
	public AuthUser(String email,String username,String password,String role) {
		this.email=email;
		this.password=password;
		this.role=role;
		this.username=username;		
	}
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String email;
	private String password;
	private String role;
}