package by.gsu.cryptocurrencyrates.ifaces.impl.crypto;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import by.gsu.cryptocurrencyrates.InfoActivity;
import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.adapter.MainListAdapter;
import by.gsu.cryptocurrencyrates.adapter.RecyclerViewAdapter;
import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.controller.MainActivityController;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoDAO;
import by.gsu.cryptocurrencyrates.ifaces.api.CoinMarketApi;
import by.gsu.cryptocurrencyrates.model.Crypto;
import by.gsu.cryptocurrencyrates.properties.LocalCrypto;
import by.gsu.cryptocurrencyrates.properties.Settings;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCryptoImpl implements ICryptoDAO {
    private List<Crypto> cryptoList;
    private static CoinMarketApi api;
    private Retrofit retrofit;
    public void refresh(final AppCompatActivity activity) {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(CoinMarketApi.class);
        final int currencyId = Settings.getCurrencyId();

        getApi().getCryptoList(Constants.CURRENCIES[currencyId],Constants.CRYPTO_COUNT).enqueue(new Callback<List<Crypto>>() {
            @Override
            public void onResponse(Call<List<Crypto>> call, Response<List<Crypto>> response) {
                List<Crypto> list = response.body();
                if(list != null) {
                    cryptoList = list;
                    if(currencyId == Constants.EUR_ID)
                        convertEUR();
                    else if(currencyId == Constants.RUB_ID)
                        convertRUB();
                }
                RecyclerView recyclerView = activity.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(activity.getApplicationContext(), cryptoList);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Crypto>> call, Throwable t) {
                Toast.makeText(activity.getApplicationContext(), Constants.ERROR_CONNECTION, Toast.LENGTH_LONG).show();
            }
        });
    }
    public Crypto getItem(int position) {
        return cryptoList.get(position);
    }
    public List<Crypto> getList() {
        return cryptoList;
    }
    private static CoinMarketApi getApi() {
        return api;
    }
    private void convertEUR() {
        for(Crypto crypto : cryptoList) {
            crypto.convertEUR();
        }
    }
    private void convertRUB() {
        for(Crypto crypto : cryptoList) {
            crypto.convertRUB();
        }
    }
}
