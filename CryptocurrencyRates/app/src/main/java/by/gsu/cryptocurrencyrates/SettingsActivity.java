package by.gsu.cryptocurrencyrates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
        SettingsActivityController.languageMenuInit(langListView, langTextView, settingsButton, langAdapter, this);
        SettingsActivityController.pointsMenuInit(pointsListView, pointsTextView, settingsButton, pointsAdapter, this);
        SettingsActivityController.settingsButtonInit(settingsButton, this);

    }
}
