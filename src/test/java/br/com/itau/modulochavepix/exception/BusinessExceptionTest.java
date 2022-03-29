package br.com.itau.modulochavepix.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BusinessExceptionTest {
    @Test
    void testConstructor() {
        BusinessException actualBusinessException = new BusinessException("foo");
        assertNull(actualBusinessException.getCause());
        assertEquals(0, actualBusinessException.getSuppressed().length);
        assertEquals("foo", actualBusinessException.getMessage());
        assertEquals("foo", actualBusinessException.getLocalizedMessage());
    }
}

