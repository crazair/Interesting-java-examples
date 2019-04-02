package anosv.ijs.patterns.decorator;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Button button = new ButtonBase();
        button.click();

        System.out.println("----");

        Function<Button, Button> function = ButtonDecorator::doubleClick;
        button = function.apply(button);
        button.click();

    }
}
