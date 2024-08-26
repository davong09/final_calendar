package com.javalab.calendar.service;

import com.javalab.calendar.dto.GenderRatioDTO;
import com.javalab.calendar.dto.UserStatisticsDTO;
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

        return new GenderRatioDTO(maleCount, femaleCount);
    }

    public UserStatisticsDTO getAgeStatistics() {
        // 나이 범위 설정 (예: 0-9, 10-19, ..., 90-99, 100 이상)
        int[] ageGroups = new int[7];
        int[][] ageRanges = { {0, 9}, {10, 19}, {20, 29}, {30, 39}, {40, 49}, {50, 59}, {60, 100} };

        for (int i = 0; i < ageRanges.length; i++) {
            ageGroups[i] = userRepository.countByAgeRange(ageRanges[i][0], ageRanges[i][1]);
        }

        return new UserStatisticsDTO(ageGroups);
    }
}
