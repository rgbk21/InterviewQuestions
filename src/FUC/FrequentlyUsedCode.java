package FUC;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class FrequentlyUsedCode {

    //writeToAFile will create a file with name "filename.csv" and write "something" to it
    public void writeToAFile (){

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("filename.csv"), "utf-8"))) {
            //The text that you have to write goes here
            writer.write("something");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //readFromAFile will read the text from the file named "filename.txt".
    public void readFromAFile(){

        try(BufferedReader br = new BufferedReader(new FileReader("filename.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                //Do your thing here
                System.out.println(line);
                sb.append(line);//StringBuilder appends everything to the String. And remembers it.
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();//everything is going to store the entire text as a String
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //This method will extract each <K, V> pair from the HashTable and print it
    //Change the delimiter as required
    public void extractingElementsFromHashTable(Hashtable<String, Integer> myHashTable){

        for (Map.Entry<String,Integer> entry : myHashTable.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        FrequentlyUsedCode mySolution = new FrequentlyUsedCode();
//        mySolution.writeToAFile();
//        mySolution.readFromAFile();
        //Add <A, 1>, <B, 2> ... <Z, 26> to myHashTable and then extract all entries
        //by passing to extractingElementsFromHashTable()
        Hashtable<String, Integer> myHashTable = new Hashtable<>();
        for(int i = 0; i < 26; i++){
            String next = Character.toString((char)('A' + i));
            myHashTable.put(next, i);
        }
        mySolution.extractingElementsFromHashTable(myHashTable);
    }



}
