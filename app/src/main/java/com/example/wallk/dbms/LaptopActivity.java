package com.example.wallk.dbms;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import model.Laptop;
import model.LoaiSP;
import other.LaptopAdapter;
import other.getLaptop;
import other.getLoaiSP;
import other.LoaiSPAdater;

public class LaptopActivity extends AppCompatActivity {
    ListView lv;
    Intent intent;
    String ip,user,pass;
    Button btnThem;
    List<Laptop> MyData = null;
    LaptopAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_list);
        setControl();
        getLoginInfo();
        setList();
        setEvent();
        getResult();
    }

    private void getResult() {

    }

    private void setEvent() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // lấy Laptop tại vị trí click
                Laptop lt = (Laptop) lv.getAdapter().getItem(position);
//                Toast.makeText(getApplicationContext(), "Selected item at position: " +
//                        lt.toString(), Toast.LENGTH_LONG)
//                        .show();
                Intent intentLT = new Intent(LaptopActivity.this,EditLaptopActivity.class);
                intentLT.putExtra("model",lt);
                intentLT.putExtra("status","edit");
                intentLT.putExtra("IP",ip);
                intentLT.putExtra("User",user);
                intentLT.putExtra("Pass",pass);
                startActivityForResult(intentLT,2);
            };
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLT = new Intent(LaptopActivity.this,EditLaptopActivity.class);
                intentLT.putExtra("status","add");
                intentLT.putExtra("maSP",MyData.get(MyData.size()-1).getMaSP());
                intentLT.putExtra("IP",ip);
                intentLT.putExtra("User",user);
                intentLT.putExtra("Pass",pass);
                startActivityForResult(intentLT,1);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Laptop lt = (Laptop) lv.getAdapter().getItem(position);
                MyData.remove(position);// position of item you click
                getLaptop myData = new getLaptop();
                myData.doInBackground(ip,user,pass,lt.getMaSP().toString(),"delete");
                Toast.makeText(getApplicationContext(), "Xoá thành công"
                        , Toast.LENGTH_LONG)
                        .show();
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void setControl() {
        this.setTitle("Danh Sách Laptop");
        lv = findViewById(R.id.lv);
        btnThem = findViewById(R.id.btnThem);
    }

    private void setList() {
        getLaptop mydata =new getLaptop();
        MyData= mydata.doInBackground(ip,user,pass);
        arrayAdapter = new LaptopAdapter(this, R.layout.laptop_item , MyData);
        lv.setAdapter(arrayAdapter);
    }

    private void getLoginInfo()
    {
         intent = getIntent();
         ip=intent.getStringExtra("IP");
         user=intent.getStringExtra("User");
         pass=intent.getStringExtra("Pass");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==99)
        {
            Toast.makeText(getApplicationContext(), "Thêm thành công"
                        , Toast.LENGTH_LONG)
                       .show();
            setList();
        }
        else if(requestCode==2 && resultCode==99)
        {
            Toast.makeText(getApplicationContext(), "Sửa thành công"
                    , Toast.LENGTH_LONG)
                    .show();
            setList();
        }
    }
}
