package android.csulb.edu.accgame;

/**
 * Created by VIRAL on 3/15/2015.
 */
public class Particle {

    private static final float COR = 0.7f;

    public float posX;
    public float posY;
    private float velX;
    private float velY;

    public void updatePosition(float xAxis, float yAxis, float zAxis, long timeStamp){
        float deltaTime = (System.nanoTime() - timeStamp) / 1000000000.0f;
        velX += -xAxis * deltaTime;
        velY += -yAxis * deltaTime;

        posX += velX * deltaTime;
        posY += velY * deltaTime;
    }

    public void resolveCollisionWithBound(float horizontalBound, float verticalBound){
        if(posX > horizontalBound){
            posX = horizontalBound;
            velX = -velX * COR;
        }else if(posX < -horizontalBound){
            posX = -horizontalBound;
            velX = -velX * COR;
        }

        if(posY > verticalBound){
            posY = verticalBound;
            velY = -velY * COR;
        }else if(posX < -verticalBound){
            posY = -verticalBound;
            velY = -velY * COR;
        }

    }
}
