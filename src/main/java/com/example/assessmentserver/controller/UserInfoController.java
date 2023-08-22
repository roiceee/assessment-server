package com.example.assessmentserver.controller;

import com.example.assessmentserver.dto.UserInfoDTO;
import com.example.assessmentserver.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://roice-assessment.vercel.app"})
@RequestMapping("api/userinfo")
@AllArgsConstructor
public class UserInfoController {

    private UserInfoService userInfoService;

    @GetMapping("test")
    public String getUserInfo() {
        return "Hello World!";
    }

    @PutMapping("save")
    public ResponseEntity<UserInfoDTO> saveUserInfo(Authentication authentication,
                                                    @RequestBody UserInfoDTO userInfoDTO) {
        UserInfoDTO userInfo = userInfoService.saveUserInfo(authentication.getName(), userInfoDTO);
        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("get")
    public ResponseEntity<UserInfoDTO> getUserInfo(Authentication authentication) {
        UserInfoDTO userInfo = userInfoService.getUserInfo(authentication.getName());
        return ResponseEntity.ok(userInfo);
    }

}
