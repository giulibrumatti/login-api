package com.api.login.controller;

import com.api.login.dto.request.UserRequestDTO;
import com.api.login.dto.response.UserResponseDTO;
import com.api.login.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "${frontend.url}")
public class UserController {

    @Autowired
    private IUserService service;

    @Operation(summary= "Crear usuario", description="Agregar un nuevo usuario al sistema")
    @ApiResponse(responseCode = "201", description = "Usuario creado")
    @PostMapping("")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO usReqDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createUser(usReqDto));
    }
}
