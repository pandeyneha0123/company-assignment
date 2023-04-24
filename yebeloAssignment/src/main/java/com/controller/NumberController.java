package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exception.categoryValueException;
import com.model.NumberResponse;
import com.service.NumberService;

public class NumberController {
private final NumberService numberService;
    
    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }
    
    @PostMapping("/FetchNextNumber")
    public ResponseEntity<NumberResponse> fetchNextNumber(@RequestBody categoryCodeRequest request) {
        try {
            int oldValue = numberService.getCurrentValue(request.getCategoryCode());
            int newValue = numberService.getNextValue(request.getCategoryCode());
            NumberResponse response = new NumberResponse(oldValue, newValue);
            return ResponseEntity.ok(response);
        } catch (categoryValueException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new NumberResponse(e.getMessage(), 0));
        }
    }

}
