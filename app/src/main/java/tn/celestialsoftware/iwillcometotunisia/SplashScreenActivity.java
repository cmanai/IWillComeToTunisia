package tn.celestialsoftware.iwillcometotunisia;

import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.GetDataCallback;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class SplashScreenActivity extends ActionBarActivity {
    List<ParseObject> ob;
    String Title,Desc,price1,price2;

    int j=0;
    NewsBDD tBDD;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
      tBDD = new NewsBDD(SplashScreenActivity.this);
        tBDD.open();
        tBDD.removeAllArticles();

        tBDD.close();
        new RemoteDataTask().execute();
    }


    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the class table named "Country" in Parse.com

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Offre");


            try {
                try {


                    ob = query.find();

                } catch (com.parse.ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml


            for (ParseObject country : ob) {
                Title = (String) country.get("titre");

                Desc = (String) country.get("description");
                price1 = (String) country.get("golden");
                price2 = (String) country.get("price");

                ParseGeoPoint p=  country.getParseGeoPoint("geo");
String b =String.valueOf( p.getLatitude());
    String a=  String.valueOf( p.getLongitude());
                        News nt = new News(Title, Desc, price1, price2,a,b);

                     //   Toast.makeText(getApplicationContext(),titles.get(j),Toast.LENGTH_LONG).show();
                        tBDD = new NewsBDD(SplashScreenActivity.this);
                        tBDD.open();

                        tBDD.insertTop(nt);
                        tBDD.close();




            }






            //   l = new ArrayList<News>();
            //  NewsBDD = new NewsBDD(getActivity().getApplicationContext());
            // NewsBDD.open();

            //  l = userBDD.selectAll();

            //    userBDD.close();

            Intent intent = new Intent(SplashScreenActivity.this,
                    Container.class);

            startActivity(intent);

finish();


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
