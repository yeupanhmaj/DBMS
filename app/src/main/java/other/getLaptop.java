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
    private String URL ="https://image.ibb.co/cpLcZf/kisscc0-laptop-drawing-computer-monitors-computer-icons-3d-laptop-isometric-design-drawing-5b7597169d27e3-0931819315344330466437.png";

    public List<Laptop> doInBackground(String ip,String User,String Pass) {

        List<Laptop> data = null;
        data = new ArrayList<>();
        try {
            ConectionClass conStr = new ConectionClass();
            connect = conStr.CONN(ip,User,Pass);        // Connect to database
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
                    if(rs.getString("Hinh")!=null)
                    temp.setHinh(rs.getString("Hinh"));
                    else temp.setHinh(URL);
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
    public String doInBackground(String ip, String User, String Pass,Laptop lt,String status) {
        String query="";
        try {
            ConectionClass conStr = new ConectionClass();
            connect = conStr.CONN(ip,User,Pass);        // Connect to database
            if (connect == null) {
                ConnectionResult = "Check Your Internet Access!";
            } else {
                if(status.equals("add"))
                    // Change below query according to your own database.
                    query = "exec ThemSP '"+lt.getMaSP()+"','"
                            +lt.getMaLoaiSP()+"','"
                            +lt.getTenSP()+"','"
                            +lt.getHang()+"','"
                            +lt.getCauHinh()+"'";
                else if(status.equals("edit"))
                    query = "exec SuaSP '"+lt.getMaSP()+"','"
                            +lt.getMaLoaiSP()+"','"
                            +lt.getTenSP()+"','"
                            +lt.getHang()+"','"
                            +lt.getCauHinh()+"'";
                else if(status.equals("delete"))
                    query = "exec SuaSP '"+lt.getMaSP()+"','"
                            +lt.getMaLoaiSP()+"','"
                            +lt.getTenSP()+"','"
                            +lt.getHang()+"','"
                            +lt.getCauHinh()+"'";
                Statement stmt = connect.createStatement();
                stmt.executeUpdate(query);
                ConnectionResult = "successful";
                isSuccess = true;
                connect.close();
            }
        } catch (Exception ex) {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
        }
        return ConnectionResult;
    }
    public String doInBackground(String ip, String User, String Pass,String maSP,String status) {
        String query="";
        try {
            ConectionClass conStr = new ConectionClass();
            connect = conStr.CONN(ip,User,Pass);        // Connect to database
            if (connect == null) {
                ConnectionResult = "Check Your Internet Access!";
            } else {
                 if(status.equals("delete"))
                    query = "exec XoaSP '"+maSP+"'";
                Statement stmt = connect.createStatement();
                stmt.executeUpdate(query);
                ConnectionResult = "successful";
                isSuccess = true;
                connect.close();
            }
        } catch (Exception ex) {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
        }
        return ConnectionResult;
    }
}
