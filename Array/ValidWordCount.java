package Array;
import java.util.Scanner;
import java.util.*;

public class ValidWordCount {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input_string = sc.nextLine();
        System.out.println(countValidWords(input_string));
    }

    public static int countValidWords(String s){
        int validCount = 0;
        String[] arr = s.split(" ");
        for(String word : arr){
            if(isAlphaNumeric(word) && word.length()>=3 && hasVowelAndConsonant(word)){
                validCount++;
            }
        }
        return validCount;
    }

    public static boolean isAlphaNumeric(String str){
        char[] char_arr = str.toCharArray();
        for(char ch:char_arr){
            if(!((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9'))){
                return false;
            }
        }
        return true;
    }
    public static boolean hasVowelAndConsonant(String str){
        char[] char_arr = str.toCharArray();
        ArrayList<Character> vowelList = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for(char c : char_arr){
            if(vowelList.contains(c)){
                hasVowel=true;
            }else if(!(c>='0' && c<='9')){
                hasConsonant=true ;
            }
        }
        return (hasVowel && hasConsonant);
    }
}
