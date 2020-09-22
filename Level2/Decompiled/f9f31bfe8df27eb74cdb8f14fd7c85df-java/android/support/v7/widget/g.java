package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;

class g {
    private final View a;
    private final l b;
    private int c = -1;
    private au d;
    private au e;
    private au f;

    g(View view) {
        this.a = view;
        this.b = l.a();
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new au();
        }
        au auVar = this.f;
        auVar.a();
        ColorStateList i = p.i(this.a);
        if (i != null) {
            auVar.d = true;
            auVar.a = i;
        }
        PorterDuff.Mode j = p.j(this.a);
        if (j != null) {
            auVar.c = true;
            auVar.b = j;
        }
        if (!auVar.d && !auVar.c) {
            return false;
        }
        l.a(drawable, auVar, this.a.getDrawableState());
        return true;
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList a() {
        if (this.e != null) {
            return this.e.a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new au();
        }
        this.e.a = colorStateList;
        this.e.d = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new au();
        }
        this.e.b = mode;
        this.e.c = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.c = -1;
        b((ColorStateList) null);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        aw a2 = aw.a(this.a.getContext(), attributeSet, a.j.ViewBackgroundHelper, i, 0);
        try {
            if (a2.g(a.j.ViewBackgroundHelper_android_background)) {
                this.c = a2.g(a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.b.b(this.a.getContext(), this.c);
                if (b2 != null) {
                    b(b2);
                }
            }
            if (a2.g(a.j.ViewBackgroundHelper_backgroundTint)) {
                p.a(this.a, a2.e(a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(a.j.ViewBackgroundHelper_backgroundTintMode)) {
                p.a(this.a, af.a(a2.a(a.j.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        if (this.e != null) {
            return this.e.b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new au();
            }
            this.d.a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        au auVar;
        Drawable background = this.a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            if (this.e != null) {
                auVar = this.e;
            } else if (this.d != null) {
                auVar = this.d;
            } else {
                return;
            }
            l.a(background, auVar, this.a.getDrawableState());
        }
    }
}
