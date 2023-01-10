import java.util.Scanner;
public class mainFile {
    Scanner sc = new Scanner(System.in);
    public void main() {
        try {
            boolean flag = true;
            while (flag){
             System.out.println(ConsoleColors.CYAN+"1.show all databases. "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"2.create the database. "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"3.Use the database. "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"4.create table. "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"5.show tables in the database. "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"6.To drop the table. "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"7.drop the database. "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"8.Insert the data to the table. "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"9.Select the record from the table."+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"10.to alter the table "+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"11.delete the record from the table."+ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"15. exit"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.PURPLE+"Enter the number : "+ConsoleColors.RESET);
            int mainType = sc.nextInt();
                System.out.println("<------------------------------------------------------------------>");
            switch (mainType)
            {
                case 1:
                    ShowDataBases kk = new ShowDataBases();
                    kk.show();
                    break;
                case 2:
                    createDataBase obj = new createDataBase();
                    obj.data();
                    break;
                case 3:
                    useDataBase object = new useDataBase();
                    object.show();
                    break;
                case 4:
                    createTable dd = new createTable();
                    break;
                case 5:
                    showTable sc = new showTable();
                    sc.kk();
                    break;
                case 6:
                    dropTable sce = new dropTable();
                    sce.table();
                    break;
                case 7:
                    dropDataBase k = new dropDataBase();
                    k.database();
                    break;
                case 8:
                    insertData ke = new insertData();
                    ke.insert();
                    break;

                case 9:
                    selectData ohfdhh = new selectData();
                    ohfdhh.select();
                    break;
                case 10:
                    alterTable objec  = new alterTable();
                    objec.main();
                    break;
                case 11:
                    deleteData obge = new  deleteData();
                    obge.main();
                    break;
                case 15:
//                    System.out.println(ConsoleColors.RESET);
                    flag = false;
                    break;
                default:
                    System.out.println("Enter the correct number.......");
            }
                System.out.println("<------------------------------------------------------------------>");
                System.out.println("<------------------------------------------------------------------>");

        }
        }
        catch (Exception e){
            System.out.print(e);
        }
    }

}