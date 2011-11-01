package com.palazzisoft.ligabalonpie.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistroView {

	@RequestMapping("/registro.pal")
	public void registrar() {
		System.out.println("que ganas de garchar dios");
	}
}
