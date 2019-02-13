package by.gsu.cryptocurrencyrates.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crypto {
    /*
        "price_rub": "239360.69295",
        "24h_volume_rub": "382119635164.3936767578",
        "market_cap_rub": "4196178451951"
     */
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("rank")
    @Expose
    private long rank;
    @SerializedName("price_usd")
    @Expose
    private double price;
    @SerializedName("price_btc")
    @Expose
    private double priceBTC;
    @SerializedName("24h_volume_usd")
    @Expose
    private double dayVolume;
    @SerializedName("market_cap_usd")
    @Expose
    private double marketCap;
    @SerializedName("available_supply")
    @Expose
    private String availableSupply;
    @SerializedName("total_supply")
    @Expose
    private String TotalSupply;
    @SerializedName("max_supply")
    @Expose
    private String maxSupply;
    @SerializedName("percent_change_1h")
    @Expose
    private double percentChange1h;
    @SerializedName("percent_change_24h")
    @Expose
    private double percentChange24h;
    @SerializedName("percent_change_7d")
    @Expose
    private double percentChange7d;
    @SerializedName("last_updated")
    @Expose
    private long lastUpdated;
    @SerializedName("price_eur")
    @Expose
    private double priceEUR;
    @SerializedName("24h_volume_eur")
    @Expose
    private double dayVolumeEUR;
    @SerializedName("market_cap_eur")
    @Expose
    private double marketCapEUR;
    @SerializedName("price_rub")
    @Expose
    private double priceRUB;
    @SerializedName("24h_volume_rub")
    @Expose
    private double dayVolumeRUB;
    @SerializedName("market_cap_rub")
    @Expose
    private double marketCapRUB;

    public Crypto() {

    }
    public Crypto(String id, String name, String symbol, long rank, double price, double priceBTC, double dayVolume, double marketCap, String availableSupply,
                  String totalSupply, String maxSupply, double percentChange1h, double percentChange24h, double percentChange7d, long lastUpdated) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.price = price;
        this.priceBTC = priceBTC;
        this.dayVolume = dayVolume;
        this.marketCap = marketCap;
        this.availableSupply = availableSupply;
        TotalSupply = totalSupply;
        this.maxSupply = maxSupply;
        this.percentChange1h = percentChange1h;
        this.percentChange24h = percentChange24h;
        this.percentChange7d = percentChange7d;
        this.lastUpdated = lastUpdated;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public long getRank() {
        return rank;
    }
    public void setRank(long rank) {
        this.rank = rank;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPriceBTC() {
        return priceBTC;
    }
    public void setPriceBTC(double priceBTC) {
        this.priceBTC = priceBTC;
    }
    public double getDayVolume() {
        return dayVolume;
    }
    public void setDayVolume(double dayVolume) {
        this.dayVolume = dayVolume;
    }
    public double getMarketCap() {
        return marketCap;
    }
    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }
    public String getAvailableSupply() {
        return availableSupply;
    }
    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }
    public String getTotalSupply() {
        return TotalSupply;
    }
    public void setTotalSupply(String totalSupply) {
        TotalSupply = totalSupply;
    }
    public String getMaxSupply() {
        return maxSupply;
    }
    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }
    public double getPercentChange1h() {
        return percentChange1h;
    }
    public void setPercentChange1h(double percentChange1h) {
        this.percentChange1h = percentChange1h;
    }
    public double getPercentChange24h() {
        return percentChange24h;
    }
    public void setPercentChange24h(double percentChange24h) {
        this.percentChange24h = percentChange24h;
    }
    public double getPercentChange7d() {
        return percentChange7d;
    }
    public void setPercentChange7d(double percentChange7d) {
        this.percentChange7d = percentChange7d;
    }
    public long getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public double getPriceEUR() {
        return priceEUR;
    }
    public void setPriceEUR(double priceEUR) {
        this.priceEUR = priceEUR;
    }
    public double getDayVolumeEUR() {
        return dayVolumeEUR;
    }
    public void setDayVolumeEUR(double dayVolumeEUR) {
        this.dayVolumeEUR = dayVolumeEUR;
    }
    public double getMarketCapEUR() {
        return marketCapEUR;
    }
    public void setMarketCapEUR(double marketCapEUR) {
        this.marketCapEUR = marketCapEUR;
    }
    public double getPriceRUB() {
        return priceRUB;
    }
    public void setPriceRUB(double priceRUB) {
        this.priceRUB = priceRUB;
    }
    public double getDayVolumeRUB() {
        return dayVolumeRUB;
    }
    public void setDayVolumeRUB(double dayVolumeRUB) {
        this.dayVolumeRUB = dayVolumeRUB;
    }
    public double getMarketCapRUB() {
        return marketCapRUB;
    }
    public void setMarketCapRUB(double marketCapRUB) {
        this.marketCapRUB = marketCapRUB;
    }
    public void convertEUR() {
        price = priceEUR;
        dayVolume = dayVolumeEUR;
        marketCap = marketCapEUR;
    }
    public void convertRUB() {
        price = priceRUB;
        dayVolume = dayVolumeRUB;
        marketCap = marketCapRUB;
    }
}
