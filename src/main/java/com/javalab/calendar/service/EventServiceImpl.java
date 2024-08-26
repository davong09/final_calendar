package com.javalab.calendar.service;

import com.javalab.calendar.repository.EventMapper;
import com.javalab.calendar.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventMapper eventMapper;

	@Override
	public void createEvent(EventVo eventVo) {
		eventMapper.insertEvent(eventVo);
	}

	@Override
	public List<EventVo> getAllEvents() {
		return eventMapper.selectAllEvents();
	}

	@Override
	public EventVo getEventById(int id) {
		return eventMapper.selectEventById(id);
	}

	@Override
	public void updateEvent(EventVo eventVo) {
		eventMapper.updateEvent(eventVo);
	}

	@Override
	public void deleteEvent(int id) {
		eventMapper.deleteEvent(id);
	}
}
