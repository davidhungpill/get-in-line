package com.fastcampus.getinline.controller.api;

import com.fastcampus.getinline.dto.APIDataResponse;
import com.fastcampus.getinline.dto.AdminRequest;
import com.fastcampus.getinline.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class APIAuthController {

    @PostMapping("/sing-up")
    public APIDataResponse<String> singUp(@RequestBody AdminRequest adminRequest)
    {
        return APIDataResponse.empty();
    }

    @PostMapping("/login")
    public APIDataResponse<String> login(@RequestBody LoginRequest loginRequest)
    {
        return APIDataResponse.empty();
    }

}
