package by.gsu.cryptocurrencyrates.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class POJOGraph {
    @SerializedName("Response")
    @Expose
    private String response;
    @SerializedName("Data")
    @Expose
    private List<Dot> dots;
    public POJOGraph() {

    }
    public POJOGraph(String response, List<Dot> dots) {
        this.response = response;
        this.dots = dots;
    }
    public List<Dot> getDots() {
        return dots;
    }
    public void setDots(List<Dot> dots) {
        this.dots = dots;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
