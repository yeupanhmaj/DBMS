package com.example.wallk.dbms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btnDangNhap,btnCancel;
    EditText txtIP,txtUser,txtPass;
    Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCenter.start(getApplication(), "fab3c80c-070d-41f6-9e65-b797848cb79a", Analytics.class, Crashes.class);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        this.setTitle("Đăng Nhập");
        txtIP=findViewById(R.id.txtIP);
        txtUser=findViewById(R.id.txtUser);
        txtPass=findViewById(R.id.txtPass);
        btnDangNhap = findViewById(R.id.btnLogin);
        btnCancel= findViewById(R.id.btnCancel);
    }
    private  void setEvent()
    {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LaptopActivity.class);
                intent.putExtra("IP",txtIP.getText().toString());
                intent.putExtra("User",txtUser.getText().toString());
                intent.putExtra("Pass",txtPass.getText().toString());
                startActivity(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


