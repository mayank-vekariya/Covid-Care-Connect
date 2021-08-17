package com.example.covid_all.other;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_all.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class news extends AppCompatActivity {
    private  static final String url="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json";
    RecyclerView recyclerView;
    private List<model> topHeadlinesModelList=new ArrayList<>();
    adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView=findViewById(R.id.recycle);
        fetchData();


        adapter=new adapter(topHeadlinesModelList,this);
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    private void fetchData() {
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray jsonArray = jsonObject.getJSONArray("articles");
                            int length = jsonArray.length();

                            for (int i = 0; i < length; i++) {

                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);



                                String author = jsonObject1.getString("author");
                                String title = jsonObject1.getString("title");

                                String url = jsonObject1.getString("url");

                                String urlToImage = jsonObject1.getString("urlToImage");
                                topHeadlinesModelList.add(new model(author,title,url,urlToImage));
                            }
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("tag",e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(news.this, "Data Not Found !!!", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}