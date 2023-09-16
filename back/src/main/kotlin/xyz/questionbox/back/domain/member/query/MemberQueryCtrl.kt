package xyz.questionbox.back.domain.member.query

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("members")
class MemberQueryCtrl {

    @GetMapping
    fun getMembers() : String {
        return "hello"
    }

}