package com.javalab.calendar.repository;

import com.javalab.calendar.vo.EventVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/*
 * @author sujin
 */
@Mapper
public interface EventMapper {
	void insertEvent(EventVo eventVo);
	List<EventVo> selectAllEvents();
	EventVo selectEventById(int id);
	void updateEvent(EventVo eventVo);
	void deleteEvent(int id);
}
