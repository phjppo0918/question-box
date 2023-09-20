package xyz.questionbox.back.domain.member.command.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.NoArgsConstructor
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Member(
    @Id val email: String,
    val name: String,
    var nickname: String,
    var password: String,
    val role : Set<Role> = setOf(Role.USER)
) {
    fun updatePassword(newPassword: String) {
        this.password = newPassword
    }
    fun updateNickname(newNickname: String) {
        this.nickname = newNickname
    }
}