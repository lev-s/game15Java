/* Creature
 *  Version information
 *  4/19/2022
 *  Copyright User
 */

package Game;

import processing.core.PApplet;

public class Creature {
    private int x;
    private int y;
    private int size;
    private int speed;
    private int health;

    public Creature() {
    }

    public Creature(int x, int y, int size, int health) {
        this.x = x;
        this.y = y;
        this.speed = 1;
        this.size = size;
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void teleport(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public void moveTo(int x, int y) {
        if (getDistance(this.x, this.y, x, y) > 0.5) {
            this.x -= (this.x - x) / 1;
            this.y -= (this.y - y) / 1;
        }
    }

    public void moveTo(int dir) {
        if (dir == 0) {
            this.y -= size;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSize() {
        return size;
    }
}