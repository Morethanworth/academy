//package com.ctw.workstation.simple;
//
//import com.ctw.workstation.config.CtwAcademyTestProfile;
//import com.ctw.workstation.config.WiremockResource;
//import com.github.tomakehurst.wiremock.client.WireMock;
//import io.quarkus.logging.Log;
//import io.quarkus.test.junit.QuarkusTest;
//import io.quarkus.test.junit.TestProfile;
//import jakarta.inject.Inject;
//import jakarta.ws.rs.core.Request;
//import org.assertj.core.api.Assertions;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@QuarkusTest
//@TestProfile(CtwAcademyTestProfile.class)
//class HelloAcademyExternalTest {
//
//    @Inject
//    HelloAcademy helloAcademy;
//
//    @Inject
//    Request request;
//
//
//    @Test
//    @DisplayName("Saying hello to external api")
//    void saying_hello_to_external_api() {
//
//        //given
//        String name = "Rafael";
//        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/external/hello"))
//                .willReturn(WireMock.ok("Hello " + name + "!")));
//
//        //when
//        String result = helloAcademy.sayHello(name);
//
//        //then
//
//        Assertions.assertThat(result).isEqualTo("Hello Rafael!");
//    }
//
//
//
//}