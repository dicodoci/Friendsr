package app.listview.pedor.com.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences.Editor editor;
    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Get friend clicked
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // Set all views based on selected friend
        ImageView imageView = findViewById(R.id.picture);
        imageView.setImageResource(retrievedFriend.getDrawableId());
        TextView textViewName = findViewById(R.id.name);
        textViewName.setText(retrievedFriend.getName());
        TextView textViewBio = findViewById(R.id.bio);
        textViewBio.setText(retrievedFriend.getBio());

        // Set rating back to old rating with as default value 0 stars
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();
        float rating = prefs.getFloat(retrievedFriend.getName(), (float) 0.0);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(rating);

        // Set change listener for the rating bar
        ratingBar.setOnRatingBarChangeListener(new RatingBarChangeListener());

    }
    private class RatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            System.out.println("pls no fuck");
            editor.putFloat(retrievedFriend.getName(),v);
            editor.apply();
            retrievedFriend.setRating(v);
        }
    }
}
