package android.csulb.edu.accgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;


/**
 * Created by VIRAL on 3/15/2015.
 */
public class SimulationView extends View implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensorAccelerometer;
    private Display display;

    private Bitmap fieldP;
    private Bitmap basketP;
    private Bitmap bitmapP;

    private static final int BALL_SIZE = 64;
    private static final int BASKET_SIZE = 80;

    private float xOrigin;
    private float yOrigin;
    private float horizontalBound;
    private float verticalBound;

    private float xAxis;
    private float yAxis;
    private float zAxis;
    private long timeStamp;

    private Particle mBall;

    public SimulationView(Context context) {
        super(context);

        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        Bitmap ball = BitmapFactory.decodeResource(getResources(),R.mipmap.ball);
        bitmapP = Bitmap.createScaledBitmap(ball,BALL_SIZE,BALL_SIZE,true);

        Bitmap basket = BitmapFactory.decodeResource(getResources(),R.mipmap.basket);
        basketP = Bitmap.createScaledBitmap(basket,BASKET_SIZE,BASKET_SIZE,true);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        fieldP = BitmapFactory.decodeResource(getResources(),R.mipmap.court,options);

        mBall = new Particle();

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();

        horizontalBound = display.getWidth();
        verticalBound = display.getHeight();

        xOrigin = 50;
        yOrigin = 50;
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        zAxis = event.values[2];
        timeStamp = event.timestamp;

        if(display.getRotation() == Surface.ROTATION_0){
            xAxis = event.values[0];
            yAxis = event.values[1];

        }else if(display.getRotation() == Surface.ROTATION_90){
            xAxis = -event.values[1];
            yAxis = event.values[0];
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void startSimulation(){
        if(sensorAccelerometer != null){
            sensorManager.registerListener(this,sensorAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void stopSimulation(){
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(fieldP,0,0,null);
        canvas.drawBitmap(basketP,xOrigin - BASKET_SIZE / 2, yOrigin - BASKET_SIZE / 2, null);
        mBall.updatePosition(xAxis,yAxis,zAxis,timeStamp);
        mBall.resolveCollisionWithBound(horizontalBound,verticalBound);

        canvas.drawBitmap(bitmapP, (xOrigin - BALL_SIZE / 2) + mBall.posX,  (yOrigin - BALL_SIZE / 2) + mBall.posY, null);
        invalidate();
    }
}
