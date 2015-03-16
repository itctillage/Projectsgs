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
                "100 g green beans\n");
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
        fish3.setCookingMaterials("Ingredients:\n" +
                "2 small sea bass, scaled and gutted\n" +
                "1 fennel bulb, sliced\n" +
                "1 lemon, sliced\n" +
                "handful basil leaves, roughly torn\n" +
                "small handful black olives\n" +
                "1 tbsp olive oil\n");
        fish3.setCookingMethod("Method:\n" +
                "Heat oven to 200C/180C fan/gas 6.\n" +
                "Rinse and dry the fish. Season all over, then stuff the cavity with some fennel slices, lemon and basil.\n " +
                "Scatter the olives and any leftover fennel, basil and lemon into a roasting tin.\n" +
                "Place the sea bass on top. Drizzle each fish with the oil and bake for about 30 mins or until cooked through and starting to brown.");

        FishObject fish4 = new FishObject();
        fish4.setImageId(R.drawable.fishbulgar);
        fish4.setCookingName("White Fish with Spiced bulghar pilaf");
        fish4.setKitchen("From: Good Food");
        fish4.setType(SeafoodConstant.TYPE_FISH);
        fish4.setCookingMaterials("Ingredients:\n" +
                "4 firm white fish fillets\n" +
                "1 tbsp olive oil\n" +
                "2 onions, finely sliced\n" +
                "3 carrots, grated\n" +
                "2 tsp cumin seeds\n" +
                "2 tbsp harissa\n" +
                "200g bulghar wheat\n" +
                "6 dried apricots, chopped\n" +
                "700ml weak chicken stock (using 1 stock cube)\n" +
                "200g baby spinach\n" +
                "4 thin lemon slices\n");
        fish4.setCookingMethod("Method:\n"+
                "Heat the oil in a lidded flameproof casserole dish. Tip in the onions and cook for 10 mins until soft and golden.\n" +
                "Add the carrots and cumin, and cook for 2 mins more.\n" +
                "Stir through the harissa, bulghar and apricots, pour over the stock and bring to the boil. Cover and simmer for 7 mins.\n" +
                "Add the spinach and stir through until just wilted. Arrange the fish fillets on top, pop a slice of lemon on each and season.\n" +
                "Replace the lid and cook for 8 mins, keeping over a low-ish heat.\n" +
                "Turn heat to low and cook for 7-8 mins more until the fish is cooked through and the bulghar is tender. Season with pepper and serve.");

        FishObject fish5 = new FishObject();
        fish5.setImageId(R.drawable.thaisalmon);
        fish5.setCookingName("Grill Thai Salmon");
        fish5.setKitchen("From: Good Food");
        fish5.setType(SeafoodConstant.TYPE_FISH);
        fish5.setCookingMaterials("Ingredients:\n" +
                "4 x 140g/5oz salmon fillets\n" +
                "2 tsp sunflower oil\n" +
                "small knob of root ginger, peeled and grated\n" +
                "1 mild red chilli, finely sliced \n" +
                "bunch spring onions, finely sliced\n" +
                "1½ tbsp sweet soy sauce\n" +
                "¼ tsp sugar\n" +
                "1 x 20g pack coriander, leaves only chopped\n");
        fish5.setCookingMethod("Method:\n" +
                "Heat grill to high. Place the fish in a shallow baking dish.\n" +
                "Grill for 4-5 mins until cooked through, but still a little pink in the centre. Cover and set aside.\n" +
                "Heat a wok, add the oil, then stir-fry the ginger, chilli and spring onions for 2-3 mins. Stir in the soy, sugar and a splash of water, then take off the heat.\n" +
                "Throw in the coriander and serve immediately with the salmon.");

        FishObject fish6 = new FishObject();
        fish6.setImageId(R.drawable.ssprawn);
        fish6.setCookingName("Szechuan sweet & sour prawns");
        fish6.setKitchen("From: Jamieoliver.com");
        fish6.setType(SeafoodConstant.TYPE_SHELLFISH);
        fish6.setCookingMaterials("Ingredients:\n" +
                "300g pineapple\n"+
                "1 red and yellow pepper\n"+
                "2 cloves of garlic\n"+
                "2 fresh red chillies\n"
                );
        fish6.setCookingMethod("Method:\n" +
                "Peel and slice the pineapple lengthways into 8 wedges, de-seed and finely slice the peppers lenghtway. \n"+
                "Place chillies, garlic and ginger into a pestle and mortar bash with salt to a rough paste.\n"+
                "Place the mixed paste into large a bowl with the prawns and a splash of oil, then mix well.\n"+
                "Add oil in frying pan over a medium-high heat,"
                );

        if(dbSource.isFishTableEmpty())
        {
            dbSource.insertFish(fish1);
            dbSource.insertFish(fish2);
            dbSource.insertFish(fish3);
            dbSource.insertFish(fish4);
            dbSource.insertFish(fish5);
            dbSource.insertFish(fish6);
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
//--------------------------------------------------------------------------------------------------
    class GcmRegistrationAsyncTask extends AsyncTask<Context, Void, String> {
    private static Registration regService = null;
    private GoogleCloudMessaging gcm;
    private Context context;

    // TODO: change to your own sender ID to Google Developers Console project number.
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
//--------------------------------------------------------------------------------------------------
}

