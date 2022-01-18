package com.my.posapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.my.posapp.R;
import com.my.posapp.model.GetBrandNameModel;
import com.my.posapp.model.GetUserProducType;

import java.util.ArrayList;

public class AlBrandListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<GetBrandNameModel.Result> modelList;
    private OnItemClickListener mItemClickListener;


    public AlBrandListAdapter(Context context, ArrayList<GetBrandNameModel.Result> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<GetBrandNameModel.Result> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itme_brand, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final GetBrandNameModel.Result model = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;

          genericViewHolder.txtProductType.setText(model.getBrandName());


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

    private GetBrandNameModel.Result getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {

        void onItemClick(View view, int position, GetBrandNameModel.Result model);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductType;


        public ViewHolder(final View itemView) {
            super(itemView);

            this.txtProductType=itemView.findViewById(R.id.txtProductType);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });
        }
    }


}

