package id.fanani.katalogfilm.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;

import id.fanani.katalogfilm.R;
import id.fanani.katalogfilm.adapter.movieAdapter;
import id.fanani.katalogfilm.pojo.pojo_movies;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private RecyclerView rvMovies;
    private ArrayList<pojo_movies> listMovies = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_movie_rv, container, false);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        listMovies.addAll(getListDataMovies());
        showRecyclerViewMovie();
        return view;
    }

    private void showRecyclerViewMovie() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getContext()));
        movieAdapter adapter = new movieAdapter(this.getContext());
        adapter.setListMovie(listMovies);
        rvMovies.setAdapter(adapter);
    }

    private ArrayList<pojo_movies> getListDataMovies() {
        String[] movieTitle = getResources().getStringArray(R.array.mv_titles);
        String[] movieReleased = getResources().getStringArray(R.array.mv_released);
        String[] movieDesc = getResources().getStringArray(R.array.mv_description);
        String[] movieReview = getResources().getStringArray(R.array.mv_reviews);
        TypedArray moviePoster = getResources().obtainTypedArray(R.array.mv_poster);

        ArrayList<pojo_movies> listMovies = new ArrayList<>();
        for (int i = 0; i<movieTitle.length; i++) {
            pojo_movies movies = new pojo_movies();
            movies.setTittle(movieTitle[i]);
            movies.setRelease_date(movieReleased[i]);
            movies.setDesc(movieDesc[i]);
            movies.setReview(movieReview[i]);
            movies.setPoster(moviePoster.getResourceId(i, -1));
            listMovies.add(movies);
        }

        return listMovies;
    }

}
