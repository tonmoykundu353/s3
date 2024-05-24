package com.example.splash_learn;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class home_activity extends AppCompatActivity {
    private long pressedTime;


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        loadFragment(new home_fragment());
      bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            click(item);
           return true;
        });
      //

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.link)
                {
                    Toast.makeText(home_activity.this, "link is clicked", Toast.LENGTH_SHORT).show();
                    //loadFragment(new link_fragment());
                    Intent intent=new Intent(home_activity.this, EventShowingActivity.class);
                    startActivity(intent);

                }
                else if (id==R.id.university) {
                    Toast.makeText(home_activity.this, "university is clicked", Toast.LENGTH_SHORT).show();
                    //loadFragment(new university_fragment());
                    Intent intent=new Intent(home_activity.this, OrganizerLoginActivity2.class);
                    startActivity(intent);

                }

                else if (id==R.id.sign_out) {

                   // Toast.makeText(home_activity.this, "sign_out is clicked", Toast.LENGTH_SHORT).show();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("DETAILS");
                    reference.child(login_activity.log_name).removeValue();
                                    // user is now signed out
                    Toast.makeText(home_activity.this, "successfully deleted account", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(home_activity.this, login_activity.class));
                    finish();

                }

                else if (id==R.id.conntact) {

                    Intent intent = new Intent(home_activity.this, contact_us.class);
                    startActivity(intent);

                }
                else {

                    Intent intent = new Intent(home_activity.this, login_activity.class);
                    startActivity(intent);

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }



    private void click(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.home)
        {
            //Toast.makeText(this, "home is clicked", Toast.LENGTH_SHORT).show();
            loadFragment(new home_fragment());
        }
        if(id==R.id.bottom_university)
        {
            //Toast.makeText(this, "university is clicked", Toast.LENGTH_SHORT).show();
            loadFragment(new university_fragment());
        }
        if(id==R.id.link)
        {
            //Toast.makeText(this, "link is clicked", Toast.LENGTH_SHORT).show();
            loadFragment(new link_fragment());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.profile_update)
        {
            //Toast.makeText(this, "profile update is clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(home_activity.this, profile_update.class));
        }
        if (id==R.id.rate_us)
        {
//            Toast.makeText(this, "rate us update is clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(home_activity.this, New_link.class));
        }
        if(id==R.id.share)
        {
            Toast.makeText(this, "This Feature will be available soon", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.books)
        {
            startActivity(new Intent(home_activity.this,scinece_books.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage((CharSequence) "Do you want to exit?").setCancelable(true).setNegativeButton((CharSequence) "no", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setPositiveButton((CharSequence) "yes",
                (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(DialogInterface dialogInterface, int i) {
                home_activity.this.finishAffinity();
            }
        });
        builder.create().show();

    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container,fragment);
        ft.commit();
    }


}