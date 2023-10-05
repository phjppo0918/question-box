package xyz.questionbox.back.domain.member.command.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.security.crypto.password.PasswordEncoder
import xyz.questionbox.back.domain.member.command.exception.NotMatchPasswordException

@Entity
class Member(
    @Id val email: String,
    @Column(nullable = false) val name: String,
    @Column(nullable = false, unique = true) var nickname: String,
    @Column(nullable = false) var password: String,
    passwordEncoder: PasswordEncoder,
) {
    val role: Set<Role> = setOf(Role.USER)

    init {
        password = passwordEncoder.encode(password)
    }

    fun changePassword(beforePassword: String, newPassword: String, passwordEncoder: PasswordEncoder) {
        if (!passwordEncoder.matches(beforePassword, this.password)) {
            throw NotMatchPasswordException()
        }
        password = passwordEncoder.encode(newPassword)
    }

    fun changeNickname(newNickname: String) {
        nickname = newNickname
    }

    val univDomain: String
        get() = email.split("@")[1]
}