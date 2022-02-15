package com.paulinawojcik;


import java.util.Scanner;

public class Game {

    private String movieTitle;
    private String hiddenTitle;
    private int wrongGuesses;
    private boolean ongoing;

    private void initializeGame() {

        Movies movieList = new Movies("movies.txt");
        movieTitle = movieList.chooseRandomMovie();
        hiddenTitle = movieTitle;
        hiddenTitle = hiddenTitle.replace(' ', '_');
        wrongGuesses = 0;
        ongoing = true;

    }

    public void startGame() {

        initializeGame();

        while (ongoing) {

            displayGame();

            Scanner scanner = new Scanner(System.in);
            char letter = scanner.next().charAt(0);

            if (movieTitle.indexOf(letter) >= 0) {

                hiddenTitle = hiddenTitle.replace(letter, '_');

            } else {

                wrongGuesses++;
                if (wrongGuesses == 10) {
                    System.out.println("You lost. The movie title is: " + movieTitle);
                    ongoing = false;
                }

            }

            if (hiddenTitle.replace("_", "").length() == 0) {

                System.out.println("You win! The movie title is: " + movieTitle);
                ongoing = false;

            }

        }
    }

    private void displayGame() {

        StringBuilder displayedTitle = new StringBuilder();

        for (int i = 0; i < movieTitle.length(); i++) {

            if (hiddenTitle.charAt(i) == '_') {
                displayedTitle.append(movieTitle.charAt(i));
            } else {
                displayedTitle.append('_');
            }

        }

        System.out.println("\nYou have guessed (" + wrongGuesses + ") wrong letters.");
        System.out.println(displayedTitle);
        System.out.println("Guess a letter: ");
    }

}
