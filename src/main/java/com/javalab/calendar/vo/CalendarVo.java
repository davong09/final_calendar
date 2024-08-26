package com.javalab.calendar.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 캘린더 도메인 클래스
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CalendarVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int calenId; // 달력 번호
    private String memberId; // 회원번호
    private int eventId; // 일정번호
    private String calenName; // 달력 제목
    private String calenDetail; // 달력 상세
    private String calenColor; // 달력 색상

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate calenCreate; // 달력 생성 날짜

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate calenUpdate; // 달력 업데이트 날짜
}
