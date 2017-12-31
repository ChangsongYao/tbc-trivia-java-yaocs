package kata.trivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private ArrayList players = new ArrayList();
    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];

    private LinkedList popQuestions = new LinkedList();
    private LinkedList scienceQuestions = new LinkedList();
    private LinkedList sportsQuestions = new LinkedList();
    private LinkedList rockQuestions = new LinkedList();

    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

//   Working on TODO: Check public interface of the server-side code to see how it is being used by the client-side code
    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

//    TODO-later: The return value of method Game.add() is not used.
    public boolean add(String playerName) {


        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;
//    TODO-later: Replace System.out.println() with a log method of logger.
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    } 

//    TODO: The method Game.howManyPlayers() should be private because it is only used by its own class Game
    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int rollingNumber) {
        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + rollingNumber);

        if (inPenaltyBox[currentPlayer]) {
            if (rollingNumber % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
                currentPlayerMovesToNewPlacesAndAnswersAQuestion(rollingNumber);
            } else {
                System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
            currentPlayerMovesToNewPlacesAndAnswersAQuestion(rollingNumber);
        }

    }

    private void currentPlayerMovesToNewPlacesAndAnswersAQuestion(int rollingNumber){
        places[currentPlayer] = places[currentPlayer] + rollingNumber;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        System.out.println(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        System.out.println("The category is " + currentCategory());
        askQuestion();
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }


    private String currentCategory() {
        if (places[currentPlayer] == 0) return "Pop";
        if (places[currentPlayer] == 4) return "Pop";
        if (places[currentPlayer] == 8) return "Pop";
        if (places[currentPlayer] == 1) return "Science";
        if (places[currentPlayer] == 5) return "Science";
        if (places[currentPlayer] == 9) return "Science";
        if (places[currentPlayer] == 2) return "Sports";
        if (places[currentPlayer] == 6) return "Sports";
        if (places[currentPlayer] == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                return currentPlayerGetsAGoldCoinAndSelectNextPlayer();
            } else {
                nextPlayer();
                return true;
            }
        } else {
            return currentPlayerGetsAGoldCoinAndSelectNextPlayer();
        }
    }

    private boolean currentPlayerGetsAGoldCoinAndSelectNextPlayer(){
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");
        boolean isGameStillInProgress = didPlayerWin();
        nextPlayer();
        return isGameStillInProgress;
    }

    private void nextPlayer(){
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
//  TODO-later: The return value of method Game.wrongAnswerd() is unnecessary and should be eliminated
        return true;
    }

//  TODO: The name of the method Game.didPlayerWin() should be Game.isGameStillInProgress()
    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
}
