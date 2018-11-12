package com.example.wallk.dbms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.Map;

import model.LoaiSP;
import other.GetData;
import other.LoaiSPAdater;

public class LaptopActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_list);
        lv = (ListView)findViewById(R.id.LV);
        setList();
    }

    private void setList() {
        List<LoaiSP> MyData = null;
        GetData mydata =new GetData();
        MyData= mydata.doInBackground();

        LoaiSPAdater arrayAdapter = new LoaiSPAdater(this, R.layout.loaisp_item , MyData);
        lv.setAdapter(arrayAdapter);
    }
}
