package com.javalab.calendar.repository;

import com.javalab.calendar.vo.CalendarVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CalendarMapper {

    /**
     * 사용자 ID로 캘린더 정보 가져오기
     *
     * @param memberId 캘린더를 가져올 회원의 ID
     * @return 사용자 ID에 해당하는 CalendarVo 객체
     */
    CalendarVo findByMemberId(@Param("memberId") String memberId);

    /**
     * 캘린더 이벤트 업데이트
     *
     * @param calendarVo 업데이트할 캘린더 정보가 담긴 객체
     */
    void update(CalendarVo calendarVo);

    /**
     * 새로운 일정 저장
     *
     * @param eventVo 저장할 캘린더 이벤트 정보가 담긴 객체
     */
    void saveEvent(CalendarVo eventVo);

    /**
     * 특정 월의 일정 목록 가져오기
     *
     * @param memberId 일정을 가져올 회원의 ID
     * @param month    일정을 가져올 월 (예: "2024-08")
     * @return 해당 월의 CalendarVo 객체 목록
     */
    List<CalendarVo> findEventsByMonth(@Param("memberId") String memberId, @Param("month") String month);
}
