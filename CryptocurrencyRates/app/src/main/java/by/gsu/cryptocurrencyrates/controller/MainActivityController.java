package by.gsu.cryptocurrencyrates.controller;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.adapter.MainListAdapter;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoDAO;
import by.gsu.cryptocurrencyrates.model.Crypto;
import by.gsu.cryptocurrencyrates.properties.Settings;

public class MainActivityController {
    public static void titleListInit(AppCompatActivity activity) {
        TextView name = activity.findViewById(R.id.textTitleName);
        TextView cost = activity.findViewById(R.id.textTitleCost);
        TextView percent = activity.findViewById(R.id.textTitlePercentChange);

        name.setText(Settings.getTitleName(activity));
        cost.setText(Settings.getTitleCost(activity) + " " + Settings.getCurrency());
        percent.setText(Settings.getTitlePercent(activity));
    }
    public static void listViewInit(ICryptoDAO cryptoDAO, final AppCompatActivity activity) {
        cryptoDAO.refresh(activity);
    }
}
