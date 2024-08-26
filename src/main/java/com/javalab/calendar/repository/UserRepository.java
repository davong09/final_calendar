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
        String sql = "SELECT COUNT(*) FROM member WHERE gender = 'male'";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    // 여성 회원 수를 가져오는 메소드
    public long countFemaleMembers() {
        String sql = "SELECT COUNT(*) FROM member WHERE gender = 'female'";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    // 나이 범위에 따른 사용자 수를 가져오는 메소드
    public int countByAgeRange(int minAge, int maxAge) {
        String sql = "SELECT COUNT(*) FROM member WHERE (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM birth)) BETWEEN ? AND ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, minAge, maxAge);
    }
}
