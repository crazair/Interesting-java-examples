package anosv.ijs.prallel_and_life_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class S1Tests extends BaseTestSuits {

    @Test
    void test1() {
        System.out.println("Start test 1!");
        sleepForTest(3000);
        Assertions.assertTrue(true);
    }

    @Test
    void test2() {
        System.out.println("Start test 2!");
        sleepForTest(3000);
        Assertions.assertTrue(true);
    }

}
