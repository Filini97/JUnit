import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;

public class SimpleAccountTests {

    Random rand = new Random();

    long a = rand.nextLong(0, 250_000);
    Account testAcc = new SimpleAccount(a);


//    private int startBalance = 0;

    @Test
    public void addTest() {
        // arrange
        int b = rand.nextInt(0, 500_000);

        // act
        boolean result = testAcc.add(b);

        // assert
        Assertions.assertTrue(result);

    }

    @Test
    public void payTest() {
        // arrange
        long amount = a - rand.nextLong(1, 200_000);

        // act
        boolean result = testAcc.pay(amount);

        // assert
        Assertions.assertTrue(result);
    }

}
