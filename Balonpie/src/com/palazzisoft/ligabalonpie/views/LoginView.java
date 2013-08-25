package com.palazzisoft.ligabalonpie.views;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.AdministradorController;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.entities.Administrador;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
@RequestMapping("/login.htm")
public class LoginView {

	Logger log = Logger.getLogger(LoginView.class);

	private ParticipanteController participanteController;

	private AdministradorController administradorController;

	@Autowired	
	public LoginView(ParticipanteController participanteController, AdministradorController adminostradorController) {
		this.participanteController = participanteController;
		this.administradorController = adminostradorController;
	}

	public static final String PARTICIPANTE_SESSION = "participanteSession";
	private static final String TIPO_LOGUEO = "tipoLogueo";

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showForm(HttpServletRequest req, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		String viewPage = PageViews.ERROR_PAGINA;

		try {
			String user = req.getParameter("user");
			String password = req.getParameter("password");
			String esAdmin = req.getParameter("esAdmin");

			if (esAdmin == null) {
				ParticipanteCommand participanteCommand = participanteController.login(user, password);

				if (participanteCommand != null) {
					req.getSession().setAttribute(PARTICIPANTE_SESSION, participanteCommand);
					req.setAttribute(TIPO_LOGUEO, "participante");
					req.setAttribute("participanteId", participanteCommand.getId());
					viewPage = PageViews.DASHBOARD;
					
					model.addObject("participante", participanteCommand);
				} else {
					viewPage = PageViews.LOGIN_INVALIDO;
				}
			} else {
				Administrador administrador = administradorController.login(user, password);

				if (administrador != null) {
					req.getSession().setAttribute(PARTICIPANTE_SESSION, administrador);
					req.setAttribute(TIPO_LOGUEO, "administrador");
					viewPage = PageViews.DASHBOARD;
				} else {
					viewPage = PageViews.LOGIN_INVALIDO;
				}
			}
		} catch (Exception e) {
			viewPage = PageViews.ERROR_PAGINA;
		}

		model.setViewName(viewPage);
		
		return model;
	}
}
