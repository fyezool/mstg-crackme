package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.g.d;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class aj extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public static class a extends ViewGroup.MarginLayoutParams {
        public float g;
        public int h;

        public a(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }

    public aj(Context context) {
        this(context, (AttributeSet) null);
    }

    public aj(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aj(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        aw a2 = aw.a(context, attributeSet, a.j.LinearLayoutCompat, i2, 0);
        int a3 = a2.a(a.j.LinearLayoutCompat_android_orientation, -1);
        if (a3 >= 0) {
            setOrientation(a3);
        }
        int a4 = a2.a(a.j.LinearLayoutCompat_android_gravity, -1);
        if (a4 >= 0) {
            setGravity(a4);
        }
        boolean a5 = a2.a(a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a5) {
            setBaselineAligned(a5);
        }
        this.g = a2.a(a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a2.a(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a2.a(a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a2.a(a.j.LinearLayoutCompat_divider));
        this.n = a2.a(a.j.LinearLayoutCompat_showDividers, 0);
        this.o = a2.e(a.j.LinearLayoutCompat_dividerPadding, 0);
        a2.a();
    }

    private void a(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private void c(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View b2 = b(i4);
            if (b2.getVisibility() != 8) {
                a aVar = (a) b2.getLayoutParams();
                if (aVar.width == -1) {
                    int i5 = aVar.height;
                    aVar.height = b2.getMeasuredHeight();
                    measureChildWithMargins(b2, makeMeasureSpec, 0, i3, 0);
                    aVar.height = i5;
                }
            }
        }
    }

    private void d(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View b2 = b(i4);
            if (b2.getVisibility() != 8) {
                a aVar = (a) b2.getLayoutParams();
                if (aVar.height == -1) {
                    int i5 = aVar.width;
                    aVar.width = b2.getMeasuredWidth();
                    measureChildWithMargins(b2, i3, 0, makeMeasureSpec, 0);
                    aVar.width = i5;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int a(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int a(View view, int i2) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02dd, code lost:
        if (r15 > 0) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02e8, code lost:
        if (r15 < 0) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ea, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02eb, code lost:
        r13.measure(r9, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
        r1 = android.view.View.combineMeasuredStates(r1, r13.getMeasuredState() & -256);
        r9 = r34;
        r10 = r35;
     */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0338  */
    public void a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        float f2;
        int i10;
        boolean z;
        int i11;
        int max;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        View view;
        int i19;
        boolean z2;
        int i20;
        int i21;
        int i22 = i2;
        int i23 = i3;
        this.f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i24 = this.b;
        boolean z3 = this.h;
        float f3 = 0.0f;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i31 = 8;
            int i32 = i28;
            if (i30 < virtualChildCount) {
                View b2 = b(i30);
                if (b2 == null) {
                    this.f += d(i30);
                    i12 = virtualChildCount;
                    i13 = mode2;
                    i28 = i32;
                } else {
                    int i33 = i25;
                    if (b2.getVisibility() == 8) {
                        i30 += a(b2, i30);
                        i12 = virtualChildCount;
                        i13 = mode2;
                        i28 = i32;
                        i25 = i33;
                    } else {
                        if (c(i30)) {
                            this.f += this.m;
                        }
                        a aVar = (a) b2.getLayoutParams();
                        float f4 = f3 + aVar.g;
                        if (mode2 == 1073741824 && aVar.height == 0 && aVar.g > 0.0f) {
                            int i34 = this.f;
                            this.f = Math.max(i34, aVar.topMargin + i34 + aVar.bottomMargin);
                            i19 = i27;
                            view = b2;
                            i14 = i29;
                            i12 = virtualChildCount;
                            i13 = mode2;
                            i16 = i32;
                            i18 = i33;
                            i15 = i26;
                            z4 = true;
                            i17 = i30;
                        } else {
                            int i35 = i26;
                            if (aVar.height != 0 || aVar.g <= 0.0f) {
                                i21 = Integer.MIN_VALUE;
                            } else {
                                aVar.height = -2;
                                i21 = 0;
                            }
                            i18 = i33;
                            i15 = i35;
                            int i36 = i27;
                            View view2 = b2;
                            i12 = virtualChildCount;
                            i13 = mode2;
                            i16 = i32;
                            i14 = i29;
                            i17 = i30;
                            a(b2, i30, i2, 0, i3, f4 == 0.0f ? this.f : 0);
                            int i37 = i21;
                            if (i37 != Integer.MIN_VALUE) {
                                aVar.height = i37;
                            }
                            int measuredHeight = view2.getMeasuredHeight();
                            int i38 = this.f;
                            view = view2;
                            this.f = Math.max(i38, i38 + measuredHeight + aVar.topMargin + aVar.bottomMargin + b(view));
                            i19 = z3 ? Math.max(measuredHeight, i36) : i36;
                        }
                        if (i24 >= 0 && i24 == i17 + 1) {
                            this.c = this.f;
                        }
                        if (i17 >= i24 || aVar.g <= 0.0f) {
                            if (mode == 1073741824 || aVar.width != -1) {
                                z2 = false;
                            } else {
                                z2 = true;
                                z6 = true;
                            }
                            int i39 = aVar.leftMargin + aVar.rightMargin;
                            int measuredWidth = view.getMeasuredWidth() + i39;
                            int max2 = Math.max(i15, measuredWidth);
                            int combineMeasuredStates = View.combineMeasuredStates(i18, view.getMeasuredState());
                            boolean z7 = z5 && aVar.width == -1;
                            if (aVar.g > 0.0f) {
                                if (!z2) {
                                    i39 = measuredWidth;
                                }
                                i16 = Math.max(i16, i39);
                                i20 = i14;
                            } else {
                                if (!z2) {
                                    i39 = measuredWidth;
                                }
                                i20 = Math.max(i14, i39);
                            }
                            i27 = i19;
                            z5 = z7;
                            i28 = i16;
                            f3 = f4;
                            int i40 = max2;
                            i29 = i20;
                            i25 = combineMeasuredStates;
                            i30 = a(view, i17) + i17;
                            i26 = i40;
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                }
                i30++;
                mode2 = i13;
                virtualChildCount = i12;
                int i41 = i2;
                int i42 = i3;
            } else {
                int i43 = i25;
                int i44 = i27;
                int i45 = i29;
                int i46 = virtualChildCount;
                int i47 = mode2;
                int i48 = i32;
                int i49 = i26;
                if (this.f > 0) {
                    i4 = i46;
                    if (c(i4)) {
                        this.f += this.m;
                    }
                } else {
                    i4 = i46;
                }
                if (z3) {
                    i5 = i47;
                    if (i5 == Integer.MIN_VALUE || i5 == 0) {
                        this.f = 0;
                        int i50 = 0;
                        while (i50 < i4) {
                            View b3 = b(i50);
                            if (b3 == null) {
                                max = this.f + d(i50);
                            } else if (b3.getVisibility() == i31) {
                                i50 += a(b3, i50);
                                i50++;
                                i31 = 8;
                            } else {
                                a aVar2 = (a) b3.getLayoutParams();
                                int i51 = this.f;
                                max = Math.max(i51, i51 + i44 + aVar2.topMargin + aVar2.bottomMargin + b(b3));
                            }
                            this.f = max;
                            i50++;
                            i31 = 8;
                        }
                    }
                } else {
                    i5 = i47;
                }
                this.f += getPaddingTop() + getPaddingBottom();
                int i52 = i44;
                int i53 = i3;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumHeight()), i53, 0);
                int i54 = (16777215 & resolveSizeAndState) - this.f;
                if (z4 || (i54 != 0 && f3 > 0.0f)) {
                    if (this.g > 0.0f) {
                        f3 = this.g;
                    }
                    this.f = 0;
                    float f5 = f3;
                    int i55 = 0;
                    int i56 = i43;
                    int i57 = i45;
                    i7 = i56;
                    while (i55 < i4) {
                        View b4 = b(i55);
                        if (b4.getVisibility() == 8) {
                            i9 = i5;
                            f2 = f5;
                            int i58 = i2;
                        } else {
                            a aVar3 = (a) b4.getLayoutParams();
                            float f6 = aVar3.g;
                            if (f6 > 0.0f) {
                                int i59 = (int) ((((float) i54) * f6) / f5);
                                int i60 = i54 - i59;
                                float f7 = f5 - f6;
                                int childMeasureSpec = getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + aVar3.leftMargin + aVar3.rightMargin, aVar3.width);
                                if (aVar3.height == 0) {
                                    i11 = 1073741824;
                                    if (i5 == 1073741824) {
                                    }
                                } else {
                                    i11 = 1073741824;
                                }
                                i59 = b4.getMeasuredHeight() + i59;
                            } else {
                                f2 = f5;
                                int i61 = i2;
                            }
                            int i62 = i7;
                            int i63 = aVar3.leftMargin + aVar3.rightMargin;
                            int measuredWidth2 = b4.getMeasuredWidth() + i63;
                            i49 = Math.max(i49, measuredWidth2);
                            int i64 = measuredWidth2;
                            if (mode != 1073741824) {
                                i9 = i5;
                                i10 = -1;
                                if (aVar3.width == -1) {
                                    z = true;
                                    if (!z) {
                                        i63 = i64;
                                    }
                                    int max3 = Math.max(i57, i63);
                                    boolean z8 = z5 && aVar3.width == i10;
                                    int i65 = this.f;
                                    this.f = Math.max(i65, i65 + b4.getMeasuredHeight() + aVar3.topMargin + aVar3.bottomMargin + b(b4));
                                    z5 = z8;
                                    i57 = max3;
                                    i7 = i62;
                                }
                            } else {
                                i9 = i5;
                                i10 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max32 = Math.max(i57, i63);
                            if (z5 || aVar3.width == i10) {
                            }
                            int i652 = this.f;
                            this.f = Math.max(i652, i652 + b4.getMeasuredHeight() + aVar3.topMargin + aVar3.bottomMargin + b(b4));
                            z5 = z8;
                            i57 = max32;
                            i7 = i62;
                        }
                        i55++;
                        f5 = f2;
                        i5 = i9;
                    }
                    i6 = i2;
                    this.f += getPaddingTop() + getPaddingBottom();
                    i8 = i57;
                } else {
                    i8 = Math.max(i45, i48);
                    if (z3 && i5 != 1073741824) {
                        for (int i66 = 0; i66 < i4; i66++) {
                            View b5 = b(i66);
                            if (!(b5 == null || b5.getVisibility() == 8 || ((a) b5.getLayoutParams()).g <= 0.0f)) {
                                b5.measure(View.MeasureSpec.makeMeasureSpec(b5.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i52, 1073741824));
                            }
                        }
                    }
                    i7 = i43;
                    i6 = i2;
                }
                if (z5 || mode == 1073741824) {
                    i8 = i49;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i8 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i6, i7), resolveSizeAndState);
                if (z6) {
                    c(i4, i53);
                    return;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i4 - i2;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.e & a.j.AppCompatTheme_windowActionModeOverlay;
        int i10 = this.e & 8388615;
        int paddingTop = i9 != 16 ? i9 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - this.f : (((i5 - i3) - this.f) / 2) + getPaddingTop();
        int i11 = 0;
        while (i11 < virtualChildCount) {
            View b2 = b(i11);
            if (b2 == null) {
                paddingTop += d(i11);
            } else if (b2.getVisibility() != 8) {
                int measuredWidth = b2.getMeasuredWidth();
                int measuredHeight = b2.getMeasuredHeight();
                a aVar = (a) b2.getLayoutParams();
                int i12 = aVar.h;
                if (i12 < 0) {
                    i12 = i10;
                }
                int a2 = d.a(i12, p.b(this)) & 7;
                if (a2 == 1) {
                    i6 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + aVar.leftMargin;
                    i7 = i6 - aVar.rightMargin;
                } else if (a2 != 5) {
                    i7 = aVar.leftMargin + paddingLeft;
                } else {
                    i6 = paddingRight - measuredWidth;
                    i7 = i6 - aVar.rightMargin;
                }
                int i13 = i7;
                if (c(i11)) {
                    paddingTop += this.m;
                }
                int i14 = paddingTop + aVar.topMargin;
                a(b2, i13, i14 + a(b2), measuredWidth, measuredHeight);
                i11 += a(b2, i11);
                paddingTop = i14 + measuredHeight + aVar.bottomMargin + b(b2);
            }
            i11++;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View b2 = b(i2);
            if (!(b2 == null || b2.getVisibility() == 8 || !c(i2))) {
                a(canvas, (b2.getTop() - ((a) b2.getLayoutParams()).topMargin) - this.m);
            }
        }
        if (c(virtualChildCount)) {
            View b3 = b(virtualChildCount - 1);
            a(canvas, b3 == null ? (getHeight() - getPaddingBottom()) - this.m : b3.getBottom() + ((a) b3.getLayoutParams()).bottomMargin);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, int i2) {
        this.k.setBounds(getPaddingLeft() + this.o, i2, (getWidth() - getPaddingRight()) - this.o, this.m + i2);
        this.k.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        return 0;
    }

    /* renamed from: b */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public View b(int i2) {
        return getChildAt(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03b0, code lost:
        if (r8 > 0) goto L_0x03be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03bb, code lost:
        if (r8 < 0) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03bd, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03be, code lost:
        r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r8, r4), r2);
        r9 = android.view.View.combineMeasuredStates(r9, r14.getMeasuredState() & -16777216);
        r2 = r40;
        r4 = r41;
     */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d7  */
    public void b(int i2, int i3) {
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        float f2;
        int i10;
        boolean z;
        int baseline;
        int i11;
        int i12;
        boolean z2;
        boolean z3;
        int i13;
        View view;
        int i14;
        boolean z4;
        int measuredHeight;
        int baseline2;
        int i15;
        int max;
        int max2;
        int i16 = i2;
        int i17 = i3;
        this.f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr2 = this.i;
        int[] iArr3 = this.j;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.a;
        boolean z6 = this.h;
        int i18 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f3 = 0.0f;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        boolean z8 = false;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            if (i19 >= virtualChildCount) {
                break;
            }
            View b2 = b(i19);
            if (b2 == null) {
                this.f += d(i19);
            } else if (b2.getVisibility() == 8) {
                i19 += a(b2, i19);
            } else {
                if (c(i19)) {
                    this.f += this.l;
                }
                a aVar = (a) b2.getLayoutParams();
                float f4 = f3 + aVar.g;
                if (mode == i18 && aVar.width == 0 && aVar.g > 0.0f) {
                    if (z7) {
                        max2 = this.f + aVar.leftMargin + aVar.rightMargin;
                    } else {
                        int i25 = this.f;
                        max2 = Math.max(i25, aVar.leftMargin + i25 + aVar.rightMargin);
                    }
                    this.f = max2;
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        b2.measure(makeMeasureSpec, makeMeasureSpec);
                        i13 = i19;
                        z3 = z6;
                        z2 = z5;
                        view = b2;
                    } else {
                        i13 = i19;
                        z3 = z6;
                        z2 = z5;
                        view = b2;
                        i14 = 1073741824;
                        z8 = true;
                        if (mode2 == i14 || aVar.height != -1) {
                            z4 = false;
                        } else {
                            z4 = true;
                            z10 = true;
                        }
                        int i26 = aVar.topMargin + aVar.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i26;
                        int combineMeasuredStates = View.combineMeasuredStates(i24, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            int i27 = ((((aVar.h >= 0 ? this.e : aVar.h) & a.j.AppCompatTheme_windowActionModeOverlay) >> 4) & -2) >> 1;
                            iArr2[i27] = Math.max(iArr2[i27], baseline2);
                            iArr[i27] = Math.max(iArr[i27], measuredHeight - baseline2);
                        }
                        int max3 = Math.max(i21, measuredHeight);
                        boolean z11 = z9 && aVar.height == -1;
                        if (aVar.g <= 0.0f) {
                            if (!z4) {
                                i26 = measuredHeight;
                            }
                            i23 = Math.max(i23, i26);
                        } else {
                            int i28 = i23;
                            if (z4) {
                                measuredHeight = i26;
                            }
                            i22 = Math.max(i22, measuredHeight);
                            i23 = i28;
                        }
                        int i29 = i13;
                        i21 = max3;
                        i24 = combineMeasuredStates;
                        z9 = z11;
                        i19 = a(view, i29) + i29;
                        f3 = f4;
                        i19++;
                        iArr3 = iArr;
                        z6 = z3;
                        z5 = z2;
                        i18 = 1073741824;
                        int i30 = i3;
                    }
                } else {
                    if (aVar.width != 0 || aVar.g <= 0.0f) {
                        i15 = Integer.MIN_VALUE;
                    } else {
                        aVar.width = -2;
                        i15 = 0;
                    }
                    i13 = i19;
                    z3 = z6;
                    z2 = z5;
                    View view2 = b2;
                    a(b2, i13, i2, f4 == 0.0f ? this.f : 0, i3, 0);
                    int i31 = i15;
                    if (i31 != Integer.MIN_VALUE) {
                        aVar.width = i31;
                    }
                    int measuredWidth = view2.getMeasuredWidth();
                    if (z7) {
                        view = view2;
                        max = this.f + aVar.leftMargin + measuredWidth + aVar.rightMargin + b(view);
                    } else {
                        view = view2;
                        int i32 = this.f;
                        max = Math.max(i32, i32 + measuredWidth + aVar.leftMargin + aVar.rightMargin + b(view));
                    }
                    this.f = max;
                    if (z3) {
                        i20 = Math.max(measuredWidth, i20);
                    }
                }
                i14 = 1073741824;
                if (mode2 == i14 || aVar.height != -1) {
                }
                int i262 = aVar.topMargin + aVar.bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i262;
                int combineMeasuredStates2 = View.combineMeasuredStates(i24, view.getMeasuredState());
                int i272 = ((((aVar.h >= 0 ? this.e : aVar.h) & a.j.AppCompatTheme_windowActionModeOverlay) >> 4) & -2) >> 1;
                iArr2[i272] = Math.max(iArr2[i272], baseline2);
                iArr[i272] = Math.max(iArr[i272], measuredHeight - baseline2);
                int max32 = Math.max(i21, measuredHeight);
                if (z9 || aVar.height == -1) {
                }
                if (aVar.g <= 0.0f) {
                }
                int i292 = i13;
                i21 = max32;
                i24 = combineMeasuredStates2;
                z9 = z11;
                i19 = a(view, i292) + i292;
                f3 = f4;
                i19++;
                iArr3 = iArr;
                z6 = z3;
                z5 = z2;
                i18 = 1073741824;
                int i302 = i3;
            }
            z3 = z6;
            z2 = z5;
            i19++;
            iArr3 = iArr;
            z6 = z3;
            z5 = z2;
            i18 = 1073741824;
            int i3022 = i3;
        }
        boolean z12 = z6;
        boolean z13 = z5;
        int i33 = i21;
        int i34 = i22;
        int i35 = i23;
        int i36 = i24;
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.l;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            i4 = i36;
        } else {
            i4 = i36;
            i33 = Math.max(i33, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z12 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            int i37 = 0;
            while (i37 < virtualChildCount) {
                View b3 = b(i37);
                if (b3 == null) {
                    this.f += d(i37);
                } else if (b3.getVisibility() == 8) {
                    i37 += a(b3, i37);
                } else {
                    a aVar2 = (a) b3.getLayoutParams();
                    if (z7) {
                        this.f += aVar2.leftMargin + i20 + aVar2.rightMargin + b(b3);
                    } else {
                        int i38 = this.f;
                        i12 = i33;
                        this.f = Math.max(i38, i38 + i20 + aVar2.leftMargin + aVar2.rightMargin + b(b3));
                        i37++;
                        i33 = i12;
                    }
                }
                i12 = i33;
                i37++;
                i33 = i12;
            }
        }
        int i39 = i33;
        this.f += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumWidth()), i16, 0);
        int i40 = (16777215 & resolveSizeAndState) - this.f;
        if (z8 || (i40 != 0 && f3 > 0.0f)) {
            if (this.g > 0.0f) {
                f3 = this.g;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f = 0;
            int i41 = i34;
            int i42 = i4;
            int i43 = -1;
            float f5 = f3;
            int i44 = 0;
            while (i44 < virtualChildCount) {
                View b4 = b(i44);
                if (b4 == null || b4.getVisibility() == 8) {
                    i9 = i40;
                    i8 = virtualChildCount;
                    int i45 = i3;
                } else {
                    a aVar3 = (a) b4.getLayoutParams();
                    float f6 = aVar3.g;
                    if (f6 > 0.0f) {
                        int i46 = (int) ((((float) i40) * f6) / f5);
                        float f7 = f5 - f6;
                        int i47 = i40 - i46;
                        i8 = virtualChildCount;
                        int childMeasureSpec = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + aVar3.topMargin + aVar3.bottomMargin, aVar3.height);
                        if (aVar3.width == 0) {
                            i11 = 1073741824;
                            if (mode == 1073741824) {
                            }
                        } else {
                            i11 = 1073741824;
                        }
                        i46 = b4.getMeasuredWidth() + i46;
                    } else {
                        i9 = i40;
                        i8 = virtualChildCount;
                        int i48 = i3;
                    }
                    if (z7) {
                        this.f += b4.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin + b(b4);
                        f2 = f5;
                    } else {
                        int i49 = this.f;
                        f2 = f5;
                        this.f = Math.max(i49, b4.getMeasuredWidth() + i49 + aVar3.leftMargin + aVar3.rightMargin + b(b4));
                    }
                    boolean z14 = mode2 != 1073741824 && aVar3.height == -1;
                    int i50 = aVar3.topMargin + aVar3.bottomMargin;
                    int measuredHeight2 = b4.getMeasuredHeight() + i50;
                    i43 = Math.max(i43, measuredHeight2);
                    if (!z14) {
                        i50 = measuredHeight2;
                    }
                    int max4 = Math.max(i41, i50);
                    if (z9) {
                        i10 = -1;
                        if (aVar3.height == -1) {
                            z = true;
                            if (z13 && (baseline = b4.getBaseline()) != i10) {
                                int i51 = ((((aVar3.h < 0 ? this.e : aVar3.h) & a.j.AppCompatTheme_windowActionModeOverlay) >> 4) & -2) >> 1;
                                iArr2[i51] = Math.max(iArr2[i51], baseline);
                                iArr[i51] = Math.max(iArr[i51], measuredHeight2 - baseline);
                            }
                            i41 = max4;
                            z9 = z;
                            f5 = f2;
                        }
                    } else {
                        i10 = -1;
                    }
                    z = false;
                    if (z13 || (baseline = b4.getBaseline()) != i10) {
                    }
                    i41 = max4;
                    z9 = z;
                    f5 = f2;
                }
                i44++;
                i40 = i9;
                virtualChildCount = i8;
                int i52 = i2;
            }
            i5 = virtualChildCount;
            i6 = i3;
            this.f += getPaddingLeft() + getPaddingRight();
            i39 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i43 : Math.max(i43, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i4 = i42;
            i7 = i41;
        } else {
            i7 = Math.max(i34, i35);
            if (z12 && mode != 1073741824) {
                for (int i53 = 0; i53 < virtualChildCount; i53++) {
                    View b5 = b(i53);
                    if (!(b5 == null || b5.getVisibility() == 8 || ((a) b5.getLayoutParams()).g <= 0.0f)) {
                        b5.measure(View.MeasureSpec.makeMeasureSpec(i20, 1073741824), View.MeasureSpec.makeMeasureSpec(b5.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i5 = virtualChildCount;
            i6 = i3;
        }
        if (!z9 && mode2 != 1073741824) {
            i39 = i7;
        }
        setMeasuredDimension(resolveSizeAndState | (i4 & -16777216), View.resolveSizeAndState(Math.max(i39 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i6, i4 << 16));
        if (z10) {
            d(i5, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010a  */
    public void b(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean a2 = bc.a(this);
        int paddingTop = getPaddingTop();
        int i16 = i5 - i3;
        int paddingBottom = i16 - getPaddingBottom();
        int paddingBottom2 = (i16 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i17 = this.e & a.j.AppCompatTheme_windowActionModeOverlay;
        boolean z = this.a;
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        int a3 = d.a(this.e & 8388615, p.b(this));
        int paddingLeft = a3 != 1 ? a3 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i4) - i2) - this.f : (((i4 - i2) - this.f) / 2) + getPaddingLeft();
        if (a2) {
            i7 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i7 = 0;
            i6 = 1;
        }
        int i18 = 0;
        while (i18 < virtualChildCount) {
            int i19 = i7 + (i6 * i18);
            View b2 = b(i19);
            if (b2 == null) {
                paddingLeft += d(i19);
            } else if (b2.getVisibility() != 8) {
                int measuredWidth = b2.getMeasuredWidth();
                int measuredHeight = b2.getMeasuredHeight();
                a aVar = (a) b2.getLayoutParams();
                if (z) {
                    i11 = i18;
                    i10 = virtualChildCount;
                    if (aVar.height != -1) {
                        i12 = b2.getBaseline();
                        i13 = aVar.h;
                        if (i13 < 0) {
                            i13 = i17;
                        }
                        i14 = i13 & a.j.AppCompatTheme_windowActionModeOverlay;
                        i9 = i17;
                        if (i14 != 16) {
                            i15 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + aVar.topMargin) - aVar.bottomMargin;
                        } else if (i14 == 48) {
                            int i20 = aVar.topMargin + paddingTop;
                            if (i12 != -1) {
                                i20 += iArr[1] - i12;
                            }
                            i15 = i20;
                        } else if (i14 != 80) {
                            i15 = paddingTop;
                        } else {
                            int i21 = (paddingBottom - measuredHeight) - aVar.bottomMargin;
                            if (i12 != -1) {
                                i21 -= iArr2[2] - (b2.getMeasuredHeight() - i12);
                            }
                            i15 = i21;
                        }
                        if (c(i19)) {
                            paddingLeft += this.l;
                        }
                        int i22 = aVar.leftMargin + paddingLeft;
                        i8 = paddingTop;
                        a(b2, i22 + a(b2), i15, measuredWidth, measuredHeight);
                        int i23 = measuredWidth + aVar.rightMargin;
                        View view = b2;
                        i18 = i11 + a(view, i19);
                        paddingLeft = i22 + i23 + b(view);
                        i18++;
                        virtualChildCount = i10;
                        i17 = i9;
                        paddingTop = i8;
                    }
                } else {
                    i11 = i18;
                    i10 = virtualChildCount;
                }
                i12 = -1;
                i13 = aVar.h;
                if (i13 < 0) {
                }
                i14 = i13 & a.j.AppCompatTheme_windowActionModeOverlay;
                i9 = i17;
                if (i14 != 16) {
                }
                if (c(i19)) {
                }
                int i222 = aVar.leftMargin + paddingLeft;
                i8 = paddingTop;
                a(b2, i222 + a(b2), i15, measuredWidth, measuredHeight);
                int i232 = measuredWidth + aVar.rightMargin;
                View view2 = b2;
                i18 = i11 + a(view2, i19);
                paddingLeft = i222 + i232 + b(view2);
                i18++;
                virtualChildCount = i10;
                i17 = i9;
                paddingTop = i8;
            } else {
                int i24 = i18;
            }
            i8 = paddingTop;
            i10 = virtualChildCount;
            i9 = i17;
            i18++;
            virtualChildCount = i10;
            i17 = i9;
            paddingTop = i8;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas) {
        int i2;
        int left;
        int i3;
        int virtualChildCount = getVirtualChildCount();
        boolean a2 = bc.a(this);
        for (int i4 = 0; i4 < virtualChildCount; i4++) {
            View b2 = b(i4);
            if (!(b2 == null || b2.getVisibility() == 8 || !c(i4))) {
                a aVar = (a) b2.getLayoutParams();
                b(canvas, a2 ? b2.getRight() + aVar.rightMargin : (b2.getLeft() - aVar.leftMargin) - this.l);
            }
        }
        if (c(virtualChildCount)) {
            View b3 = b(virtualChildCount - 1);
            if (b3 != null) {
                a aVar2 = (a) b3.getLayoutParams();
                if (a2) {
                    left = b3.getLeft();
                    i3 = aVar2.leftMargin;
                } else {
                    i2 = b3.getRight() + aVar2.rightMargin;
                    b(canvas, i2);
                }
            } else if (a2) {
                i2 = getPaddingLeft();
                b(canvas, i2);
            } else {
                left = getWidth();
                i3 = getPaddingRight();
            }
            i2 = (left - i3) - this.l;
            b(canvas, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, int i2) {
        this.k.setBounds(i2, getPaddingTop() + this.o, this.l + i2, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean c(int i2) {
        if (i2 == 0) {
            return (this.n & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.n & 4) != 0;
        }
        if ((this.n & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* access modifiers changed from: package-private */
    public int d(int i2) {
        return 0;
    }

    public int getBaseline() {
        int i2;
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() > this.b) {
            View childAt = getChildAt(this.b);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i3 = this.c;
                if (this.d == 1 && (i2 = this.e & a.j.AppCompatTheme_windowActionModeOverlay) != 48) {
                    if (i2 == 16) {
                        i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2;
                    } else if (i2 == 80) {
                        i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                    }
                }
                return i3 + ((a) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.b == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public a generateDefaultLayoutParams() {
        if (this.d == 0) {
            return new a(-2, -2);
        }
        if (this.d == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.k != null) {
            if (this.d == 1) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(aj.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(aj.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.d == 1) {
            a(i2, i3, i4, i5);
        } else {
            b(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.d == 1) {
            a(i2, i3);
        } else {
            b(i2, i3);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.b = i2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.k) {
            this.k = drawable;
            boolean z = false;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.o = i2;
    }

    public void setGravity(int i2) {
        if (this.e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & a.j.AppCompatTheme_windowActionModeOverlay) == 0) {
                i2 |= 48;
            }
            this.e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        if ((8388615 & this.e) != i3) {
            this.e = i3 | (this.e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int i2) {
        if (this.d != i2) {
            this.d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.n) {
            requestLayout();
        }
        this.n = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & a.j.AppCompatTheme_windowActionModeOverlay;
        if ((this.e & a.j.AppCompatTheme_windowActionModeOverlay) != i3) {
            this.e = i3 | (this.e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.g = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
