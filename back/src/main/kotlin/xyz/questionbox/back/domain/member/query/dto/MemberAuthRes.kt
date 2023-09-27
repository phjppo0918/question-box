package xyz.questionbox.back.domain.member.query.dto

import xyz.questionbox.back.domain.member.command.entity.Member

class MemberAuthRes (
    val email: String,
    val password: String,
    val role : List<String>
){
    constructor(member: Member) : this(member.email, member.password, member.role.map {it.name})
}
