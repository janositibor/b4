package sentences;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceTransformer {
    private void validateSentence(String sentence){
        isUpperCase(sentence.substring(0,1));
        correctEnding(sentence.substring(sentence.length()-1));
    }

    private void correctEnding(String ending) {
        Pattern pattern= Pattern.compile("[.?!]");
        Matcher matcher= pattern.matcher(ending);
        if(!matcher.find()){
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }

    private void isUpperCase(String firstChar) {
        if(!firstChar.equals(firstChar.toUpperCase())){
            throw new IllegalArgumentException("Must start with capital letter!");
        }
    }

    public String shortenSentence(String sentence){
        validateSentence(sentence);
        String[] words=sentence.split(" ");
        if(words.length<=4){
            return sentence;
        }
        return (words[0]+" ... "+words[words.length-1]);


    }
}
