package com.javalab.calendar.controller;

import com.javalab.calendar.dto.CustomUser;
import com.javalab.calendar.dto.MemberFormDto;
import com.javalab.calendar.service.MemberService;
import com.javalab.calendar.service.MypageService;
import com.javalab.calendar.vo.MemberVo;
import com.javalab.calendar.vo.Role;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/mypage")
@Controller
@RequiredArgsConstructor
@Log4j2
public class MypageController {

    private final MypageService mypageService;
    /*
        일정 등록한 것들 볼 수 있게끔도 추가하면 좋을듯
     */

    /**
     * 회원 내용 보기 메소드
     */
    @GetMapping("/detail.do/{memberId}")
    public String getMember(@PathVariable("memberId") String memberId, Model model) {
        log.info("MyapgeController getMember");
        MemberVo memberVo = mypageService.getMember(memberId);
        model.addAttribute("memberVo", memberVo);
        return "mypage/mypagemain"; // jsp 이름
    }
}
