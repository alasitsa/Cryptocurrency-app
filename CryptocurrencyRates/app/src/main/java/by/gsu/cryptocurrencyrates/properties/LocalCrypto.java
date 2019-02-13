package by.gsu.cryptocurrencyrates.properties;

import by.gsu.cryptocurrencyrates.model.Crypto;
import by.gsu.cryptocurrencyrates.model.CryptoGraphParams;

public class LocalCrypto {
    private static Crypto localCrypto;
    public static void setCrypto(Crypto crypto) {
        localCrypto = crypto;
    }
    public static Crypto getCrypto() {
        return localCrypto;
    }
}
