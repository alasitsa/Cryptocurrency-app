package by.gsu.cryptocurrencyrates.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dot {
    @SerializedName("time")
    @Expose
    private long time;
    @SerializedName("close")
    @Expose
    private double close;
    public Dot() {

    }
    public Dot(long time, double close) {
        this.time = time;
        this.close = close;
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
}
