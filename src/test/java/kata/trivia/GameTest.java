package kata.trivia;


import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameTest {
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
    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_for_7_times_and_answer_the_question_wrongly_for_1_time_followed_by_an_odd_rolling_number_but_then_correctly_for_6_times() {
//Arrange
        Game game = new Game();
        game.add("Chet");
        boolean isGameStillInProgress = true;
//Act
        game.roll(1);
        game.wrongAnswer();
        game.roll(1);
        game.wasCorrectlyAnswered();
        for(int i = 0; i < 5; i++){
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }
//Assert
        assertFalse(isGameStillInProgress);

    }
    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_for_8_times_and_answers_the_question_wrongly_for_1_tme_followed_by_an_even_rolling_number_but_then_correctly_for_7_times() {
//Arrange
        Game game = new Game();
        game.add("Chet");
        boolean isGameStillInProgress = true;
//Act
        game.roll(1);
        game.wrongAnswer();
        game.roll(2);
        game.wasCorrectlyAnswered();
        for (int i = 0; i < 6; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }
//Assert
        assertFalse(isGameStillInProgress);
    }
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
