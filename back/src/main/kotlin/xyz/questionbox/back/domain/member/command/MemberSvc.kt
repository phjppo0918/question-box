package xyz.questionbox.back.domain.member.command

import jakarta.persistence.EntityNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import xyz.questionbox.back.domain.member.command.dto.ChangePasswordReq
import xyz.questionbox.back.domain.member.command.dto.CreateMemberReq
import xyz.questionbox.back.domain.member.command.entity.Member
import xyz.questionbox.back.global.annotation.CommandService
import java.util.*


@CommandService
class MemberSvc(
    private val memberRepo: MemberRepo,
    private val passwordEncoder: PasswordEncoder
) {
    fun signup(req: CreateMemberReq) {
        val newMember = Member(req.email, req.name, req.nickname, generatePassword())
        memberRepo.save(newMember);
    }

    fun changePassword(email: String, req: ChangePasswordReq) =
        getEntity(email).updatePassword(req.beforePassword, req.afterPassword)

    private fun generatePassword() =
        encodePassword(UUID.randomUUID().toString().substring(0, 8))

    private fun encodePassword(rawPassword: String) =
        passwordEncoder.encode(rawPassword)

    private fun getEntity(id: String) =
        memberRepo.findById(id).orElseThrow { EntityNotFoundException() }
}
