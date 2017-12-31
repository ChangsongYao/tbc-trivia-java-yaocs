package kata.trivia;


import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameTest {
    //    TODO-user-intent: the game should be over if a player rolls the dice and answers each question correctly for 6 times
    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_and_answers_each_question_correctly_for_6_times() {
//Arrange
        Game game = new Game();
        game.add("Chet");
        boolean isGameStillInProgress = true;
//Act
        for(int i = 0; i < 6; i++){
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }
//Assert
        assertFalse(isGameStillInProgress);

    }
    //    TODO-user-intent: the game should be over if a player rolls the dice for 7 times and answers the question wrongly for 1 time followed by an odd rolling number but then correctly for 6 times.

    //    TODO-user-intent: the game should be over if a player rolls the dice for 8 times and answers the question wrongly for 1 tme followed by an even rolling number but then correctly for 7 times.

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertEquals(5, 2 + 3);
        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            System.out.println(rand.nextInt(6) + 1);
        }
    }
}
