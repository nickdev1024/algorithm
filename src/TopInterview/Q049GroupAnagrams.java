package TopInterview;

import java.util.*;

class Q049GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>> ans = new ArrayList<>();
        if (null == arr || arr.length == 0) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        char[] str;
        String sorted;
        List<String> list;
        for (String s : arr) {
            str = s.toCharArray();
            Arrays.sort(str);
            sorted = String.valueOf(str);
            if (!map.containsKey(sorted)) {
                list = new ArrayList<>();
                map.put(sorted, list);
            }
            map.get(sorted).add(s);
        }
        ans.addAll(map.values());
        return ans;
    }

    private void validate() {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams(arr);

        for (List<String> list : ans) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    static public void main(String... args) {
        new Q049GroupAnagrams().validate();
    }
}