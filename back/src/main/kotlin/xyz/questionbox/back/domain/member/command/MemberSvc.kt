package xyz.questionbox.back.domain.member.command

import xyz.questionbox.back.domain.member.command.dto.CreateMemberReq
import xyz.questionbox.back.domain.member.command.entity.Member
import xyz.questionbox.back.global.annotation.CommandService
import java.util.UUID


@CommandService
class MemberSvc(
    private val memberRepo: MemberRepo
) {
    fun signup(req: CreateMemberReq) {
        val newMember = Member(req.email, req.name, req.nickname, generatePassword())
        memberRepo.save(newMember);
    }

    private fun generatePassword() = UUID.randomUUID().toString().substring(0, 8)


}
