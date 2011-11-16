package com.palazzisoft.ligabalonpie.views;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.AdministradorController;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.entities.Administrador;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class LoginView implements Controller {

	Logger log = Logger.getLogger(LoginView.class);
	
	@Autowired
	private ParticipanteController participanteController;
	
	@Autowired
	private AdministradorController administradorController;
			
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		try {
			String user     = req.getParameter("user");
			String password = req.getParameter("password");		
			String esAdmin  = req.getParameter("esAdministrador");
			
			if (esAdmin == null) {
				Participante participante = participanteController.login(user, password);				
				req.getSession().setAttribute("participanteSession", participante);
				req.getSession().setAttribute("tipoLogueo", "participante");	
				mv.setViewName(PageViews.DASHBOARD);
			}
			else {
				Administrador administrador = administradorController.login(user, password);
				req.getSession().setAttribute("participanteSession", administrador);				
				req.getSession().setAttribute("tipoLogueo", "administrador");								
				mv.setViewName(PageViews.DASHBOARD);
			}					
		}
		catch (Exception e) {
			mv.setViewName(PageViews.ERROR_PAGINA);
		}
		
		return mv;						
		
	}

}
