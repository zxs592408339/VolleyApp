package com.warmtel.volleyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyErrorHelper;
import com.android.volley.toolbox.StringRequest;


public class MainActivity extends AppCompatActivity {
    private String httpUrl = "http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html";
    private Button mGetBtn;
    private TextView mContentTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGetBtn = (Button) findViewById(R.id.volley_get_data);
        mContentTxt = (TextView) findViewById(R.id.volley_content_txt);

        mGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest request = new StringRequest(Request.Method.GET, httpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                mContentTxt.setText(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                String errorstry = VolleyErrorHelper.getMessage(error,MainActivity.this);
                                mContentTxt.setText(errorstry);
                            }
                        }
                );

                RequestManager.addRequest(request,this);

            }
        });
    }
}
