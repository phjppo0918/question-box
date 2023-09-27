package xyz.questionbox.back.domain.member.command.svc

data class Password(
    val rawValue: String,
    val encryptValue: String,
)
