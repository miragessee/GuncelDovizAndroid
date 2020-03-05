package com.hakansoftware.gunceldoviz.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hakansoftware.gunceldoviz.R;
import com.hakansoftware.gunceldoviz.views.CustomView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.swagger.client.model.Doviz;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements Filterable {

    private List<Doviz> dovizList;
    private LayoutInflater inflater;
    private List<Doviz> dovizListFilter;

    public RecyclerViewAdapter(Context context, List<Doviz> dovizList) {
        inflater = LayoutInflater.from(context);
        this.dovizList = dovizList;
        this.dovizListFilter = dovizList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_guncel_doviz_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Doviz selectedProduct = dovizList.get(position);
        holder.setData(selectedProduct, position);
    }

    @Override
    public int getItemCount() {
        return dovizList.size();
    }

    @Override
    public Filter getFilter() {
        return dovizListFiltering;
    }

    private Filter dovizListFiltering = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Doviz> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(dovizList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Doviz item : dovizList) {
                    if (item.getSelling().startsWith(filterPattern) || item.getBuying().startsWith(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dovizListFilter.clear();
            dovizListFilter.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtCode, txtName, txtBuying, txtSelling, txtPercent;
        ImageView ivDoviz;
        CustomView customView;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtCode = (TextView) itemView.findViewById(R.id.txtCode);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtBuying = (TextView) itemView.findViewById(R.id.txtBuying);
            txtSelling = (TextView) itemView.findViewById(R.id.txtSelling);
            txtPercent = (TextView) itemView.findViewById(R.id.txtPercent);
            ivDoviz = (ImageView) itemView.findViewById(R.id.ivDoviz);
            customView = (CustomView) itemView.findViewById(R.id.customView);
        }

        public void setData(Doviz selectedDoviz, int position) {
            this.txtCode.setText(selectedDoviz.getCode());
            this.txtName.setText(selectedDoviz.getName());
            this.txtBuying.setText(selectedDoviz.getBuying());
            this.txtSelling.setText(selectedDoviz.getSelling());
            this.txtPercent.setText(selectedDoviz.getPercentage());
            Picasso.get().load(selectedDoviz.getImageLink()).into(this.ivDoviz);
            if (selectedDoviz.getArrow().equals("down"))
            {
                this.customView.swapColor(Color.RED);
                this.customView.setArrowRotation(180);
                this.txtPercent.setTextColor(Color.RED);
            }
            else if (selectedDoviz.getArrow().equals("up"))
            {
                this.customView.swapColor(Color.GREEN);
                this.txtPercent.setTextColor(Color.GREEN);
            }
            else if (selectedDoviz.getArrow().equals("draw"))
            {
                this.customView.isLine = true;
                this.txtPercent.setTextColor(Color.rgb(255, 165, 0));
            }
            else
            {
                this.customView.setVisibility(View.INVISIBLE);
            }
        }


        @Override
        public void onClick(View v) {

        }
    }
}
