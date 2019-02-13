package by.gsu.cryptocurrencyrates.ifaces;
import android.support.v7.app.AppCompatActivity;
import java.util.List;
import by.gsu.cryptocurrencyrates.model.Crypto;

public interface ICryptoDAO {
    void refresh(AppCompatActivity activity);
    Crypto getItem(int position);
    List<Crypto> getList();
}
