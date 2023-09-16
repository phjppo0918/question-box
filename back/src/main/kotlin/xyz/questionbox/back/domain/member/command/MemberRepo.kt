package xyz.questionbox.back.domain.member.command

import org.springframework.data.jpa.repository.JpaRepository
import xyz.questionbox.back.domain.member.command.entity.Member


interface MemberRepo : JpaRepository<Member, String>