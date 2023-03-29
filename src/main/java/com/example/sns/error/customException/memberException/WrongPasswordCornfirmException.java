package com.example.sns.error.customException.memberException;

import com.example.sns.error.CustomException;
import com.example.sns.error.ErrorCode;

public class WrongPasswordCornfirmException extends CustomException {

	public WrongPasswordCornfirmException() {
		super(ErrorCode.DUPLICATE_EMAIL);
	}
}