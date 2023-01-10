import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class createDataBase {
    public void data(){
        try {
            Scanner sc = new Scanner(System.in);
            String url = "jdbc:mysql://localhost:3306/";
            String username = "shajin";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            System.out.print("Enter the dataBase to be created : ");
           String dataBase  = sc.nextLine();
            stmt.executeUpdate("create database "+dataBase);
            System.out.println("database created successfully....");
        }
        catch (Exception e){
            System.out.println("Data base already exiting....."+e);
        }


    }

}
