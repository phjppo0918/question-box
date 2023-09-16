package xyz.questionbox.back.global.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import xyz.questionbox.back.domain.member.command.entity.Member

class SecurityUser(
    val member: Member
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return member.role.map {
            SimpleGrantedAuthority(it.name)
        }.toMutableList()
    }

    override fun getPassword() = member.password
    override fun getUsername() = member.email
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true

}