package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.getFibonacci(1));
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.getFibonacci(2));
    }

    @Test
    public void should_return_2_when_calculate_given_position_is_3() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(2, fibonacci.getFibonacci(3));
    }

    @Test
    public void should_return_3_when_calculate_given_position_is_4() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(3, fibonacci.getFibonacci(4));
    }

    @Test
    public void should_return_5_when_calculate_given_position_is_5() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(5, fibonacci.getFibonacci(5));
    }

    @Test
    public void should_return_12586269025L_when_calculate_given_position_is_50() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(12586269025L, fibonacci.getFibonacci(50));
    }

}