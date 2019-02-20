package by.gsu.cryptocurrencyrates;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.controller.InfoActivityController;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoGraphDAO;
import by.gsu.cryptocurrencyrates.ifaces.impl.graph.ApiCryptoGraphImpl;
import by.gsu.cryptocurrencyrates.model.Crypto;
import by.gsu.cryptocurrencyrates.properties.LocalCrypto;
import by.gsu.cryptocurrencyrates.properties.Settings;

public class InfoActivity extends AppCompatActivity {
    private String isNull;
    private LineGraphSeries<DataPoint> series;
    private ICryptoGraphDAO graphDAO;
    private GraphView graph;
    public void setGlobals() {
        graphDAO = new ApiCryptoGraphImpl();//HardcodedCryptoGraphImpl()
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setGlobals();
        this.setTitle(LocalCrypto.getCrypto().getName());

        //info
        isNull = Settings.getTextForNull(this);
        Crypto crypto = LocalCrypto.getCrypto();
        String currency = Settings.getCurrency();
        TextView textRank = findViewById(R.id.dTextRank); //rank (long)
        String rank = toOutputString(new Long(crypto.getRank()));
        TextView textSymb = findViewById(R.id.dTextSymb); //symbol (String)
        String symbol = toOutputString(crypto.getSymbol());
        TextView textPrice = findViewById(R.id.dTextPrice); //price (double)
        String price = toOutputString(new Double(crypto.getPrice()), currency);
        TextView textVolume = findViewById(R.id.dTextVolume); //volume (double)
        String volume = toOutputString(new Double(crypto.getDayVolume()), currency);
        TextView textMCap = findViewById(R.id.dTextMarketCap); //market cap (double)
        String mCap = toOutputString(new Double(crypto.getMarketCap()), currency);
        TextView textCSupply = findViewById(R.id.dTextCSupply); //available supply (double)
        String cSupply = toOutputString(crypto.getAvailableSupply(), symbol);
        TextView textTSupply = findViewById(R.id.dTextTSupply); //total supply (double)
        String tSupply = toOutputString(crypto.getTotalSupply(), symbol);
        TextView textMSupply = findViewById(R.id.dTextMSupply); //max supply (double)
        String mSupply = toOutputString(crypto.getMaxSupply(), symbol);
        TextView textPChange = findViewById(R.id.dTextPChange); //percent change (7d) (double)
        TextView textP1h = findViewById(R.id.dTextP1h); //percent change (1h) (double)
        String p1h = toOutputString(new Double(crypto.getPercentChange1h()), Constants.PRC_SYMB);
        Double value1h = new Double(crypto.getPercentChange1h());
        TextView textP24h = findViewById(R.id.dTextP24h); //percent change (24h) (double)
        String p24h = toOutputString(new Double(crypto.getPercentChange24h()), Constants.PRC_SYMB);
        Double value24h = new Double(crypto.getPercentChange24h());
        TextView textP7d = findViewById(R.id.dTextP7d); //percent change (7d) (double)
        String p7d = toOutputString(new Double(crypto.getPercentChange7d()), Constants.PRC_SYMB);
        Double value7d = new Double(crypto.getPercentChange7d());
        textRank.setText(Settings.getRankString(this) + " " + rank);
        textSymb.setText(Settings.getSymbolString(this) + " " + symbol);
        textPrice.setText(Settings.getPriceString(this) + " " + price);
        textVolume.setText(Settings.getVolumeString(this) + " " + volume);
        textMCap.setText(Settings.getMCapString(this) + " " + mCap);
        textCSupply.setText(Settings.getCSupplyString(this) + " " + cSupply);
        textTSupply.setText(Settings.getTSupplyString(this) + " " + tSupply);
        textMSupply.setText(Settings.getMSupplyString(this) + " " +  mSupply);
        textPChange.setText(Settings.getPChangeString(this));
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

        //graph
        String symb = LocalCrypto.getCrypto().getSymbol();
        graphDAO.load(symb, graphDAO, this);
    }
    private String toOutputString(Long value) {
        if(value.equals(null)) {
            return isNull;
        }
        return value.toString();
    }
    private String toOutputString(String string) {
        if(string == null) {
            return isNull;
        }
        return string;
    }
    private String toOutputString(Double value, String symbol) {
        if(value.equals(null)) {
            return isNull;
        }
        return String.format("%.4f %s",value, symbol);
    }
    private String toOutputString(String string, String symbol) {
        if(string == null) {
            return isNull;
        }
        return string + " " + symbol;
    }
}
