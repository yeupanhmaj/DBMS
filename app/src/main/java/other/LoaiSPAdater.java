package other;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wallk.dbms.R;

import java.util.ArrayList;
import java.util.List;

import model.LoaiSP;

public class LoaiSPAdater extends ArrayAdapter<LoaiSP> {
    Activity context;
    int resource;
    List<LoaiSP> object;

    public LoaiSPAdater(Activity context, int resource, List<LoaiSP> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.object=objects;
    }

//    public View getView(int position,View convertView, ViewGroup parent) {
//        //dùng để build layout thành code java
//        LayoutInflater inflater= this.context.getLayoutInflater();
//        View row=inflater.inflate(this.resource,null);
//        TextView txtID= (TextView)row.findViewById(R.id.txtID);
//        TextView txtTen=(TextView)row.findViewById(R.id.txtName);
//
//        //back to layout, gán các dữ liệu vào trong layout
//        LoaiSP LSP = this.object.get(position);
//        txtID.setText(LSP.getMaLoaiSP());
//        txtTen.setText(LSP.getTenLoaiSP());
//
//        return row;
//    }
}
