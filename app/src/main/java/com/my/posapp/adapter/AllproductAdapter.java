package com.my.posapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.my.posapp.R;
import com.my.posapp.model.GetAllProductCreateModel;
import com.my.posapp.model.PaymentModel;

import java.util.ArrayList;

public class AllproductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<GetAllProductCreateModel.Result> modelList;
    private OnItemClickListener mItemClickListener;


    public AllproductAdapter(Context context, ArrayList<GetAllProductCreateModel.Result> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<GetAllProductCreateModel.Result> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itme_product_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final GetAllProductCreateModel.Result model = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.txtProductName.setText(model.getName());
            genericViewHolder.txtSku.setText(model.getSku());
            genericViewHolder.txtPrice.setText(model.getSellingPrice());
            genericViewHolder.txtUnitCost.setText(model.getUnitCost());

        }

    }

    @Override
    public int getItemCount()
    {
        return modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private GetAllProductCreateModel.Result getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {

        void onItemClick(View view, int position, GetAllProductCreateModel.Result model);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductName;
        TextView txtSku;
        TextView txtPrice;
        TextView txtUnitCost;

        public ViewHolder(final View itemView) {
            super(itemView);

        this.txtProductName=itemView.findViewById(R.id.txtProductName);
        this.txtSku=itemView.findViewById(R.id.txtSku);
        this.txtPrice=itemView.findViewById(R.id.txtPrice);
        this.txtUnitCost=itemView.findViewById(R.id.txtUnitCost);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });
        }
    }


}

