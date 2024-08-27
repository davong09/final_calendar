package com.javalab.calendar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

/**
 * CategoryFormDto는 카테고리의 생성 및 업데이트 시 사용되는 데이터 전송 객체입니다.
 * 클라이언트와 서버 간의 데이터 전송을 위해 사용되며, 입력 검증을 수행합니다.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EventFormDto {

    private int eventId;

    @NotNull(message = "제목은 필수입력입니다.")
    @Size(min = 1, max = 10, message = "제목은 1자 이상 10자 이내로 입력하세요.")
    private String title; // 일정의 제목

    @NotNull(message = "카테고리 입력은 필수입니다.")
    private int categoryId;

    @NotNull(message = "내용은 필수 입력입니다.")
    @Size(min = 1, max = 1000, message = "내용은 적어도 1자 이상 1000자 이내로 입력하세요.")
    private String memo;


    @NotNull(message = "시작일자는 필수입력입니다.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "종료일자는 필수입력입니다.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String location;

    private String publice;

    private String memberId; // 추가된 필드
}
