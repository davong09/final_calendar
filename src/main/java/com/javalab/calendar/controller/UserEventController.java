package com.javalab.calendar.controller;

import com.javalab.calendar.service.UserEventService;
import com.javalab.calendar.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/user-events")
public class UserEventController {

    private final UserEventService userEventService;

    @Autowired
    public UserEventController(UserEventService userEventService) {
        this.userEventService = userEventService;
    }

    // 현재 로그인한 사용자의 이벤트 목록을 가져옵니다.
    @GetMapping
    public ResponseEntity<List<EventVo>> getEventsForCurrentUser(Principal principal) {
        String memberId = principal.getName();
        List<EventVo> events = userEventService.getEventsForUser(memberId);
        return ResponseEntity.ok(events);
    }

    // 새로운 이벤트를 생성합니다.
    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody EventVo event, Principal principal) {
        String memberId = principal.getName();
        event.setMemberId(memberId);
        userEventService.createEvent(event);
        return ResponseEntity.ok("이벤트가 성공적으로 추가되었습니다.");
    }

    // 특정 이벤트의 상세 정보를 조회합니다.
    @GetMapping("/{id}")
    public ResponseEntity<?> getEventDetail(@PathVariable int id) {
        EventVo event = userEventService.getEventById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
