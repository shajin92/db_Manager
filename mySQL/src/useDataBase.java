import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class useDataBase {

    public void show() {
        try {
            Scanner sc= new Scanner(System.in);
            String url = "jdbc:mysql://localhost:3306";
            String username = "shajin";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            System.out.print("Enter the data base need to be used : ");
            String database = sc.nextLine();
            stmt.executeUpdate("use "+database);
            System.out.println("Database changed....");
        }
    catch (Exception e){
        System.out.println("came to error in the page of user data base . ");
    }

    }
}
