import java.util.List;

/*
*  Use of Reduce method in stream
* */
public class FP02_Functional {

    public static void main(String[] args) {

        List<Integer> numbers=List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum= addListFunctional(numbers);
        System.out.println(sum);
    }
    private static int addListFunctional(List<Integer> numbers) {
        //Stream of number -> One result value
        //combine them into one result => One Value
        // 0 and FP02_Functional::sum
        return numbers.stream().reduce(0,(x,y)->x+y);
//                .reduce(0, FP02_Functional::sum);

    }
    public static int sum(int a, int b){
        System.out.println(a+" "+b);
        return a+b;
    }
}
