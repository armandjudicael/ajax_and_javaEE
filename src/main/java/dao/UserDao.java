package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends Dao implements DaoUtils<User> {

    public UserDao(Connection connection) {
         super(connection);
    }

    @Override
    public boolean create(User o) {
        return false;
    }

    @Override
    public int update(User o) {
        return 0;
    }

    @Override
    public int delete(User o) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    public User isValidate(String userName , String password){
        String query = " SELECT * from _user u where  u.username = ? AND u.user_pass = ? ";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1,userName);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String username = rs.getString("username");
                String pass = rs.getString("user_pass");
                Long id = rs.getLong("id");
                String email = rs.getString("email");
                return new User(userName,pass,email,id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
