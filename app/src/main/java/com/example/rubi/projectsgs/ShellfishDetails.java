package com.example.rubi.projectsgs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rubi.projectsgs.Model.FishRecipeAdapter;
import com.example.rubi.projectsgs.database.SeafoodDBSource;
import com.example.rubi.projectsgs.Model.FishObject;

import java.util.ArrayList;

/**
 * Created by Rubi on 09/01/2015.
 */
public class ShellfishDetails extends ActionBarActivity {

    ArrayList<FishObject> recipeList;
    SeafoodDBSource dataSource;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seafood_shellfish_details);

        dataSource = new SeafoodDBSource(this);
        dataSource.open();

        recipeList = new ArrayList<>();
        recipeList = dataSource.getAllShellfish();

        final ListView listview = (ListView) findViewById(R.id.lv_mon_listview);
        final FishRecipeAdapter adapter = new FishRecipeAdapter(this,
                recipeList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,final int position, long id) {
                startActivity(new Intent(ShellfishDetails.this, RecipeDetails.class).putExtra("data", recipeList.get(position)));
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seafood_shellfish_recipe, menu);
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
