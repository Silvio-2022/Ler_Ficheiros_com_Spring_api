package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.swing.text.Document;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage {
	
	@GetMapping("/hello-world")
	public String HelloWorld(){
	return "Olá Mundo";
	}
	
	@GetMapping("/vida")
	public String Teste(){
	return "A Melhor vida vivida";
	}
	
	
	//Leitura de files aqui
	@CrossOrigin(origins = "http://localhost:64935")
	@RequestMapping("/")
	public String HomePage() throws FileNotFoundException, IOException{
		return OP();
	}

	public static String OP()  throws FileNotFoundException, IOException{
		System.out.println(" Rodando ");
		 File file = ResourceUtils.getFile("classpath:texto.txt");
		
		
		String content =new String(Files.readAllBytes(file.toPath()));
		System.out.println(content);
		return content;
	}
	
	public  void converte() {
		// Load the document from disk.
		//Document doc = new Document(dataDir + "TestFile.docx");
		
		
	}
	
		//Converter docx em html
	/*public String docTohTml() {
	    //convert .docx to HTML string
	    InputStream in= new FileInputStream(new File(path));
	    XWPFDocument document = new XWPFDocument(in);
	
	
	    XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));
	
	    OutputStream out = new ByteArrayOutputStream();
	
	
	    XHTMLConverter.getInstance().convert(document, out, options);
	    String html=out.toString();
	    System.out.println(html);
	}*/

}
