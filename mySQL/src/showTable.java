import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class showTable {

    public void kk(){
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
    System.out.println("you have entered to the database..");
    System.out.print("do you want to know the tables in this database (y/n) :");
    String yes = sc.nextLine();
    if(yes.equalsIgnoreCase("y")){
       ResultSet  result =  stmt.executeQuery("show tables");
       while (result.next()){
           String aDBName = result.getString(1);
           System.out.println(aDBName+" ,");
       }
    }
}
catch (Exception e){
    e.printStackTrace();
}

}
}
