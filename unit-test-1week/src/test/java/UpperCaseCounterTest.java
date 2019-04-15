import org.junit.Test;

import static org.junit.Assert.*;

public class UpperCaseCounterTest {
    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    @Test
    public void getNumberOfUpperCaseCharacter() {
        String str = null;
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        // result가 0이 나와야만 pass.
        assertTrue(result == 0);
    }

    @Test
    public void emptyStringCheck() {
        String str = "";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        // result가 0이 나와야만 pass.
        assertTrue(result == 0);
    }

    @Test
    public void UpperCase_ABC() {
        String str = "ABC";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        // System.out.println(result);
        assertTrue(result == 3);
        assertFalse(result == 2);
    }

    @Test
    public void UpperCase_ABCdefGHI() {
        String str = "ABCdefGHI";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        System.out.println(result);
        assertTrue(result == 6);
    }

}