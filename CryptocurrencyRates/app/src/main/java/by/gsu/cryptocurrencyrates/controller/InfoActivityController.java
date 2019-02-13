package by.gsu.cryptocurrencyrates.controller;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoGraphDAO;
import by.gsu.cryptocurrencyrates.model.Crypto;
import by.gsu.cryptocurrencyrates.model.CryptoGraphParams;
import by.gsu.cryptocurrencyrates.properties.LocalCrypto;
import by.gsu.cryptocurrencyrates.properties.Settings;

public class InfoActivityController {
    private static String isNull;
    private static String getLanguageForNull(Activity activity) {
        return Settings.getTextForNull(activity);
    }
    public static void initText(Activity activity) {
        isNull = getLanguageForNull(activity);
        Crypto crypto = LocalCrypto.getCrypto();
        String currency = Settings.getCurrency();

        TextView textRank = activity.findViewById(R.id.dTextRank); //rank (long)
        String rank = toOutputString(new Long(crypto.getRank()));

        TextView textSymb = activity.findViewById(R.id.dTextSymb); //symbol (String)
        String symbol = toOutputString(crypto.getSymbol());

        TextView textPrice = activity.findViewById(R.id.dTextPrice); //price (double)
        String price = toOutputString(new Double(crypto.getPrice()), currency);

        TextView textVolume = activity.findViewById(R.id.dTextVolume); //volume (double)
        String volume = toOutputString(new Double(crypto.getDayVolume()), currency);

        TextView textMCap = activity.findViewById(R.id.dTextMarketCap); //market cap (double)
        String mCap = toOutputString(new Double(crypto.getMarketCap()), currency);

        TextView textCSupply = activity.findViewById(R.id.dTextCSupply); //available supply (double)
        String cSupply = toOutputString(crypto.getAvailableSupply(), symbol);

        TextView textTSupply = activity.findViewById(R.id.dTextTSupply); //total supply (double)
        String tSupply = toOutputString(crypto.getTotalSupply(), symbol);

        TextView textMSupply = activity.findViewById(R.id.dTextMSupply); //max supply (double)
        String mSupply = toOutputString(crypto.getMaxSupply(), symbol);

        TextView textPChange = activity.findViewById(R.id.dTextPChange); //percent change (7d) (double)

        TextView textP1h = activity.findViewById(R.id.dTextP1h); //percent change (1h) (double)
        String p1h = toOutputString(new Double(crypto.getPercentChange1h()), Constants.PRC_SYMB);
        Double value1h = new Double(crypto.getPercentChange1h());

        TextView textP24h = activity.findViewById(R.id.dTextP24h); //percent change (24h) (double)
        String p24h = toOutputString(new Double(crypto.getPercentChange24h()), Constants.PRC_SYMB);
        Double value24h = new Double(crypto.getPercentChange24h());

        TextView textP7d = activity.findViewById(R.id.dTextP7d); //percent change (7d) (double)
        String p7d = toOutputString(new Double(crypto.getPercentChange7d()), Constants.PRC_SYMB);
        Double value7d = new Double(crypto.getPercentChange7d());

        textRank.setText(Settings.getRankString(activity) + " " + rank);
        textSymb.setText(Settings.getSymbolString(activity) + " " + symbol);
        textPrice.setText(Settings.getPriceString(activity) + " " + price);
        textVolume.setText(Settings.getVolumeString(activity) + " " + volume);
        textMCap.setText(Settings.getMCapString(activity) + " " + mCap);
        textCSupply.setText(Settings.getCSupplyString(activity) + " " + cSupply);
        textTSupply.setText(Settings.getTSupplyString(activity) + " " + tSupply);
        textMSupply.setText(Settings.getMSupplyString(activity) + " " +  mSupply);
        textPChange.setText(Settings.getPChangeString(activity));
        textP1h.setText(p1h);
        textP24h.setText(p24h);
        textP7d.setText(p7d);
        if(value1h < 0)
            textP1h.setTextColor(Color.RED);
        else if(value1h > 0)
            textP1h.setTextColor(Color.GREEN);
        if(value24h < 0)
            textP24h.setTextColor(Color.RED);
        else if(value24h > 0)
            textP24h.setTextColor(Color.GREEN);
        if(value7d < 0)
            textP7d.setTextColor(Color.RED);
        else if(value7d > 0)
            textP7d.setTextColor(Color.GREEN);

    }
    private static String toOutputString(Double value) {
        if(value.equals(null)) {
            return isNull;
        }
        return String.format("%.4f",value);
    }
    private static String toOutputString(Long value) {
        if(value.equals(null)) {
            return isNull;
        }
        return value.toString();
    }
    private static String toOutputString(String string) {
        if(string == null) {
            return isNull;
        }
        return string.toString();
    }

    private static String toOutputString(Double value, String symbol) {
        if(value.equals(null)) {
            return isNull;
        }
        return String.format("%.4f %s",value, symbol);
    }
    private static String toOutputString(Long value, String symbol) {
        if(value.equals(null)) {
            return isNull;
        }
        return value.toString() + " " + symbol;
    }
    private static String toOutputString(String string, String symbol) {
        if(string == null) {
            return isNull;
        }
        return string + " " + symbol;
    }
    public static void initGraph(ICryptoGraphDAO graphDAO, GraphView graph, LineGraphSeries<DataPoint> series, AppCompatActivity activity) {
        String symb = LocalCrypto.getCrypto().getSymbol();
        graphDAO.load(symb, graphDAO, activity);
    }
}
