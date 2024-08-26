package com.javalab.calendar.repository;

import com.javalab.calendar.vo.MemberVo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 남성 회원 수를 가져오는 메소드
    public long countMaleMembers() {
        String sql = "SELECT COUNT(*) FROM member WHERE gender = '남자'";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    // 여성 회원 수를 가져오는 메소드
    public long countFemaleMembers() {
        String sql = "SELECT COUNT(*) FROM member WHERE gender = '여자'";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}
