package kata.trivia;


import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class GameTest {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertEquals(5, 2 + 3);
        Random rand = new Random();
        for(int i=0;i<25;i++){
            System.out.println(rand.nextInt(6)+1);
        }
    }
}
