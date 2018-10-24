package com.example.wallk.dbms;

import android.annotation.SuppressLint;
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
    EditText txtIP, txtUser, txtPass;
    Button btnLogin, btnCancel;
    GridView dgvCountry;
    ArrayList<String> arrayList;
    PreparedStatement stmt;
    ResultSet rs;
    ConectionClass cs;
    Connection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControlS();
        addEventS();
    }

    private void addControlS() {
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtIP = this.<EditText>findViewById(R.id.txtIP);
        txtUser = this.<EditText>findViewById(R.id.txtUser);
        txtPass = this.<EditText>findViewById(R.id.txtPass);
        //txtTest= this.<TextView>findViewById(R.id.txtTest);
        //dgvCountry = this.<GridView>findViewById(R.id.dgvCountry);

    }

    private void addEventS() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                khoiTaoDangNhap();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huyDangNhap();
            }
        });
    }

    private void huyDangNhap() {
        txtIP.getText().clear();
        txtUser.getText().clear();
        txtPass.getText().clear();
    }

    private void khoiTaoDangNhap() {
        //ConectionClass cs = new ConectionClass();
        //cs.connect("192.168.11.13");
        cs = new ConectionClass();
        conn=cs.CONN("192.168.1.1","test","120");
    }
}


