package modelDao;
import Connection.connectionProvider;

import model.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Persondao {
    private Connection connection;


    public Persondao(){
        try {
            connection = connectionProvider.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addperson (person person){
        try{
            String query = "INSERT INTO person(id, name, email,designation, address, bill) VALUES (?, ?, ?, ?, ?, ?)";
            try(PreparedStatement psmt=connection.prepareStatement(query)){
                psmt.setInt(1,person.getId());
                psmt.setString(2,person.getName());
                psmt.setString(3,person.getEmail());
                psmt.setString(4,person.getDesignation());
                psmt.setString(5,person.getAddress());
                psmt.setInt(6,person.getBill());
                psmt.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateperson(int id , person person){
        try {
            String query = "UPDATE person SET name=?, email=?,designation=?,address=?, bill=? WHERE id=?;";
            try (PreparedStatement psmt=connection.prepareStatement(query)){
                psmt.setString(1,person.getName());
                psmt.setString(2,person.getEmail());
                psmt.setString(3,person.getDesignation());
                psmt.setString(4,person.getAddress());
                psmt.setString(5,person.getEmail());
                psmt.setInt(6, id);
                psmt.executeUpdate();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<person> getAllperson(){
        List<person> persons = new ArrayList<>();
        try {
            String query ="SELECT * FROM person";
            try (PreparedStatement stm=connection.prepareStatement(query)){
                ResultSet rs = stm.executeQuery();
                while (rs.next()){
                    person person=new
                            person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
                    persons.add(person);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return persons;
    }
    public void deletePerson(int id){
        try {
            String query="DELETE FROM person WHERE id=?";
            try (PreparedStatement ps=connection.prepareStatement(query)){
                ps.setInt(1,id);
                ps.executeUpdate();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
