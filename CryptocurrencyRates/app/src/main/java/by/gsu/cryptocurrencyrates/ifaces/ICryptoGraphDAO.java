package by.gsu.cryptocurrencyrates.ifaces;

import android.support.v7.app.AppCompatActivity;

import java.util.List;
import by.gsu.cryptocurrencyrates.model.CryptoGraphParams;

public interface ICryptoGraphDAO {
    /*
        private boolean response;
        private int type;
        private boolean aggregated;
        list of cryptographparams;
        ratelimit???;
        private boolean hasWarning;

        constructor
        methods:
        //get object with params for Crypto (index Crypto = index Crypto Params)
        1. CryptoGraphParams getParams(int position);
        //get a list of objects with params for Crypto
        2. List<CryptoGraphParams> getListParam();

        3. refresh();

        4. boolean getResponse();
        5. int getType();
        6. boolean getAggregated();
        7. boolean getExistenceWarnings();
     */
    /*CryptoGraphParams getParams(int position);
    //get a list of objects with params for Crypto
    List<CryptoGraphParams> getListParam();
    void refresh();
    boolean getResponse();*/
    CryptoGraphParams getParams();
    void load(String fsym, ICryptoGraphDAO graphDAO, AppCompatActivity activity);
    boolean getResponse();
}
