package anosv.ijs.initializing_constants;

import java.util.HashSet;
import java.util.Set;

public class InitializingConstants {

    private static final Set<String> STRING_SET = new HashSet<String>() {
        {
            add("1");
            add("2");
            add("3");
        }
    };

    public static void main(String[] args) {
        STRING_SET.forEach(System.out::println);
    }
}
