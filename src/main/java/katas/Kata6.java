package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------");
        System.out.println("|          MOVIES CORN24            |");
        System.out.println("-------------------------------------");

        String moviesUrl = movies
                .stream()
                .map(boxart -> boxart.getBoxarts())
                .flatMap(secondBoxA -> secondBoxA.stream())
                .reduce((boxArt, boxArt_2) -> boxArt.getWidth() * boxArt
                        .getHeight() > boxArt_2.getWidth() * boxArt_2
                        .getHeight() ? boxArt : boxArt_2)

                .map(boxart -> boxart.getUrl())
                .orElseThrow();

        System.out.println(moviesUrl);
        return moviesUrl;
    }

}


