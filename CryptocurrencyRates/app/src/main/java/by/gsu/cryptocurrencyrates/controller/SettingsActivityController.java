package by.gsu.cryptocurrencyrates.controller;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.properties.Settings;

public class SettingsActivityController {
    private static ListView langListView;
    private static ListView pointsListView;
    public static void languageMenuInit(ListView listView, TextView textView, Button button, ArrayAdapter<String> adapter, final Activity activity) {
        langListView = listView;
        textView.setText(Settings.getLanguageText(activity));
        adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_single_choice, Constants.LANGUAGES);
        langListView.setAdapter(adapter);
        langListView.setItemChecked(Settings.getLanguage(), true);

    }
    public static void pointsMenuInit(ListView listView, TextView textView, Button button, ArrayAdapter<String> adapter, final Activity activity) {
        pointsListView = listView;
        textView.setText(Settings.getPointsText(activity));
        List<String> list = new ArrayList<String>();
        for(int number : Constants.POINTS) {
            Integer value = Integer.valueOf(number);
            list.add(value.toString());
        }
        for(String element : list) {
            System.out.println(element);
        }
        adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_single_choice, list);
        pointsListView.setAdapter(adapter);
        pointsListView.setItemChecked(Settings.getPoints(), true);
    }
    public static void settingsButtonInit(Button button, Activity activity) {
        button.setText(Settings.getSettingsButtonText(activity));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int langPosition = langListView.getCheckedItemPosition();
                if(langPosition < 0) {
                    return;
                }
                int ptPosition = pointsListView.getCheckedItemPosition();
                if(ptPosition < 0) {
                    return;
                }
                Settings.setLanguage(langPosition);
                Settings.setPoints(ptPosition);
            }
        });
    }
}
