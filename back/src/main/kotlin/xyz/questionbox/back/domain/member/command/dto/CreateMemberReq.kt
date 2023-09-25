package xyz.questionbox.back.domain.member.command.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CreateMemberReq(
    @Email val email: String,
    @NotBlank val name: String,
    @NotBlank val nickname: String,
)