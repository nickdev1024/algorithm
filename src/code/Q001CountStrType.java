package code;

import java.util.HashSet;
import java.util.Set;

class Q001CountStrType {

    private int countStrType(String[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        char[] str;
        int value;
        for (String s : arr) {
            value = 0;
            str = s.toCharArray();
            for (char ch : str) {
                value |= 1 << (ch - 'a');
            }
            set.add(value);
        }
        return set.size();
    }

    private int test(String[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        char[] str;
        int size = 26;
        int[] help = new int[size];
        int idx;
        StringBuilder builder = new StringBuilder();
        char a = 'a';

        for (String s : arr) {
            str = s.toCharArray();
            for (char ch : str) {
                idx = ch - a;
                help[idx] += help[idx] != 0 ? 0 : 1;
            }
            for (int i = 0; i < size; ++i) {
                if (help[i] == 1) {
                    builder.append((char) (a + i));
                    help[i] = 0;
                }
            }
            set.add(String.valueOf(builder));
            builder.setLength(0);
        }
        return set.size();
    }

    private String[] generateStrArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = generateRandStr(seed);
        }
        return arr;
    }

    private String generateRandStr(int seed) {
        int len = (int) (Math.random() * seed + 1);
        StringBuilder str = new StringBuilder();

        char a = 'a';
        int range = 26;
        for (int i = 0; i < len; i++) {
            str.append((char) (a + Math.random() * range));
        }
        return String.valueOf(str);
    }

    private void validate() {
        int million = 1_000_000;
        int seed = 20;
        int type1, type2;

        String[] arr;
        System.out.println("test started ...");
        for (int i = 0; i < million; i++) {
            arr = generateStrArray(seed);
            type1 = countStrType(arr);
            type2 = test(arr);

            if (type1 != type2) {
                System.err.println("test failed ...");
                return;
            }
        }
        System.out.println("test passed ...");
    }

    static public void main(String... args) {
        new Q001CountStrType().validate();
    }
}