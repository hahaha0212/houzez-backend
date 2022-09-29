package com.eta.houzezbackend.service;

import com.eta.houzezbackend.util.SystemParam;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

    @Mock
    SystemParam systemParam;

    @InjectMocks
    JwtService jwtService;

    @Test
    void shouldDecodeJwtWhenCreatedJwtAndDecodeJwt() {
        when(systemParam.getSECRET_KEY()).thenReturn("5970337336763979244226452948404D6351665468576D5A7134743777217A25");
        String a = jwtService.createJWT("123","name", 10);
        assertEquals("123", Objects.requireNonNull(jwtService.decodeJWT(a)).getId());
        assertEquals("name", Objects.requireNonNull(jwtService.decodeJWT(a)).getSubject());
    }

}