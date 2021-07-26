package com.example.the_java_junit_test_chapter_1;

public class Study {

    private StudyStatus studyStatus = StudyStatus.DRAFT;

    private int limit;

    public Study(int limit) {
        if(limit<0){
            throw new IllegalArgumentException("limit은 0보다 커야 한다.");
        }
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return studyStatus;
    }

    public int getLimit() {
        return limit;
    }
}
