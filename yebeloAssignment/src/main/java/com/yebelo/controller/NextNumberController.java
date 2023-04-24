package com.yebelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yebelo.exception.categoryValueException;
import com.yebelo.model.NumberResponse;
import com.yebelo.model.categoryValue;
import com.yebelo.service.NumberService;

@RestController
@RequestMapping("/FetchNextNumber")
public class NextNumberController {
	@Autowired
	private NumberService numService;
    
	@GetMapping(value = "/GetNumberById/{id}")
	public ResponseEntity<Long[]> getNumberById(@PathVariable(value = "id") long id) throws categoryValueException {
		Long[] fetchNextNumber = numService.fetchNextNumber(id);
		return new ResponseEntity<>(fetchNextNumber,HttpStatus.OK);
		
	}
	
	
	 //categoryValue categoryValue = ((com.model.categoryValue) categoryValue).getCategoryValueById(id);
//	    if (categoryValue == null) {
//	        throw new categoryValueException("CategoryValue not found for this id :: " + id);
//	    }
//	    NumberResponse response = new NumberResponse(categoryValue.getValue(), 0);
//	    return ResponseEntity.ok().body(response);
		//numService.

}




