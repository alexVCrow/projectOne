import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Logic {

    public static void getLogic(Properties prop) {
        try(Connection connect = ConnectDataBase.getConnectDb(prop);
            Statement st = connect.createStatement()){
            String query = "SELECT * FROM student";
            ResultSet rs = st.executeQuery(query);
            List<StudentDto> listStudents = new ArrayList<>();
            while (rs.next()) {
                StudentDto studentDto = new StudentDto();
                studentDto.setId(rs.getInt("id"));
                studentDto.setFirstName(rs.getString("first_name"));
                studentDto.setLastName(rs.getString("last_name"));
                studentDto.setEmail(rs.getString("last_name"));
                listStudents.add(studentDto);
            }
            System.out.println("list " + listStudents.toString());
        } catch(IllegalAccessException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
