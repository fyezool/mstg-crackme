package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.c;
import android.support.v7.a.a;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class k {
    private final CompoundButton a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    k(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = android.support.v4.widget.c.a(r2.a);
     */
    public int a(int i) {
        Drawable a2;
        return (Build.VERSION.SDK_INT >= 17 || a2 == null) ? i : i + a2.getIntrinsicWidth();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, a.j.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(a.j.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(a.j.CompoundButton_android_button, 0)) != 0) {
                this.a.setButtonDrawable(b.b(this.a.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(a.j.CompoundButton_buttonTint)) {
                c.a(this.a, obtainStyledAttributes.getColorStateList(a.j.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(a.j.CompoundButton_buttonTintMode)) {
                c.a(this.a, af.a(obtainStyledAttributes.getInt(a.j.CompoundButton_buttonTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Drawable a2 = c.a(this.a);
        if (a2 == null) {
            return;
        }
        if (this.d || this.e) {
            Drawable mutate = android.support.v4.b.a.a.f(a2).mutate();
            if (this.d) {
                android.support.v4.b.a.a.a(mutate, this.b);
            }
            if (this.e) {
                android.support.v4.b.a.a.a(mutate, this.c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.a.getDrawableState());
            }
            this.a.setButtonDrawable(mutate);
        }
    }
}
