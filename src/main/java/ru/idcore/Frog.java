package ru.idcore;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    private static Frog instance = null;
    protected int position;

    private Frog() {
        position = 5;
    }

    public static Frog getInstance() {
        return (instance == null) ? new Frog() : instance;
    }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        if (steps > 0) {
            if (position + steps <= MAX_POSITION) {
                position += steps;
                return true;
            } else {
                return false;
            }
        }
        if (steps < 0) {
            if (position + steps >= MIN_POSITION) {
                position += steps;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }



    @Override
    public String toString() {
        //return ("\u2606").repeat(position) + ("\u2612") + ("\u2606").repeat(MAX_POSITION - position);
        return ("|__|").repeat(position) + ("| Х |") + ("|__|").repeat(MAX_POSITION - position);

    }
}
