import java.util.*;
public class APWordCount {
    static Character punctuation[] = {'.', '?', '!'};

    private static boolean isValid(String para){ 
        if(Arrays.asList(punctuation).contains(para.charAt(para.length()-1))){
            return true;
        }
        return false;
    }

    public static int numberOfSentence(String para){
        int sentences = 0;
        int lastSentenceIndex = 0;
        for(int i=0; i<para.length(); i++){
            // Checks if character contains any punctuation and checks if the sentence length is >= 4
            // because the shortest possible sentence "I am"(look it up if you dont beleive me) is 4 characters
            if(Arrays.asList(punctuation).contains(para.charAt(i)) && i-lastSentenceIndex>4){
                sentences ++;
                lastSentenceIndex = i;
            }
        }
        // If there is no puncuation at the end and paragraph length is 4 characters or more greater than the last punctuation index then adds one more to sentences
        if(!isValid(para) && (para.length()-1)-lastSentenceIndex>4){
            sentences++;
        }
        return sentences;
    }

    public static int numberOfWords(String para){
        int words = 0;
        int lastWordIndex = 0;
        // Adds 1 to word counter every time there is a space(or puncuation to account for the fact that there is no space after the last word)
        for(int i=0; i<para.length(); i++){
            if((para.charAt(i) == ' ' || Arrays.asList(punctuation).contains(para.charAt(i))) && i-lastWordIndex != 1){
                lastWordIndex = i;
                words++;
            }
        }
        // If paragraph does not end in puncuation and the last word index count was not at the end then it adds one more
        if(!isValid(para) && (para.length()-1)-lastWordIndex>0){words++;}
        return words;
    }

    private static int numberOfCharacters(String para){  
        int characters = 0;
        // counts every character except spaces as the assignment specified in the partial code
        for(int i=0; i<para.length(); i++){
            if(para.charAt(i) != ' '){
                characters++;
            }
        }
        return characters;
    }

    private static boolean findWord(String para, String wrd){
        // Using .toLowerCase() so that capitilization does not interfere with finding out if a word is present in paragraph
        if(para.toLowerCase().contains(wrd.toLowerCase())){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String para = "Sometimes you need to practice a little tough love! This message shows that you're there to offer up the tools for education, but it's up to your students to accept and use these tools.";
        System.out.println("Number of words: " +numberOfWords(para));
        System.out.println("Number of sentences: " + numberOfSentence(para));   
        System.out.println("Number of characters: " + numberOfCharacters(para));      
        System.out.println(findWord(para, "the"));
    } 
}
