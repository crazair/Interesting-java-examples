package anosv.ijs.or_else_optional;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    /*
    * Самый чистый подход "попробуйте услуги" с учетом текущего API.
    * Важным аспектом является не постоянная цепочка операций, которую вы должны написать один раз,
    * но как легко добавить другую услугу (или изменить список служб в целом).
    * Здесь достаточно добавить или удалить один ()->serviceX().
    *
    * Из-за ленивой оценки потоков никакой сервис не будет вызываться,
    * если предыдущая служба вернула непустую Optional.
    */
    public static void main(String[] args) {
        Optional<String> result = new Main().getOptionalString();
        System.out.println(result.get());
    }

    private Optional<String> getOptionalString() {
        return Stream.<Supplier<Optional<String>>>of(
                () -> serviceA(),
                () -> serviceB(),
                () -> serviceC())
               .map(Supplier::get)
               .filter(Optional::isPresent)
               .map(Optional::get)
               .findFirst();
    }

    private static Optional<String> serviceA() {
        System.out.println("serviceA");
        return Optional.ofNullable(null);
    }

    private static Optional<String> serviceB() {
        System.out.println("serviceB");
        return Optional.ofNullable("1");
    }

    private static Optional<String> serviceC() {
        System.out.println("serviceC");
        return Optional.ofNullable("123");
    }
}