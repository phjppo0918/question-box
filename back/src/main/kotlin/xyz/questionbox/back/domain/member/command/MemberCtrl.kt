package xyz.questionbox.back.domain.member.command

import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import xyz.questionbox.back.domain.member.command.dto.ChangePasswordReq
import xyz.questionbox.back.domain.member.command.dto.CreateMemberReq
import xyz.questionbox.back.domain.member.command.svc.MemberSvc


@RestController
@RequestMapping("members")
class MemberCtrl(
    private val memberSvc: MemberSvc,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody req: CreateMemberReq) = memberSvc.signup(req)


    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updatePassword(
        auth: Authentication,
        @RequestBody req: ChangePasswordReq
    ) = memberSvc.changePassword(auth.name, req)
}