package com.javalab.calendar.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Builder
public class CategoryVo implements Serializable{
	private static final long serialVersionUID = 1L;

	private int categoryId; // 매핑된 필드 이름 (CATEGORY_ID에 해당)
	private String categoryName; // 매핑된 필드 이름 (CATEGORY_NAME에 해당)

	public CategoryVo() {
	}

	public CategoryVo(int categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
}
