package com.javalab.calendar.service;

import com.javalab.calendar.repository.EventMapper;
import com.javalab.calendar.vo.EventVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

	private final EventMapper eventMapper;

	@Override
	public List<EventVo> findAllEvents() {
		return eventMapper.findAllEvents();
	}

	@Override
	public EventVo findEventById(int eventId) {
		return eventMapper.findEventById(eventId);
	}

	@Override
	public void saveEvent(EventVo event) {
		eventMapper.insertEvent(event);
	}

	@Override
	public void updateEvent(EventVo event) {
		eventMapper.updateEvent(event);
	}

	@Override
	public void deleteEvent(int eventId) {
		eventMapper.deleteEvent(eventId);
	}

	// 로그인된 사용자 정보를 기반으로 이벤트를 저장하는 메서드 추가
	public void saveEventWithMemberId(EventVo event) {
		// 현재 로그인된 사용자의 member_id 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String memberId = null;

		if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
			org.springframework.security.core.userdetails.UserDetails userDetails = (org.springframework.security.core.userdetails.UserDetails) authentication.getPrincipal();
			memberId = userDetails.getUsername(); // 사용자 ID를 반환하는 메서드 사용
		}

		event.setMemberId(memberId); // EventVo에 memberId 설정
		eventMapper.insertEvent(event);
	}
}