package app.listview.pedor.com.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dico on 22-2-2018.
 */

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;
    public FriendsAdapter(@NonNull Context context, int resource,
                          @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent,
                                                                    false);
        }

        // Set the views with information based on the position in the friends ArrayList
        ImageView imageView = convertView.findViewById(R.id.picture);
        imageView.setImageResource(friends.get(position).getDrawableId());
        TextView textView = convertView.findViewById(R.id.name);
        textView.setText(friends.get(position).getName());

        return convertView;
    }


}
