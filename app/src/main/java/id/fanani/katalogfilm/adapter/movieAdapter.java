package id.fanani.katalogfilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.fanani.katalogfilm.DetailActivity;
import id.fanani.katalogfilm.R;
import id.fanani.katalogfilm.pojo.pojo_movies;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//class untk menampilkan data (ist) sesuai dengan layout item list yg dibuat
public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder> {
    private Context context;
    private static ArrayList<pojo_movies> ListMovie;

    //cons
    public movieAdapter(Context context){
        this.context = context;
    }

    //setter
    public static ArrayList<pojo_movies> getListMovie() {
        return ListMovie;
    }

    public static void setListMovie(ArrayList<pojo_movies> listMovie) {
        movieAdapter.ListMovie = listMovie;
    }

    @NonNull
    @Override
    public movieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movie,
                parent, false);
        return new ViewHolder(v);
    }

    //penempatan data pojo ke item_list
    @Override
    public void onBindViewHolder(@NonNull movieAdapter.ViewHolder holder, int position) {
        pojo_movies pm = getListMovie().get(position);

        holder.tittleMovies.setText(pm.getTittle());
        holder.releaseMovies.setText(pm.getRelease_date());
        holder.descMovie.setText(pm.getDesc());
        Glide.with(holder.itemView.getContext()).load(pm.getPoster())
                .into(holder.posterMovies);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    //hubungkan dengan layout xml item_list
    public class ViewHolder extends RecyclerView.ViewHolder {

        //deklarasi
        private ImageView posterMovies;
        private TextView releaseMovies, descMovie, tittleMovies;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            posterMovies = itemView.findViewById(R.id.posterMovies);
            releaseMovies = itemView.findViewById(R.id.releaseMovies);
            descMovie = itemView.findViewById(R.id.descMovies);
            tittleMovies = itemView.findViewById(R.id.tittleMovies);

            //event onClick utk list (req: buat 1 activity baru --> halaman detail)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //isi yg ditampilkan di halaman 2 sesuai dengan gambar/data yg dipilih
                    int i = getAdapterPosition();
                    pojo_movies m = getListMovie().get(i);

                    //m.setPoster(m.getPoster());
                    m.setTittle(m.getTittle());
                    m.setDesc(m.getDesc());
                    m.setRelease_date(m.getRelease_date());

                    //pindah halaman ke detail activity
                    Intent detailIntent = new Intent(itemView.getContext(), DetailActivity.class);

                    //kririm data dari intent ke halaman detail (data class parcelable)
                    detailIntent.putExtra(DetailActivity.EXTRA_MOVIE, m);

                    context.startActivity(detailIntent);
                }
            });
        }
    }
}
