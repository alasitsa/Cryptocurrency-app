package by.gsu.cryptocurrencyrates.model;

import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.List;

public class CryptoGraphParams {
    private List<DataPoint> dots;
    public CryptoGraphParams() {
        dots = new ArrayList<DataPoint>();
    }
    public CryptoGraphParams(List<DataPoint> dots) {
        this.dots = dots;
    }
    public void setList(List<DataPoint> dots) {
        this.dots = dots;
    }
    public List<DataPoint> getList() {
        return dots;
    }
    public void addDot(DataPoint dot) {
        dots.add(dot);
    }
    public DataPoint getDot(int position) {
        return dots.get(position);
    }
    public int getCount() {
        return dots.size();
    }
    public double getMaxY() {
        double max = 0d;
        for(DataPoint point : dots) {
            double local = point.getY();
            if(local > max) {
                max = local;
            }
        }
        return max;
    }
    public double getMinY() {
        double min = dots.get(0).getY();
        for(int i = 1; i < dots.size(); i++) {
            double local = dots.get(i).getY();
            if(local < min) {
                min = local;
            }
        }
        return min;
    }
    public double getMaxX() {
        double max = 0d;
        for(DataPoint point : dots) {
            double local = point.getX();
            if(local > max) {
                max = local;
            }
        }
        return max;
    }
    public double getMinX() {
        double min = dots.get(0).getX();
        for(int i = 1; i < dots.size(); i++) {
            double local = dots.get(i).getX();
            if(local < min) {
                min = local;
            }
        }
        return min;
    }
    /*private long time;
    private double close;
    private double high;
    private double low;
    private double open;
    private double volumeFrom;
    private double volumeTo;
    public CryptoGraphParams() {

    }
    public CryptoGraphParams(long time, double close, double high, double low, double open, double volumeFrom, double volumeTo) {
        this.time = time;
        this.close = close;
        this.high = high;
        this.low = low;
        this.open = open;
        this.volumeFrom = volumeFrom;
        this.volumeTo = volumeTo;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public double getClose() {
        return close;
    }
    public void setClose(double close) {
        this.close = close;
    }
    public double getHigh() {
        return high;
    }
    public void setHigh(double high) {
        this.high = high;
    }
    public double getLow() {
        return low;
    }
    public void setLow(double low) {
        this.low = low;
    }
    public double getOpen() {
        return open;
    }
    public void setOpen(double open) {
        this.open = open;
    }
    public double getVolumeFrom() {
        return volumeFrom;
    }
    public void setVolumeFrom(double volumeFrom) {
        this.volumeFrom = volumeFrom;
    }
    public double getVolumeTo() {
        return volumeTo;
    }
    public void setVolumeTo(double volumeTo) {
        this.volumeTo = volumeTo;
    }*/
}
