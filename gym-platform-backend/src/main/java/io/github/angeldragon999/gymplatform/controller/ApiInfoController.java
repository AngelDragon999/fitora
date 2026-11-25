package io.github.angeldragon999.gymplatform.controller;

import io.github.angeldragon999.gymplatform.dto.ApiInfoResponse;
import io.github.angeldragon999.gymplatform.service.ApiInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiInfoController {

    private final ApiInfoService apiInfoService;

    public ApiInfoController(ApiInfoService apiInfoService) {
        this.apiInfoService = apiInfoService;
    }

    @GetMapping("/info")
    public ApiInfoResponse getApiInfo(){
        return apiInfoService.getApplicationInfo();
    }

}