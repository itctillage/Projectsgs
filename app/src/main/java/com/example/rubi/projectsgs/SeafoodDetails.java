package com.example.rubi.projectsgs;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rubi.projectsgs.Model.FishObject;

/**
 * Created by Rubi on 05/02/2015.
 */
public class SeafoodDetails extends ActionBarActivity {

    private ImageView ivFish;
    private TextView tvName;
    private TextView tvMaterials;
    private TextView tvKitchen;
    private TextView tvMethod;
    FishObject fishObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seafood_details);

        ivFish = (ImageView) findViewById(R.id.iv_fish);
        tvName = (TextView) findViewById(R.id.tv_name_sf);
        tvMaterials = (TextView) findViewById(R.id.tv_materials_sf);
        tvKitchen = (TextView) findViewById(R.id.tv_kitchen_sf);
        tvMethod = (TextView) findViewById(R.id.tv_method_sf);

        fishObject = (FishObject) getIntent().getSerializableExtra("data");

        if (fishObject != null) {
            ivFish.setImageResource(fishObject.getImageId());
            tvName.setText(fishObject.getCookingName());
            tvMaterials.setText(fishObject.getCookingMaterials());
            tvKitchen.setText(fishObject.getKitchen());
            tvMethod.setText(fishObject.getCookingMethod());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seafood_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


