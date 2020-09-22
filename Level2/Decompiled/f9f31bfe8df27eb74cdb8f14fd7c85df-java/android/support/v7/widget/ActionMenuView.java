package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends aj implements h.b, p {
    h.a a;
    e b;
    private h c;
    private Context d;
    private int e;
    private boolean f;
    private d g;
    private o.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public interface a {
        boolean c();

        boolean d();
    }

    private static class b implements o.a {
        b() {
        }

        public void a(h hVar, boolean z) {
        }

        public boolean a(h hVar) {
            return false;
        }
    }

    public static class c extends aj.a {
        @ViewDebug.ExportedProperty
        public boolean a;
        @ViewDebug.ExportedProperty
        public int b;
        @ViewDebug.ExportedProperty
        public int c;
        @ViewDebug.ExportedProperty
        public boolean d;
        @ViewDebug.ExportedProperty
        public boolean e;
        boolean f;

        public c(int i, int i2) {
            super(i, i2);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class d implements h.a {
        d() {
        }

        public void a(h hVar) {
            if (ActionMenuView.this.a != null) {
                ActionMenuView.this.a.a(hVar);
            }
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return ActionMenuView.this.b != null && ActionMenuView.this.b.a(menuItem);
        }
    }

    public interface e {
        boolean a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f2);
        this.l = (int) (f2 * 4.0f);
        this.d = context;
        this.e = 0;
    }

    static int a(View view, int i2, int i3, int i4, int i5) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.b();
        int i6 = 2;
        if (i3 <= 0 || (z2 && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z2 || i7 >= 2) {
                i6 = i7;
            }
        }
        if (cVar.a || !z2) {
            z = false;
        }
        cVar.d = z;
        cVar.b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x024f A[LOOP:5: B:136:0x024f->B:141:0x0272, LOOP_START, PHI: r3 r32 
      PHI: (r3v5 int) = (r3v4 int), (r3v6 int) binds: [B:135:0x024d, B:141:0x0272] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r32v1 int) = (r32v0 int), (r32v2 int) binds: [B:135:0x024d, B:141:0x0272] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x027e  */
    private void c(int i2, int i3) {
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        int i10;
        int i11;
        boolean z4;
        int i12;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i3, paddingTop, -2);
        int i13 = size - paddingLeft;
        int i14 = i13 / this.k;
        int i15 = i13 % this.k;
        if (i14 == 0) {
            setMeasuredDimension(i13, 0);
            return;
        }
        int i16 = this.k + (i15 / i14);
        int childCount = getChildCount();
        int i17 = i14;
        int i18 = 0;
        int i19 = 0;
        boolean z5 = false;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        long j2 = 0;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            int i23 = size2;
            if (childAt.getVisibility() == 8) {
                i10 = i13;
            } else {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i24 = i20 + 1;
                if (z6) {
                    i11 = i24;
                    i10 = i13;
                    z4 = false;
                    childAt.setPadding(this.l, 0, this.l, 0);
                } else {
                    i10 = i13;
                    i11 = i24;
                    z4 = false;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f = z4;
                cVar.c = z4 ? 1 : 0;
                cVar.b = z4;
                cVar.d = z4;
                cVar.leftMargin = z4;
                cVar.rightMargin = z4;
                cVar.e = z6 && ((ActionMenuItemView) childAt).b();
                int a2 = a(childAt, i16, cVar.a ? 1 : i17, childMeasureSpec, paddingTop);
                int max = Math.max(i21, a2);
                if (cVar.d) {
                    i22++;
                }
                if (cVar.a) {
                    z5 = true;
                }
                i17 -= a2;
                i19 = Math.max(i19, childAt.getMeasuredHeight());
                if (a2 == 1) {
                    i12 = max;
                    j2 |= (long) (1 << i18);
                } else {
                    i12 = max;
                }
                i20 = i11;
                i21 = i12;
            }
            i18++;
            size2 = i23;
            i13 = i10;
        }
        int i25 = i13;
        int i26 = size2;
        boolean z7 = z5 && i20 == 2;
        boolean z8 = false;
        while (true) {
            if (i22 <= 0 || i17 <= 0) {
                z = z8;
            } else {
                int i27 = 0;
                int i28 = 0;
                int i29 = Integer.MAX_VALUE;
                long j3 = 0;
                while (i27 < childCount) {
                    c cVar2 = (c) getChildAt(i27).getLayoutParams();
                    boolean z9 = z8;
                    if (cVar2.d) {
                        if (cVar2.b < i29) {
                            j3 = 1 << i27;
                            i29 = cVar2.b;
                            i28 = 1;
                        } else if (cVar2.b == i29) {
                            j3 |= 1 << i27;
                            i28++;
                        }
                    }
                    i27++;
                    z8 = z9;
                }
                z = z8;
                j2 |= j3;
                if (i28 > i17) {
                    break;
                }
                int i30 = i29 + 1;
                int i31 = 0;
                while (i31 < childCount) {
                    View childAt2 = getChildAt(i31);
                    c cVar3 = (c) childAt2.getLayoutParams();
                    int i32 = i19;
                    int i33 = childMeasureSpec;
                    int i34 = childCount;
                    long j4 = (long) (1 << i31);
                    if ((j3 & j4) != 0) {
                        if (!z7 || !cVar3.e) {
                            z3 = true;
                        } else {
                            z3 = true;
                            if (i17 == 1) {
                                childAt2.setPadding(this.l + i16, 0, this.l, 0);
                            }
                        }
                        cVar3.b += z3 ? 1 : 0;
                        cVar3.f = z3;
                        i17--;
                    } else if (cVar3.b == i30) {
                        j2 |= j4;
                    }
                    i31++;
                    i19 = i32;
                    childMeasureSpec = i33;
                    childCount = i34;
                }
                z8 = true;
            }
        }
        z = z8;
        int i35 = childMeasureSpec;
        int i36 = childCount;
        int i37 = i19;
        if (!z5) {
            i4 = 1;
            if (i20 == 1) {
                z2 = true;
                if (i17 > 0 || j2 != 0 || (i17 >= i20 - i4 && !z2 && i21 <= i4)) {
                    i6 = i36;
                    i5 = 0;
                } else {
                    float bitCount = (float) Long.bitCount(j2);
                    if (!z2) {
                        if ((j2 & 1) != 0) {
                            i5 = 0;
                            if (!((c) getChildAt(0).getLayoutParams()).e) {
                                bitCount -= 0.5f;
                            }
                        } else {
                            i5 = 0;
                        }
                        int i38 = i36 - 1;
                        if ((j2 & ((long) (1 << i38))) != 0 && !((c) getChildAt(i38).getLayoutParams()).e) {
                            bitCount -= 0.5f;
                        }
                    } else {
                        i5 = 0;
                    }
                    int i39 = bitCount > 0.0f ? (int) (((float) (i17 * i16)) / bitCount) : 0;
                    boolean z10 = z;
                    i6 = i36;
                    for (int i40 = 0; i40 < i6; i40++) {
                        if ((j2 & ((long) (1 << i40))) != 0) {
                            View childAt3 = getChildAt(i40);
                            c cVar4 = (c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                cVar4.c = i39;
                                cVar4.f = true;
                                if (i40 == 0 && !cVar4.e) {
                                    cVar4.leftMargin = (-i39) / 2;
                                }
                            } else if (cVar4.a) {
                                cVar4.c = i39;
                                cVar4.f = true;
                                cVar4.rightMargin = (-i39) / 2;
                            } else {
                                if (i40 != 0) {
                                    cVar4.leftMargin = i39 / 2;
                                }
                                if (i40 != i6 - 1) {
                                    cVar4.rightMargin = i39 / 2;
                                }
                            }
                            z10 = true;
                        }
                    }
                    z = z10;
                }
                if (z) {
                    while (i5 < i6) {
                        View childAt4 = getChildAt(i5);
                        c cVar5 = (c) childAt4.getLayoutParams();
                        if (!cVar5.f) {
                            i9 = i35;
                        } else {
                            i9 = i35;
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.b * i16) + cVar5.c, 1073741824), i9);
                        }
                        i5++;
                        i35 = i9;
                    }
                }
                if (mode == 1073741824) {
                    i7 = i25;
                    i8 = i37;
                } else {
                    i8 = i26;
                    i7 = i25;
                }
                setMeasuredDimension(i7, i8);
            }
        } else {
            i4 = 1;
        }
        z2 = false;
        if (i17 > 0 && j2 != 0) {
        }
        i6 = i36;
        i5 = 0;
        if (z) {
        }
        if (mode == 1073741824) {
        }
        setMeasuredDimension(i7, i8);
    }

    /* renamed from: a */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return j();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.h <= 0) {
            cVar.h = 16;
        }
        return cVar;
    }

    public void a(h hVar) {
        this.c = hVar;
    }

    public void a(o.a aVar, h.a aVar2) {
        this.h = aVar;
        this.a = aVar2;
    }

    public boolean a() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).d();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).c();
    }

    public boolean a(j jVar) {
        return this.c.a((MenuItem) jVar, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public c j() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    public c c() {
        c b2 = j();
        b2.a = true;
        return b2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public h d() {
        return this.c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        return this.g != null && this.g.d();
    }

    public boolean f() {
        return this.g != null && this.g.e();
    }

    public boolean g() {
        return this.g != null && this.g.h();
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new h(context);
            this.c.a((h.a) new d());
            this.g = new d(context);
            this.g.c(true);
            this.g.a(this.h != null ? this.h : new b());
            this.c.a((o) this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.c();
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        return this.g != null && this.g.i();
    }

    public void i() {
        if (this.g != null) {
            this.g.f();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.g != null) {
            this.g.b(false);
            if (this.g.h()) {
                this.g.e();
                this.g.d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (!this.i) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = i4 - i2;
        int paddingRight = (i11 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = bc.a(this);
        int i12 = paddingRight;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i15)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i8 = getPaddingLeft() + cVar.leftMargin;
                        i9 = i8 + measuredWidth;
                    } else {
                        i9 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i8 = i9 - measuredWidth;
                    }
                    int i16 = i10 - (measuredHeight / 2);
                    childAt.layout(i8, i16, i9, measuredHeight + i16);
                    i12 -= measuredWidth;
                    i13 = 1;
                } else {
                    i12 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    boolean a3 = a(i15);
                    i14++;
                }
            }
        }
        if (childCount == 1 && i13 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = (i11 / 2) - (measuredWidth2 / 2);
            int i18 = i10 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth2 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i14 - (i13 ^ 1);
        if (i19 > 0) {
            i6 = i12 / i19;
            i7 = 0;
        } else {
            i7 = 0;
            i6 = 0;
        }
        int max = Math.max(i7, i6);
        if (a2) {
            int width = getWidth() - getPaddingRight();
            while (i7 < childCount) {
                View childAt3 = getChildAt(i7);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.a) {
                    int i20 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i21 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i20 - measuredWidth3, i21, i20, measuredHeight3 + i21);
                    width = i20 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
                i7++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i7 < childCount) {
            View childAt4 = getChildAt(i7);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.a) {
                int i22 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i10 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft = i22 + measuredWidth4 + cVar3.rightMargin + max;
            }
            i7++;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z = this.i;
        this.i = View.MeasureSpec.getMode(i2) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (!(!this.i || this.c == null || size == this.j)) {
            this.j = size;
            this.c.b(true);
        }
        int childCount = getChildCount();
        if (!this.i || childCount <= 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        c(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.d(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.b = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    public void setPopupTheme(int i2) {
        if (this.e != i2) {
            this.e = i2;
            if (i2 == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(d dVar) {
        this.g = dVar;
        this.g.a(this);
    }
}
