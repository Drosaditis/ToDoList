import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ToDoList {
    public Scanner input= new Scanner(System.in);
    public ArrayList<String> list = new ArrayList<>();


    public void Program(){
        try {
            File myObj = new File("Items.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        boolean stopProgram = false;
        while (!stopProgram) {
            System.out.println("If you want to print to the List enter P");
            System.out.println("If you want to add an item to the List enter A");
            System.out.println("If you want to delete an item of the List enter D");
            System.out.println("If you want to end the program press E");
            String answer = input.nextLine();
            if (answer.equals("P")) {
                for (String s : list) {
                    System.out.println(s);
                }
            } else {
                if (answer.equals("A")) {
                    add();
                } else {
                    if (answer.equals("D")) {
                        delete();

                    } else {
                        if (answer.equals("E")) {
                            stopProgram = true;
                        } else {
                            System.out.println("Not an option");
                        }
                    }

                }
            }
        }
        try {
            FileWriter myWriter = new FileWriter("Items.txt");
            String listTemp="";
            for (String s : list){
                listTemp= listTemp + "\n" + s;
            }
            myWriter.write(listTemp);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("The program ended");
    }


    void add(){
        System.out.println("Write something you want to do");
        String item= input.nextLine();
        list.add(item);
    }
    void delete(){
        System.out.println("Which item you want to delete;");
        int i=input.nextInt();
        list.remove(i+1);
    }
}

