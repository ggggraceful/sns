package com.example.sns.controller;

import com.example.sns.dto.request.SignUpReqDto;
import com.example.sns.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<Void> registerMember(@RequestBody @Valid SignUpReqDto signUpReqDto){
		memberService.signup(signUpReqDto);
		return ResponseEntity.status(HttpStatus.OK.value()).body(null);
	}
}
