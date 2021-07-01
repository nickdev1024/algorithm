package TopInterview;

class Q169MajorityElement {

    public int majorityElement(int[] arr) {
        int candidate = 0;
        int frequency = 0;

        for (int num : arr) {
            if (frequency == 0) {
                candidate = num;
                frequency = 1;
            } else if (num == candidate) {
                ++frequency;
            } else {
                --frequency;
            }
        }
        return candidate;
    }

    static public void main(String... args) {
        int[] arr = {3, 2, 3};
        Q169MajorityElement obj = new Q169MajorityElement();
        System.out.println(obj.majorityElement(arr));
        arr = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(obj.majorityElement(arr));
    }
}