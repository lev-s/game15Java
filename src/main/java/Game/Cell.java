package Game;

public class Cell {
    private int size;
    private int x, y;

    private STATE state;
    private enum color {RED, GREEN, GREY};
    private int value;

    public Cell(int size) {
        this.size = size;
        this.value = 0;
        this.state = state.EMPTY;
    }

    public STATE getState() {
        return state;
    }

    public Cell(int size, int x, int y) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.state = STATE.EMPTY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeState() {
        if (this.state == STATE.EMPTY) {
            this.state = STATE.O;
        } else if (this.state == STATE.O) {
            this.state = STATE.X;
        } else {
            this.state = STATE.EMPTY;
        }
    }

    @Override
    public String toString() {
        if (state == STATE.EMPTY) {
            return "";
        } else if (state == STATE.O) {
            return "O";
        } else {
            return "X";
        }
    }
}

///* Cell
// *  Version information
// *  5/10/2022
// *  Copyright User
// */
//
//package Game;
//
//public class Cell {
//    private int size;
//    private int x, y;
//
//    private String text;
//
//    private STATE state;
//    private enum color {GREEN, RED};
//
//
//
//    public STATE getState() {
//        return state;
//    }
//
//    public Cell(int size, int x, int y, String text) {
//        this.size = size;
//        this.x = x;
//        this.y = y;
//        this.state = STATE.EMPTY;
//        this.text = text;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void changeState() {
//        if (this.state == STATE.EMPTY) {
//            this.state = STATE.O;
//        } else if (this.state == STATE.O) {
//            this.state = STATE.X;
//        } else {
//            this.state = STATE.EMPTY;
//        }
//    }
//
//    @Override
//    public String toString() {
//        if (this.text.equals("16")){
//            return "";
//        }else {
//            return this.text;
//        }
//    }
//}