package other;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wallk.dbms.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.Laptop;
import model.LoaiSP;

public class LaptopAdapter extends ArrayAdapter<Laptop>
{
    Activity context;
    int resource;
    List<Laptop> object;
    private String URL="https://image.ibb.co/cpLcZf/kisscc0-laptop-drawing-computer-monitors-computer-icons-3d-laptop-isometric-design-drawing-5b7597169d27e3-0931819315344330466437.png";

    public LaptopAdapter(Activity context, int resource, List<Laptop> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.object=objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //dùng để build layout thành code java
        LayoutInflater inflater= this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtTen= (TextView)row.findViewById(R.id.txtTenLT);
        TextView txtThongTin=(TextView)row.findViewById(R.id.txtThongTinLT);
        ImageView imgHinh = (ImageView)row.findViewById(R.id.imgHinh) ;

        //back to layout, gán các dữ liệu vào trong layout
        Laptop Lt = this.object.get(position);
        txtTen.setText(Lt.toString());
        txtThongTin.setText(Lt.getCauHinh());
            Picasso.with(context).load(Lt.getHinh()).into(imgHinh);
        return row;
    }
}

