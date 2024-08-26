package com.javalab.calendar.dto;

public class UserStatisticsDTO {
    private int[] ageGroups;

    public UserStatisticsDTO(int[] ageGroups) {
        this.ageGroups = ageGroups;
    }

    public int[] getAgeGroups() {
        return ageGroups;
    }

    public void setAgeGroups(int[] ageGroups) {
        this.ageGroups = ageGroups;
    }

    // 나이대 그룹의 총합을 계산하는 메서드
    private int getTotalCount() {
        int total = 0;
        for (int count : ageGroups) {
            total += count;
        }
        return total;
    }

    // 각 나이대의 비율을 반환하는 메서드
    public double[] getAgeGroupPercentages() {
        int total = getTotalCount();
        double[] percentages = new double[ageGroups.length];
        for (int i = 0; i < ageGroups.length; i++) {
            percentages[i] = total == 0 ? 0 : Math.round(((double) ageGroups[i] / total) * 100);
        }
        return percentages;
    }
}
