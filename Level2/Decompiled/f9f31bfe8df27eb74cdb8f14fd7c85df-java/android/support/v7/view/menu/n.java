package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.g.d;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.support.v7.view.menu.o;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class n {
    private final Context a;
    private final h b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private o.a i;
    private m j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public n(Context context, h hVar, View view, boolean z, int i2) {
        this(context, hVar, view, z, i2, 0);
    }

    public n(Context context, h hVar, View view, boolean z, int i2, int i3) {
        this.g = 8388611;
        this.l = new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                n.this.e();
            }
        };
        this.a = context;
        this.b = hVar;
        this.f = view;
        this.c = z;
        this.d = i2;
        this.e = i3;
    }

    private void a(int i2, int i3, boolean z, boolean z2) {
        m b2 = b();
        b2.c(z2);
        if (z) {
            if ((d.a(this.g, p.b(this.f)) & 7) == 5) {
                i2 += this.f.getWidth();
            }
            b2.b(i2);
            b2.c(i3);
            int i4 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b2.a(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        b2.a();
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [android.support.v7.view.menu.m] */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.support.v7.view.menu.t] */
    /* JADX WARNING: type inference failed for: r1v13, types: [android.support.v7.view.menu.e] */
    /* JADX WARNING: Multi-variable type inference failed */
    private m g() {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        ? eVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width) ? new e(this.a, this.f, this.d, this.e, this.c) : new t(this.a, this.b, this.f, this.d, this.e, this.c);
        eVar.a(this.b);
        eVar.a(this.l);
        eVar.a(this.f);
        eVar.a(this.i);
        eVar.a(this.h);
        eVar.a(this.g);
        return eVar;
    }

    public void a() {
        if (!c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void a(int i2) {
        this.g = i2;
    }

    public void a(o.a aVar) {
        this.i = aVar;
        if (this.j != null) {
            this.j.a(aVar);
        }
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(boolean z) {
        this.h = z;
        if (this.j != null) {
            this.j.a(z);
        }
    }

    public boolean a(int i2, int i3) {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i2, i3, true, true);
        return true;
    }

    public m b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public void d() {
        if (f()) {
            this.j.c();
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.j = null;
        if (this.k != null) {
            this.k.onDismiss();
        }
    }

    public boolean f() {
        return this.j != null && this.j.d();
    }
}
