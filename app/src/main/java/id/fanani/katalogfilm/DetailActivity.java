package id.fanani.katalogfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import id.fanani.katalogfilm.pojo.pojo_movies;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_MOVIE = "extra_movie";

    ImageView detailPoster;
    TextView detailJudul, detailDate, detailDesc, detailReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailPoster = findViewById(R.id.detail_poster);
        detailJudul = findViewById(R.id.detail_judul);
        detailDate = findViewById(R.id.detail_release_date);
        detailDesc = findViewById(R.id.detail_deskripsi);
        detailReview = findViewById(R.id.detail_review);

        //ambil paket EXTRA_MOVIE
        pojo_movies movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        detailPoster.setImageResource(movies.getPoster());
        detailJudul.setText(movies.getTittle());
        detailDate.setText(movies.getRelease_date());
        detailDesc.setText(movies.getDesc());
        detailReview.setText(movies.getReview());
    }
}