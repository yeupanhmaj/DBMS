package com.example.wallk.dbms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import model.Laptop;
import other.getLaptop;

public class EditLaptopActivity extends AppCompatActivity {
    Intent intent;
    Laptop model;
    String status,ip,user,pass;
    EditText txtTenLaptopEdit,txtHangLaptopEdit,txtCauHinhLaptopEdit;
    Button btnXacNhan,btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_edit_layout);
        intent  = getIntent();
        ip=intent.getStringExtra("IP");
        user=intent.getStringExtra("User");
        pass=intent.getStringExtra("Pass");
        setControl();
        setInfo();
        setEvent();
    }

    private void setInfo() {
        if(status.equals("edit"))
        {
            this.setTitle("Sửa thông tin");
            model   = (Laptop) intent.getSerializableExtra("model");
            txtCauHinhLaptopEdit    .setText(model.getCauHinh());
            txtHangLaptopEdit       .setText(model.getHang());
            txtTenLaptopEdit        .setText(model.getTenSP());
        }
        else if(status.equals("add"))
        {
            this.setTitle("Thêm thông tin");
            model   = new Laptop("","1","","","","");
            txtCauHinhLaptopEdit    .setText(model.getCauHinh());
            txtHangLaptopEdit       .setText(model.getHang());
            txtTenLaptopEdit        .setText(model.getTenSP());
        }
    }

    private void setEvent() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.equals("add"))
                {
                    try{
                        int temp = Integer.parseInt(intent.getStringExtra("maSP"))+1;
                        String maSP= String.valueOf(temp);
                        getLaptop myData = new getLaptop();
                        model.setTenSP(txtTenLaptopEdit.getText().toString());
                        model.setCauHinh(txtCauHinhLaptopEdit.getText().toString());
                        model.setHang(txtHangLaptopEdit.getText().toString());
                        model.setMaSP(maSP);

                        if(myData.doInBackground(ip,user,pass,model,status).equals("successful"))
                        {
                            intent.putExtra("status",myData.doInBackground(ip,user,pass,model,status));
                            setResult(99,intent);
                            finish();
                        }
                    }catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                else if(status.equals("edit"))
                {
                    try{

                        getLaptop myData = new getLaptop();
                        model.setTenSP(txtTenLaptopEdit.getText().toString());
                        model.setCauHinh(txtCauHinhLaptopEdit.getText().toString());
                        model.setHang(txtHangLaptopEdit.getText().toString());

                        if(myData.doInBackground(ip,user,pass,model,status).equals("successful"))
                        {
                            intent.putExtra("status",myData.doInBackground(ip,user,pass,model,status));
                            setResult(99,intent);
                            finish();
                        }
                    }catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setControl() {

        status = intent.getStringExtra("status");
        txtTenLaptopEdit        = findViewById(R.id.txtEditName);
        txtHangLaptopEdit       = findViewById(R.id.txtEditHang);
        txtCauHinhLaptopEdit    = findViewById(R.id.txtEditCauHinh);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        btnHuy=findViewById(R.id.btnHuy);
    }
}
