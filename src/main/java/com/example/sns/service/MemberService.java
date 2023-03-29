package com.example.sns.service;

import com.example.sns.domain.user.Member;
import com.example.sns.dto.request.MemberReqDto;
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
	public void signup(MemberReqDto memberReqDto) {

		validateMemberSignUpInfo(memberReqDto);
		memberReqDto.setPassword(passwordEncoder.encode(memberReqDto.getPassword()));

		Member member = Member.builder()
				.email(memberReqDto.getEmail())
				.password(passwordEncoder.encode(memberReqDto.getPassword()))
				.build();
		memberRepository.save(member);

	}

	private void validateMemberSignUpInfo(MemberReqDto memberReqDto) {
		if(memberRepository.existsByEmail(memberReqDto.getEmail()))
			throw new MemberEamilAlreadyExistsException();
		if(!memberReqDto.getPassword().equals(memberReqDto.getPasswordCheck())){
			throw new WrongPasswordCornfirmException();
		}

	}

}
