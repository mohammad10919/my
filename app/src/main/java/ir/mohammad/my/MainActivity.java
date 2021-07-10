package ir.mohammad.my;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView=findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.home){
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    openFragment(new HomeFragment());
                    return true;
                }else if (item.getItemId()==R.id.message){
                    Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT).show();
                    openFragment(new chatFragment());
                    return true;
                }else if (item.getItemId()==R.id.tamas){
                    Toast.makeText(MainActivity.this, "Tamas", Toast.LENGTH_SHORT).show();
                    openFragment(new TamasFragment());
                    return true;
                }
                return false;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentLayout,new HomeFragment()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.Profile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            openFragment(new ProfileFragment());
         }else if (item.getItemId()==R.id.setting){
            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
            openFragment(new settingFragment());
        }else if(item.getItemId()==R.id.contact) {
            Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
            openFragment(new ContactFragment());
        }else if(item.getItemId()==R.id.signout){
            Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();
            openFragment(new SignoutFragment());
        }
            drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }



    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentLayout,fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}