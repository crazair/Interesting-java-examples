package anosv.ijs.elegant_java_builder;

public class Main {

    public static void main(String[] args) {
        Account account = Account.newBuilder()
                .setToken("hello")
                .setUserId("habr")
                .build();
    }
}
