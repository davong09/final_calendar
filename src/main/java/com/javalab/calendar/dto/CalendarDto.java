package com.javalab.calendar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

/**
 * 캘린더 데이터 전송 객체 (DTO)
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CalendarDto {

    private int calenId; // 캘린더 ID
    private String memberId; // 회원 ID
    private int eventId; // 이벤트 ID
    private String calen_name; // 캘린더 이름
    private String calen_detail; // 캘린더 세부사항
    private String calen_color; // 캘린더 색상
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate calen_create; // 캘린더 생성 날짜
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate calen_update; // 캘린더 업데이트 날짜
}
