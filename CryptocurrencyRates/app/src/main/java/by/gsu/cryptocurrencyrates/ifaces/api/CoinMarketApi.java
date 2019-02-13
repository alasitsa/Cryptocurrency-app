package by.gsu.cryptocurrencyrates.ifaces.api;

import java.util.List;

import by.gsu.cryptocurrencyrates.model.Crypto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinMarketApi {
    @GET("/v1/ticker/")
    Call<List<Crypto>> getCryptoList(@Query("convert") String currencyName, @Query("limit") int limitValue);
}
