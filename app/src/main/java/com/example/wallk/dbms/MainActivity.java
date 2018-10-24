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
    Connection cs;

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

        cs = connect();
        if(cs!=null)
        {
            Toast.makeText(MainActivity.this,"thành công",Toast.LENGTH_LONG);
        }
    }

    @SuppressLint("NewApi")
    public Connection CONN(String ip, String un, String password) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        String classs = "net.sourceforge.jtds.jdbc.Driver";
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);
            //ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
            //       + "databaseName=" + db + ";user=" + un + ";password="
            //       + password + ";";
            ConnURL = "jdbc:jtds:sqlserver://192.168.43.82;databaseName=test;user=user;password=1";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }

    private static final String LOG = "DEBUG";
    private static String ip = "192.168.43.83";
    private static String port = "1433";
    private static String classs = "net.sourceforge.jtds.jdbc.Driver";
    private static String db = "test";
    private static String un = "user";
    private static String password = "1";

    public  Connection connect() {
        Connection conn = null;
        String ConnURL = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";
            Toast.makeText(MainActivity.this,"thành công",Toast.LENGTH_LONG);
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException e) {
            Log.d(LOG, e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.d(LOG, e.getMessage());
        }
        return conn;
    }

}


