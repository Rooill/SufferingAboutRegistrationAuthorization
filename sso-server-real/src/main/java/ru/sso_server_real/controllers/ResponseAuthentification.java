package ru.sso_server_real.controllers;

import javax.swing.Spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.sso_server_real.service.ResponseRegistration;

@Getter
@Setter
@ToString 
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseAuthentification {
	boolean successful;
}
