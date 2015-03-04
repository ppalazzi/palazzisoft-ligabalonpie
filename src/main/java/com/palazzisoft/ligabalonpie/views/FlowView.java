package com.palazzisoft.ligabalonpie.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author ppalazzi
 *
 */
@Controller
public class FlowView {

	@RequestMapping (value = "/inicio.htm", method = RequestMethod.GET)
	public String comenzarFlujo() {
		return "comenzar.htm";
	}
}
