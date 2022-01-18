package com.my.posapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.my.posapp.R;
import com.my.posapp.model.GetCustomerModel;
import com.my.posapp.model.GetSaveModel;

import java.util.ArrayList;

public class AllSaveListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<GetSaveModel.Result> modelList;
    private OnItemClickListener mItemClickListener;


    public AllSaveListAdapter(Context context, ArrayList<GetSaveModel.Result> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<GetSaveModel.Result> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itme_list_save_all, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final GetSaveModel.Result model = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;

            //genericViewHolder.txtName.setText(model.getCustomerName());
           // genericViewHolder.txtCustomerName.setText(model.getCustomerDetails().getCustomerName());
           // genericViewHolder.txtTime.setText("06:55");

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

    private GetSaveModel.Result getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position, GetSaveModel.Result model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       // TextView txtName;
        //TextView txtCustomerName;
       // TextView txtTime;

        public ViewHolder(final View itemView) {
            super(itemView);

          //  this.txtName=itemView.findViewById(R.id.txtName);
        //    this.txtCustomerName=itemView.findViewById(R.id.txtCustomerName);
       //     this.txtTime=itemView.findViewById(R.id.txtTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });
        }
    }


}

