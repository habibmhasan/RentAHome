package com.example.rentahome;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ViewHolder extends RecyclerView.ViewHolder {


    View mView;



    public ViewHolder(View itemView){
        super (itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx, String title, String description, String image){

        TextView mTitletv = mView.findViewById(R.id.rTitletv);
        TextView mDetailtv = mView.findViewById(R.id.rDescriptiontv);
        ImageView mImageview = mView.findViewById(R.id.rImgView);

        mTitletv.setText(title);
        mDetailtv.setText(description);
        Picasso.get().load(image).into(mImageview);
    }

    private ViewHolder.ClickListener mClickListener;

    public interface ClickListener{
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
