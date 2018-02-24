package app.listview.pedor.com.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Friend> friends = new ArrayList<>();

        // Create array with names so we can loop through it
        String[] names = {"Arya", "Cersei", "Daenerys", "Jaime", "Jon", "Jorah", "Margaery",
                          "Melisandre", "Sansa", "Tyrion"};

        // Create a bios for every person
        String[] bios = {"Ik ben dat kleine meisje dat helemaal doordraait",
                "Ben al in een relatie met mn broer",
                "Ben al in een relatie met mn draken ofzo",
                "Vroeger gebruikte ik mn hand, maar moet nu wat anders zoeken",
                "Weet ik veel", "Ik ben verdikkeme nog steeds single",
                "Ik probeer macht te krijgen door rare te glimlachen",
                "Ik hoor in een gesticht", "Ik ben jong en ik wil wat",
                "Ik ben eigenlijk helemaal niet zo heel erg lang"};

        // Create friends in loop based on the names
        for(int i=0; i<10; i++) {
            String name = names[i];
            String bio = bios[i];
            friends.add(new Friend(name, bio, getResources().getIdentifier(name.toLowerCase(),
                    "drawable", getPackageName())));
        }

        // Adapter that fills the screen with all profiles
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(adapter);

        // Set on click listener for the grid
        grid.setOnItemClickListener(new GridItemClickListener());
    }

    // Class that enables going to individual profiles
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
