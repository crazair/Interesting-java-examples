package anosv.ijs.patterns.decorator;

public class ButtonBase implements Button{

    @Override
    public void click() {
        System.out.println("click!");
    }
}
