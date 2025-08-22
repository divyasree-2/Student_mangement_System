import java.io.*;
import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String dataFile = "data/students.txt";
    public static void main(String[] args) {
        while(true){
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch(choice){
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: searchStudent(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
    static void addStudent() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile, true));
            System.out.print("Enter Roll Number: ");
            String roll = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            String age = sc.nextLine();
            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            bw.write(roll + "," + name + "," + age + "," + course);
            bw.newLine();
            bw.close();
            System.out.println("Student added successfully!");
        } catch(IOException e){
            System.out.println("Error writing to file.");
        }
    }
    static void viewStudents() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFile));
            String line;
            System.out.println("\nRoll | Name | Age | Course");
            System.out.println("--------------------------");
            while((line = br.readLine()) != null){
                System.out.println(line.replace(",", " | "));
            }
            br.close();
        } catch(IOException e){
            System.out.println("No students found.");
        }
    }
    static void updateStudent()
