package ru.gb.student.anroidnotes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import ru.gb.student.anroidnotes.frontend.Navigation;
import ru.gb.student.anroidnotes.frontend.NavigationType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Navigation.navigateTo(getSupportFragmentManager(), R.id.notes_list, new NotesListFragment(), NavigationType.ADD_WITHOUT_BACKSTACK);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initToolbarAndDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawer(toolbar);
    }

    private void initDrawer(Toolbar toolbar) {

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.menu_item_about:
                        Navigation.navigateTo(getSupportFragmentManager(), R.id.notes_list, new AboutAppFragment(), NavigationType.ADD_WITH_BACKSTACK);
                        return true;
                    case R.id.menu_item_settings:
                        Navigation.navigateTo(getSupportFragmentManager(), R.id.notes_list, new SettingsFragment(), NavigationType.ADD_WITH_BACKSTACK);
                        return true;
                    case R.id.menu_item_close_app:
                        finish();
                        return true;
                }
                return false;
            }
        });

    }

}