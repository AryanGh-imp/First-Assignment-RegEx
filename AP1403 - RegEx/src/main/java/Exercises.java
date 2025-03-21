import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    /*
        complete the method below, so it will validate an email address
     */
    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     */
    public String findDate(String string) {

        String regex = "\\b(\\d{4})[-/](0?[1-9]|1[0-2])[-/](0?[1-9]|[12][0-9]|3[01])\\b|" +
                "\\b(0?[1-9]|[12][0-9]|3[01])[-/](0?[1-9]|1[0-2])[-/]\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        - at least 8 characters
        - has to include at least one uppercase letter, and at least a lowercase
        - at least one number and at least a special char "!@#$%^&*"
        - has no white-space in it
     */
    public int findValidPasswords(String string) {
        if (string == null || string.isEmpty()) return 0;

        String[] passwords = string.split("\\s+");
        int count = 0;

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[^\\s]{8,}$";
        Pattern pattern = Pattern.compile(regex);

        for (String password : passwords) {
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                count++;
            }
        }

        return count;
    }

    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public List<String> findPalindromes(String string) {

        List<String> list = new ArrayList<>();

        String[] words = string.split("\\s+");

        for (String word : words) {
            String cleanWord = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");

            if (cleanWord.length() >= 3 &&
                    cleanWord.equalsIgnoreCase(new StringBuilder(cleanWord).reverse().toString())) {
                list.add(cleanWord);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // you can test your code here
    }
}
