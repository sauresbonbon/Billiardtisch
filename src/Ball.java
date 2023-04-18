class Ball{

    float xSpeed = 3, ySpeed = 3;
    float ballSize;
    float r;
    float x = (int)(Math.random()*599);
    float y = (int)(Math.random()*599);


    Billiardtisch tisch;

    Ball(Billiardtisch tisch, float ballSize){
        this.tisch = tisch;
        this.ballSize = ballSize;
        r = ballSize/2;
    }

    void display(){
        tisch.ellipse(x, y, ballSize, ballSize);
        tisch.fill(0);
    }

    void move(){
        x = x + xSpeed;
        y = y + ySpeed;
    }

    void bounce(){
        if (x < r+1) {
            xSpeed *= -1;
        }
        else if(x > 600-r+1) {
            xSpeed *= -1;
        }

        if (y < r+1) {
            ySpeed *= -1;
        }
        else if(y > 600-r+1){
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