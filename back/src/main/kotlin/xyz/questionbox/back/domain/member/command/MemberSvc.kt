package xyz.questionbox.back.domain.member.command

import xyz.questionbox.back.domain.member.command.dto.CreateMemberReq
import xyz.questionbox.back.global.annotation.CommandService


@CommandService
class MemberSvc(
    private val memberRepo: MemberRepo
) {
    fun signup(req: CreateMemberReq) {
        memberRepo.save(req.toEntity());
    }

}
