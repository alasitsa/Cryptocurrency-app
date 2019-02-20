package by.gsu.cryptocurrencyrates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.controller.SettingsActivityController;
import by.gsu.cryptocurrencyrates.properties.Settings;

public class SettingsActivity extends AppCompatActivity {
    private ListView langListView;
    private ArrayAdapter<String> langAdapter;
    private ListView pointsListView;
    private ArrayAdapter<String> pointsAdapter;
    private Button settingsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setTitle(Settings.getSettingsTitle(this));
        TextView langTextView = (TextView) findViewById(R.id.settingsLanguageText);
        TextView pointsTextView = (TextView) findViewById(R.id.settingsPointsText);
        langListView = (ListView) findViewById(R.id.listViewSettings);
        pointsListView = (ListView) findViewById(R.id.listViewPointsSettings);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        SettingsActivityController.settingsButtonInit(settingsButton, this);

        //lang list
        langTextView.setText(Settings.getLanguageText(this));
        langAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, Constants.LANGUAGES);
        langListView.setAdapter(langAdapter);
        langListView.setItemChecked(Settings.getLanguage(), true);

        //points list
        pointsTextView.setText(Settings.getPointsText(this));
        List<String> list = new ArrayList<String>();
        for(int number : Constants.POINTS) {
            Integer value = Integer.valueOf(number);
            list.add(value.toString());
        }
        for(String element : list) {
            System.out.println(element);
        }
        pointsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, list);
        pointsListView.setAdapter(pointsAdapter);
        pointsListView.setItemChecked(Settings.getPoints(), true);

        //button
        settingsButton.setText(Settings.getSettingsButtonText(this));
        settingsButton.setOnClickListener(new View.OnClickListener() {
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
