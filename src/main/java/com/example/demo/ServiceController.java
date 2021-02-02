package com.example.demo;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.Part;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Element;

import com.charan.WSDLParserProject.SoapUtils;

@RestController
class ServiceController {


  @GetMapping("/wsdl")
   ArrayList parseWsdl() {
	  
      ArrayList serviceArray = new ArrayList<Object>();

	    try {
	    	
	      URL wsdlURL = new File("calculator.wsdl").toURI().toURL();
	      WSDLReader wsdlReader = WSDLFactory.newInstance().newWSDLReader();
	      wsdlReader.setFeature("javax.wsdl.verbose", true);
	      Definition wsdlDefinition = wsdlReader.readWSDL(wsdlURL.toString());
	      Map<String, Service> wsdlServices = wsdlDefinition.getServices();
	      
	      for (Service wsdlService : wsdlServices.values()) {
	    	  	System.out.println("Service: " + wsdlService.getQName().getLocalPart());
	        Map<String, Port> wsdlPorts = wsdlService.getPorts();
	        ArrayList portsArray = new ArrayList<Object>();
	        
	        for (Port wsdlPort : wsdlPorts.values()) {
	          System.out.println("  - Port: "+ wsdlPort.getName());
	          List<ExtensibilityElement> wsdlElements = wsdlPort.getExtensibilityElements();
		      ArrayList locationUriArray = new ArrayList<Object>();
	          
	          for (ExtensibilityElement wsdlElement : wsdlElements) {
	            System.out.println("    - LocationURI: " + SoapUtils.getLocationURI(wsdlElement));
	            locationUriArray.add(SoapUtils.getLocationURI(wsdlElement));
	          };
	          
	          List<BindingOperation> wsdlBindingOperations = wsdlPort.getBinding().getBindingOperations();
	          ArrayList operationArray = new ArrayList<Object>();
	     	  
	          
	          for (BindingOperation wsdlBindingOperation : wsdlBindingOperations) {
	            System.out.println("    - BindingOperation: " + wsdlBindingOperation.getName());
	            Element docElement = wsdlBindingOperation.getOperation().getDocumentationElement();
	            Map<String, Part> wsdlInputParts = wsdlBindingOperation.getOperation().getInput().getMessage().getParts();
	            ArrayList input = new ArrayList<QName>();
	            ArrayList output = new ArrayList<QName>();
	            
	            for (Part wsdlPart : wsdlInputParts.values()) {
	              System.out.println("      - Input:  " + wsdlPart.getElementName());
	              input.add(wsdlPart.getElementName());
	            }
	            
	            Map<String, Part> wsdlOutputParts = wsdlBindingOperation.getOperation().getOutput().getMessage().getParts();
	            
	            for (Part wsdlPart : wsdlOutputParts.values()) {
	              System.out.println("      - Output: " + wsdlPart.getElementName());
	              output.add(wsdlPart.getElementName());
	            }
	            
         		Operation operation = new Operation(wsdlBindingOperation.getName(),input,output);
         		operationArray.add(operation);
	            System.out.println("----------------------------------");
	            
	          }
	          
	          EndPointPort portObj = new EndPointPort(wsdlPort.getName(),locationUriArray,operationArray);
	          portsArray.add(portObj);
	          
	        }
	        WSDLService s = new WSDLService(wsdlService.getQName().getLocalPart(),portsArray);
	        serviceArray.add(s);
	      }
	      
	      
	    }
	    catch (Exception e) {
	      System.out.println(e.getMessage());
	    
  }
	    return serviceArray;

}
}
