package by.gsu.cryptocurrencyrates.properties;

import android.app.Activity;
import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.constants.Constants;

public class Settings {
    private static int lang;
    private static int currency;
    private static int points;
    public static void setLanguageByLocale() {
        String language = Locale.getDefault().getDisplayLanguage();
        if(language.equals("русский")) {
            lang = Constants.RU;
        }
        else {
            lang = Constants.EN;
        }
    }
    public static int getLanguage() {
        return lang;
    }
    public static void setLanguage(int language) {
        lang = language;
    }
    public static String getRankString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_RANK);
        else
            return activity.getString(R.string.RANK);
    }
    public static String getSymbolString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_SYMB);
        else
            return activity.getString(R.string.SYMB);
    }
    public static String getPriceString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_PRICE);
        else
            return activity.getString(R.string.PRICE);
    }
    public static String getVolumeString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_VOLUME);
        else
            return activity.getString(R.string.VOLUME);
    }
    public static String getMCapString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_MCAP);
        else
            return activity.getString(R.string.MCAP);
    }
    public static String getCSupplyString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_CSUPPLY);
        else
            return activity.getString(R.string.CSUPPLY);
    }
    public static String getTSupplyString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_TSUPPLY);
        else
            return activity.getString(R.string.TSUPPLY);
    }
    public static String getMSupplyString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_MSUPPLY);
        else
            return activity.getString(R.string.MSUPPLY);
    }
    public static String getPChangeString(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_PCHANGE);
        else
            return activity.getString(R.string.PCHANGE);
    }
    public static String getSettingsTitle(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_SETTINGS_TITLE);
        else
            return activity.getString(R.string.SETTINGS_TITLE);
    }
    public static String getTextForNull(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_IS_NULL);
        else
            return activity.getString(R.string.IS_NULL);
    }
    public static String getLanguageText(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_LANGUAGE_TEXT);
        else
            return activity.getString(R.string.LANGUAGE_TEXT);
    }
    public static String getPointsText(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_POINTS_TEXT);
        else
            return activity.getString(R.string.POINTS_TEXT);
    }
    public static String getSettingsButtonText(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_SAVE_BUTTON);
        else
            return activity.getString(R.string.SAVE_BUTTON);
    }
    public static String getTitleName(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_NAME_TITLE);
        else
            return activity.getString(R.string.NAME_TITLE);
    }
    public static String getTitleCost(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_COST_TITLE);
        else
            return activity.getString(R.string.COST_TITLE);
    }
    public static String getTitlePercent(Activity activity) {
        if(lang == Constants.RU)
            return activity.getString(R.string.RU_PERCENT_TITLE);
        else
            return activity.getString(R.string.PERCENT_TITLE);
    }

    public static void setCurrency(int curr) {
        currency = curr;
    }
    public static String getCurrency() {
        if(currency == Constants.EUR_ID)
            return Constants.EUR;
        else if(currency == Constants.RUB_ID)
            return Constants.RUB;
        else
            return Constants.USD;
    }
    public static int getCurrencyId() {
        return currency;
    }
    public static void setPoints(int pts) {
        points = pts;
    }
    public static int getPoints() {
        return points;
    }
    public static void saveCurrency(Context context) {
        FileOutputStream writer;

        try {
            writer = context.openFileOutput(Constants.PROP_FILE_NAME, Context.MODE_PRIVATE);
            switch(currency) {
                case Constants.USD_ID:
                    writer.write(Constants.USD_ID_CHAR);
                    break;
                case Constants.EUR_ID:
                    writer.write(Constants.EUR_ID_CHAR);
                    break;
                case Constants.RUB_ID:
                    writer.write(Constants.RUB_ID_CHAR);
                    break;
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadCurrency(Context context) {
        File reader = new File(context.getFilesDir(), Constants.PROP_FILE_NAME);
        try {
            if(!reader.exists())
                reader.createNewFile();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        Scanner sc;
        try {

            sc = new Scanner(reader);
            String output = null;
            if(sc.hasNext()) {
                output = sc.nextLine();
            }
            if(output == null) {
                currency = Constants.USD_ID;
            }
            else {
                  currency = Integer.parseInt(output);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
