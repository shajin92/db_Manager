import java.sql.*;
import java.util.Scanner;

public class createTable {


    Scanner sc = new Scanner(System.in);

    public createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306";
            String username = "shajin";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            System.out.print("Enter the data base need to be used : ");
            String database = sc.nextLine();
            stmt.executeUpdate("use "+database);
            System.out.println("Database changed....");

            String url1 = "jdbc:mysql://localhost:3306/"+database;
            String username1 = "shajin";
            String password1 = "password";
            Connection connection1 = DriverManager.getConnection(url1, username1, password1);
            Statement stm = connection.createStatement();
            System.out.println("connecting.....");

                System.out.print("1. enter the tableName :  ");
                String tableName = sc.nextLine();

                System.out.print("Enter the number of columns Required : ");
                int columnSize = sc.nextInt();
                String array[] = new String[columnSize];
                String dataType[] = new String[columnSize];
                Integer dataSize[] = new Integer[columnSize];
                for (int i = 0; i < array.length; i++) {
                    System.out.print("Enter the " + (i + 1) + " column name : ");
                    array[i] = sc.next();
                    System.out.print("Enter the " + (i + 1) + " type : ");
                    dataType[i] = sc.next();
                    System.out.print("Enter the size of the type contain (Only Numeric): ");
                    dataSize[i] = sc.nextInt();
                }
            String primaryKey;
            System.out.print("Enter the column that need to be primary key : ");
            primaryKey = sc.next();

                StringBuffer sb = new StringBuffer();
                for (int i = 0; i<array.length;i++){
                    sb.append(array[i]+" "+dataType[i]+"("+dataSize[i]+") not null");
                    if(i!= array.length){
                        sb.append(", ");
                    }
//                     , ");
                }

            String str = sb.toString();
            System.out.println(str);
//            str = str.substring(0, str.length()-2);
            String command ="create table "+tableName+" (" +str+" primary key ("+primaryKey+")"+")";
            System.out.println(command);
            stm.executeUpdate(command);


        }
        catch (Exception E){
            System.out.println("came to error in the page of create table"+E);
        }

    }
}