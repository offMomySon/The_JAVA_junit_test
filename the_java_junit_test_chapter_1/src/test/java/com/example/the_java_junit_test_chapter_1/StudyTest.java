package com.example.the_java_junit_test_chapter_1;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    @Test
    @DisplayName("스터디 만들기")
    void create_new_study(){
        Study study = new Study(1);


        assertAll(
                ()->assertNotNull(study),
                ()->assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면" + StudyStatus.DRAFT + " 상태입니다."),
                ()->assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능인원은 0 이상이어야 한다.")
        );
    }

    @Test
    @DisplayName("assertThrows 예시")
    void create_new_study2(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-1));
        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());
    }

    @Test
    @DisplayName("assertTimeout 예시")
    void create_new_study3(){
        // 설정한 Duration 을 초과해도,
        // 실행한 Executable 이 종료될 때 까지 기다린다.
        // Transaction 같은 경우 해당 method 를 사용하는게 안정적일 수 있다.
        assertTimeout(Duration.ofMillis(100), ()->{
            new Study(10);
            Thread.sleep(300);
        });

        // TODO ThreadLocal
        // ThreadLocal 을 사용하는 code block 이 존재하면, 예상하지 못한 결과가 발생할 수 있다.

        // Spring Transaction 의 경우 기본전략이 ThreadLocal 을 이용하고 있다.
        // 다른 Thread 에서 ThreadLocal 이 공유되지않는다. -> 전략을 변경할 수 있긴하지만..
        // 그렇기 때문에 spring 이 만든 Transactional 설정이 적용이 안될 수 있다.
        // 그렇기 때문에 실제로 Spring 의 Transaction Test 를 rollback 이 기본인데 동작하지않고 DB 에 반영되는 경우가 있다.
        // Transaction 설정을 가지고 있는 Thread 와 별개의 Thread 로 코드를 실행하기 때문이다.
        // 주의해서 사용해야한다.
        assertTimeoutPreemptively(Duration.ofMillis(100), ()->{
            new Study(10);
            Thread.sleep(300);
        });
    }
    
    @Test
    @Disabled
    void create_new_study_again(){
        Study study = new Study(-1);
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