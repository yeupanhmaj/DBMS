package com.example.wallk.dbms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import model.Laptop;
import model.LoaiSP;
import other.LaptopAdapter;
import other.getLaptop;
import other.getLoaiSP;
import other.LoaiSPAdater;

public class LaptopActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_list);
        lv = (ListView)findViewById(R.id.lv);
        setList();
    }

    private void setList() {
        List<Laptop> MyData = null;
        getLaptop mydata =new getLaptop();
        MyData= mydata.doInBackground();

        final LaptopAdapter arrayAdapter = new LaptopAdapter(this, R.layout.laptop_item , MyData);
        lv.setAdapter(arrayAdapter);
    }
}
