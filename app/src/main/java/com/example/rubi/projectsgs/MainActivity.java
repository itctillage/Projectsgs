package com.example.rubi.projectsgs;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rubi.myapplication.backend.registration.Registration;
import com.example.rubi.projectsgs.Model.FishObject;
import com.example.rubi.projectsgs.database.SeafoodDBSource;
import com.example.rubi.projectsgs.utils.SeafoodConstant;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainActivity extends ActionBarActivity {

    private Button btSpecies;
    private Button btMethod;
    private Button btTipsTrick;
    private SeafoodDBSource dbSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GcmRegistrationAsyncTask(this).execute();

        btSpecies = (Button) findViewById(R.id.bt_menu_species);
        btMethod = (Button) findViewById(R.id.bt_menu_method);
        btTipsTrick = (Button) findViewById(R.id.bt_menu_tiptrick);

        btSpecies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SeafoodSpecies.class));
            }
        });
        dbSource = new SeafoodDBSource(this);
        dbSource.open();

        FishObject fish1 = new FishObject();
        fish1.setImageId(R.drawable.blackcod);
        fish1.setCookingName("Marinated Black Cod");
        fish1.setKitchen("From: NOBU");
        fish1.setType(SeafoodConstant.TYPE_FISH);
        fish1.setCookingMaterials("Ingredients:\n" +
                "1/4 cup sake.\n" +
                "1/4 cup mirin.\n" +
                "4 tablespoons white miso paste.\n" +
                "3 tablespoons sugar.\n" +
                "4 black cod fillets, about 1/2 pound each.\n " );
        fish1.setCookingMethod("Method:\n" +
                "2 days beforehand, make the miso marinade and marinate the fish.\n" +
                "Boil sake and  mirin in a medium saucepan over high heat for 20 seconds and add the miso paste and whisk. \n" +
                "When the miso has dissolved completely, turn the heat up to high again and add the sugar, whisking constantly to ensure that the sugar doesn't burn on the bottom of the pan.\n" +
                "Remove from heat once the sugar is fully dissolved. Cool to room temperature.\n" +
                "Pat the black cod fillets thoroughly dry with paper towels. Slather the fish with the miso marinade and place in a non-reactive dish or bowl and cover tightly with plastic wrap.\n"+
                "Leave to marinate in refrigerator for 2 to 3 days.\n" + "\n" +
                "To cook the fish:\n" +
                "Preheat oven to 400°F.\n" +
                "Lightly wipe off any excess miso clinging to the fillets but don't rinse it off.\n" +
                "Place the fish skin-side-up on the pan until the surface of the fish browns and blackens in spots, about 3 minutes. \n" +
                "Flip it until the other side is browned. Transfer to the oven and bake for 5 to 10 minutes, until fish is opaque and flakes easily.");

        FishObject fish2 = new FishObject();
        fish2.setImageId(R.drawable.bakedsalmon);
        fish2.setCookingName("Baked Salmon");
        fish2.setKitchen("From: Jamie Oliver");
        fish2.setType(SeafoodConstant.TYPE_FISH);
        fish2.setCookingMaterials("Ingredients:\n" +
                "sea salt\n" +
                "freshly ground black pepper\n" +
                "700 g new potatoes\n" +
                "100 g runner beans\n" +
                "100 g green beans\n" + "\n");
        fish2.setCookingMethod("Method:\n" +
                "Preheat the oven to 230ºC/450ºF/gas 8.\n" +
                "Half-fill a large saucepan with cold water and add a tiny pinch of salt.\n" +
                "Scrub the new potatoes and cut bigger ones in half, leaving the smaller ones whole.\n" +
                "cut the runner beans into the stringy piece that runs the length of the bean.\n" +
                "Once boiling, carefully lower the potatoes into the water cooked for 10 minutes and add all the beans cooked further for 4 minutes\n" +
                "Drain the potatoes and beans, then tip into roasting tray, dot over the butter and drizzle with olive oil.\n" +
                "Rub each fillet with a little salt, pepper and olive oil, and place on top of the potatoes and beans\n" +
                "and place on top of the potatoes and beans.\n" +
                "Bake in the hot oven for 10 to 15 minutes, until the salmon is cooked through and the vegetables are soft.");

        FishObject fish3 = new FishObject();
        fish3.setImageId(R.drawable.seabass);
        fish3.setCookingName("Baked Seabass with fennel");
        fish3.setKitchen("From: Good Food");
        fish3.setType(SeafoodConstant.TYPE_FISH);
        fish3.setCookingMaterials("Ingredients:\n");
        fish3.setCookingMethod("Method:\n");

        if(dbSource.isFishTableEmpty())
        {
            dbSource.insertFish(fish1);
            dbSource.insertFish(fish2);
            dbSource.insertFish(fish3);
        }

        btTipsTrick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    class GcmRegistrationAsyncTask extends AsyncTask<Context, Void, String> {
    private static Registration regService = null;
    private GoogleCloudMessaging gcm;
    private Context context;

    // TODO: change to your own sender ID to Google Developers Console project number, as per instructions above
    private static final String SENDER_ID = "484003405342";

    public GcmRegistrationAsyncTask(Context context) {
        this.context = context;
    }


    protected String doInBackground(Context... params) {
        if (regService == null) {
            Registration.Builder builder = new Registration.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // Need setRootUrl and setGoogleClientRequestInitializer only for local testing,
                    // otherwise they can be skipped
                    .setRootUrl("https://projectsgs-1.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end of optional local run code

            regService = builder.build();
        }

        String msg = "";
        try {
            if (gcm == null) {
                gcm = GoogleCloudMessaging.getInstance(context);
            }
            String regId = gcm.register(SENDER_ID);
            msg = "Device registered, registration ID=" + regId;

            // You should send the registration ID to your server over HTTP,
            // so it can use GCM/HTTP or CCS to send messages to your app.
            // The request to your server should be authenticated if your app
            // is using accounts.
            regService.register(regId).execute();

        } catch (IOException ex) {
            ex.printStackTrace();
            msg = "Error: " + ex.getMessage();
        }
        return msg;
    }

        @Override
        protected void onPostExecute(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        Logger.getLogger("REGISTRATION").log(Level.INFO, msg);
    }
}

