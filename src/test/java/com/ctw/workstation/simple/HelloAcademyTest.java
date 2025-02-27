//package com.ctw.workstation.simple;
//
//import org.apache.commons.lang3.NotImplementedException;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.*;
//
//@ExtendWith(MockitoExtension.class)
//class HelloAcademyTest {
//
//
//    @Mock
//    ExternalMessageService externalMessageService;
//
//    @InjectMocks
//    HelloAcademy helloAcademy;
//
//
//    @Test
//    @DisplayName("Hello from outer space")
//    void hello_from_outer_space(){
//
//        //given
//        String name = "Rafael";
//
//        //mock config
//        Mockito.when(externalMessageService.sayHelloFromOuterSpace())
//                .thenThrow(new NotImplementedException("Feature not implemented"));
//
//
////        when
//        String result = helloAcademy.sayHello(null);
//
//        //then
//        assertThat(result).isEqualTo("Hello Rafael from outer space");
//    }
//    @Test
//    void hello_from_outer_space_spy(){
//
//        //given
//        String name = "ABCD";
//        HelloAcademy helloAcademy = new HelloAcademy();
//
//
//        ExternalMessageService externalMessageService = new ExternalMessageServiceImplementation();
//        ExternalMessageService externalMessageServiceSpy =  Mockito.spy(ExternalMessageService.class);
//        //helloAcademy.externalMessageService = externalMessageServiceSpy;
//
//        Mockito.doReturn("Hello World").when(externalMessageServiceSpy).sayHelloFromOuterSpace();
//
//
////        when
//        String result = helloAcademy.sayHello(name);
//
//        //then
//        assertThat(result).isEqualTo("Hello World");
//    }
//
//
//
//
//}