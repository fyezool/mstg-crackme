package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.widget.g;
import android.support.v7.a.a;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.ImageView;

public class p {
    private final ImageView a;
    private au b;
    private au c;
    private au d;

    public p(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new au();
        }
        au auVar = this.d;
        auVar.a();
        ColorStateList a2 = g.a(this.a);
        if (a2 != null) {
            auVar.d = true;
            auVar.a = a2;
        }
        PorterDuff.Mode b2 = g.b(this.a);
        if (b2 != null) {
            auVar.c = true;
            auVar.b = b2;
        }
        if (!auVar.d && !auVar.c) {
            return false;
        }
        l.a(drawable, auVar, this.a.getDrawableState());
        return true;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b2 = b.b(this.a.getContext(), i);
            if (b2 != null) {
                af.a(b2);
            }
            this.a.setImageDrawable(b2);
        } else {
            this.a.setImageDrawable((Drawable) null);
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new au();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new au();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        aw a2 = aw.a(this.a.getContext(), attributeSet, a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (!(drawable != null || (g = a2.g(a.j.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = b.b(this.a.getContext(), g)) == null)) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                af.a(drawable);
            }
            if (a2.g(a.j.AppCompatImageView_tint)) {
                g.a(this.a, a2.e(a.j.AppCompatImageView_tint));
            }
            if (a2.g(a.j.AppCompatImageView_tintMode)) {
                g.a(this.a, af.a(a2.a(a.j.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        if (this.c != null) {
            return this.c.a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        if (this.c != null) {
            return this.c.b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        au auVar;
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            af.a(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            if (this.c != null) {
                auVar = this.c;
            } else if (this.b != null) {
                auVar = this.b;
            } else {
                return;
            }
            l.a(drawable, auVar, this.a.getDrawableState());
        }
    }
}
