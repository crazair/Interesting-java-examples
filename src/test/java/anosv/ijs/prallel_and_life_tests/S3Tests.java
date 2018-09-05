package anosv.ijs.prallel_and_life_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class S3Tests extends BaseTestSuits {

    @Test
    void test5() {
        System.out.println("Start test 5!");
        sleepForTest(3000);
        Assertions.assertTrue(true);
    }

    @Test
    void test6() {
        System.out.println("Start test 6!");
        sleepForTest(3000);
        Assertions.assertTrue(true);
    }

}