package other;

import com.example.wallk.dbms.ConectionClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Laptop;
import model.LoaiSP;

public class getLaptop {
    Connection connect;
    String ConnectionResult = "";
    Boolean isSuccess = false;

    public List<Laptop> doInBackground() {

        List<Laptop> data = null;
        data = new ArrayList<>();
        try {
            ConectionClass conStr = new ConectionClass();
            connect = conStr.CONN();        // Connect to database
            if (connect == null) {
                ConnectionResult = "Check Your Internet Access!";
            } else {
                // Change below query according to your own database.
                String query = "select * from Laptop";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Laptop temp = new Laptop();
                    temp.setMaSP(rs.getString("MaSP"));
                    temp.setMaLoaiSP(rs.getString("MaLoaiSP"));
                    temp.setTenSP(rs.getString("TenSP"));
                    temp.setHang(rs.getString("Hang"));
                    temp.setCauHinh(rs.getString("CauHinh"));
                    temp.setHinh(rs.getString("Hinh"));
                    data.add(temp);
                }
                ConnectionResult = " successful";
                isSuccess = true;
                connect.close();
            }
        } catch (Exception ex) {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
        }
        return data;
    }
}