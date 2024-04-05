import CalculatorController.ArthmeticEvaluator;
import CalculatorController.Button;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestArthmeticEvaluator {
    @Test
    public void testCalculate() {
        ArthmeticEvaluator arthmeticEvaluator = new ArthmeticEvaluator();
        List<Button> buttons = new ArrayList<>();
        buttons.add(new Button("NUMBER", "5"));
        buttons.add(new Button("OPERATOR", "ADDITION"));
        buttons.add(new Button("NUMBER", "3"));
        assertEquals(8.0, ArthmeticEvaluator.calculate(
                buttons.toArray(new Button[0])
        ), 0.0);

    }
    @Test
    public void testCalculate1() {
        ArthmeticEvaluator arthmeticEvaluator = new ArthmeticEvaluator();
        List<Button> buttons = new ArrayList<>();
        buttons.add(new Button("NUMBER", "5"));
        buttons.add(new Button("OPERATOR", "SUBTRACTION"));
        buttons.add(new Button("NUMBER", "3"));
        assertEquals(8.0, ArthmeticEvaluator.calculate(
                buttons.toArray(new Button[0])
        ), 0.0);

    }
    @Test
    public void testCalculate2() {
        ArthmeticEvaluator arthmeticEvaluator = new ArthmeticEvaluator();
        List<Button> buttons = new ArrayList<>();
        buttons.add(new Button("NUMBER", "5"));
        buttons.add(new Button("OPERATOR", "MULTIPLY"));
        buttons.add(new Button("NUMBER", "3"));
        assertEquals(8.0, ArthmeticEvaluator.calculate(
                buttons.toArray(new Button[0])
        ), 0.0);

    }
    @Test
    public void testPerformOperation() {
        ArthmeticEvaluator arthmeticEvaluator = new ArthmeticEvaluator();

        try {
            ArthmeticEvaluator.performOperation(
                    5.0,0,"DIVISION" );
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Pass
        }

    }
}