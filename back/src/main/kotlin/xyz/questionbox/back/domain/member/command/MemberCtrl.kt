package xyz.questionbox.back.domain.member.command

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import xyz.questionbox.back.domain.member.command.dto.CreateMemberReq


@RestController
@RequestMapping("members")
class MemberCtrl(
    private val memberSvc : MemberSvc,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody req : CreateMemberReq) {
        memberSvc.signup(req)
    }
}