package com.example.sns.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpReqDto {

	@Email(message = "메일 양식을 지켜주세요.")
	private String email;

//	@Pattern(regexp = NICKNAME_REGEX, message = "닉네임 형식에 맞지 않습니다.")
//	private String nickname;

	@Pattern(regexp = PASSWORD_REGEX, message = "비밀번호는 소문자, 숫자, 특수문자를 필수로 포함한 8-16자 이어야 합니다. ")
	private String password;

	@NotBlank(message = "패스워드 확인을 입력해 주세요.")
	private String passwordCheck;

//	@Pattern(regexp = PHONE_REGEX, message = "휴대폰번호를 올바르게 입력해주세요.")
//	private String phone;

	// LocalDate / Long / String
//	@Pattern(regexp = BIRTH_REGEX, message = "생년월일을 입력해주세요.")
//	private String birth;


	private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,16}$"; // 소문자, 숫자, 특수문자
	private static final String NICKNAME_REGEX = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$"; // 소문자, 숫자, 한글
	private static final String PHONE_REGEX = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$"; // 000-1234-1234 또는 01012341234
	private static final String BIRTH_REGEX ="(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])"; // 20230101
}

