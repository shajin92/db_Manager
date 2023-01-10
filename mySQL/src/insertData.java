import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;
import java.util.Scanner;

public class insertData {
    public void insert() {
 try {
     Scanner SC = new Scanner(System.in);
       System.out.print("Enter the database : ");
        String url = "jdbc:mysql://localhost:3306/"+SC.nextLine();
        String username = "shajin";
        String password = "password";
        try {
         Connection connection = DriverManager.getConnection(url, username, password);
        Statement stmt = connection.createStatement();
        System.out.print("Enter the table name : ");
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
        String mainArray [] = new String[arr.length-1];
         for(int i=0, k=0;i<arr.length;i++){
         if(i!=j){
             mainArray[k]=arr[i];
             k++;
         }
     }
         String[] value = new  String[mainArray.length];
         for (int d = 0 ; d< mainArray.length; d++){
             System.out.print("enter the value of "+mainArray[d]+" :  ");
             value[d]= SC.nextLine();
         }
            StringBuffer sbj = new StringBuffer();
         for (int i = 0; i<mainArray.length;i++){
             sbj.append('"'+value[i]+'"');

         if(i!= mainArray.length-1){
                 sbj.append(",");
             }
         }
         String valueStr = sbj.toString();
          String kk =  "INSERT INTO "+tableName+" VALUE ("+valueStr+")";
          stmt.execute(kk);
            System.out.println("done correctly....");
 }

        catch (Exception e){
            System.out.println("enter the correct table name.."+e);
        }

 }catch (Exception e){
            System.out.println("unknown database please enter the valid database...");
        }
 }


 catch (Exception e){
  e.printStackTrace();
 }
}
}