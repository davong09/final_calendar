package com.javalab.calendar.service;

import com.javalab.calendar.repository.UserEventMapper;
import com.javalab.calendar.service.UserEventService;
import com.javalab.calendar.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEventServiceImpl implements UserEventService {

	private final UserEventMapper userEventMapper;

	@Autowired
	public UserEventServiceImpl(UserEventMapper userEventMapper) {
		this.userEventMapper = userEventMapper;
	}

	@Override
	public List<EventVo> getEventsForUser(String memberId) {
		return userEventMapper.findEventsByMemberId(memberId);
	}

	@Override
	public void createEvent(EventVo event) {
		userEventMapper.insertuserEvent(event);
	}

	@Override
	public EventVo getEventById(int id) {
		return userEventMapper.findEventById(id);
	}
}
