/**
 * 
 * 443011994
Hanadi Al-shawesh
Data structure Lab(6),HashTable
*/
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner san = new Scanner(System.in);
        int mainchoice;
        
        // Create a hash table with a size of 10
        HashTable hashTable = new HashTable(100);

        boolean exitCode = true;
        while (exitCode) {
        System.out.println("Please enter the service");
            System.out.println(" 1. Insert 2. Search  3. Remove  4.Print ");
            mainchoice = san.nextInt();
            switch (mainchoice) {
                case 1 -> {
                    String key,value;
                    System.out.println("please enter the Key ");
                    key = san.next();
                     System.out.println("please enter the Value ");

                    value=san.next();
                    hashTable.insert(key,value);
                }
                case 2 -> {
                     String retrive,key;
                    System.out.println("please enter the key to Search it ");
                    key = san.next();
                   retrive = hashTable.search(key);
                   System.out.println("The value of the key is: " + retrive);
                    
                }
                case 3 -> {          // print the values using Iterator

                    String key;
                    System.out.println("please enter the key to Search it ");
                    key = san.next();
                    hashTable.remove(key);
                    System.out.println("The value of the key is remove it:");
                    Iterator<String> iterater = hashTable.iterator();
                    while(iterater.hasNext())
                    System.out.println(iterater.next());
                     
                }
                case 4 -> {
                    Iterator<String> iterater = hashTable.iterator();
                    while(iterater.hasNext())
                    System.out.println(iterater.next());
                }
                case 5 -> {
                    System.out.println("Thank you. Code exit done");

                    exitCode = false;
                }
                }
            }
    }
}