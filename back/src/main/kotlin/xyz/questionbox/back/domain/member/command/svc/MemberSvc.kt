package xyz.questionbox.back.domain.member.command.svc

import jakarta.persistence.EntityNotFoundException
import org.springframework.context.ApplicationEventPublisher
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.transaction.annotation.Transactional
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
        val newMember = Member(req.email, req.name, req.nickname, password, passwordEncoder)

        memberRepo.save(newMember)
        eventPublisher.publishEvent(CreatedMemberEvent(req.email, password))
    }

    @Transactional
    fun changePassword(email: String, req: ChangePasswordReq) =
        getEntity(email).changePassword(req.beforePassword, req.afterPassword, passwordEncoder)

    private fun generatePassword() = UUID.randomUUID().toString().substring(0, 8)

    private fun getEntity(id: String) =
        memberRepo.findById(id).orElseThrow { EntityNotFoundException() }
}
