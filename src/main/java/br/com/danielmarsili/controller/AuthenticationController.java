package br.com.danielmarsili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielmarsili.dto.LoginDTO;
import br.com.danielmarsili.dto.LoginResponseDTO;
import br.com.danielmarsili.dto.UserMeDTO;
import br.com.danielmarsili.security.JWTTokenUtil;
import br.com.danielmarsili.service.UserService;
import br.com.danielmarsili.util.ApplicationUtils;
import io.swagger.annotations.Api;


/**
 * The Class AuthenticationController.
 */
@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Authentication")
public class AuthenticationController {

    /** The authentication manager. */
    private AuthenticationManager authenticationManager;

    /** The jwt token util. */
    private JWTTokenUtil jwtTokenUtil;

    /** The user details service. */
    private UserDetailsService userDetailsService;

    /** The user service. */
    private UserService userService;


    /**
     * User service.
     *
     * @param UserDetailsService the user details service
     * @param jwtTokenUtil the jwt token util
     * @param authenticationManager the authentication manager
     * @param userService the user service
     */
    @Autowired
    public void userService(UserDetailsService userDetailsService, //
        JWTTokenUtil jwtTokenUtil, //
        AuthenticationManager authenticationManager, //
        UserService userService) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    /**
     * Creates the authentication token.
     *
     * @param loginDTO the login DTO
     * @return the response entity
     */
    @PostMapping(path = "/signin")
    public ResponseEntity<LoginResponseDTO> createAuthenticationToken(@RequestBody LoginDTO loginDTO){
        authenticate(loginDTO.getLogin(), loginDTO.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getLogin());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    /**
     * Authenticate.
     *
     * @param username the username
     * @param password the password
     */
    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        userService.saveLastLogin(username);

    }

    /**
     * Me.
     *
     * @param authentication the authentication
     * @return the response entity
     */
    @GetMapping(path = "/me")
    public ResponseEntity<UserMeDTO> me(Authentication authentication) {
        return ResponseEntity
            .ok(ApplicationUtils.mapBean(userService.findByLogin(authentication.getName()), UserMeDTO.class));
    }

}
