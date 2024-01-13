import javax.swing.*;

public class GuessingGame {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        int totalRounds = 3; // You can change the number of rounds as needed
        int roundsPlayed = 0;
        int totalGuesses = 0;

        while (roundsPlayed < totalRounds) {
            int computerNumber = (int) (Math.random() * 100 + 1);
            int userAnswer = 0;
            int count = 1;

            System.out.println("The correct guess would be " + computerNumber);

            while (userAnswer != computerNumber) {
                String response = JOptionPane.showInputDialog(null,
                        "Enter a guess between 1 and 100", "Guessing Game", 3);
                userAnswer = Integer.parseInt(response);
                JOptionPane.showMessageDialog(null, "" + determineGuess(userAnswer, computerNumber, count));
                count++;
                totalGuesses++;
            }

            roundsPlayed++;
        }

        JOptionPane.showMessageDialog(null, "Game Over!\nTotal Correct Guesses: " + (totalRounds - roundsPlayed) +
                "\nTotal Guesses Made: " + totalGuesses);

        // Ask the user if they want to play again
        int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        if (playAgain == JOptionPane.YES_OPTION) {
            playGame();
        } else {
            JOptionPane.showMessageDialog(null, "Thank you for playing!");
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        } else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count;
        } else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
}
