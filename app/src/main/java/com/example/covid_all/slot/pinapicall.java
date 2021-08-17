package com.example.covid_all.slot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_all.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pinapicall extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pinapicall);
//        Intent intent=getIntent();
//        String mm=intent.getStringExtra("gujudata");
        listView= (ListView) findViewById(R.id.list_item);
// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=382345&date=09-06-2021";



// Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("sessions");
                    if (jsonArray.length()>0) {
                        String[] data = new String[jsonArray.length()];
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject center = jsonArray.getJSONObject(i);
                            String ma = center.getString("name");
                            int pp = center.getInt("available_capacity");
                            int gg = center.getInt("min_age_limit");
                            data[i] = ("available_capacity : " + String.valueOf(pp) + "\nname : " + ma + "\nmin_age_limit : " + String.valueOf(gg));
                            System.out.println(data[i]);


                        }
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(pinapicall.this, android.R.layout.simple_expandable_list_item_1, data);
                        listView.setAdapter(arrayAdapter);
                    }
                    else {
                        Toast.makeText(pinapicall.this,"data not found",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Log.d("ss","galti he");
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ss","galti he request me hi...");
            }
        });

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);

    }

}

