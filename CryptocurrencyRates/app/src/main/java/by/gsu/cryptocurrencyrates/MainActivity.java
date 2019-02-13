package by.gsu.cryptocurrencyrates;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.controller.MainActivityController;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoDAO;
import by.gsu.cryptocurrencyrates.ifaces.impl.crypto.ApiCryptoImpl;
import by.gsu.cryptocurrencyrates.properties.Settings;

public class MainActivity extends AppCompatActivity {
    private ICryptoDAO cryptoDAO;
    private DrawerLayout dLayout;
    private ActionBarDrawerToggle dToggle;
    private void setGlobals() {
        cryptoDAO = new ApiCryptoImpl();
        Settings.setLanguageByLocale();
        Settings.loadCurrency(getApplicationContext());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setGlobals();
        MainActivityController.titleListInit(this);
        MainActivityController.listViewInit(cryptoDAO, this);
        navBarInit();

    }
    private void navBarInit() {
        dLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        dToggle = new ActionBarDrawerToggle(this, dLayout, R.string.open, R.string.close);
        dToggle.setDrawerIndicatorEnabled(true);

        dLayout.addDrawerListener(dToggle);
        dToggle.syncState();
        final NavigationView navView = (NavigationView) findViewById(R.id.navBar);
        final AppCompatActivity activity = this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                int curr = Settings.getCurrencyId();
                if(curr != id) {
                    if(id == R.id.itemRUB)
                        Settings.setCurrency(Constants.RUB_ID);
                    if(id == R.id.itemEUR)
                        Settings.setCurrency(Constants.EUR_ID);
                    if(id == R.id.itemUSD)
                        Settings.setCurrency(Constants.USD_ID);
                    Settings.saveCurrency(getApplicationContext());
                    MainActivityController.titleListInit(activity);
                    MainActivityController.listViewInit(cryptoDAO, activity);
                }
                if(id == R.id.itemSettings) {
                    Intent intent = new Intent(navView.getContext(), SettingsActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return dToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
