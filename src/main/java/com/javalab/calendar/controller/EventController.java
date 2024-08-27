package com.javalab.calendar.controller;

import com.javalab.calendar.dto.EventFormDto;
import com.javalab.calendar.service.EventService;
import com.javalab.calendar.vo.EventVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/events")
@RequiredArgsConstructor
@Slf4j
public class EventController {

    private final EventService eventService;

    // 이벤트 목록 조회
    @GetMapping("/list")
    public String listEvents(Model model) {
        List<EventVo> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "event/eventList"; // 이벤트 목록을 보여주는 뷰
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        if (!model.containsAttribute("eventFormDto")) {
            model.addAttribute("eventFormDto", new EventFormDto());
        }
        log.info("getmapping에서 eventCreate.html 불러옴");
        return "event/eventCreate"; // 이벤트 생성 폼을 보여주는 뷰
    }

    // 이벤트 생성 처리
    @PostMapping("/create")
    public String createEvent(@Valid @ModelAttribute("eventFormDto") EventFormDto eventFormDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.error("Validation errors occurred: " + bindingResult.getAllErrors());
            return "event/eventCreate"; // 폼 입력 오류 시 다시 폼 페이지로 이동
        }

        EventVo event = EventVo.builder()
                .eventId(eventFormDto.getEventId())
                .title(eventFormDto.getTitle())
                .categoryId(eventFormDto.getCategoryId())
                .memo(eventFormDto.getMemo())
                .startDate(eventFormDto.getStartDate().atStartOfDay()) // LocalDate를 LocalDateTime으로 변환
                .endDate(eventFormDto.getEndDate().atTime(23, 59, 59)) // LocalDate를 LocalDateTime으로 변환
                .location(eventFormDto.getLocation())
                .publice(Integer.parseInt(eventFormDto.getPublice()))
                .build();

        // 로그인된 사용자의 memberId를 포함하여 이벤트를 저장
        eventService.saveEventWithMemberId(event);
        log.info("이벤트가 성공적으로 생성되었습니다.");
        redirectAttributes.addFlashAttribute("message", "이벤트가 성공적으로 생성되었습니다.");
        return "redirect:/events/list"; // 생성 후 목록 페이지로 리다이렉트
    }

    // 이벤트 수정 폼
    @GetMapping("/update/{eventId}")
    public String showUpdateForm(@PathVariable("eventId") int eventId, Model model) {
        EventVo event = eventService.findEventById(eventId);
        if (event == null) {
            return "redirect:/events/list"; // 이벤트가 존재하지 않을 경우 목록 페이지로 리다이렉트
        }

        EventFormDto eventFormDto = EventFormDto.builder()
                .eventId(event.getEventId())
                .title(event.getTitle())
                .categoryId(event.getCategoryId())
                .memo(event.getMemo())
                .startDate(event.getStartDate().toLocalDate()) // LocalDateTime을 LocalDate로 변환
                .endDate(event.getEndDate().toLocalDate()) // LocalDateTime을 LocalDate로 변환
                .build();

        model.addAttribute("eventFormDto", eventFormDto);
        return "event/eventUpdate"; // 이벤트 수정 폼을 보여주는 뷰
    }

    // 이벤트 수정 처리
    @PostMapping("/update/{eventId}")
    public String updateEvent(@PathVariable("eventId") int eventId,
                              @Valid @ModelAttribute("eventFormDto") EventFormDto eventFormDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "event/eventUpdate"; // 폼 입력 오류 시 수정 폼 페이지로 이동
        }

        EventVo event = EventVo.builder()
                .eventId(eventId)
                .title(eventFormDto.getTitle())
                .categoryId(eventFormDto.getCategoryId())
                .memo(eventFormDto.getMemo())
                .startDate(eventFormDto.getStartDate().atStartOfDay()) // LocalDate를 LocalDateTime으로 변환
                .endDate(eventFormDto.getEndDate().atTime(23, 59, 59)) // LocalDate를 LocalDateTime으로 변환
                .build();

        eventService.updateEvent(event);
        redirectAttributes.addFlashAttribute("message", "이벤트가 성공적으로 수정되었습니다.");
        return "redirect:/events/list"; // 수정 후 목록 페이지로 리다이렉트
    }

    // 이벤트 삭제 처리
    @PostMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable("eventId") int eventId,
                              RedirectAttributes redirectAttributes) {
        eventService.deleteEvent(eventId);
        redirectAttributes.addFlashAttribute("message", "이벤트가 성공적으로 삭제되었습니다.");
        return "redirect:/events/list"; // 삭제 후 목록 페이지로 리다이렉트
    }
}
