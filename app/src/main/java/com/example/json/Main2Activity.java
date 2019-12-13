package com.example.json;
                                  //btn clk to show the data in textview//
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class Main2Activity extends AppCompatActivity {
    TextView data;
    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        data = (TextView) findViewById(R.id.fetcheddata);
        RequestQueue queue= Volley.newRequestQueue(this);
        click=(Button)findViewById(R.id.button);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonparse();
            }
        });


    }

    private void jsonparse() {


        String url = " http://www.mocky.io/v2/5de7a04c3700007c02092ac4";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {
                        //Toast.makeText(getApplicationContext(),"error :" + response, Toast.LENGTH_LONG).show();
                        try {

                            JSONArray array = response.getJSONArray("formules");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                String formule = object.getString("formule");
                                String url = object.getString("url");
                                data.append(formule+","+url+"\n\n");
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