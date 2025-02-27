//package com.ctw.workstation.simple;
//
//import io.quarkus.logging.Log;
//import io.quarkus.test.junit.QuarkusTest;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class MathOperationsTest {
//
//    private static MathOperations mathOperations;
//
//    @BeforeAll
//    static void setUp() {
//        Log.info("setting up tests");
//        mathOperations = new MathOperations();
//    }
//    @BeforeEach
//    void setUpEach() {
//        Log.info("setting up before each test");
//    }
//
//    @AfterEach
//    void tearDownEach() {
//        Log.info("tearing down after each test");
//    }
//
//    @AfterAll
//    static void tearDown() {
//        Log.info("ending tests");
//    }
//
//
//
//    @Test
//    @Order(1)
//    void add() {
//        //given
//
//        //when then
//        Assertions.assertAll(
//                () -> Assertions.assertEquals(5, mathOperations.add(3,2)),
//                () -> Assertions.assertEquals(10,mathOperations.add(5,5)),
//                () -> Assertions.assertEquals(2,mathOperations.add(-2,4))
//        );
//    }
//
//    @Test
//    @Order(2)
//    @DisplayName("Divide per 0 throws exception")
//    void dicide_per_zero(){
//        //given
//        int dividend = 2;
//        int divisor = 0;
//
//        //when then
//        Assertions.assertThrows(ArithmeticException.class, () -> mathOperations.divide(dividend,divisor));
//
//    }
//
//
//
//
//}