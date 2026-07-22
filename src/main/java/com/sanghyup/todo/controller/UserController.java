package com.sanghyup.todo.controller;

import com.sanghyup.todo.dto.user.SignupRequest;
import com.sanghyup.todo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
//    참고: 지금은 ResponseEntity<String>으로 "회원가입 성공"을 반환해도 괜찮다.
//    이후 프로젝트를 리팩터링하면서 ApiResponse 같은 공통 응답 형식으로 바꿔서 실무 스타일로 개선할 예정이다.
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest request) {
        userService.signup(request);

        return ResponseEntity.ok("회원가입 성공");
    }
}
