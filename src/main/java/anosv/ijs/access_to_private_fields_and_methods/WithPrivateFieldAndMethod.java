package anosv.ijs.access_to_private_fields_and_methods;

public class WithPrivateFieldAndMethod {

    private int field = 10;

    public WithPrivateFieldAndMethod() {
    }

    public int getField() {
        return field;
    }

    private void setField(int field) {
        this.field = field;
    }
}
