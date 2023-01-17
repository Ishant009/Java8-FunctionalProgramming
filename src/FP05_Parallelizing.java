import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.LongStream;

public class FP05_Parallelizing {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(0, 100000000).parallel().sum());
//        System.out.println(LongStream.range(0, 100000000).sum());
        System.out.println(System.currentTimeMillis() - time);
    }

}
