package com.traveldestination.planner.auth.controller;

import com.traveldestination.planner.auth.model.request.AuthenticationRequest;
import com.traveldestination.planner.auth.model.request.SignUpRequest;
import com.traveldestination.planner.auth.model.response.SignUpResponse;
import com.traveldestination.planner.auth.service.AuthService;
import com.traveldestination.planner.common.model.entity.UserEntity;
import com.traveldestination.planner.common.respository.jpa.UserRepository;
import com.traveldestination.planner.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

import static com.traveldestination.planner.common.Constant.HttpConstant.AUTHORIZATION;
import static com.traveldestination.planner.common.Constant.HttpConstant.TOKEN_PREFIX;


@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthService authService;


    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
                                          HttpServletResponse response) throws IOException, JSONException {


        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {

            throw new BadCredentialsException("Incorrect username or password.");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        Optional<UserEntity> optionalUser = userRepository.findFirstByUsername(userDetails.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        if (optionalUser.isPresent()) {
            response.getWriter().write(new JSONObject()
                    .put("userId", optionalUser.get().getId())
                    .put("role", optionalUser.get().getRole())
                    .toString() );

            response.addHeader( "Access-Control-Expose-Headers",  "Authorization");
            response.addHeader( "Access-Control-Allow-Headers",  "Authorization, X-PINGOTHER, Origin, " +
                    "X-Requested-With, Content-Type, Accept, X-Custom-header");

            response.addHeader(AUTHORIZATION, TOKEN_PREFIX + jwt);

        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser (@RequestBody SignUpRequest signupRequest){
        if (authService.hasUserWithUserName (signupRequest.getUserName())){
            return new ResponseEntity<>( "User already exists", HttpStatus.NOT_ACCEPTABLE);
        }

        SignUpResponse userDto = authService.createUser (signupRequest);
        return new ResponseEntity<> (userDto, HttpStatus.OK);

    }
}
