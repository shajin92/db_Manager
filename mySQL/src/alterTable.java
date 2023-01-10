import java.sql.*;
import java.util.Scanner;

public class alterTable {
Scanner sc = new Scanner(System.in);
    public void main() {
        System.out.println("1.do you need delete a column. ");
        System.out.println("2. do you need add column.");
        System.out.print("Enter the number : ");
        int main = sc.nextInt();
        switch (main){
            case 1:
                deleteColumn();
                break;
            case 2:
                addcolumn();
                break;
            default:
                System.out.println("Enter the correct number ......");
        }
    }
    public void deleteColumn(){
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

//                ALTER TABLE table_name DROP COLUMN column_name;
                System.out.print("Enter the column need to delete : ");
                String deletecol = sc.next();
                try {
                    stmt.execute("ALTER TABLE "+tableName+" DROP COLUMN "+deletecol);

                }
                catch (Exception E){
                    System.out.println("enter only above mentioned column...");
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
    public void addcolumn(){
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
                System.out.print("Enter the column name : ");
                String columnName = sc.next();
                System.out.print("Enter the type of column : ");
                String columnType = sc.next();
                System.out.print("Enter the size of the type contain (Only Numeric): ");
                int columSize = sc.nextInt();
                System.out.print("Do you like make it primary key (y/n): ");
                String primarykey = null;
                String ye = sc.next();
                if (ye.equalsIgnoreCase("y")){
                    primarykey = "PRIMARY KEY";
                }
//                ALTER TABLE hill ADD COLUMN name varchar(20;
                String sql = "ALTER TABLE "+tableName+" ADD COLUMN  "+columnName+" "+columnType+"("+columSize+")"+primarykey;
                System.out.println(sql);
                stmt.execute(sql);
            }
            catch (Exception e){
                System.out.println("enter the correct table name..."+e);
            }
        }
        catch (Exception e){
            System.out.println("enter the valid database..");
        }
    }
}
