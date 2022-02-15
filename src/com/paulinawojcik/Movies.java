package com.paulinawojcik;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movies {

    private final List<String> movieList;

    public Movies(String filePath) {

        movieList = new ArrayList<>();

        try {
            readMovies(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    private void readMovies(String filePath) throws FileNotFoundException {

        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            movieList.add(fileScanner.nextLine());
        }
        fileScanner.close();

    }

    public String chooseRandomMovie() {

        int randomIndex = (int) (Math.random() * movieList.size());
        return movieList.get(randomIndex);

    }

    public List<String> getMovieList() {
        return movieList;
    }

}
