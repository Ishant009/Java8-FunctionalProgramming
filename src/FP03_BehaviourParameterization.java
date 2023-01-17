import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03_BehaviourParameterization {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(2, 9, 13, 4, 6, 12, 12, 15);

        filterAndPrint(numbers, x1 -> x1 % 2 == 0);
        filterAndPrint(numbers, x -> x % 2 != 0);

        System.out.println("Exercise 1 : ");

        List sqrNumbers = mapAndCreateNewList(numbers, x -> x * x);
        System.out.println(sqrNumbers);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream().map(function).collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream().filter(predicate).forEach(System.out::println);

    }

}
