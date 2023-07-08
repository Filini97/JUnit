import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CreditAccountTests {

    Random rand = new Random();
    long b = rand.nextLong(-6_000_000, -50_000);
    long l = b - 200_000;
    Account testAcc1 = new CreditAccount(b, l);

    Account testAcc2 = new SimpleAccount(b * -1 / 2);


    @Test
    public void readyForTransferTest() {
        // arrange
        long a = rand.nextLong(0, b * -1);

        // act
        boolean result = testAcc1.readyForTransfer(a);

        // assert
        Assertions.assertTrue(result);
    }

    @Test
    public void transferTest() {
        //arrange
        long a = rand.nextLong(0, (l - b) * -1);

        //act
        boolean result = testAcc1.transfer(testAcc2, a);

        //assert
        Assertions.assertTrue(result);
    }
}
