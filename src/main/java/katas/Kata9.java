package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------");
        System.out.println("|          MOVIES CORN24            |");
        System.out.println("-------------------------------------");

        List<Map> middleMovies = movieLists.stream()
                .flatMap( middle -> middle.getVideos()
                        .stream())
                .map(moment -> ImmutableMap.of("id", moment
                        .getId(), "title", moment.getTitle(), "time", moment
                        .getInterestingMoments()
                        .stream()

                        .map(dateTime -> dateTime.getTime())
                        .collect(Collectors.toList()),
                        "url", moment.getBoxarts()
                                .stream()

                        .reduce((firstBoxart,secondBoxart) -> firstBoxart
                                .getWidth() < firstBoxart
                                .getHeight() ? firstBoxart:secondBoxart)
                                .map(url -> url.getUrl())))
                .collect(Collectors.toList());

        System.out.println("Interesting moment time, and smallest box art url");
        System.out.println(middleMovies);
        return middleMovies;
    }
}
