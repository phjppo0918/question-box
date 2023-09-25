package xyz.questionbox.back.domain.member.command.dto

import jakarta.validation.constraints.NotBlank

class ChangePasswordReq(
    @NotBlank val beforePassword: String,
    @NotBlank val afterPassword: String,
)