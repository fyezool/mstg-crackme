package android.support.v4.widget;

import android.os.Build;
import android.widget.EdgeEffect;

public final class f {
    private static final b a = (Build.VERSION.SDK_INT >= 21 ? new a() : new b());

    static class a extends b {
        a() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    static class b {
        b() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    public static void a(EdgeEffect edgeEffect, float f, float f2) {
        a.a(edgeEffect, f, f2);
    }
}
