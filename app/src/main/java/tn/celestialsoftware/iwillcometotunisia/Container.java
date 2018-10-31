package tn.celestialsoftware.iwillcometotunisia;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;

import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.model.interfaces.OnCheckedChangeListener;

public class Container extends ActionBarActivity {




    //save our header or result
    private AccountHeader.Result headerResult = null;
    private Drawer.Result result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_layout);


        // Handle Toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Create the AccountHeader
        headerResult = new AccountHeader()
                .withActivity(this)

                .withHeaderBackground(R.drawable.bb)


                .withSavedInstance(savedInstanceState)
                .build();
        //Create the drawer
        // add the items we want to use with our Drawer

        result = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)


                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(

                        new SectionDrawerItem().withName("# I Will Come To Tunisia"),
                        new SecondaryDrawerItem().withName("Home").withIcon(R.drawable.home).withIdentifier(1).withCheckable(false).withIconColor(R.color.material_drawer_dark_primary_icon),

                        new SecondaryDrawerItem().withName("FeedBack").withIcon(R.drawable.fee).withIdentifier(2).withCheckable(false),

                        new SecondaryDrawerItem().withName("About us").withIcon(R.drawable.about).withIdentifier(3).withCheckable(false)

                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        //check if the drawerItem is set.
                        //there are different reasons for the drawerItem to be null
                        //--> click on the header
                        //--> click on the footer
                        //those items don't contain a drawerItem

                        if (drawerItem != null) {

                            if (drawerItem.getIdentifier() == 1) {
                                FragmentManager fm = getSupportFragmentManager();

                                FragmentTransaction ft = fm.beginTransaction();


                                Fragment llf = new HomeFragment();

                                ft.replace(R.id.lol, llf);

                                ft.commit();
                                getSupportActionBar().setTitle("Home");
                                result.setSelectionByIdentifier(1, false);
                            }

                            if (drawerItem.getIdentifier() == 2) {
                                /*
                                FragmentManager fm = getSupportFragmentManager();

                                FragmentTransaction ft = fm.beginTransaction();


                                Fragment llf = new HomeFragment();

                                ft.replace(R.id.lol, llf);

                                ft.commit();
                                getSupportActionBar().setTitle("FeedBack");
                                */
                                Intent i = new Intent(getApplicationContext(),VideoListDemoActivity.class);
                                startActivity(i);
                                result.setSelectionByIdentifier(2, false);
                            }

                            if (drawerItem.getIdentifier() == 3) {
                                FragmentManager fm = getSupportFragmentManager();

                                FragmentTransaction ft = fm.beginTransaction();


                                Fragment llf = new AboutFragment();

                                ft.replace(R.id.lol, llf);

                                ft.commit();
                                getSupportActionBar().setTitle("About us");
                                result.setSelectionByIdentifier(3, false);
                            }
/*
                            if (drawerItem.getIdentifier() == 4) {
                                FragmentManager fm = getSupportFragmentManager();

                                FragmentTransaction ft = fm.beginTransaction();


                                Fragment llf = new Main();

                                ft.replace(R.id.lol, llf);

                                ft.commit();
                                getSupportActionBar().setTitle("Gennady Padalka");
                                result.setSelectionByIdentifier(4, false);

                            }

                            if (drawerItem.getIdentifier() == 5) {
                                FragmentManager fm = getSupportFragmentManager();

                                FragmentTransaction ft = fm.beginTransaction();


                                Fragment llf = new Main();

                                ft.replace(R.id.lol, llf);

                                ft.commit();
                                getSupportActionBar().setTitle("Mikhail Kornienko");
                                result.setSelectionByIdentifier(5, false);

                            }
                            if (drawerItem.getIdentifier() == 6) {
                                FragmentManager fm = getSupportFragmentManager();

                                FragmentTransaction ft = fm.beginTransaction();


                                Fragment llf = new Main();

                                ft.replace(R.id.lol, llf);

                                ft.commit();
                                getSupportActionBar().setTitle("Scott Kellys");
                                result.setSelectionByIdentifier(6, false);
                            }

*/

                        }
                        //  Container.this.startActivity(i);

                    }

                })

                .build();


        //only set the active selection or active profile if we do not recreate the activity
        if (savedInstanceState == null) {
            // set the selection to the item with the identifier 10
            result.setSelectionByIdentifier(1, true);


        }
    }

    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (drawerItem instanceof Nameable) {
                Log.i("material-drawer", "DrawerItem: " + ((Nameable) drawerItem).getName() + " - toggleChecked: " + isChecked);
            } else {
                Log.i("material-drawer", "toggleChecked: " + isChecked);
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_qr:
                // search action

            break;
        }
        return true;
    }


}


