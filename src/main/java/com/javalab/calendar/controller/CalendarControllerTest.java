package com.javalab.calendar.controller;

import com.javalab.calendar.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class CalendarControllerTest {

    @GetMapping("/maincalendar")
    public String mainCalendar(HttpSession session, Model model) {
        // 세션에서 memberVo 객체를 가져옴
        MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");

        // model에 memberVo 객체 추가하여 템플릿에서 사용 가능하게 설정
        model.addAttribute("memberVo", memberVo);

        // calendar/maincalendar.html 페이지로 이동
        return "calendar/maincalendar"; // HTML 파일 이름
    }

}
