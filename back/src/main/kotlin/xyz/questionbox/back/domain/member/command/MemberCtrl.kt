package xyz.questionbox.back.domain.member.command

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import xyz.questionbox.back.domain.member.command.dto.CreateMemberReq


@RestController
@RequestMapping("members")
class MemberCtrl(
    private val memberSvc : MemberSvc,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(req : CreateMemberReq) {
        memberSvc.signup(req)
    }
}