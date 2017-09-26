package edu.orangecoastcollege.cs273.sbadajoz.paintestimator;


public class InteriorRoom {
    private static final float DOOR_AREA = 21;
    private static final float WINDOW_AREA = 16;
    private static final float SQ_FEET_PER_GALLON = 275;

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

    /**
     * Calculates the total amount of surface area
     * @return total surface area
     */
    public float totalSurfaceArea() {
        return wallSurfaceArea()- doorAndWindowArea();
    }

    /**
     * Calculates the amount of paint needed to paint the room
     * @return Gallons of paint needed
     */
    public float gallonsOfPaintRequires() {
        return totalSurfaceArea() / SQ_FEET_PER_GALLON;
    }

    /**
     * Returns the number of doors in the room
     * @return num of Doors
     */
    public float getDoors() {
        return mDoors;
    }

    /**
     * Returns the height of the room
     * @return room height
     */
    public float getHeight() {
        return mHeight;
    }

    /**
     * Sets the height of the room to a new value
     * @param height New room height
     */
    public void setHeight(float height) {
        mHeight = height;
    }

    /**
     * Returns the length of the room
     * @return room length
     */
    public float getLength() {
        return mLength;
    }

    /**
     * Sets the length of the room to a new value
     * @param length new room length
     */
    public void setLength(float length) {
        mLength = length;
    }

    /**
     * Returns the number of windows in the room
     * @return number of windows
     */
    public float getWindows() {
        return mWindows;
    }

    /**
     * Sets the number of doors to a new value
     * @param doors new number of doors
     */
    public void setDoors(float doors) {
        mDoors = doors;
    }

    /**
     * Sets the number of windows to a new value
     * @param windows new number of windows
     */
    public void setWindows(float windows) {
        mWindows = windows;
    }

    /**
     * Returns the width of the room
     * @return Room width
     */
    public float getWidth() {
        return mWidth;
    }

    /**
     * Sets the width of the room to a new value
     * @param width new room width
     */
    public void setWidth(float width) {
        mWidth = width;
    }
}
