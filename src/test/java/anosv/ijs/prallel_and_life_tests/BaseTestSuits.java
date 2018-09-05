package anosv.ijs.prallel_and_life_tests;

import org.junit.jupiter.api.AfterAll;

public class BaseTestSuits {

    static {
        // При "Parallel Execution Test" через "junit5 API" или при НЕпараллельном запуске тестов
        // блок static BaseTestSuits выполняется 1 раз перед всеми тестами всех тестовых наборах
        System.out.println("BaseTestSuits static context");

        // Лямда в ShutdownHookUtils.setHook выполняется 1 раз ПОСЛЕ выполнения всех тестов
        ShutdownHookUtils.setHook(() -> {
            System.out.println("#################");
            System.out.println("#addShutdownHook#");
            System.out.println("#################");
        });
    }

    @AfterAll
    public static void afterSuits() {
        System.out.println("AfterAll Suit!");
    }

    protected void sleepForTest(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
