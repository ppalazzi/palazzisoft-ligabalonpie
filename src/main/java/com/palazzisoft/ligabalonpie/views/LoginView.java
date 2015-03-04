package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.util.PageViews.ERROR_PAGINA;
import static com.palazzisoft.ligabalonpie.util.PageViews.LOGIN_INVALIDO;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.AdministradorController;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.entities.Administrador;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
@RequestMapping("/login.htm")
public class LoginView {

	public static final String PARTICIPANTE_SESSION = "participanteSession";
	private static final String TIPO_LOGUEO = "tipoLogueo";
	
	Logger log = Logger.getLogger(LoginView.class);

	private final ParticipanteController participanteController;
	private final AdministradorController administradorController;

	@Autowired	
	public LoginView(final ParticipanteController participanteController, final AdministradorController adminostradorController) {
		this.participanteController = participanteController;
		this.administradorController = adminostradorController;
	}

	@RequestMapping(method = GET)
	public String loginPantalla(HttpServletRequest req, Model model) {
		return this.showForm(req, model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String showForm(HttpServletRequest req, Model model) {
		String viewPage = ERROR_PAGINA;

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
					
					model.addAttribute("participante", participanteCommand);
				} else {
					viewPage = LOGIN_INVALIDO;
				}
			} else {
				Administrador administrador = administradorController.login(user, password);

				if (administrador != null) {
					req.getSession().setAttribute(PARTICIPANTE_SESSION, administrador);
					req.setAttribute(TIPO_LOGUEO, "administrador");
					viewPage = PageViews.DASHBOARD;
				} else {
					viewPage = LOGIN_INVALIDO;
				}
			}
		} catch (Exception e) {
			viewPage = ERROR_PAGINA;
		}
		
		return viewPage;
	}

}
