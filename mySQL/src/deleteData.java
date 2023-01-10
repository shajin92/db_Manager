import java.sql.*;
import java.util.Scanner;

public class deleteData {
    Scanner sc = new Scanner(System.in);
    public void main(){

        try {
            System.out.print("Enter the database : ");
            String database = sc.next();
            String url = "jdbc:mysql://localhost:3306/"+database;
            String username = "shajin";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            System.out.print("Enter the table name : ");
            String tableName = sc.next();
            try {
                ResultSet rs = stmt.executeQuery("select * from "+tableName);
                ResultSetMetaData rsMetaData = rs.getMetaData();
                int count = rsMetaData.getColumnCount();
                String  []arr = new String[count+1];
                for(int i = 1; i<= count; i++) {
                    arr[i]= rsMetaData.getColumnName(i);
                }
                int j = 0;
                String[] mainArray = new String[arr.length-1];
                for(int i=0, k=0;i<arr.length;i++){
                    if(i!=j){
                        mainArray[k]=arr[i];
                        k++;
                    }
                }

                StringBuilder sgsb = new StringBuilder();
                for (String s : mainArray) {
                    sgsb.append(s).append("  ");
                }
                String VALUE = sgsb.toString();
                System.out.println(VALUE);
                System.out.print("enter the data need to delete : ");
                String delete = sc.next();
                try {
                    String sql = "DELETE FROM "+tableName+" where "+delete;
                    System.out.println(sql);
                    stmt.execute(sql);
                }
                catch (Exception E){
                    System.out.println("enter the correct data need to delete ...");
                }
            }
            catch (Exception e){
                System.out.println("enter the correct table name...");
            }
        }
        catch (Exception e){
            System.out.println("enter the valid database..");
        }
    }
}
