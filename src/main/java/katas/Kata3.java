package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------");
        System.out.println("|          MOVIES CORN24            |");
        System.out.println("-------------------------------------");


        List<Integer> arrayVideosId = movieLists
                .stream()
                .flatMap(videos -> videos.getVideos()
                        .stream())

                .map(id -> id.getId()
                        .intValue())

                .collect(Collectors.toList());

        System.out.println("Use this codes/ids, for serch some videos:");
        System.out.println(arrayVideosId);
        return arrayVideosId;

        //return ImmutableList.of(1, 2, 3);
    }
}
