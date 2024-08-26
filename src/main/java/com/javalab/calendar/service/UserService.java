package com.javalab.calendar.service;

import com.javalab.calendar.dto.GenderRatioDTO;
import com.javalab.calendar.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GenderRatioDTO getGenderRatio() {
        long maleCount = userRepository.countMaleMembers();
        long femaleCount = userRepository.countFemaleMembers();

        // GenderRatioDTO에 총 회원 수와 비율 계산을 위임
        return new GenderRatioDTO(maleCount, femaleCount);
    }
}
