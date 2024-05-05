package Connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class connectionProvider {
        private static Connection con;
        public static Connection getConnection(){
            try {
                if (con==null){
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con=
                            DriverManager.getConnection("jdbc:mysql://localhost:3305/vibha06","root","8120");

                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return con;
        }
    }

