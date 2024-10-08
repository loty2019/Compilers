import java.lang.Integer;
import java.lang.System;
import java.util.Random;

public class SwitchStatement {
    public static void main(String[] args) {
        Random rng = new Random();
        int rank = 1 + rng.nextInt(13);
        int suit = 1 + rng.nextInt(4);

        String rankStr = "";
        switch (rank) {
            case 1:
                rankStr = "Ace";
                break;
            case 11:
                rankStr = "Jack";
                break;
            case 12:
                rankStr = "Queen";
                break;
            case 13:
                rankStr = "King";
                break;
            default:
                rankStr = String.valueOf(rank);
        }

        String suitStr = "";
        switch (suit) {
            case 1:
                suitStr = "Spades";
                break;
            case 2:
                suitStr = "Hearts";
                break;
            case 3:
                suitStr = "Diamonds";
                break;
            case 4:
                suitStr = "Clubs";
        }

        System.out.println(rankStr + " of " + suitStr);
    }
}
