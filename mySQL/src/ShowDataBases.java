import java.sql.*;

public class ShowDataBases {
    public void show() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String username = "shajin";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            String sql = "show databases";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String aDBName = result.getString(1);
                System.out.println(aDBName+" ,");
            }
        }

        catch (Exception e) {
            System.out.println("came to error in the page of show data base. "+e);
        }
        }
    }

