package com.liquorstore.oauthserver.controller;

import com.liquorstore.oauthserver.model.AuthenticationRequestDTO;
import com.liquorstore.oauthserver.model.AuthenticationResponseDTO;
import com.liquorstore.oauthserver.service.CustomAuthenticationProvider;
import com.liquorstore.oauthserver.service.CustomUserDetailsService;
import com.liquorstore.oauthserver.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {



}
