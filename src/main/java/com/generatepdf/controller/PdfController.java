package com.generatepdf.controller;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.generatepdf.bean.DataRequest;

@Controller
public class PdfController {
	
	@Autowired
    private TemplateEngine templateEngine;
	
	 @PostMapping("/generate-pdf")
	public  ResponseEntity<InputStreamResource>  generatePdf(@RequestBody DataRequest datasent, Model model) throws IOException{
	        Context context = new Context();
	        context.setVariable("name", datasent.getName());
	        context.setVariable("email", datasent.getEmail());
	        context.setVariable("mobile", datasent.getMobile());
	        context.setVariable("address", datasent.getAddress());

	        String htmlContent = templateEngine.process("pdf_template", context);

	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        PdfRendererBuilder builder = new PdfRendererBuilder();
	        builder.withHtmlContent(htmlContent, null);
	        builder.toStream(byteArrayOutputStream);
	        builder.run();

	        ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=user.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
		
	}

}
