package testTasksAreNotForBank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * Created by user on 07.09.16.
 */
@RunWith(JUnitParamsRunner.class)
public class TestReverse {
    private static final Object[] getStringArray() {
        return new Object[] {
                new String[] {"123456", "654321"},
                new String[] {"qazwsx", "xswzaq"}
        };
    }

    @Test
    @Parameters(method = "getStringArray")
    public void YouShouldGetAStringInReverseOrder(
            String currentString, String reversedString) {
        assertEquals(reversedString, Reverse.reverse(currentString));
    }
}
