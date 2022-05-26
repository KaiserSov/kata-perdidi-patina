package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {

    private static BinaryOperator<BoxArt> getSmallest() {
        return (firstBoxArt,secondBoxArt) -> firstBoxArt
                .getWidth() * firstBoxArt
                .getHeight() < secondBoxArt
                .getWidth() * secondBoxArt
                .getHeight() ? firstBoxArt : secondBoxArt;
    }

    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        System.out.println("-------------------------------------");
        System.out.println("|          MOVIES CORN24            |");
        System.out.println("-------------------------------------");

        List<Map> smallestMovie = movieLists
                .stream()
                .flatMap(movie -> movie.getVideos()
                        .stream())
                .map(video -> ImmutableMap.of("id",video
                                .getId(),"title",video
                                .getTitle(),"boxArt",
                        video.getBoxarts()
                                .stream()

                                .reduce(getSmallest())
                                .map(boxArt -> boxArt.getUrl()).get()))
                .collect(Collectors.toList());

        smallestMovie.forEach(System.out :: println);
        return smallestMovie;
    }


}

