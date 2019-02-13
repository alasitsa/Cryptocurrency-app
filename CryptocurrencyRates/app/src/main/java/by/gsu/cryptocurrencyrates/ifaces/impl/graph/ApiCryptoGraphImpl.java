package by.gsu.cryptocurrencyrates.ifaces.impl.graph;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.List;
import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoGraphDAO;
import by.gsu.cryptocurrencyrates.ifaces.api.CryptoCompareApi;
import by.gsu.cryptocurrencyrates.model.CryptoGraphParams;
import by.gsu.cryptocurrencyrates.model.pojo.Dot;
import by.gsu.cryptocurrencyrates.model.pojo.POJOGraph;
import by.gsu.cryptocurrencyrates.properties.LocalCrypto;
import by.gsu.cryptocurrencyrates.properties.Settings;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCryptoGraphImpl implements ICryptoGraphDAO {
    private boolean response;
    private CryptoGraphParams graphParams;
    private static CryptoCompareApi api;
    private Retrofit retrofit;
    public ApiCryptoGraphImpl() {
        graphParams = new CryptoGraphParams();
        response = true;
    }
    public CryptoGraphParams getParams() {
        return graphParams;
    }
    public boolean getResponse() {
        return response;
    }
    public void load(String fsym, final ICryptoGraphDAO graphDAO, final AppCompatActivity activity) {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://min-api.cryptocompare.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(CryptoCompareApi.class);
        final int currencyId = Settings.getCurrencyId();
        int number = Settings.getPoints();
        System.out.println(LocalCrypto.getCrypto().getSymbol());
        System.out.println(Constants.CURRENCIES[currencyId]);
        System.out.println(Constants.POINTS[number]);

        getApi().getGraph(LocalCrypto.getCrypto().getSymbol(), Constants.CURRENCIES[currencyId],Constants.POINTS[number]).enqueue(new Callback<POJOGraph>() {
            @Override
            public void onResponse(Call<POJOGraph> call, Response<POJOGraph> response) {
                POJOGraph graphPar = response.body();
                if(graphPar == null)
                    return;
                graphParams = convertPOJOToCryptoGraph(graphPar);
                GraphView graph = (GraphView) activity.findViewById(R.id.graph);
                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
                graph.addSeries(series);

                Viewport viewport = graph.getViewport();
                viewport.setYAxisBoundsManual(true);
                viewport.setXAxisBoundsManual(true);
                double min = graphParams.getMinY() - Constants.MARGIN_Y;
                if(min < 0)
                    viewport.setMinY(0);
                else
                    viewport.setMinY(min);
                viewport.setMaxY(graphParams.getMaxY() + Constants.MARGIN_Y);
                viewport.setMaxX(graphParams.getMaxX());
                viewport.setMinX(graphParams.getMinX());
                viewport.setScrollable(true);

                int n = graphParams.getCount();
                for(int i = 0; i < n; i++) {
                    series.appendData(graphParams.getDot(i), true, n);
                }
            }
            @Override
            public void onFailure(Call<POJOGraph> call, Throwable t) {
                Toast.makeText(activity.getApplicationContext(), Constants.ERROR_CONNECTION, Toast.LENGTH_LONG).show();
            }
        });
    }
    private static CryptoCompareApi getApi() {
        return api;
    }
    private CryptoGraphParams convertPOJOToCryptoGraph(POJOGraph graph) {
        List<Dot> dots = graph.getDots();
        CryptoGraphParams graphParams = new CryptoGraphParams();
        for(Dot dot: dots) {
            DataPoint point = dotToDataPoint(dot);
            graphParams.addDot(point);
        }
        return graphParams;
    }
    private DataPoint dotToDataPoint(Dot dot) {
        double x = dot.getTime();
        double y = dot.getClose();
        return new DataPoint(x, y);
    }
}
