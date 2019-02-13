package by.gsu.cryptocurrencyrates.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.model.Crypto;

public class MainListAdapter extends ArrayAdapter<Crypto> {
    private LayoutInflater mInflater;
    private List<Crypto> cryptoes;
    private int textViewResourceId;
    public MainListAdapter(Context context, int textViewResourceId, List<Crypto> cryptoes) {
        super(context,textViewResourceId,cryptoes);
        this.cryptoes = cryptoes;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.textViewResourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parents) {
        convertView = mInflater.inflate(this.textViewResourceId, null);
        Crypto crypto = cryptoes.get(position);
        if(crypto != null) {
            TextView name = (TextView) convertView.findViewById(R.id.textName);
            TextView cost = (TextView) convertView.findViewById(R.id.textCost);
            TextView percentChange = (TextView) convertView.findViewById(R.id.textPercentChange);
            name.setText(crypto.getName());
            String strCost = String.format("%.2f",crypto.getPrice());
            cost.setText(strCost);
            double percent = crypto.getPercentChange24h();
            String strPercent24 = Double.toString(percent);
            percentChange.setText(strPercent24);
            if(percent < 0)
                percentChange.setTextColor(Color.RED);
            else if(percent > 0)
                percentChange.setTextColor(Color.GREEN);
        }
        return convertView;
    }
}
