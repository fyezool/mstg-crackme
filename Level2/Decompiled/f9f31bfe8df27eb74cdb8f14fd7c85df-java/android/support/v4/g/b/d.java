package android.support.v4.g.b;

import android.view.animation.Interpolator;

abstract class d implements Interpolator {
    private final float[] a;
    private final float b = (1.0f / ((float) (this.a.length - 1)));

    protected d(float[] fArr) {
        this.a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.a.length - 1)) * f), this.a.length - 2);
        return this.a[min] + (((f - (((float) min) * this.b)) / this.b) * (this.a[min + 1] - this.a[min]));
    }
}
