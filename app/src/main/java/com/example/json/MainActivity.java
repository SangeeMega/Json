package com.example.json;
                           //btn clk to show the data in listview using customadapter and pojo class//

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button BtnClick;
    ListView listView;
    CustomAdapter adapter;

    private ArrayList<Pojo> listdata ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnClick=(Button)findViewById(R.id.BtnClick);
        listView = (ListView) findViewById(R.id.list);
        listdata = new ArrayList<Pojo>();
        adapter=new CustomAdapter(this,listdata);
        listView.setAdapter(adapter);


        BtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonparse();
            }
        });


    }

    private void jsonparse() {


        String url = " https://reqres.in/api/users?page=2";
        RequestQueue queue = Volley.newRequestQueue(this);
//obj->arr->object//
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {
                        adapter.notifyDataSetChanged();
                        try {
                            JSONArray array = response.getJSONArray("data");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                Pojo pojo=new Pojo();
                                pojo.setEmail(object.getString("email"));
                                pojo.setId(object.getInt("id"));
                                listdata.add((pojo));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"error :" + error, Toast.LENGTH_LONG).show();

                    }
        }

        );

        queue.add(getRequest);

    }
}