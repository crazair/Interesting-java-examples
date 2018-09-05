package anosv.ijs.prallel_and_life_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.SAME_THREAD)
public class S2Tests extends BaseTestSuits {

    @Test
    void test3() {
        System.out.println("Start test 3!");
        sleepForTest(3000);
        Assertions.assertTrue(true);
    }

    @Test
    void test4() {
        System.out.println("Start test 4!");
        sleepForTest(3000);
        Assertions.assertTrue(true);
    }

}
