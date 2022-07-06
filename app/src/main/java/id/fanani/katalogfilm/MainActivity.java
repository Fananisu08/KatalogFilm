package id.fanani.katalogfilm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.fanani.katalogfilm.fragment.MovieFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navView;

    FloatingActionButton msetting, mfavorite, madd_library;

    Boolean isAllFabsVisible;

    //listener
    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    //kondisi halaman yg ditampilkan dari bottom nav
                    switch (item.getItemId()){
                        case R.id.nav_movies:
                            fragment = new MovieFragment();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.framelayout, fragment, fragment.getClass()
                                            .getSimpleName()).commit();
                            return true;
                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msetting = findViewById(R.id.setting);
        mfavorite = findViewById(R.id.favorite);
        madd_library = findViewById(R.id.add_library);

        mfavorite.setVisibility(View.GONE);
        madd_library.setVisibility(View.GONE);

        isAllFabsVisible = false;

        msetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isAllFabsVisible){
                    mfavorite.show();
                    madd_library.show();
                    isAllFabsVisible = true;
                } else {
                    mfavorite.hide();
                    madd_library.hide();
                    isAllFabsVisible = false;
                }
            }
        });

        navView = findViewById(R.id.bottom_nav);
        navView.setOnNavigationItemSelectedListener(listener);
        if (savedInstanceState == null){
            navView.setSelectedItemId(R.id.nav_movies);
        } else if (savedInstanceState == null){
            navView.setSelectedItemId(R.id.nav_movies);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_view, menu);
        return super.onCreateOptionsMenu(menu);
    }
}