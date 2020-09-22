package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.TextView;

class aa extends z {
    private au b;
    private au c;

    aa(TextView textView) {
        super(textView);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
        if (this.b != null || this.c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.b);
            a(compoundDrawablesRelative[2], this.c);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.a.getContext();
        l a = l.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTextHelper_android_drawableStart)) {
            this.b = a(context, a, obtainStyledAttributes.getResourceId(a.j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTextHelper_android_drawableEnd)) {
            this.c = a(context, a, obtainStyledAttributes.getResourceId(a.j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
