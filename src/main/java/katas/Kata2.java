package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import util.DataUtil;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        System.out.println("-------------------------------------");
        System.out.println("|          MOVIES CORN24            |");
        System.out.println("-------------------------------------");

        List<Integer> arrayMovies = movies
                .stream()
                .filter(movie -> movie
                        .getRating().equals(5.0))
                .map(movie -> movie.getId())
                .collect(Collectors.toList());

        System.out.println("You can serch the movies with the best rating with this codes:");
        System.out.println(arrayMovies);
        return arrayMovies;
    }
}
