package com.example.wallk.dbms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import model.Laptop;

public class EditLaptopActivity extends AppCompatActivity {
    Intent intent;
    Laptop model;
    String status;
    EditText txtTenLaptopEdit,txtHangLaptopEdit,txtCauHinhLaptopEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_edit_layout);
        setControl();
        setEvent();
    }

    private void setEvent() {
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

    private void setControl() {
        intent  = getIntent();
        status = intent.getStringExtra("status");
        txtTenLaptopEdit        = findViewById(R.id.txtEditName);
        txtHangLaptopEdit       = findViewById(R.id.txtEditHang);
        txtCauHinhLaptopEdit    = findViewById(R.id.txtEditCauHinh);
    }
}
