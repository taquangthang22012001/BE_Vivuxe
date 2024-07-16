package com.vti.vivuxe.service.Authentication;

import com.vti.vivuxe.dto.request.SigninRequest;
import com.vti.vivuxe.dto.request.SignupRequest;
import com.vti.vivuxe.dto.response.JWTAuthenticationResponse;
import com.vti.vivuxe.entity.User;

public interface IAuthenticationService {
	User signup(SignupRequest signupRequest);

	JWTAuthenticationResponse signin(SigninRequest request);
}
