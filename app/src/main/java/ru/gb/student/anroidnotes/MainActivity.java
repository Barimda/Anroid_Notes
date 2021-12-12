package ru.gb.student.anroidnotes;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.*;
import androidx.appcompat.widget.*;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import ru.gb.student.anroidnotes.frontend.Navigation;
import ru.gb.student.anroidnotes.frontend.NavigationType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbarAndDrawer();
        Navigation.navigateTo(getSupportFragmentManager(), R.id.notes_list, new NotesListFragment(), NavigationType.ADD_WITHOUT_BACKSTACK);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initToolbarAndDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initToolbar(toolbar);
        initDrawer(toolbar);
    }

    private void initToolbar(Toolbar toolbar) {
        toolbar.setOnMenuItemClickListener(item -> {
            int ID = item.getItemId();
            switch (ID){
                case R.id.new_note:
                    Navigation.navigateTo(getSupportFragmentManager(), R.id.notes_list, new NoteDetailsFragment(), NavigationType.ADD_WITH_BACKSTACK);
            }
            return false;
        });
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

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemID = item.getItemId();
            switch (itemID){
                case R.id.menu_item_about:
                    Navigation.navigateTo(getSupportFragmentManager(),R.id.notes_list, new AboutAppFragment(),NavigationType.ADD_WITH_BACKSTACK);
                    drawer.closeDrawers();
                    return true;
                case R.id.menu_item_settings:
                    Navigation.navigateTo(getSupportFragmentManager(),R.id.notes_list, new SettingsFragment(),NavigationType.ADD_WITH_BACKSTACK);
                    drawer.closeDrawers();
                    return true;
                case R.id.menu_item_close_app:
                    onPause();
                    return true;
            }
            return false;
        });

    }

    @Override
    protected void onPause() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.attention_text)
                .setMessage(R.string.exit_question)
                // Из этого окна нельзя выйти кнопкой Back
                .setCancelable(true)
                .setPositiveButton(R.string.yes, (dialogInterface, i) -> finish())
                .show();
        super.onPause();
    }
}