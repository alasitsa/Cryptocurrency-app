package by.gsu.cryptocurrencyrates.ifaces.api;

import by.gsu.cryptocurrencyrates.model.pojo.POJOGraph;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CryptoCompareApi {
    @GET("/data/histoday")
    Call<POJOGraph> getGraph(@Query("fsym") String symbol, @Query("tsym") String currencyName, @Query("limit") int limitValue);
}
