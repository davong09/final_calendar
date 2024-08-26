package com.javalab.calendar.controller;

import com.javalab.calendar.service.CalendarService;
import com.javalab.calendar.service.EventService;
import com.javalab.calendar.vo.CalendarVo;
import com.javalab.calendar.vo.EventVo;
import com.javalab.calendar.vo.MemberVo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/calendar")
@Slf4j
public class CalendarController {

    private final CalendarService calendarService;
    private final EventService eventService;

    @Autowired
    public CalendarController(CalendarService calendarService, EventService eventService) {
        this.calendarService = calendarService;
        this.eventService = eventService;
    }

    @GetMapping("/event/create.do")
    public String createEventForm(@RequestParam("date") String date, Model model) {
        log.info("Event creation form requested for date: {}", date);
        model.addAttribute("eventVo", new EventVo());
        model.addAttribute("selectedDate", date); // 선택된 날짜를 모델에 추가
        return "calendar/eventCreate"; // 일정 등록 폼 페이지로 이동
    }

    @PostMapping("/event/save.do")
    public String saveEvent(@ModelAttribute("eventVo") @Valid EventVo eventVo,
                            @RequestParam("date") String date,
                            @AuthenticationPrincipal MemberVo memberVo) {
        log.info("Saving event for user: {}", memberVo.getMemberId());
        eventVo.setMemberId(memberVo.getMemberId());

        // 날짜 문자열을 LocalDate로 변환
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        eventVo.setStartDate(localDate); // 시작일 설정
        eventVo.setEndDate(localDate); // 종료일 설정
        eventVo.setAllDay(1); // 종일 일정으로 설정
        eventVo.setPublice(1); // 공개로 설정

        // 서비스에서 일정을 저장하는 로직 호출
        eventService.createEvent(eventVo);
        return "redirect:/calendar/view.do"; // 저장 후 다시 캘린더 보기 페이지로 리다이렉트
    }

    @GetMapping("/data.do")
    @ResponseBody
    public List<EventVo> getCalendarData(@RequestParam("month") String month,
                                         @AuthenticationPrincipal MemberVo memberVo) {
        log.info("Fetching calendar data for month: {} and user: {}", month, memberVo.getMemberId());
        return eventService.getEventsByMonth(memberVo.getMemberId(), month); // 수정 필요: 특정 월의 일정만 가져오는 로직으로 변경 필요
    }

    @GetMapping("/view.do")
    public String viewCalendar(@AuthenticationPrincipal MemberVo memberVo, Model model) {
        log.info("Viewing calendar for user: {}", memberVo.getMemberId());
        CalendarVo calendar = calendarService.getCalendarByUserId(memberVo.getMemberId());
        model.addAttribute("calendar", calendar);
        return "calendar/maincalendar"; // 캘린더 상세 페이지로 이동
    }
}
