////Game of 15Puzzle
//// Using processing
//// Classes
import Game.Cell;
import Game.STATE;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.Random;

public class Main extends PApplet {
    final int WIDTH = 800;
    final int HEIGHT = 600;
    final int SIZE = 120;
    final int ROWS = 4;
    final int COLS = 4;
    private Cell cells[][] = new Cell[ROWS][COLS];

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);

    }

    @Override
    public void setup() {
        surface.setTitle("Game of 15Puzzle");

        textAlign(CENTER, CENTER);
        textSize(32);
        int a[] = new int[16];
        int setCount = 0;
        for (int i = 0; i < 16; i++){
            a[i] = i;
        }

        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int randomIndexToSwap = rand.nextInt(a.length);
            int temp = a[randomIndexToSwap];
            a[randomIndexToSwap] = a[i];
            a[i] = temp;
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = new Cell(SIZE, WIDTH / 2 + SIZE * j - (int) (SIZE * COLS / 2.0), HEIGHT / 2 + SIZE * i - (int) (SIZE * ROWS / 2.0));
                cells[i][j].setValue(a[setCount]);
                setCount++;
            }
        }
    }

    @Override
    public void draw() {
        background(255);

        textSize(25);
        fill(0, 0, 0);
        text("N/n - New Game        F9  - Complete the game", 400, 25);
        textSize(15);
        fill(0, 0, 0);
        text("Author:   Sherkhan Naimanov, MATH19", 400, 570);


        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (cells[i][j].getState() == STATE.O) {
                    fill(200, 0, 0);
                } else if (cells[i][j].getState() == STATE.X) {
                    fill(0, 200, 0);
                } else {
                    fill(100, 100, 100);
                }
                rect(cells[i][j].getX(), cells[i][j].getY(), SIZE, SIZE);
                fill(255);
                if (cells[i][j].getValue() != 0) {
                    textSize(80);
                    text(cells[i][j].getValue() + "", cells[i][j].getX() + SIZE / 2, cells[i][j].getY() + SIZE / 3);

                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == 37) { // LEFT KEY
            moveLeft();
        }
        if (event.getKeyCode() == 38) { // UP KEY
            moveUp();
        }
        if (event.getKeyCode() == 39) { // RIGHT KEY
            moveRight();
        }
        if (event.getKeyCode() == 40) { // DOWN KEY
            moveDown();
        }
        if (event.getKeyCode() == 78) { // N KEY
            newGame();
        }
        if (event.getKeyCode() == 120) { // N KEY
            complete();
        }
    }

    private void moveUp() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(cells[i][j].getValue()==0){
                    x = i;
                    y = j;
                }
            }
        }
        if(x!=0){
            cells[x][y].setValue(cells[x-1][y].getValue());
            cells[x-1][y].setValue(0);
        }
        else{
            println("You cannot go so far!");
        }
    }

    private void moveRight() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(cells[i][j].getValue()==0){
                    x = i;
                    y = j;
                }
            }
        }

        if (y!=3){
            cells[x][y].setValue(cells[x][y+1].getValue());
            cells[x][y+1].setValue(0);
        }
        else{
            println("You cannot go so far!");
        }
    }

    private void moveDown() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(cells[i][j].getValue()==0){
                    x = i;
                    y = j;
                }
            }
        }

        if (x!=3){
            cells[x][y].setValue(cells[x+1][y].getValue());
            cells[x+1][y].setValue(0);
        }
        else{
            println("You cannot go so far!");
        }
    }

    private void moveLeft() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(cells[i][j].getValue()==0){
                    x = i;
                    y = j;
                }
            }
        }
        if (y!=0){
            cells[x][y].setValue(cells[x][y-1].getValue());
            cells[x][y-1].setValue(0);
        }
        else{
            println("You cannot go so far!");
        }
    }

    private void newGame() {

        for (int i=0;i<100;i++){
            int oldX = (int)(Math.random() * ROWS);
            int oldY = (int)(Math.random() * COLS);
            int oldC = cells[oldX][oldY].getValue();
            int newX = (int)(Math.random() * ROWS);
            int newY = (int)(Math.random() * COLS);
            int newC = cells[newX][newY].getValue();

            cells[oldX][oldY].setValue(newC);
            cells[newX][newY].setValue(oldC);
        }
    }

    private void complete() {
        int counter = 1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == 3 && j == 3){
                    continue;
                }
                else {
                    cells[i][j].setValue(counter);
                    counter++;
                }
            }
        }
        cells[3][3].setValue(0);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}