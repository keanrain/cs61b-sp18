
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque str = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            str.addLast(word.charAt(i));
        }
        return str;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> str = wordToDeque(word);

        return isPalHelper(str);
    }

    private boolean isPalHelper(Deque<Character> str) {
        if (str.size() <= 1) {
            return true;
        }
        if (str.removeFirst() != str.removeLast()) {
            return false;
        } else {
            return isPalHelper(str);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> str = wordToDeque(word);
        while (str.size() > 1) {
            if (!cc.equalChars(str.removeLast(),  str.removeFirst())) {
                return false;
            }
        }
        return true;
    }
}
