import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class dropDataBase {
    public void database(){
        try {
            Scanner SC = new Scanner(System.in);
            String url = "jdbc:mysql://localhost:3306";
            String username = "shajin";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            String sql = "drop database ";
            System.out.print(ConsoleColors.BLACK_BOLD+"Enter the database need to be  dropped : "+ConsoleColors.RESET);
            String dataBase = SC.nextLine();
            stmt.execute(sql+dataBase);
            System.out.println(ConsoleColors.RED_BOLD+"Database deleted...."+ConsoleColors.RESET);
        }
        catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD+"Data base not found.."+ConsoleColors.RESET);
        }
    }
}
