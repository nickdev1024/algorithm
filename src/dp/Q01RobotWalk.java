package dp;

class Q01RobotWalk {

    /**
     * calculate the total number of ways walking from start to aim
     *
     * @param size  total number of spots
     * @param start the start position
     * @param aim   the finish position
     * @param step  the remaining step from current position to aim position
     * @return the total number of ways walking from start to aim
     */
    private int way1(int size, int start, int aim, int step) {
        if (step == 0) {
            return start == aim ? 1 : 0;
        }
        if (start < 1 || start > size || aim < 1 || aim > size) {
            return 0;
        }
        return way1(size, start + 1, aim, step - 1)
                + way1(size, start - 1, aim, step - 1);

    }

    private void validate() {
        int size = 7;
        int start = 2;
        int aim = 4;
        int step = 4;

        System.out.println(way1(size, start, aim, step));
    }

    static public void main(String... args) {
        new Q01RobotWalk().validate();
    }
}