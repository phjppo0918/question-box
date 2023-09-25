package xyz.questionbox.back.domain.member.query

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.questionbox.back.domain.member.query.dto.MemberRes

@RestController
@RequestMapping("members")
class MemberQueryCtrl(private val memberDao: MemberDao) {
    @GetMapping("{email}")
    fun getMembers(@PathVariable email: String): MemberRes =
        memberDao.getByEmail(email)

    @GetMapping("me")
    fun getMe(auth: Authentication): MemberRes =
        memberDao.getByEmail(auth.name)
}