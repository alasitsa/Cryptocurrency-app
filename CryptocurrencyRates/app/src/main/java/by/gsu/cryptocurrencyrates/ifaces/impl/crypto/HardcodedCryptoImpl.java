package by.gsu.cryptocurrencyrates.ifaces.impl.crypto;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import by.gsu.cryptocurrencyrates.InfoActivity;
import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.adapter.MainListAdapter;
import by.gsu.cryptocurrencyrates.adapter.RecyclerViewAdapter;
import by.gsu.cryptocurrencyrates.constants.Constants;
import by.gsu.cryptocurrencyrates.controller.MainActivityController;
import by.gsu.cryptocurrencyrates.ifaces.ICryptoDAO;
import by.gsu.cryptocurrencyrates.model.Crypto;
import by.gsu.cryptocurrencyrates.properties.LocalCrypto;

public class HardcodedCryptoImpl implements ICryptoDAO {
    private List<Crypto> cryptoList;

    public void refresh(final AppCompatActivity activity) {
        ArrayList<Crypto> list = new ArrayList<>();
        Crypto[] cryptoes = {
                new Crypto("bitcoin",
                        "Bitcoin",
                        "BTC",
                        1,
                        3471.60665998,
                        1.0,
                        4898204760.71,
                        60813262135.0,
                        "17517325.0",
                        "17517325.0",
                        "21000000.0",
                        -0.14,
                        -0.24,
                        -3.31,
                        1549217184),
                new Crypto("ripple",
                        "XRP",
                        "XRP",
                        2,
                        0.3039400686,
                        0.00008761,
                        425329679.723,
                        12511226815.0,
                        "41163466448.0",
                        "99991708587.0",
                        "100000000000",
                        -0.27,
                        -0.75,
                        -2.11,
                        1549217163),
                new Crypto("ethereum",
                        "Ethereum",
                        "ETH",
                        3,
                        107.927001333,
                        0.03110867,
                        2375088273.53,
                        11299921326.0,
                        "104699669.0",
                        "104699669.0",
                        null,
                        -0.19,
                        0.02,
                        -5.92,
                        1549217175)

        };
        list.add(cryptoes[0]);
        list.add(cryptoes[1]);
        list.add(cryptoes[2]);
        cryptoList = list;

        RecyclerView recyclerView = activity.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(activity.getApplicationContext(), cryptoList);
        recyclerView.setAdapter(adapter);
    }
    public Crypto getItem(int position) {
        return cryptoList.get(position);
    }
    public List<Crypto> getList() {
        return cryptoList;
    }
}
