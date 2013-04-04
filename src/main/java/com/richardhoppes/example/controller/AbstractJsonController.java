package com.richardhoppes.example.controller;

import com.richardhoppes.example.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractJsonController {

	/**
	 * Handle ResourceNotFoundException
	 * 1. Set response status to 404
	 * 2. Return standard JSON error response
	 * @param ex ResourceNotFoundException
	 * @return Standard JSON error response
	 */
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody
	Map<String, String> handleException(ResourceNotFoundException ex) {
		return createStandardResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * Create a standard error response map
	 * @param message Error message that should be displayed
	 * @param httpStatus
	 * @return Error response map
	 */
	protected Map<String, String> createStandardResponse(String message, HttpStatus httpStatus) {
		Map<String, String> retVal = new HashMap<String, String>();
		retVal.put("message", message);
		retVal.put("status_code", httpStatus.toString());
		retVal.put("status_message", httpStatus.getReasonPhrase());
		return retVal;
	}


}
