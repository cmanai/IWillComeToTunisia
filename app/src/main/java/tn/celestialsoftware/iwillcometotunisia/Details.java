package tn.celestialsoftware.iwillcometotunisia;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;


public class Details extends ActionBarActivity {
    private GoogleMap mMap;
    String title,desc,pos;
    TextView td,dd;
    int aa;
    List<News> l = new ArrayList<News>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.details_layout);

        dd=(TextView)findViewById(R.id.DescDet);
        setUpMapIfNeeded();
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);




        Intent i = getIntent();
pos= i.getStringExtra("pos");


        NewsBDD n = new NewsBDD(getApplicationContext());
        n.open();

        l = n.selectAll();

        n.close();
aa=Integer.valueOf(pos);
        toolbar.setTitle(l.get(aa).getTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        double lat = Double.parseDouble(l.get(aa).getB()); // latitude
        double lon = Double.parseDouble(l.get(aa).getA()); // longitud
        LatLng le= new LatLng(lat,lon);
        dd.setText(l.get(Integer.valueOf(pos)).getDesc());
        mMap.addMarker(new MarkerOptions().position(le).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(le, 15));

// Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);


    }
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap != null) {
            return;
        }
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (mMap == null) {
            return;
        }
        // Initialize map options. For example:
        // mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:

                finish();


                break;

        }
        return  super.onOptionsItemSelected(item);
    }

}
