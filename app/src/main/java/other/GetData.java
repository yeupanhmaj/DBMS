package other;

import com.example.wallk.dbms.ConectionClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.LoaiSP;

public class GetData {

    Connection connect;
    String ConnectionResult = "";
    Boolean isSuccess = false;

    public List<LoaiSP> doInBackground() {

        List<LoaiSP> data = null;
        data = new ArrayList<>();
        try
        {
            ConectionClass conStr=new ConectionClass();
            connect =conStr.CONN();        // Connect to database
            if (connect == null)
            {
                ConnectionResult = "Check Your Internet Access!";
            }
            else
            {
                // Change below query according to your own database.
                String query = "select * from LoaiSP";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    LoaiSP temp = new LoaiSP();
                    temp.setMaLoaiSP(rs.getString("MaLoaiSP"));
                    temp.setTenLoaiSP(rs.getString("TenLoaiSP"));
                    data.add(temp);
                }
                ConnectionResult = " successful";
                isSuccess=true;
                connect.close();
            }
        }
        catch (Exception ex)
        {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
        }
        return data;
    }


}
