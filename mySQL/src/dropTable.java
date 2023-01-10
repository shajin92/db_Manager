import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class dropTable {
    public void table(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the data base need to be used : ");
            String database = sc.nextLine();
            String url1 = "jdbc:mysql://localhost:3306/"+database;
            String username1 = "shajin";
            String password1 = "password";
            Connection connection = DriverManager.getConnection(url1, username1, password1);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("use "+database);
            System.out.println("Database changed....");
            System.out.print("Enter the table need to be deleted : ");
            String table = sc.nextLine();
            stmt.execute("drop table "+table);
            System.out.println(ConsoleColors.RED+"table is deleted....."+ConsoleColors.RESET);
        }
        catch (Exception e){
            System.out.println("<----No table found---->");
        }
}
}
