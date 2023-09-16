package xyz.questionbox.back.domain.member.command.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import xyz.questionbox.back.domain.member.command.entity.Member

data class CreateMemberReq(
    @Email val email: String,
    @NotBlank val name: String,
    @NotBlank val nickname: String,
    @NotBlank val password: String,
) {
    fun toEntity() = Member(email, name, nickname, password)
}
