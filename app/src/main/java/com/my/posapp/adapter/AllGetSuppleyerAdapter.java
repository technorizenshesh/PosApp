package com.my.posapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.my.posapp.R;
import com.my.posapp.model.AllGetPurchesListModel;
import com.my.posapp.model.GetCustomerModel;

import java.util.ArrayList;

public class AllGetSuppleyerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<AllGetPurchesListModel.Result> modelList;
    private OnItemClickListener mItemClickListener;


    public AllGetSuppleyerAdapter(Context context, ArrayList<AllGetPurchesListModel.Result> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<AllGetPurchesListModel.Result> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itme_supplyer_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final AllGetPurchesListModel.Result model = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.txtName.setText(model.getSupplierName());
            genericViewHolder.txtPhone.setText(model.getPhoneNumber());
            genericViewHolder.txtAddress.setText(model.getAddress());

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

    private AllGetPurchesListModel.Result getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {

        void onItemClick(View view, int position, AllGetPurchesListModel.Result model);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtPhone;
        TextView txtAddress;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.txtName=itemView.findViewById(R.id.txtName);
            this.txtPhone=itemView.findViewById(R.id.txtPhone);
            this.txtAddress=itemView.findViewById(R.id.txtAddress);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });
        }
    }


}

