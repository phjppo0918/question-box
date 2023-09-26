package xyz.questionbox.back.domain.member.query

import org.springframework.data.jpa.repository.JpaRepository
import xyz.questionbox.back.domain.member.command.entity.Member

interface MemberQueryRepo : JpaRepository<Member, String> {
    fun findByEmail(email: String) : Member
}