package com.vti.vivuxe.dto.response;

import lombok.Data;

@Data
public class JWTAuthenticationResponse {
	private String token;

	private String refreshToken;
}
