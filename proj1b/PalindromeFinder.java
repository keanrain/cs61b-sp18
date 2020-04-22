/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        int[] nums = new int[26];
        String[] longestWords = new String[26];

        while (!in.isEmpty()) {
            String word = in.readString();
            for (int i = 0; i < 26; i++) {
                OffByN offByi = new OffByN(i);
                // what N are there the most palindromes in English?
                // What is the longest offByN palindrome for any N?
                if (palindrome.isPalindrome(word, offByi)) {
                    if (longestWords[i] == null) {
                        longestWords[i] = word;
                    } else if (word.length() > longestWords[i].length()) {
                        longestWords[i] = word;
                    }
                    nums[i]++;
                }
            }
        }
        for (int i: nums) {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println();
        for (String i: longestWords) {
            System.out.print(i + ' ');
        }
    }
}
