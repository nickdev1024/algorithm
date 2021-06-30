package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q022GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return null;
        }
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        process(ans, "", n, 0);
        return ans;
    }

    private void process(List<String> ans, String sol, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(sol);
            return;
        }
        if (left > 0) {
            process(ans, sol + "(", left - 1, right + 1);
        }
        if (right > 0) {
            process(ans, sol + ")", left, right - 1);
        }
    }

    static public void main(String... args) {
        Q022GenerateParentheses obj = new Q022GenerateParentheses();
        List<String> ans = obj.generateParenthesis(1);
        for (String list : ans) {
            System.out.println(list);
        }
    }
}