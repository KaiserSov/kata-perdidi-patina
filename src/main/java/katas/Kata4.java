package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        System.out.println("-------------------------------------");
        System.out.println("|          MOVIES CORN24            |");
        System.out.println("-------------------------------------");

        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));
        List<Map> boxArtMovies =  movieLists
                .stream()
                .flatMap((movieList) -> movieList.getVideos()
                        .stream())

                .map(movie -> Map.of("id", movie
                        .getId(), "title", movie
                        .getTitle(), "boxart", movie
                        .getBoxarts()
                        .stream()
                        .filter(newBoxArt -> newBoxArt.getWidth() == 150 && newBoxArt.getHeight() == 200)
                        .map(boxartUrl -> boxartUrl.getUrl())
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());

        System.out.println("Material with pictures:");
        System.out.println(boxArtMovies);
        return boxArtMovies;
    }
}
