import org.junit.Test;

import static org.junit.Assert.*;

public class InterpolacjaTest {

    @Test
    public void interpolacjaWPunkcie() {

        Interpolacja interpolacja = new Interpolacja(3,4);

        double[] xValue = {1, 3, 5};
        double[] yValue = {12, 4, 4};
        interpolacja.setxValue(xValue);
        interpolacja.setyValue(yValue);

        assertEquals (3.0, interpolacja.interpolacjaWPunkcie(),0.0);

    }
}