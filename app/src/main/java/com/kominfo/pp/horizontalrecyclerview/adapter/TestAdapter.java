package com.kominfo.pp.horizontalrecyclerview.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kominfo.pp.horizontalrecyclerview.R;
import com.kominfo.pp.horizontalrecyclerview.model.TestModel;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private AlphaAnimation butonClick = new AlphaAnimation(1F,0.8F);
    private ArrayList<TestModel> dataList;
    private Context mContex;

    public TestAdapter(ArrayList<TestModel> dataList, Context mContex) {
        this.dataList = dataList;
        this.mContex = mContex;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_list, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TestViewHolder holder, final int position) {
        final TestModel data = dataList.get(position);
        holder.imgTest.setImageResource(data.getImg());
        holder.txtTitle.setText(data.getTitle());
        holder.cardList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardList.startAnimation(butonClick);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TestViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTest;
        TextView txtTitle;
        CardView cardList;

        public TestViewHolder(View itemView) {
            super(itemView);
            imgTest = (ImageView)itemView.findViewById(R.id.imgTest);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
            cardList = (CardView)itemView.findViewById(R.id.cardList);
        }

    }
}
