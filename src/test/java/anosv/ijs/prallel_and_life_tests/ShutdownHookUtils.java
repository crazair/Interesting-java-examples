package anosv.ijs.prallel_and_life_tests;

public class ShutdownHookUtils {

    private static ShutdownHookUtils instance;

    private ShutdownHookUtils() {
    }

    public static synchronized ShutdownHookUtils setHook(Runnable hook) {
        if (instance == null) {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> hook.run()));
            instance = new ShutdownHookUtils();
        }
        return instance;
    }

}
