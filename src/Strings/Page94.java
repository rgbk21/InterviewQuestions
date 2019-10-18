package Strings;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Page94 {

    public boolean isPalindromic(String s){

        for(int i = 0, j = s.length() - 1; i <= j; i++,j--){//You can do without the = in the condition check
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Page94 mySolution = new Page94();
        System.out.println(mySolution.isPalindromic("ababcaba"));
    }
}

class page95{

    public String intToString (int x){
        //Note that in this algorithm, we are storing the number in reverse, then finally calling reverse()
        //This helps us to avoid adding each integer at index 0 and then shifting the entire string to the right
        //thus saving time
        if (x == 0) return "0";
        boolean isNegative = false;
        StringBuilder s = new StringBuilder();

        if(x < 0) isNegative = true;
        x = Math.abs(x);

        while(x != 0){
            s.append(x % 10);
            x = x / 10;
        }

        if(isNegative) s.append("-");
        s.reverse();
        return s.toString();
    }

    public int stringToInt(String s){

        int num = 0;
        boolean isNegative = false;
        if(s.charAt(0) == '-') isNegative = true;

        for(int i = isNegative ? 1 : 0; i < s.length(); i++){
            num = num * 10 + (s.charAt(i) - '0');
        }

        return isNegative ? -num : num;
    }

    public static void main(String[] args) {
        page95 mySolution = new page95();
        System.out.println(mySolution.intToString(1));
        System.out.println(mySolution.stringToInt("-1095"));
    }
}

class page97{

    public String convertBase(String numAsString , int b1 , int b2){
        //Write a program that performs base conversion. The input is a string, an integer b1, and another integer b2.
        // The string represents an integer in base b1.
        // The output should be the string representing the integer in base b2. Assume 2 < b1, b2 < 16.
        //Add code for handling negative numbers later.

        StringBuilder finalNum = new StringBuilder();
        //Converting numAsString from base-b1 to base10
        int numInDecimal = 0;
        for(int i = 0; i < numAsString.length(); i++){
            numInDecimal = numInDecimal * b1 + (numAsString.charAt(i) > '9' ? (10 + (numAsString.charAt(i) - 'A')) : (numAsString.charAt(i) - '0'));
        }
        System.out.println("Number in Decimal: " + numInDecimal);

        //Now we need to convert numInDecimal in base-10 to finalNum in base-b2
        while(numInDecimal != 0){
            int temp = numInDecimal % b2;
            finalNum.append(temp > 9 ? (char)((temp - 10) + 'A') : (char)(temp + '0'));//Correct version
//            finalNum.append(temp > 9 ? (char)((temp - 10) + 'A') : (temp));//Incorrect version
            numInDecimal = numInDecimal / b2;
        }
        finalNum.reverse();
        System.out.println("Number in base b2: " + finalNum.toString());
        return finalNum.toString();
    }

    public static void main(String[] args) {
        page97 mySolution = new page97();
        mySolution.convertBase("127", 10, 16);
    }
}

class page98{

    public int ssDecodeColID (String col){

        int decodedColId = 0;
        for(int i = 0; i < col.length(); i++){
            decodedColId = decodedColId * 26 + (col.charAt(i) - 'A' + 1);
        }
        return decodedColId;
    }

    public static void main(String[] args) {
        page98 mySolution = new page98();
        System.out.println(mySolution.ssDecodeColID("ZZ"));
    }
}

class page99{

    public int replaceAndRemove(int size, char[] s){





        return 0;
    }

    public static void main(String[] args) {
        char[] myCharArray = new char[] {'a','c','d','b','b','c','a'};
        page99 mySolution = new page99();

    }
}

class page100{

    public boolean isPalindrome (String s){

        s = s.toLowerCase();
        for(int left = 0, right = s.length() - 1; left <= right; left++, right--){

            while(!Character.isAlphabetic(s.charAt(left))){//Or you can use: Character.isLetterOrDigit();
                left++;
            }
            while(!Character.isAlphabetic(s.charAt(right))){
                right--;
            }
            if(s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        page100 mySolution = new page100();
        System.out.println(mySolution.isPalindrome("A man, a plan, a canal, Panama."));
    }


}

class page106{

    public List<String> getValidIpAddress(String s){
        //19216811 = 192.168.1.1
        List<String> validAddresses = new ArrayList<>();





        return validAddresses;
    }

    public static void main(String[] args) {
        page106 mySolution = new page106();
        System.out.println(mySolution.getValidIpAddress("19216811"));
    }

}

class page107{

    public String snakeString (String s){

        StringBuilder sinuString = new StringBuilder();
        // s[1], s[5], s[9],..., followed by s[0],s[2], s[4],..., and then s[3], s[7],s[ll],
        for(int i = 0; i < 3; i++){

            if (i == 0){
                for(int j = 1; j < s.length(); j+=4){
                    sinuString.append(s.charAt(j));
                }
            } else if(i == 1){
                for(int j = 0; j < s.length(); j+=2){
                    sinuString.append(s.charAt(j));
                }
            } else{
                for(int j = 3; j < s.length(); j+=4){
                    sinuString.append(s.charAt(j));
                }
            }
        }
        return sinuString.toString();
    }

    public static void main(String[] args) {

        page107 mySolution = new page107();
        System.out.println(mySolution.snakeString("Hello World"));

    }

}

class page108{

    public String decoding(String s){

        int charCount = 0;
        StringBuilder decodedStr = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0){
                charCount = s.charAt(i) - '0';
                continue;
            }
            while (charCount > 0){
                decodedStr.append(s.charAt(i) );
                charCount--;
            }
        }
        return decodedStr.toString();
    }

    public String encoding(String s){
        //eeefee 3e4f2e
        StringBuilder encodedStr = new StringBuilder();
        int charCount = 0;

        for(int i = 0; i < s.length()-1; i++){

            if(s.charAt(i) != s.charAt(i+1)){
                encodedStr.append(++charCount);
                encodedStr.append(s.charAt(i));
                charCount = 0;
            }else{
                ++charCount;
            }
        }
        encodedStr.append(++charCount);
        encodedStr.append(s.charAt(s.length()-1));

        return encodedStr.toString();
    }

    public static void main(String[] args) {

        page108 mySolution = new page108();
        System.out.println(mySolution.decoding("3e4f2e"));
        System.out.println(mySolution.encoding("eeeffffee"));
    }
}





class AddWithoutPlusOperator{

    public int calculateSum(int x, int y){

        int sum = 0;
        int carry = 0;

        do {
            sum = x ^ y;
            carry = (x & y) << 1;
            x = sum;
            y = carry;
        } while(carry != 0);

        return sum;
    }

    public static void main(String[] args) {
        AddWithoutPlusOperator mySolution = new AddWithoutPlusOperator();
        System.out.println(mySolution.calculateSum(5,5));
    }
}








class CommonCode{

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
            String line = br.readLine();//Read the first line separately
            //Do stuff with the first line here
            System.out.println("First Line: " + line);

            //Then start reading from the next line and keep reading till you are done
            while ((line = br.readLine()) != null) {
                //Do your thing here
                sb.append(line);//StringBuilder appends everything to the String. And remembers it.
                sb.append(System.lineSeparator());//Add the system specific line separator
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

        CommonCode mySolution = new CommonCode();
//        mySolution.writeToAFile();
        mySolution.readFromAFile();

        Hashtable<String, Integer> myHashTable = new Hashtable<>();
        for(int i = 0; i < 26; i++){
            String next = Character.toString((char)('A' + i));
            myHashTable.put(next, i);
        }
        mySolution.extractingElementsFromHashTable(myHashTable);
    }
}


