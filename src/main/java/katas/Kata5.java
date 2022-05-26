package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        System.out.println("-------------------------------------");
        System.out.println("|          MOVIES CORN24            |");
        System.out.println("-------------------------------------");
        System.out.println(" ");

        Double ratingMovies = movies
                .stream()
                .map(movie -> movie.getRating())
                .reduce((ratingMax, rating) -> {
                    return ratingMax < rating ? rating : ratingMax;
                })
                .orElse(0D);

        System.out.println(ratingMovies);
        return ratingMovies;

        //return 3.0;
    }
}
