package by.gsu.cryptocurrencyrates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import by.gsu.cryptocurrencyrates.controller.InfoActivityController;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoGraphDAO;
import by.gsu.cryptocurrencyrates.ifaces.impl.graph.ApiCryptoGraphImpl;
import by.gsu.cryptocurrencyrates.properties.LocalCrypto;

public class InfoActivity extends AppCompatActivity {
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
        InfoActivityController.initText(this);
        InfoActivityController.initGraph(graphDAO, graph, series, this);
    }
}
