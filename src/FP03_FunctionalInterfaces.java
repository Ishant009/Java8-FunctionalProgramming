import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03_FunctionalInterfaces {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 12, 15);
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        Function<Integer, Integer> squareFunction = x -> x * x;
        Consumer<Integer> println = System.out::println;
        numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(println);

        BinaryOperator<Integer> sum1 = Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
        int sum = numbers.stream().reduce(0, sum1);
        System.out.println("sum : " + sum);

        //Suplier -> Dont have any input but return something back; eg-> create object of something..
        System.out.println("+++Suplier+++");
        Supplier<Integer> randomIntegerSupplier = () -> (int) (Math.random() * 100);
        Supplier<Integer> randomIntegerSupplier1 = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println(randomIntegerSupplier.get());
        System.out.println(randomIntegerSupplier1.get());

        System.out.println("+++Unary Operator+++");

        UnaryOperator<Integer> unaryOperator = (x) -> x * 3;
        System.out.println(unaryOperator.apply(10));

        System.out.println("+++BiPredicate+++");

        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return (number < 10 && str.length() > 5);
        };

        System.out.println(biPredicate.test(15, "integer"));

        System.out.println("+++BiFunction+++");

        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + str;
        };

        System.out.println(biFunction.apply(12, "ishant"));

        System.out.println("+++BiConsumers+++");
        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept("ishant", "couhan");
    }

}
