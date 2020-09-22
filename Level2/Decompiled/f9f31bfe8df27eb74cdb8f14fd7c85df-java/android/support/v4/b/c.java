package android.support.v4.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.a.a.a;
import android.support.v4.a.a.b;
import android.support.v4.e.b;
import android.support.v4.f.g;

public class c {
    private static final a a = (Build.VERSION.SDK_INT >= 26 ? new f() : (Build.VERSION.SDK_INT < 24 || !e.a()) ? Build.VERSION.SDK_INT >= 21 ? new d() : new g() : new e());
    private static final g<String, Typeface> b = new g<>(16);

    interface a {
        Typeface a(Context context, Resources resources, int i, String str, int i2);

        Typeface a(Context context, CancellationSignal cancellationSignal, b.C0006b[] bVarArr, int i);

        Typeface a(Context context, a.b bVar, Resources resources, int i);
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = a.a(context, resources, i, str, i2);
        if (a2 != null) {
            b.a(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0006b[] bVarArr, int i) {
        return a.a(context, cancellationSignal, bVarArr, i);
    }

    public static Typeface a(Context context, a.C0003a aVar, Resources resources, int i, int i2, b.a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof a.d) {
            a.d dVar = (a.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.b() == 0) {
                z2 = true;
            }
            typeface = android.support.v4.e.b.a(context, dVar.a(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typeface = a.a(context, (a.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.a(typeface, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            b.a(b(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return b.a(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
