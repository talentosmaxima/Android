package com.example.maxapp1.view;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.maxapp1.R;
import com.example.maxapp1.ui.dashboard.DashboardFragment;
import com.example.maxapp1.ui.home.HomeFragment;
import com.example.maxapp1.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MenuClientes extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView navView;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private  Menu menux;
    private   Toolbar myToolbar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  getSupportActionBar().hide();
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu_clientes);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float h = displayMetrics.heightPixels;
        float w = displayMetrics.widthPixels;

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        navView = findViewById(R.id.nav_view);



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_cliente, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        navView.setOnNavigationItemSelectedListener(this);






        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_up,menu);
        SearchView sv = new SearchView(this);
        MenuItem searchItem = menu.findItem(R.id.pesquisa);
        searchItem.setActionView(sv);
        sv = (SearchView) menu.findItem(R.id.pesquisa).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                }
                return false;
            }
        });
        menux=menu;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();

        menux.findItem(R.id.legendas).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                final LegendasView legendasView = new LegendasView(getBaseContext());
                legendasView.enviarAlerta ().show ();

                legendasView.getBtFechar().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        legendasView.fechar();

                    }
                });
                return false;
            }
        });

         return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.navigation_cliente: {
                mudarFragment(new HomeFragment());
                myToolbar.setTitle("Dados do cliente");
                visibilidadeDoMenu(false);

                break;
            }
            case R.id.navigation_dashboard: {
                mudarFragment(new DashboardFragment());
                myToolbar.setTitle("Hist.Pedidos");

                visibilidadeDoMenu(true);
                break;
            }
            case R.id.navigation_notifications: {
                mudarFragment(new NotificationsFragment());
                myToolbar.setTitle("Alvarás");

                visibilidadeDoMenu(false);
                break;
            }

        }
        return true;
    }
    private void visibilidadeDoMenu(Boolean visivel){
        menux.findItem(R.id.legendas).setVisible(visivel);
        menux.findItem(R.id.pesquisa).setVisible(visivel);

    }
    private void mudarFragment(Fragment fragment){
        Fragment newFragment = fragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();


}

}