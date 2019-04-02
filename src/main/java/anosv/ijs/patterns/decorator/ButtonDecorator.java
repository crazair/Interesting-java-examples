package anosv.ijs.patterns.decorator;

public class ButtonDecorator {

    public static Button doubleClick(Button button){
        return () -> {
            button.click();
            button.click();
        };
    }
}
