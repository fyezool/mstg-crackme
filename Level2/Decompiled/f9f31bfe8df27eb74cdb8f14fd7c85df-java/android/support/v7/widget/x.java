package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

class x extends t {
    private final SeekBar a;
    private Drawable b;
    private ColorStateList c = null;
    private PorterDuff.Mode d = null;
    private boolean e = false;
    private boolean f = false;

    x(SeekBar seekBar) {
        super(seekBar);
        this.a = seekBar;
    }

    private void d() {
        if (this.b == null) {
            return;
        }
        if (this.e || this.f) {
            this.b = a.f(this.b.mutate());
            if (this.e) {
                a.a(this.b, this.c);
            }
            if (this.f) {
                a.a(this.b, this.d);
            }
            if (this.b.isStateful()) {
                this.b.setState(this.a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.b != null) {
            int max = this.a.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.b.getIntrinsicWidth();
                int intrinsicHeight = this.b.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.b.setBounds(-i2, -i, i2, i);
                float width = ((float) ((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.a.getPaddingLeft(), (float) (this.a.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback((Drawable.Callback) null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.a);
            a.b(drawable, p.b(this.a));
            if (drawable.isStateful()) {
                drawable.setState(this.a.getDrawableState());
            }
            d();
        }
        this.a.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        aw a2 = aw.a(this.a.getContext(), attributeSet, a.j.AppCompatSeekBar, i, 0);
        Drawable b2 = a2.b(a.j.AppCompatSeekBar_android_thumb);
        if (b2 != null) {
            this.a.setThumb(b2);
        }
        a(a2.a(a.j.AppCompatSeekBar_tickMark));
        if (a2.g(a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = af.a(a2.a(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (a2.g(a.j.AppCompatSeekBar_tickMarkTint)) {
            this.c = a2.e(a.j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        a2.a();
        d();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.a.getDrawableState())) {
            this.a.invalidateDrawable(drawable);
        }
    }
}
