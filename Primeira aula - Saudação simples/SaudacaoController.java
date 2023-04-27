package br.com.anderson;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacaoController {

	private static final String template = "Hello, %s!";
	private final AtomicLong contador = new AtomicLong();
	
	@RequestMapping("/saudacao")
	public Saudacao saudacao(@RequestParam(value = "name", defaultValue = "World") String name) {
		 return new Saudacao(contador.incrementAndGet(), String.format(template, name)); 
	}
	
}
