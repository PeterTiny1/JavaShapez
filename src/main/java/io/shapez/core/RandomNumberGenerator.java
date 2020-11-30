package io.shapez.core;

public class RandomNumberGenerator {
    private final String seed;
    int internalRng;

    public RandomNumberGenerator(String seed) {
        internalRng = (int) makeNewRng(seed);
        this.seed = seed;
    }

    private double makeNewRng(String seed) {
        int c = 1;
        double s0 = mash(" ");
        double s1 = mash(" ");
        double s2 = mash(" ");

        s0 -= mash(seed);
        if (s0 < 0) {
            s0 += 1;
        }
        s1 -= mash(seed);
        if (s1 < 0) {
            s1 += 1;
        }
        s2 -= mash(seed);
        if (s2 < 0) {
            s2 += 1;
        }
        double random;
        double t = 2091639 * s0 + c * 2.3283064365386963e-10;
        s0 = s1;
        s1 = s2;
        return (s2 = t - (c = (int) t));
    }

    private double mash(String data) {
        long n = 0xefc8249d;
        for (long i = 0; i < data.length(); ++i) {
            n += data.charAt((int) i);
            long h = (long) (0.02519603282416938 * n);
            n = h;
            h *= n;
            n = h;
            h -= n;
            n += h * (long) (0x10000000);
        }
        return (n) * 2.3283064365386963e-10;
    }

    public int nextIntRange(int min, int max) {
        return this.next() * (max - min) + min;
    }

    public int next() {
        return (int) this.makeNewRng(this.seed);
    }

    public float nextRange(double min, double max) {
        return (float) (this.next() * (max - min) + min);
    }

    public Object choice(Object[] array) {
        int index = this.nextIntRange(0, array.length);
        return array[index];
    }
}
