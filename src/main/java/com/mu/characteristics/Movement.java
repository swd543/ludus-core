package com.mu.characteristics;

public class Movement {
    private boolean canMoveDiagonally=false;
    private boolean canJump=true;
    private int distance=1;

    public Movement() {}

    public Movement(boolean canMoveDiagonally, boolean canJump, int distance) {
        this.canMoveDiagonally = canMoveDiagonally;
        this.canJump = canJump;
        this.distance = distance;
    }

    public boolean canMoveDiagonally() {
        return canMoveDiagonally;
    }

    public boolean canJump() {
        return canJump;
    }

    public int getDistance() {
        return distance;
    }

    public Movement setCanMoveDiagonally(boolean canMoveDiagonally) {
        this.canMoveDiagonally = canMoveDiagonally;
        return this;
    }

    public Movement setCanJump(boolean canJump) {
        this.canJump = canJump;
        return this;
    }

    public Movement setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "canMoveDiagonally=" + canMoveDiagonally +
                ", canJump=" + canJump +
                ", distance=" + distance +
                '}';
    }
}
