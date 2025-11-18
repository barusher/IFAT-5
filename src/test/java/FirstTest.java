import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {
    public String checkNumber(int number) {
        if (number % 3 == 0) {
            return "I";
        } else if (number % 5 == 0) {
            return "F";
        }
        return "Not divide on 3 and 5";
    }

    @Test
    public void checkIfatNumberThree() {
        String actualResult = checkNumber(3);
        assertEquals(actualResult, "I", "Ожидалось другое значение");
    }

    @Test
    public void checkIfatNumberFive() {
        String actualResult = checkNumber(5);
        assertEquals(actualResult, "F", "Ожидалось другое значение");
    }
}
