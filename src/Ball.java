class Ball{

    float xSpeed = 3, ySpeed = 3;
    float ballSize;
    float r;
    float x;
    float y;


    Billiardtisch tisch;

    /**
     * Konstruktor der Klasse Ball.
     * */
    Ball(Billiardtisch tisch, float ballSize){
        this.tisch = tisch;
        this.ballSize = ballSize;
        r = ballSize/2;
        x = tisch.random(ballSize, tisch.width-ballSize);
        y = tisch.random(ballSize, tisch.height-ballSize);
    }

    /**
     * Erzeugt einen Ball.
     * */
    void display(){
        tisch.ellipse(x, y, ballSize, ballSize);
        tisch.fill(200);
    }
    /**
     * Methode durch die sich die Bälle bewegen.
     * */
    void move(){
        x = x + xSpeed;
        y = y + ySpeed;
    }

    /**
     * Die Bälle prallen durch diese Methode an den Seiten ab.
     * */
    void bounce(){
        if (x < ballSize) {
            xSpeed *= -1;
        }
        else if(x > tisch.width-ballSize) {
            xSpeed *= -1;
        }

        if (y < ballSize) {
            ySpeed *= -1;
        }
        else if(y > tisch.height-ballSize){
            ySpeed *= -1;
        }
    }

    void overlaps(Ball ball){
        float d = tisch.dist(x, y, ball.x, ball.y);
        if( d <= r + ball.r+1){
            if(x < ball.x){
                xSpeed = -tisch.abs(xSpeed);
            }
            if(x > ball.x+1){
                xSpeed = tisch.abs(xSpeed);
            }
            if(y < ball.y+1){
                ySpeed = -tisch.abs(ySpeed);
            }
            if(y > ball.y+1){
                ySpeed = tisch.abs(ySpeed);
            }
        }
    }
}