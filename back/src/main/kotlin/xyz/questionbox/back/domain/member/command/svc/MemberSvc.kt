package xyz.questionbox.back.domain.member.command.svc

import jakarta.persistence.EntityNotFoundException
import org.springframework.context.ApplicationEventPublisher
import org.springframework.security.crypto.password.PasswordEncoder
import xyz.questionbox.back.domain.member.command.MemberRepo
import xyz.questionbox.back.domain.member.command.dto.ChangePasswordReq
import xyz.questionbox.back.domain.member.command.dto.CreateMemberReq
import xyz.questionbox.back.domain.member.command.entity.Member
import xyz.questionbox.back.domain.member.command.event.CreatedMemberEvent
import xyz.questionbox.back.global.annotation.CommandService
import java.util.*


@CommandService
class MemberSvc(
    private val memberRepo: MemberRepo,
    private val passwordEncoder: PasswordEncoder,
    private val eventPublisher: ApplicationEventPublisher
) {
    fun signup(req: CreateMemberReq) {
        val password = generatePassword()
        val newMember = Member(req.email, req.name, req.nickname, password.encryptValue)
        memberRepo.save(newMember)
        eventPublisher.publishEvent(CreatedMemberEvent(req.email, password.rawValue))
    }

    fun changePassword(email: String, req: ChangePasswordReq) =
        getEntity(email).updatePassword(req.beforePassword, req.afterPassword)

    private fun generatePassword() : Password {
        val rawPassword = UUID.randomUUID().toString().substring(0, 8)
        return Password(rawPassword, encodePassword(rawPassword))
    }


    private fun encodePassword(rawPassword: String) =
        passwordEncoder.encode(rawPassword)

    private fun getEntity(id: String) =
        memberRepo.findById(id).orElseThrow { EntityNotFoundException() }
}
