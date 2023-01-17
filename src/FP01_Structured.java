import java.util.List;

public class FP01_Structured {

    public static void main(String[] args) {
        printAllNumbersInListStructred(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }

    private static void printAllNumbersInListStructred(List<Integer> numbers) {
        for (int num : numbers) {
            System.out.println(num);

        }
    }
}
