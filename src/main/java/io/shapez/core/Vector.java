package io.shapez.core;

public class Vector {
    public float y;
    public float x;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public static Direction transformDirectionFromMultipleOf90(Direction direction, int angle) {
        if (angle == 0 || angle == 360) {
            return direction;
        }
        switch (direction) {
            case top: {
                switch (angle) {
                    case 90:
                        return Direction.right;
                    case 180:
                        return Direction.bottom;
                    case 270:
                        return Direction.left;
                    default:
                        return direction;
                }
            }
            case right: {
                switch (angle) {
                    case 90:
                        return Direction.bottom;
                    case 180:
                        return Direction.left;
                    case 270:
                        return Direction.top;
                    default:
                        return direction;
                }
            }
            case bottom: {
                switch (angle) {
                    case 90:
                        return Direction.left;
                    case 180:
                        return Direction.right;
                    case 270:
                        return Direction.top;
                    default:
                        return direction;
                }
            }
            case left: {
                switch (angle) {
                    case 90:
                        return Direction.top;
                    case 180:
                        return Direction.right;
                    case 270:
                        return Direction.bottom;
                    default:
                        return direction;
                }
            }
            default:
                return direction;
        }
    }

    public Vector divideScalar(int f) {
        return new Vector(this.x / f, this.y / f);
    }

    public Vector rotateFastMultipleOf90(int angle) {
        switch (angle) {
            case 360:
            case 0: {
                return new Vector(this.x, this.y);
            }
            case 90: {
                return new Vector(-this.y, this.x);
            }
            case 180: {
                return new Vector(-this.x, -this.y);
            }
            case 270: {
                return new Vector(this.y, -this.x);
            }
            default: {
                return new Vector();
            }
        }
    }

    public Vector addScalar(float f) {
        return new Vector(this.x + f, this.y + f);
    }

    public float length() {
        return (float) Math.hypot(this.x, this.y);
    }

    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    public Vector sub(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }
}
