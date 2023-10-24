package lk.ijse.finalproject02.Model;

import lk.ijse.finalproject02.DB.DBConnection;
import lk.ijse.finalproject02.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usermodel {
    public static boolean savUser(UserDTO user){
        Connection con;
        try {
            con= DBConnection.getInstance().getConnection();
            PreparedStatement ps=con.prepareStatement("insert into User values (?,?,?,?)");
            ps.setString(1, user.getUserId());
            ps.setString(2,user.getUserName());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getMail());

            int aff=ps.executeUpdate();
            return aff>0;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<UserDTO> getAllUsers(){
        ArrayList<UserDTO> ar=new ArrayList<>();

        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement ps=connection.prepareStatement("select * from User");
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                UserDTO ut=new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4) );
                ar.add(ut);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return ar;

    }
}