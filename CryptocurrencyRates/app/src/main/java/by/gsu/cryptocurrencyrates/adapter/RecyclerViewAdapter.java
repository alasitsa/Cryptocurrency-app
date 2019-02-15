package by.gsu.cryptocurrencyrates.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import by.gsu.cryptocurrencyrates.InfoActivity;
import by.gsu.cryptocurrencyrates.R;
import by.gsu.cryptocurrencyrates.model.Crypto;
import by.gsu.cryptocurrencyrates.properties.LocalCrypto;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Crypto> cryptoes;
    private Context context;
    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        TextView name;
        TextView cost;
        TextView percent;
        public ViewHolder(View view) {
            super(view);
            layout = view.findViewById(R.id.parentLayout);
            name = view.findViewById(R.id.textName);
            cost = view.findViewById(R.id.textCost);
            percent = view.findViewById(R.id.textPercentChange);
        }
        public void bind(Crypto crypto) {
            name.setText(crypto.getName());
            String  strCost = String.format("%.2f",crypto.getPrice());
            cost.setText(strCost);
            double pChange = crypto.getPercentChange24h();
            String strPercent = String.valueOf(pChange);
            percent.setText(strPercent);
            if(pChange > 0)
                percent.setTextColor(Color.GREEN);
            else if(pChange < 0)
                percent.setTextColor(Color.RED);

        }
    }
    public RecyclerViewAdapter(Context context, List<Crypto> cryptoes) {
        this.cryptoes = cryptoes;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Crypto crypto = cryptoes.get(position);
        holder.bind(crypto);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InfoActivity.class);
                LocalCrypto.setCrypto(crypto);
                view.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return cryptoes.size();
    }
}
