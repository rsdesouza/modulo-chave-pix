package br.com.itau.modulochavepix.api.errors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.itau.modulochavepix.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

class ApiErrosTest {
    @Test
    void testConstructor() {
        assertEquals(1, (new ApiErros(new BusinessException("foo"))).getErrors().size());
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testConstructor2() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at br.com.itau.modulochavepix.api.errors.ApiErros.<init>(ApiErros.java:20)
        //   In order to prevent <init>(BusinessException)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   <init>(BusinessException).
        //   See https://diff.blue/R013 to resolve this issue.

        new ApiErros((BusinessException) null);
    }

    @Test
    void testConstructor3() {
        BindingResult bindingResult = mock(BindingResult.class);
        ArrayList<ObjectError> objectErrorList = new ArrayList<>();
        when(bindingResult.getAllErrors()).thenReturn(objectErrorList);
        assertEquals(objectErrorList,
                (new ApiErros(new BindException(new BindException(new BindException(new BindException(bindingResult))))))
                        .getErrors());
        verify(bindingResult).getAllErrors();
    }

    @Test
    void testConstructor4() {
        ArrayList<ObjectError> objectErrorList = new ArrayList<>();
        objectErrorList.add(new ObjectError("Object Name", "Default Message"));
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getAllErrors()).thenReturn(objectErrorList);
        List<String> errors = (new ApiErros(
                new BindException(new BindException(new BindException(new BindException(bindingResult)))))).getErrors();
        assertEquals(1, errors.size());
        assertEquals("Default Message", errors.get(0));
        verify(bindingResult).getAllErrors();
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testConstructor5() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at br.com.itau.modulochavepix.api.errors.ApiErros.<init>(ApiErros.java:15)
        //   In order to prevent <init>(BindingResult)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   <init>(BindingResult).
        //   See https://diff.blue/R013 to resolve this issue.

        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getAllErrors()).thenReturn(new ArrayList<>());
        new BindException(new BindException(new BindException(bindingResult)));
        new ApiErros((BindingResult) null);
    }

    @Test
    void testConstructor6() {
        ArrayList<ObjectError> objectErrorList = new ArrayList<>();
        objectErrorList.add(new ObjectError("Object Name", "Default Message"));
        objectErrorList.add(new ObjectError("Object Name", "Default Message"));
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getAllErrors()).thenReturn(objectErrorList);
        List<String> errors = (new ApiErros(
                new BindException(new BindException(new BindException(new BindException(bindingResult)))))).getErrors();
        assertEquals(2, errors.size());
        assertEquals("Default Message", errors.get(0));
        assertEquals("Default Message", errors.get(1));
        verify(bindingResult).getAllErrors();
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testConstructor7() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at br.com.itau.modulochavepix.api.errors.ApiErros.lambda$new$0(ApiErros.java:15)
        //       at java.util.ArrayList.forEach(ArrayList.java:1540)
        //       at br.com.itau.modulochavepix.api.errors.ApiErros.<init>(ApiErros.java:15)
        //   In order to prevent <init>(BindingResult)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   <init>(BindingResult).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<ObjectError> objectErrorList = new ArrayList<>();
        objectErrorList.add(null);
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getAllErrors()).thenReturn(objectErrorList);
        new ApiErros(new BindException(new BindException(new BindException(new BindException(bindingResult)))));
    }
}

