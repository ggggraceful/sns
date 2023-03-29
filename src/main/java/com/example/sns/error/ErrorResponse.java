package com.example.sns.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

	private String code;
	private String errorMessage;


	public ErrorResponse(String s) {
		this.errorMessage = s;
	}

	public ErrorResponse(ErrorCode code){
		this.code = code.getCode();
		this.errorMessage = code.getMessage();
	}


}