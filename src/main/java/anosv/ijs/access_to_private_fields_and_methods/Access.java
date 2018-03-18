package anosv.ijs.access_to_private_fields_and_methods;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Access {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        WithPrivateFieldAndMethod privateClass = new WithPrivateFieldAndMethod();

        System.out.println("1. Get field: " + privateClass.getField());

        Method method = WithPrivateFieldAndMethod.class.getDeclaredMethod("setField", int.class);
        method.setAccessible(true);
        method.invoke(privateClass,20);

        System.out.println("2. Get field: " + privateClass.getField());

        Field field = WithPrivateFieldAndMethod.class.getDeclaredField("field");
        field.setAccessible(true);
        field.set(privateClass, 30);

        System.out.println("3. Get field: " + privateClass.getField());
    }
}
