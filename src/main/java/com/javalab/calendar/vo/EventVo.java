package com.javalab.calendar.vo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EventVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int eventId;       // 이벤트 ID
    private String memberId;   // 회원 ID
    private int categoryId;    // 카테고리 ID
    private int routineId;     // 루틴 ID
    private String title;      // 제목
    private String location;   // 위치
    private LocalDateTime startDate;  // 시작 날짜
    private LocalDateTime endDate;    // 종료 날짜
    private String memo;       // 메모
    private int allDay;         // 종일 여부 (1: 종일, 0: 시간 지정)
    private int publice;        // 공개 여부 (1: 공개, 0: 비공개)
}
