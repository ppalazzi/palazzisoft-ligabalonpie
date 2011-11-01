package com.palazzisoft.ligabalonpie.views;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
public class LoginView {

	Logger log = Logger.getLogger(LoginView.class);
	
	@Autowired
	private ParticipanteController participanteController;
	
	@RequestMapping("/login.pal")
	public ModelAndView login(@RequestParam("user")String user, @RequestParam("password")  String password) {		
		String ret = PageViews.ERROR_PAGINA;
		
		try {
			Participante participante = participanteController.login(user, password);
				
			if (participante != null) {
				ret = PageViews.PARTICIPANTE_VALIDO;
			}			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return new ModelAndView(ret);		
	}
}
