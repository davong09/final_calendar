//package com.javalab.calendar.controller;
//
//import com.javalab.calendar.service.EventService;
//import lombok.extern.slf4j.Slf4j;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/events")
//@RequiredArgsConstructor
//@Slf4j
//public class EventRestController {
//
//    private final EventService eventService;
//
//    @GetMapping
//    public List<EventDto> getAllEvents() {
//        log.info("getAllEvents");
//        return eventService.findAllEvents();
//    }
//
//    @PostMapping("/create")
//    public EventDto createEvent(@RequestBody EventDto eventDto) {
//        log.info("createEvent 부분");
//        eventService.saveEvent(eventDto);
//        return eventDto;
//    }
//
//    @GetMapping("/{id}")
//    public EventDto getEventById(@PathVariable int id) {
//        log.info("getEventById 부분");
//        return eventService.findEventById(id);
//    }
//
//    @PutMapping("/update")
//    public EventDto updateEvent(@RequestBody EventDto eventDto) {
//        log.info("updateEvent 부분");
//        eventService.updateEvent(eventDto);
//        return eventDto;
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteEvent(@PathVariable int id) {
//        log.info("deleteEvent 부분");
//        eventService.deleteEvent(id);
//    }
//}
