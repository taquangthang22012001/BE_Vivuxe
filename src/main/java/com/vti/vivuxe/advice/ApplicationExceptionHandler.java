package com.vti.vivuxe.advice;

import com.vti.vivuxe.exception.DuplicateFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


@RestControllerAdvice
public class ApplicationExceptionHandler{

//	*
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException e){
		Map<String, String> errorMap = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}


	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({NoSuchElementException.class, DuplicateFieldException.class})
	public Map<String, String> handleCustomExceptions(RuntimeException e){
		Map<String, String> errorMap = new HashMap<>();

		if(e instanceof DuplicateFieldException){
			errorMap.put("error", "Duplicate field(s) found");
		}else if(e instanceof NoSuchElementException){
			errorMap.put("error", e.getMessage());
		}else{
			errorMap.put("error", "Unknown error occurred");
		}

		return errorMap;
	}




}
