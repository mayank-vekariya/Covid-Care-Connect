package com.example.covid_all.tifin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.covid_all.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link descfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class descfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String name,area,state,dis,pincode,phone,type,time,available;
    public descfragment() {
        // Required empty public constructor
    }
    public descfragment(String name,String area,String state,String dis,String pincode,String phone,String type,String time,String available) {

       this.name=name;
       this.area=area;
       this.state=state;
       this.dis=dis;
       this.pincode=pincode;
       this.phone=phone;
       this.type=type;
       this.time=time;
       this.available=available;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment descfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static descfragment newInstance(String param1, String param2) {
        descfragment fragment = new descfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    TextView name1,area1,state1,dis1,pincode1,phone1,type1,time1,available1;
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_descfragment, container, false);


        name1=view.findViewById(R.id.name);
        area1=view.findViewById(R.id.area);
        dis1=view.findViewById(R.id.dic);
        state1=view.findViewById(R.id.state);
        pincode1=view.findViewById(R.id.pincode);
        phone1=view.findViewById(R.id.phone_number);
        type1=view.findViewById(R.id.type);
        time1=view.findViewById(R.id.ttime);
        available1=view.findViewById(R.id.avebel);

        name1.setText("Name : "+name);
        area1.setText("Area : "+area);
        dis1.setText("Dis : "+dis);
        state1.setText("State : "+state);
        pincode1.setText("Pincode : "+pincode);
        phone1.setText("Phone : "+phone);
        type1.setText("Type : "+type);
        time1.setText("Time : "+time);
        available1.setText("Available : "+available);


        return  view;
    }
    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new descfragment()).addToBackStack(null).commit();

    }
}