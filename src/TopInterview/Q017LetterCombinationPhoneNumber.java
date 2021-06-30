package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q017LetterCombinationPhoneNumber {

    private List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (null == digits || digits.length() == 0) {
            return ans;
        }
        char[][] dict = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        char[] str = digits.toCharArray();
        char[] path = new char[str.length];
        process(str, 0, dict, ans, path);
        return ans;
    }

    private void process(char[] str, int index, char[][] dict, List<String> ans, char[] path) {
        if (index == str.length) {
            ans.add(String.valueOf(path));
        } else {
            char char2 = '2';
            char[] letters = dict[str[index] - char2];
            for (char letter : letters) {
                path[index] = letter;
                process(str, index + 1, dict, ans, path);
            }
        }
    }

    static public void main(String... args) {
        Q017LetterCombinationPhoneNumber obj = new Q017LetterCombinationPhoneNumber();
        List<String> ans = obj.letterCombinations("34");
        for (String list : ans) {
            System.out.println(list);
        }
    }
}