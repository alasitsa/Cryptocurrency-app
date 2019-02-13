package by.gsu.cryptocurrencyrates.ifaces.impl.graph;

import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoGraphDAO;
import by.gsu.cryptocurrencyrates.model.CryptoGraphParams;

public class HardcodedCryptoGraphImpl implements ICryptoGraphDAO {
    private boolean response;
    private CryptoGraphParams graphParams;
    public HardcodedCryptoGraphImpl() {
        graphParams = new CryptoGraphParams();
        response = true;
    }
    public CryptoGraphParams getParams() {
        return graphParams;
    }
    public boolean getResponse() {
        return response;
    }
    public void load(String fsym, ICryptoGraphDAO graphDAO, AppCompatActivity activity) {
        List<DataPoint> list = new ArrayList<>();
        list.add(new DataPoint(1,2));
        list.add(new DataPoint(2,4));
        list.add(new DataPoint(3,6));
        list.add(new DataPoint(4,2));
        list.add(new DataPoint(5,4));
        list.add(new DataPoint(6,3));
        list.add(new DataPoint(7,23));
        list.add(new DataPoint(234,16));
        graphParams.setList(list);

        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);

        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        double min = graphParams.getMinY() - Constants.MARGIN_Y;
        if(min < 0)
            viewport.setMinY(0);
        else
            viewport.setMinY(min);
        viewport.setMaxY(graphParams.getMaxY() + Constants.MARGIN_Y);
        viewport.setScrollable(true);

        int n = graphParams.getCount();
        for(int i = 0; i < n; i++) {
            series.appendData(graphParams.getDot(i), true, n);
        }
    }

    /*public CryptoGraphParams getParams(int position) {
        return list.get(position);
    }
    public List<CryptoGraphParams> getListParam() {
        return list;
    }
    public void refresh() {
        response = true;
        DataPoint[] dots = {
            new DataPoint(1d,2d),
            new DataPoint(1.5d, 3d),
            new DataPoint(3d, 0.2d)
        };
        List<CryptoGraphParams> localList = new ArrayList<>();
        List<DataPoint> dotList = new ArrayList<>();
        for(int i = 0; i < dots.length; i++) {
            dotList.add(dots[i]);
        }
        localList.add(new CryptoGraphParams(dotList));
        List<DataPoint> dotList2 = new ArrayList<>();
        DataPoint[] dots2 = {
                new DataPoint(1d,3d),
                new DataPoint(2d, 2d),
                new DataPoint(5d, 0.5d),
                new DataPoint(6d, 5.6d),
                new DataPoint(8d, 12.4d),
                new DataPoint(9d, 3.7d),
                new DataPoint(10d, 25.3d),
                new DataPoint(11d, 26.5d),
                new DataPoint(12d, 65.6d),
                new DataPoint(16d, 56.7d),
                new DataPoint(23d, 32.3d)
        };
        for(int i = 0; i < dots2.length; i++) {
            dotList2.add(dots2[i]);
        }
        localList.add(new CryptoGraphParams(dotList2));
        list = localList;

    }
    public boolean getResponse() {
        return response;
    }*/
}
