package com.javalab.calendar.dto;

public class GenderRatioDTO {
    private long maleCount;
    private long femaleCount;

    // Constructor
    public GenderRatioDTO(long maleCount, long femaleCount) {
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
    }

    // Getter/Setter
    public long getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(long maleCount) {
        this.maleCount = maleCount;
    }

    public long getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(long femaleCount) {
        this.femaleCount = femaleCount;
    }

    // 추가된 메소드: 성비 계산
    public double getMalePercentage() {
        long total = maleCount + femaleCount;
        return total == 0 ? 0 : (int)Math.round(((double) maleCount / total) * 100);
    }

    public double getFemalePercentage() {
        long total = maleCount + femaleCount;
        return total == 0 ? 0 : (int)Math.round(((double) femaleCount / total) * 100);
    }
}
