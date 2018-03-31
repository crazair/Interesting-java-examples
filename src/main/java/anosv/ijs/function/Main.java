package anosv.ijs.function;

public class Main {

    public static void main(String[] args) {
        doAction(() ->
                System.out.println("FFFFFUUUUUUUUUUUNNNNNNNN!!!!!!!!!"));

        doAction(new Fun() {
            @Override
            public void go() {
                System.out.println("No Lambda!");
            }
        });
    }

    interface Fun {
        void go();
    }

    public static void doAction(Fun fun) {
        System.out.println("Start!");
        fun.go();
        System.out.println("End!");
    }
}
