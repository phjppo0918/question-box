package xyz.questionbox.back.global.security

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import xyz.questionbox.back.domain.member.query.MemberDao

@Service
class UserDetailServiceImpl(
    private val memberDao: MemberDao
) : UserDetailsService {
    override fun loadUserByUsername(username: String?) =
        MemberAuth(memberDao.getAuth(username!!))
}