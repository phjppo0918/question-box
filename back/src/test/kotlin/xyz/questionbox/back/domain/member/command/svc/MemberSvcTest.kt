package xyz.questionbox.back.domain.member.command.svc

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.Test
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import xyz.questionbox.back.domain.member.command.MemberRepo
import xyz.questionbox.back.domain.member.command.dto.ChangePasswordReq
import xyz.questionbox.back.domain.member.command.dto.CreateMemberReq
import xyz.questionbox.back.domain.member.command.entity.Member


@SpringBootTest
class MemberSvcTest : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    lateinit var memberSvc: MemberSvc
    @Autowired
    lateinit var memberRepo: MemberRepo
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    init {
        describe("MemberService") {
            val request = CreateMemberReq("adsf@naver.com", "현준", "별명")
            it("회원가입을 수행한다") {
                memberSvc.signup(request)
                val savedMember =  memberRepo.findById(request.email).get()

                savedMember.nickname shouldBe request.nickname
                savedMember.name shouldBe request.name
                savedMember.password.shouldNotBeBlank()
            }

            it("비밀번호 변경을 수행한다") {
                val email = "kkk@gmail.com"
                val initPassword = "asdf"
                val newPassword = "new"
                memberRepo.save(Member(email, "kkk", "nick", initPassword, passwordEncoder))
                memberSvc.changePassword(email, ChangePasswordReq(initPassword, newPassword))

                val savedMember =  memberRepo.findById(email).get()

                passwordEncoder.matches(newPassword, savedMember.password) shouldBe true
            }
        }
    }
}