package com.javalab.calendar.controller;

import com.javalab.calendar.service.CalendarService;
import com.javalab.calendar.vo.CalendarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    // 메인 달력 페이지 표시 ~
    @GetMapping
    public String showCalendar(Model model) {
        // 현재 로그인한 사용자 정보를 가져옵니다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String memberId = authentication.getName();

        // 사용자 이름을 모델에 추가하여 Thymeleaf 템플릿으로 전달합니다.
        model.addAttribute("memberId", memberId);

        return "calendar/maincalendar"; // 템플릿 파일 경로
    }

    // 일정 추가
    @PostMapping("/add")
    @ResponseBody
    public String addEvent(@RequestBody CalendarVo calendarVo) {
        try {
            // 현재 로그인한 사용자의 ID를 가져와서 CalendarVo에 설정합니다.
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String memberId = authentication.getName();
            calendarVo.setMemberId(memberId); // CalendarVo에 사용자 ID 설정

            // 일정 추가
            calendarService.addEvent(calendarVo);
            return "Event added successfully!";
        } catch (Exception e) {
            // 오류 처리
            return "Error adding event: " + e.getMessage();
        }
    }

    // 모든 일정 목록 조회
    @GetMapping("/list")
    @ResponseBody
    public List<CalendarVo> listEvents() {
        // 현재 로그인한 사용자의 일정을 필터링하여 가져옵니다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String memberId = authentication.getName();
        return calendarService.getEventsByUsername(memberId);
    }

    // 특정 일정 조회
    @GetMapping("/event/{id}")
    @ResponseBody
    public CalendarVo getEventById(@PathVariable int id) {
        return calendarService.getEventById(id);
    }

    // 일정 업데이트
    @PutMapping("/update")
    @ResponseBody
    public String updateEvent(@RequestBody CalendarVo calendarVo) {
        try {
            calendarService.updateEvent(calendarVo);
            return "Event updated successfully!";
        } catch (Exception e) {
            return "Error updating event: " + e.getMessage();
        }
    }

    // 일정 삭제
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteEvent(@PathVariable int id) {
        try {
            calendarService.deleteEvent(id);
            return "Event deleted successfully!";
        } catch (Exception e) {
            return "Error deleting event: " + e.getMessage();
        }
    }
}
