package app.listview.pedor.com.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView imageView = findViewById(R.id.picture);
        imageView.setImageResource(retrievedFriend.getDrawableId());
        TextView textViewName = findViewById(R.id.name);
        textViewName.setText(retrievedFriend.getName());
        TextView textViewBio = findViewById(R.id.bio);
        textViewBio.setText(retrievedFriend.getBio());

    }
}
