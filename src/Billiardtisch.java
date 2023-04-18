import processing.core.PApplet;

public class Billiardtisch extends PApplet {
    public static void main(String[] args) {
        String[] appArgs = {"Billiardtisch"};
        Billiardtisch billiardtisch = new Billiardtisch();
        PApplet.runSketch(appArgs, billiardtisch);
    }

    Ball[] balls = new Ball[10];

    public void settings() {
        size(600, 600);
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(this,30);
        }
    }

    public void draw() {
        background(255);
        for (int i = 0; i < balls.length; i++) {
            balls[i].display();
            balls[i].move();
            balls[i].bounce();

            for (int k = 0; k < balls.length; k++) {
                if (k != i) {
                    balls[i].overlaps(balls[k]);
                    balls[k].overlaps(balls[i]);
                }
            }
        }
    }
}
