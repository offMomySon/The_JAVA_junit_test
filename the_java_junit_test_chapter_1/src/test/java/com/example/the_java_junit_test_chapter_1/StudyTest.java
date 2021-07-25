package com.example.the_java_junit_test_chapter_1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @Disabled
    void create1(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create1");
    }

    @BeforeAll
    static void breforeAll(){
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before Each");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After Each");
    }
}