package com.hoangdp.heodat.dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoangdp.heodat.dev.User;
import com.hoangdp.heodat.dev.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v3")
@RequiredArgsConstructor
@Tag(name = "user")
public class UserController {
    private final UserRepository userRepository;

    @Operation(description = "Xem danh sách User", responses = {
        @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = User.class))), responseCode ="200")
    })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Thành công"),
        @ApiResponse(responseCode = "401", description = "Chưa xác thực"),
        @ApiResponse(responseCode = "403", description = "Truy cập bị cấm"),
        @ApiResponse(responseCode = "404", description = "Không tìm thấy"),
    })
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathParam("id") Long id){
        return userRepository.findById(id).orElse(new User());
    }

    @PostMapping
    public User creatUser(
        @Valid
        @Parameter(description = "User model create", required = true, schema = @Schema(implementation = User.class))
        @RequestBody User user
    ){
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathParam("id") Long id){
        userRepository.deleteById(id);
    }
    
}
