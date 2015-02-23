package com.palazzisoft.ligabalonpie.security;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final ParticipanteController participanteController;
	
	@Autowired
	public CustomAuthenticationProvider(final ParticipanteController participanteController) {
		this.participanteController = participanteController;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		try {
			String user = authentication.getName();
			String password = (String) authentication.getCredentials();
			ParticipanteCommand login = participanteController.login(user, password);

			if (login != null) {
				
			}
			
			return new UsernamePasswordAuthenticationToken(user, password, null);
		} catch (ParseException e) {

		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
