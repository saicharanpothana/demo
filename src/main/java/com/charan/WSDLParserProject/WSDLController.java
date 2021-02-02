package com.charan.WSDLParserProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WSDLController {

	@GetMapping("/wsdl-parser")
	public String wsdlParser() {
		return "greeting";
	}

}


