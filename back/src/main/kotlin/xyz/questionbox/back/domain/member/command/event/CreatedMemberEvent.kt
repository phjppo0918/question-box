package xyz.questionbox.back.domain.member.command.event

data class CreatedMemberEvent (
    val email: String,
    val rawPassword: String,
)