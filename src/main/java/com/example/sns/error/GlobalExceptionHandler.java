package com.example.sns.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// genernal Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleApiRequestException(Exception ex) {
		if(ex.getMessage().contains(""))
			return new ResponseEntity<>(new ErrorResponse(ErrorCode.UNDEFINED_ERROR), HttpStatus.CONFLICT);
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage()); // 나중에 Custom Error Code로 변경
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}

	// Custom Exception
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleCustomException(CustomException e) {
		ErrorCode errorCode = e.getErrorCode();
		ErrorResponse errorResponse = new ErrorResponse(errorCode);
		return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
	}

	// Validation Exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		ObjectError objectError = e.getAllErrors().get(0);
		return ResponseEntity.badRequest()
				.body(new ErrorResponse(objectError.getDefaultMessage()));
	}

}