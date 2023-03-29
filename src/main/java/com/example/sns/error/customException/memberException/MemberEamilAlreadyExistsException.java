package com.example.sns.error.customException.memberException;

import com.example.sns.error.CustomException;
import com.example.sns.error.ErrorCode;

public class MemberEamilAlreadyExistsException extends CustomException {

	public MemberEamilAlreadyExistsException() {
		super(ErrorCode.DUPLICATE_EMAIL);
	}
}
