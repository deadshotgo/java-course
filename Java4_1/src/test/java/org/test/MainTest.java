package org.test;

import org.example.Main;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
   @Test
   public void checkIsPalindromeTrue(){
       boolean isPalindrome =  Main.isPalindrome("te et");
        assertTrue(isPalindrome);
    }

    @Test
    public void checkIsPalindromeFalse(){
        boolean isPalindrome =  Main.isPalindrome("test");
        assertFalse(isPalindrome);
    }
}
