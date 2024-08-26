package com.javalab.calendar.service;

import com.javalab.calendar.repository.EventMapper;
import com.javalab.calendar.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventMapper eventMapper;

	@Override
	public EventVo getEvent(int eventId) {
		return eventMapper.getEvent(eventId);
	}

	@Override
	public List<EventVo> listEvent() {
		return eventMapper.listEvent();
	}

	@Override
	public void createEvent(EventVo eventVo) {
		eventMapper.createEvent(eventVo);
	}

	@Override
	public void updateEvent(EventVo eventVo) {
		eventMapper.updateEvent(eventVo);
	}

	@Override
	public void deleteEvent(int eventId) {
		eventMapper.deleteEvent(eventId);
	}

	@Override
	public List<EventVo> findEventsByMonth(String memberId, String startDate, LocalDate endDate) {
		return eventMapper.findEventsByMonth(memberId, startDate, String.valueOf(endDate));
	}

	@Override
	public List<EventVo> getEventsByMonth(String memberId, String month) {
		return List.of();
	}
}
