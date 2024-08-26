// CalendarService 인터페이스 수정
package com.javalab.calendar.service;

import com.javalab.calendar.vo.CalendarVo;

import java.time.YearMonth;
import java.util.List;

public interface CalendarService {

    CalendarVo getCalendarByUserId(String memberId);

    void updateEvent(CalendarVo calendarVo);

    void saveEvent(CalendarVo eventVo);

    List<CalendarVo> getEventsByMonth(String memberId, YearMonth month);
}
