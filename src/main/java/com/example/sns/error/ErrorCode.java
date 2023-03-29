package com.example.sns.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

	UNDEFINED_ERROR(HttpStatus.CONFLICT, "E00", "?? 머지 ??"),

	// 회원가입
	DUPLICATE_EMAIL(HttpStatus.CONFLICT, "R01", "이미 사용중인 이메일입니다."),
	WRONG_PASSWORD_CONFIRM(HttpStatus.CONFLICT, "R02","비밀번호가 일치하지 않습니다." ),

	// 로그인
	WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "L01", "비밀번호가 틀립니다."),
	ID_NOT_EXIST(HttpStatus.BAD_REQUEST, "L02", "존재하지 않는 아이디입니다."),

	// 토큰
	INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "T01", "유효하지 않은 토큰입니다."),
	TOKEN_NOT_EXIST(HttpStatus.UNAUTHORIZED, "T02", "토큰이 없습니다.");


	private HttpStatus httpStatus;
	private String code;
	private String message;


	ErrorCode(HttpStatus httpStatus, String code, String message) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
	}
}