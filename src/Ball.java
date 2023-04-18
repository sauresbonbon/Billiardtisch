class Ball extends Billiardtisch{
    float col;
    float xSpeed = 3, ySpeed = 3;
    float ballSize;
    float r;
    float x = random(0,599);
    float y = random(0,599);

    Billiardtisch tisch = new Billiardtisch();

    Ball(float ballSize){
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
        float d = dist(x, y, ball.x, ball.y);
        if( d <= r + ball.r+1){
            if(x < ball.x){
                xSpeed = -abs(xSpeed);
            }
            if(x > ball.x+1){
                xSpeed = abs(xSpeed);
            }
            if(y < ball.y+1){
                ySpeed = -abs(ySpeed);
            }
            if(y > ball.y+1){
                ySpeed = abs(ySpeed);
            }
        }
    }
}