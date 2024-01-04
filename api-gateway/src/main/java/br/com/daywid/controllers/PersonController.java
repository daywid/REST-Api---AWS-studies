package br.com.daywid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daywid.exceptions.UnsupportedMathOperationException;
import br.com.daywid.math.SimpleMath;
import br.com.daywid.math.converters.NumberConverter;
import br.com.daywid.models.Person;
import br.com.daywid.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonServices service;
    //private PersonServices service = new PersonServices();

    private SimpleMath math = new SimpleMath();

   @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}



}
