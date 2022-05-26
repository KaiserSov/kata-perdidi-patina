package katas;

import model.Movie;
import util.DataUtil;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map<Integer, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();

        System.out.println("-------------------------------------");
        System.out.println("|          MOVIES CORN24            |");
        System.out.println("-------------------------------------");
        List<Map<Integer, String>> arrayMovies = movies
                .stream()
                .map(movie -> Map.of(
                        movie.getId(),
                        movie.getTitle()))
                .collect(Collectors.toList());

        System.out.println("You can watch this movies for now:");
        System.out.println(arrayMovies);
        return arrayMovies;
    }
}
