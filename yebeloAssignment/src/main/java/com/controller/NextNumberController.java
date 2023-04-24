package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exception.categoryValueException;
import com.model.NumberResponse;
import com.model.categoryValue;
import com.service.NumberService;

@RestController
@RequestMapping("/FetchNextNumber")
public class NextNumberController {
    
	@RequestMapping(value = "/GetNumberById/{id}", method = RequestMethod.GET)
	public ResponseEntity<NumberResponse> getNumberById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
	    categoryValue categoryValue = categoryValue.getCategoryValueById(id);
	    if (categoryValue == null) {
	        throw new categoryValueException("CategoryValue not found for this id :: " + id);
	    }
	    NumberResponse response = new NumberResponse(categoryValue.getValue(), 0);
	    return ResponseEntity.ok().body(response);
	}

}




