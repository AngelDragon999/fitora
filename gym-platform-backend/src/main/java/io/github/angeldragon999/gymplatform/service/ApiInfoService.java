package io.github.angeldragon999.gymplatform.service;

import io.github.angeldragon999.gymplatform.dto.ApiInfoResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiInfoService {

    public ApiInfoResponse getApplicationInfo() {
        return new ApiInfoResponse(
                "Gym platform",
                "Multi-tenant gym management platform",
                "0.1.0",
                "UP"
        );
    }
}
