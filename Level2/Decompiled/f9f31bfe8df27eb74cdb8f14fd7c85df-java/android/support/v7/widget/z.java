package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.a.a.b;
import android.support.v7.a.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class z {
    final TextView a;
    private au b;
    private au c;
    private au d;
    private au e;
    private final ac f;
    private int g = 0;
    private Typeface h;
    private boolean i;

    z(TextView textView) {
        this.a = textView;
        this.f = new ac(this.a);
    }

    protected static au a(Context context, l lVar, int i2) {
        ColorStateList b2 = lVar.b(context, i2);
        if (b2 == null) {
            return null;
        }
        au auVar = new au();
        auVar.d = true;
        auVar.a = b2;
        return auVar;
    }

    static z a(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new aa(textView) : new z(textView);
    }

    private void a(Context context, aw awVar) {
        String d2;
        Typeface typeface;
        this.g = awVar.a(a.j.TextAppearance_android_textStyle, this.g);
        boolean z = true;
        if (awVar.g(a.j.TextAppearance_android_fontFamily) || awVar.g(a.j.TextAppearance_fontFamily)) {
            this.h = null;
            int i2 = awVar.g(a.j.TextAppearance_fontFamily) ? a.j.TextAppearance_fontFamily : a.j.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.a);
                try {
                    this.h = awVar.a(i2, this.g, (b.a) new b.a() {
                        public void a(int i) {
                        }

                        public void a(Typeface typeface) {
                            z.this.a((WeakReference<TextView>) weakReference, typeface);
                        }
                    });
                    if (this.h != null) {
                        z = false;
                    }
                    this.i = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.h == null && (d2 = awVar.d(i2)) != null) {
                this.h = Typeface.create(d2, this.g);
            }
        } else if (awVar.g(a.j.TextAppearance_android_typeface)) {
            this.i = false;
            switch (awVar.a(a.j.TextAppearance_android_typeface, 1)) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    return;
            }
            this.h = typeface;
        }
    }

    /* access modifiers changed from: private */
    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.i) {
            this.h = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.g);
            }
        }
    }

    private void b(int i2, float f2) {
        this.f.a(i2, f2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f.a(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2) {
        if (!android.support.v4.widget.b.a && !c()) {
            b(i2, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, int i5) {
        this.f.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, int i2) {
        ColorStateList e2;
        aw a2 = aw.a(context, i2, a.j.TextAppearance);
        if (a2.g(a.j.TextAppearance_textAllCaps)) {
            a(a2.a(a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a2.g(a.j.TextAppearance_android_textColor) && (e2 = a2.e(a.j.TextAppearance_android_textColor)) != null) {
            this.a.setTextColor(e2);
        }
        a(context, a2);
        a2.a();
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Drawable drawable, au auVar) {
        if (drawable != null && auVar != null) {
            l.a(drawable, auVar, this.a.getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        Context context = this.a.getContext();
        l a2 = l.a();
        aw a3 = aw.a(context, attributeSet, a.j.AppCompatTextHelper, i2, 0);
        int g2 = a3.g(a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, a2, a3.g(a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(a.j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a2, a3.g(a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(a.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a2, a3.g(a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a2, a3.g(a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a3.a();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        ColorStateList colorStateList3 = null;
        if (g2 != -1) {
            aw a4 = aw.a(context, g2, a.j.TextAppearance);
            if (z3 || !a4.g(a.j.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z = a4.a(a.j.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            a(context, a4);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList e2 = a4.g(a.j.TextAppearance_android_textColor) ? a4.e(a.j.TextAppearance_android_textColor) : null;
                colorStateList = a4.g(a.j.TextAppearance_android_textColorHint) ? a4.e(a.j.TextAppearance_android_textColorHint) : null;
                if (a4.g(a.j.TextAppearance_android_textColorLink)) {
                    colorStateList3 = a4.e(a.j.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList4 = e2;
                colorStateList2 = colorStateList3;
                colorStateList3 = colorStateList4;
            } else {
                colorStateList2 = null;
                colorStateList = null;
            }
            a4.a();
        } else {
            colorStateList2 = null;
            colorStateList = null;
            z2 = false;
            z = false;
        }
        aw a5 = aw.a(context, attributeSet, a.j.TextAppearance, i2, 0);
        if (z3 || !a5.g(a.j.TextAppearance_textAllCaps)) {
            z4 = z2;
        } else {
            z = a5.a(a.j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a5.g(a.j.TextAppearance_android_textColor)) {
                colorStateList3 = a5.e(a.j.TextAppearance_android_textColor);
            }
            if (a5.g(a.j.TextAppearance_android_textColorHint)) {
                colorStateList = a5.e(a.j.TextAppearance_android_textColorHint);
            }
            if (a5.g(a.j.TextAppearance_android_textColorLink)) {
                colorStateList2 = a5.e(a.j.TextAppearance_android_textColorLink);
            }
        }
        a(context, a5);
        a5.a();
        if (colorStateList3 != null) {
            this.a.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.a.setLinkTextColor(colorStateList2);
        }
        if (!z3 && z4) {
            a(z);
        }
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
        this.f.a(attributeSet, i2);
        if (android.support.v4.widget.b.a && this.f.a() != 0) {
            int[] e3 = this.f.e();
            if (e3.length <= 0) {
                return;
            }
            if (((float) this.a.getAutoSizeStepGranularity()) != -1.0f) {
                this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f.c(), this.f.d(), this.f.b(), 0);
            } else {
                this.a.setAutoSizeTextTypeUniformWithPresetSizes(e3, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, int i2, int i3, int i4, int i5) {
        if (!android.support.v4.widget.b.a) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr, int i2) {
        this.f.a(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f.f();
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f.g();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f.a();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f.b();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f.c();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f.d();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.f.e();
    }
}
