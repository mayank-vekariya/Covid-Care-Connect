package com.example.covid_all.tifin;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_all.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.annotations.NotNull;


public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myadapter(@NonNull @NotNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull @NotNull myadapter.myviewholder holder, int position, @NonNull @NotNull model model) {
        holder.avelabel.setText("Available_Capacity : "+model.available);
        holder.type.setText("Type : "+model.type);
        holder.address.setText("Address : "+model.area+" , "+model.dis+" , "+model.state+" , "+model.pincode);
        holder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.bapuoo
                        ,new descfragment(model.getName(),model.getArea(),model.getState(),model.getDis(),model.getPincode(),model.getPhone(),model.getType(),model.getTime(),model.getAvailable()))
                                .addToBackStack(null).commit();

            }
        });
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.extra,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView avelabel,address,type;


        public myviewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            address=itemView.findViewById(R.id.area);
            avelabel=itemView.findViewById(R.id.avebel);
            type=itemView.findViewById(R.id.type);

        }
    }

}
