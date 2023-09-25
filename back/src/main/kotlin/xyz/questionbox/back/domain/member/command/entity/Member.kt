package xyz.questionbox.back.domain.member.command.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.NoArgsConstructor
import xyz.questionbox.back.domain.member.command.exception.NotMatchPasswordException

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Member(
    @Id val email: String,
    @Column(nullable = false) val name: String,
    @Column(nullable = false, unique = true) var nickname: String,
    @Column(nullable = false) var password: String,
    val role: Set<Role> = setOf(Role.USER)
) {
    fun updatePassword(beforePassword: String, newPassword: String) {
        if (!this.password.equals(beforePassword)) {
            throw NotMatchPasswordException()
        }
        this.password = newPassword
    }

    fun updateNickname(newNickname: String) {
        this.nickname = newNickname
    }


}