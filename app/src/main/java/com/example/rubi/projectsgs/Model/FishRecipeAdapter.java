package com.example.rubi.projectsgs.Model;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rubi.projectsgs.R;

import java.util.ArrayList;

/**
 * Created by Rubi on 09/01/2015.
 */
public class FishRecipeAdapter extends ArrayAdapter<FishObject> {

    private final Activity context;
    private final ArrayList<FishObject> fishes;

    public FishRecipeAdapter(Activity context, ArrayList<FishObject> fishList) {
        super(context, R.layout.item_recipe_species, fishList);
        // TODO Auto-generated constructor stub

        this.context =context;
        this.fishes = fishList;
    }

    @Override
    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_recipe_species, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.tv_fish_item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.iv_fish_item);

        txtTitle.setText("  "+fishes.get(position).getCookingName());
        imageView.setImageResource(fishes.get(position).getImageId());

        return rowView;
    };

}
