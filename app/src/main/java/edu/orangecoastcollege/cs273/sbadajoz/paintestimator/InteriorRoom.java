package edu.orangecoastcollege.cs273.sbadajoz.paintestimator;


public class InteriorRoom {
    public static final float DOOR_AREA = 21;
    public static final float WINDOW_AREA = 16;
    public static final float SQ_FEET_PER_GALLON = 275;

    private float mDoors;
    private float mWindows;
    private float mHeight;
    private float mLength;
    private float mWidth;

    private float doorAndWindowArea() {
        return (mDoors * DOOR_AREA) + (mWindows * WINDOW_AREA);
    }

    private float wallSurfaceArea() {
        return (2 * mWidth * mHeight) + (2 * mLength * mHeight) + (mWidth * mLength);
    }

    public float totalSurfaceArea() {
        return wallSurfaceArea()- doorAndWindowArea();
    }

    public float gallonsOfPaintRequires() {
        return totalSurfaceArea() / SQ_FEET_PER_GALLON;
    }

    public float getDoors() {
        return mDoors;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setHeight(float height) {
        mHeight = height;
    }

    public float getLength() {
        return mLength;
    }

    public void setLength(float length) {
        mLength = length;
    }

    public float getWindows() {
        return mWindows;
    }

    public void setDoors(float doors) {
        mDoors = doors;
    }

    public void setWindows(float windows) {
        mWindows = windows;
    }

    public float getWidth() {
        return mWidth;
    }

    public void setWidth(float width) {
        mWidth = width;
    }
}
