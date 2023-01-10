import java.sql.*;
import java.util.Scanner;

public class selectData {
    public void select() {
        try {
            Scanner SC = new Scanner(System.in);
            System.out.print("Enter the database : ");
            String database = SC.nextLine();
            String url = "jdbc:mysql://localhost:3306/"+database;
            String username = "shajin";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            System.out.print("Enter the table that need to be select :  ");
            String tableName = SC.nextLine();
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
                try {


                System.out.print("Enter the column name need to search : ");
                String columnName = SC.nextLine();
                String sql = "select "+columnName+" from "+tableName;
                ResultSet rse = stmt.executeQuery(sql);
                while (rse.next()){

                    System.out.println(columnName+" : "+rse.getString(columnName)+" ,");
                }
            }
                catch (Exception e){
                    System.out.println("Enter the correct column name....");
                }
            }
            catch (Exception e ){
                System.out.println("Enter the correct table name.....");
            }
        }
        catch (Exception e){
            System.out.println("enter the correct database name .......");
        }
    }
}
