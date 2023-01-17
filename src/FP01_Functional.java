import java.util.List;

/*
 *  Use of stream, map, filter, foreach.
 *
 * */
public class FP01_Functional {

    public static void main(String[] args) {

//        printAllNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
//        printEvenNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
//        printStringContainSpringInListFunctional(List.of("Spring", "Spring Boot", "Microservice", "AWS", "PCP", "Azura", "Docker", "Kubernetes"));
//        printfourLetterStrInListFunctional(List.of("Spring", "Spring Boot", "Microservice", "AWS", "PCP", "Azura", "Docker", "Kubernetes"));
        printcountStringInListFunctional(List.of("Spring", "Spring Boot", "Microservice", "AWS", "PCP", "Azura", "Docker", "Kubernetes" ));

    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
//        numbers.stream().filter(FP01_Functional::isEven).forEach(System.out::println);
        numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

    }

    private static void print(int number) {
        System.out.println(number);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // how to do?
        numbers.stream().forEach(System.out::println);

    }

    private static void printcountStringInListFunctional(List<String> strs) {

        strs.stream().map(str -> str + " " + str.length()).forEach(System.out::println);
    }

    private static void printStringContainSpringInListFunctional(List<String> strs) {

        strs.stream().filter(str -> str.contains("Spring" )).forEach(System.out::println);
    }

    private static void printfourLetterStrInListFunctional(List<String> strs) {

        strs.stream().filter(str -> str.length() >= 4).forEach(System.out::println);
    }
}
