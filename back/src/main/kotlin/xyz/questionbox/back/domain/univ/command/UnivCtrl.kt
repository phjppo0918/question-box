package xyz.questionbox.back.domain.univ.command

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("univ")
class UnivCtrl(
    private val univSvc: UnivSvc,
) {
}