package com.javalab.calendar.repository;

import com.javalab.calendar.vo.EventVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {
	List<EventVo> findAllEvents();
	EventVo findEventById(int eventId);
	void insertEvent(EventVo event);
	void updateEvent(EventVo event);
	void deleteEvent(int eventId);
}
