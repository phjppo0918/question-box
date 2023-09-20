package xyz.questionbox.back.domain.member.query.dto

import xyz.questionbox.back.domain.member.command.entity.Member

data class MemberRes(
    val email: String,
    val name: String,
    val nickname: String
) {
    constructor(member: Member) : this(member.email, member.name, member.nickname)
}