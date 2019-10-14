package LeetCode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/*
* Given a string s, find the longest palindromic subsequence's length in s.
* "bbbab" One possible longest palindromic subsequence is "bbbb".
* "cbbd" One possible longest palindromic subsequence is "bb".
* */
public class Problem516 {

    private Hashtable<Integer, String> mapping = new Hashtable<>();
    public List<String> letterCombinations(String digits) {

        mapping.put(2, "abc");mapping.put(3, "def");mapping.put(4, "ghi");
        mapping.put(5, "jkl");mapping.put(6, "mno");mapping.put(7, "pqr");
        mapping.put(8, "stu");mapping.put(9, "vwx");

        ArrayList<String> result = new ArrayList<>();
        

        return result;
    }


}
