package com.palazzisoft.ligabalonpie.views;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class LoginView implements Controller {

	Logger log = Logger.getLogger(LoginView.class);
	
	@Autowired
	private ParticipanteController participanteController;
	
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		

		String ret = PageViews.ERROR_PAGINA;
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		
		
		try {
			Participante participante = participanteController.login(user, password);
				
			if (participante != null) {
				ret = PageViews.DASHBOARD;
			}			
		}
		catch (Exception e) {
			log.error(e);
		}
		
		return new ModelAndView(ret);						
		
	}

}
