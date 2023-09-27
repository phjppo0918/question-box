package xyz.questionbox.back.domain.member.command

data class Password(
    val rawValue: String,
    val encryptValue: String,
)
