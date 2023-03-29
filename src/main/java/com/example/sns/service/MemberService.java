package com.example.sns.service;

import com.example.sns.domain.user.Member;
import com.example.sns.dto.request.SignUpReqDto;
import com.example.sns.error.customException.memberException.MemberEamilAlreadyExistsException;
import com.example.sns.error.customException.memberException.WrongPasswordCornfirmException;
import com.example.sns.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	//회원가입
	@Transactional
	public void signup(SignUpReqDto signUpReqDto) {

		validateMemberSignUpInfo(signUpReqDto);
		signUpReqDto.setPassword(passwordEncoder.encode(signUpReqDto.getPassword()));

		Member member = Member.builder()
				.email(signUpReqDto.getEmail())
				.password(passwordEncoder.encode(signUpReqDto.getPassword()))
				.build();
		memberRepository.save(member);

	}

	private void validateMemberSignUpInfo(SignUpReqDto signUpReqDto) {
		if(memberRepository.existsByEmail(signUpReqDto.getEmail()))
			throw new MemberEamilAlreadyExistsException();
		if(!signUpReqDto.getPassword().equals(signUpReqDto.getPasswordCheck())){
			throw new WrongPasswordCornfirmException();
		}

	}

}
