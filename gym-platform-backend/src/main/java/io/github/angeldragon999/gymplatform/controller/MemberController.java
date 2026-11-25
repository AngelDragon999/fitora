package io.github.angeldragon999.gymplatform.controller;

import io.github.angeldragon999.gymplatform.dto.CreateMemberRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @PostMapping
    public CreateMemberRequest createMember(@RequestBody @Valid CreateMemberRequest request) {
        return request;
    }
}
