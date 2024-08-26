package com.javalab.calendar.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

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
public class CategoryFormDto {

    @NotNull(message = "카테고리 아이디는 필수입니다.")
    @Min(value = 1, message = "카테고리 아이디는 1 이상의 값이어야 합니다.")
    private int categoryId;  // 카테고리 ID

    @NotBlank(message = "카테고리 이름은 필수 입력입니다.")
    @Size(min = 2, max = 15, message = "카테고리 이름은 2자 이상 30자 이내로 입력하세요.")
    private String categoryName;  // 카테고리 이름

}
