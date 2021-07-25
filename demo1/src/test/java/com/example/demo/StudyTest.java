package com.example.the_java_junit_test_1_ch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
    }

}