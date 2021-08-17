package com.example.covid_all.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covid_all.R;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.myviewholder> {
    List<model> topHeadlinesModelList;
    Context context;

    public adapter(List<model> topHeadlinesModelList, Context context) {
        this.topHeadlinesModelList = topHeadlinesModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news, parent, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(topHeadlinesModelList.get(position).getAuthor());
        holder.t2.setText(topHeadlinesModelList.get(position).getTitle());
        String url=topHeadlinesModelList.get(position).getUrl();
        Glide.with(holder.t1.getContext()).load(topHeadlinesModelList.get(position).getUrlToImage()).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.change
                        ,new web(topHeadlinesModelList.get(position).getUrl()))
                        .addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return topHeadlinesModelList.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView t1, t2;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }
}
