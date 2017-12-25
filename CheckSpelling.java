/**
Rosemary Torola

Implement a spelling checker by using a hash table. Assume that the dictionary comes from two sources: an existing large dictionary and a second ﬁle containing a personal dictionary.
Output all misspelled words and the line numbers in which they occur.
Also, for each misspelled word, list any words in the dictionary that are obtainable by applying any of the following rules: a. Add one character. b. Remove one character. c. Exchange adjacent characters.
**/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CheckSpelling{
  private HashSet<String> dict1;
  File inFile;
  File dictFile;

  public CheckSpelling() throws IOException{
    dict1 = new HashSet<>();
    inFile = args[0];
    dictFile = arggs[1];
    fillDict();
    spellCheck();

  }

  public void fillDict(){

    BufferedReader br = new BufferedReader(new FileReader(dictFile));
    String line;

    while((line = br.readLine()) != null){
      line = line.toLowerCase();
      dict1.add(line);
    }
    br.close();
  }

  public void spellCheck(){

    BufferedReader br2 = new BufferedReader(new FileReader(inFile));
    String line2;
    int lineNum = 0;

    while((line2 = br2.readLine()) != null){
      line2 = line2.toLowerCase();
      lineNum ++;
      String[] words = line.split("\\s+");
      for(String word : words){
        word = word.replaceAll("[^A-z0-9+$]", "").replaceAll("^[^A-z0-9]+", "");
        if(word.length()>0){
          if (dict1.contains(word) == false){
            System.out.println("word misspelled: " + word + "at line #" + lineNum);
            Set corrections = editWords(word);
            System.out.println("Suggested corrections: ");
            corrections.printStrings();
          }
        }
      }
    }
    br2.close();

  }

  public Set<String> editWords(String word){
    String edit;
    Set<String> newWords = new HashSet<>();
    String wlength = word.length();

    //exchange adjacent characters
    for(int n =1; n <= wlength; n ++){
      char one = word.substring (n-1,n);
      char two = word.substring(n, n+1);
      edit = word.substring(0, n-1) + two + one + word.substring(n+1, wlength);
      if(dict1.contains(edit))
        newWords.add(edit);
    }


    //remove a character
    for(int n = 1; n <= wlength; n ++){
      edit = word.substring(0,n) + word.substring(n+1, wlength);
      if(dict1.contains(edit))
        newWords.add(edit);
    }


    //add a character
    for(char c = 'a'; c <= 'z'; c++){
      for(int i =0; i <= wlength; i ++){
        edit = word.substring(0,i) + c + word.substring(j, wlength);
        if(dict1.contains(edit)){
          newWords.add(edit);
        }
      }
    }

  }

  public void printStrings(Set corrections){
    for(String word: corrections){
      System.out.println(word);
    }
  }

}
