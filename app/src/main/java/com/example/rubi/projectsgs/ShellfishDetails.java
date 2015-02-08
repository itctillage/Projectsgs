package com.example.rubi.projectsgs;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rubi on 09/01/2015.
 */
public class ShellfishDetails extends ActionBarActivity {

    private ArrayList<String> recipeList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seafood_shellfish_details);

        recipeList = new ArrayList<>();
        recipeList.add("Lobster");
        recipeList.add("Oyster");
        recipeList.add("Abalone");
        recipeList.add("Clams");
        recipeList.add("Mussels");
        recipeList.add("Scallops");
        recipeList.add("Crabs");

        final ListView listview = (ListView) findViewById(R.id.lv_mon_listview);
        /*final FishRecipeAdapter adapter = new FishRecipeAdapter(this,
                recipeList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,final int position, long id) {

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

        return super.onOptionsItemSelected(item); */
    }
}
