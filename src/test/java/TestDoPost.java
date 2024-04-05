import CalculatorController.CalculatorController;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class TestDoPost {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    ServletInputStream inputStream = Mockito.mock(ServletInputStream.class);

    BufferedReader reader = new BufferedReader(new StringReader("[{\"type\":\"NUMBER\",\"value\":\"2\"},{\"type\":\"OPERATOR\",\"value\":\"Addition\"},{\"type\":\"NUMBER\",\"value\":\"3\"}]"));


    @Test
    public void test() throws Exception {
        when(request.getReader()).thenReturn(reader);

        when(request.getInputStream()).thenReturn(inputStream);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);

        new CalculatorController().doPost(request, response);

        // Verify the session attribute value
        verify(response);



    }

    @Test
    public void testMultiplication() throws Exception {


        ServletInputStream inputStream = Mockito.mock(ServletInputStream.class);

        // Mocking behavior for request.getReader()
        BufferedReader reader1 = new BufferedReader(new StringReader("[{\"type\":\"NUMBER\",\"value\":\"2\"},{\"type\":\"OPERATOR\",\"value\":\"Multiply\"},{\"type\":\"NUMBER\",\"value\":\"3\"}]"));


        when(request.getReader()).thenReturn(reader1);

        when(request.getInputStream()).thenReturn(inputStream);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);

        new CalculatorController().doPost(request, response);

        // Verify the session attribute value
        verify(response);



    }

    @Test
    public void testDivide() throws Exception {


        ServletInputStream inputStream = Mockito.mock(ServletInputStream.class);

        // Mocking behavior for request.getReader()
        BufferedReader reader1 = new BufferedReader(new StringReader("[{\"type\":\"NUMBER\",\"value\":\"2\"},{\"type\":\"OPERATOR\",\"value\":\"Divide\"},{\"type\":\"NUMBER\",\"value\":\"3\"}]"));


        when(request.getReader()).thenReturn(reader1);

        when(request.getInputStream()).thenReturn(inputStream);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);
        new CalculatorController().doPost(request, response);
        // Verify the session attribute value
        verify(response);

    }

    @Test
    public void testSubtraction() throws Exception {


        ServletInputStream inputStream = Mockito.mock(ServletInputStream.class);

        // Mocking behavior for request.getReader()
        BufferedReader reader1 = new BufferedReader(new StringReader("[{\"type\":\"NUMBER\",\"value\":\"2\"},{\"type\":\"OPERATOR\",\"value\":\"Subtraction\"},{\"type\":\"NUMBER\",\"value\":\"3\"}]"));


        when(request.getReader()).thenReturn(reader1);

        when(request.getInputStream()).thenReturn(inputStream);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);
        new CalculatorController().doPost(request, response);
        // Verify the session attribute value
        verify(response);

    }


}
