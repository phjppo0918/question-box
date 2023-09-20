package xyz.questionbox.back.domain.member.query

import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import xyz.questionbox.back.domain.member.query.dto.MemberRes

@Service
class MemberDao(private val memberQueryRepo: MemberQueryRepo) {
    fun getByEmail(email: String): MemberRes =
        MemberRes(memberQueryRepo.findById(email)
            .orElseThrow { EntityNotFoundException() })

}