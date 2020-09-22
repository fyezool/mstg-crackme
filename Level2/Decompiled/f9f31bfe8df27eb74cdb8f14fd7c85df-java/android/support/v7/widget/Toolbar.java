package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.g.f;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    private final ActionMenuView.e H;
    private ax I;
    private d J;
    private a K;
    private o.a L;
    private h.a M;
    private boolean N;
    private final Runnable O;
    ImageButton a;
    View b;
    int c;
    c d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private ao u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    private class a implements o {
        h a;
        j b;

        a() {
        }

        public void a(Context context, h hVar) {
            if (!(this.a == null || this.b == null)) {
                this.a.d(this.b);
            }
            this.a = hVar;
        }

        public void a(h hVar, boolean z) {
        }

        public void a(o.a aVar) {
        }

        public boolean a(h hVar, j jVar) {
            Toolbar.this.i();
            ViewParent parent = Toolbar.this.a.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.a);
                }
                Toolbar.this.addView(Toolbar.this.a);
            }
            Toolbar.this.b = jVar.getActionView();
            this.b = jVar;
            ViewParent parent2 = Toolbar.this.b.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.b);
                }
                b j = Toolbar.this.generateDefaultLayoutParams();
                j.a = 8388611 | (Toolbar.this.c & a.j.AppCompatTheme_windowActionModeOverlay);
                j.b = 2;
                Toolbar.this.b.setLayoutParams(j);
                Toolbar.this.addView(Toolbar.this.b);
            }
            Toolbar.this.k();
            Toolbar.this.requestLayout();
            jVar.e(true);
            if (Toolbar.this.b instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) Toolbar.this.b).a();
            }
            return true;
        }

        public boolean a(u uVar) {
            return false;
        }

        public void b(boolean z) {
            if (this.b != null) {
                boolean z2 = false;
                if (this.a != null) {
                    int size = this.a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.a.getItem(i) == this.b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    b(this.a, this.b);
                }
            }
        }

        public boolean b() {
            return false;
        }

        public boolean b(h hVar, j jVar) {
            if (Toolbar.this.b instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) Toolbar.this.b).b();
            }
            Toolbar.this.removeView(Toolbar.this.b);
            Toolbar.this.removeView(Toolbar.this.a);
            Toolbar.this.b = null;
            Toolbar.this.l();
            this.b = null;
            Toolbar.this.requestLayout();
            jVar.e(false);
            return true;
        }
    }

    public static class b extends a.C0013a {
        int b = 0;

        public b(int i, int i2) {
            super(i, i2);
            this.a = 8388627;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(a.C0013a aVar) {
            super(aVar);
        }

        public b(b bVar) {
            super((a.C0013a) bVar);
            this.b = bVar.b;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface c {
        boolean a(MenuItem menuItem);
    }

    public static class d extends android.support.v4.g.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() {
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };
        int b;
        boolean c;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.H = new ActionMenuView.e() {
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.d != null) {
                    return Toolbar.this.d.a(menuItem);
                }
                return false;
            }
        };
        this.O = new Runnable() {
            public void run() {
                Toolbar.this.d();
            }
        };
        aw a2 = aw.a(getContext(), attributeSet, a.j.Toolbar, i2, 0);
        this.n = a2.g(a.j.Toolbar_titleTextAppearance, 0);
        this.o = a2.g(a.j.Toolbar_subtitleTextAppearance, 0);
        this.x = a2.c(a.j.Toolbar_android_gravity, this.x);
        this.c = a2.c(a.j.Toolbar_buttonGravity, 48);
        int d2 = a2.d(a.j.Toolbar_titleMargin, 0);
        d2 = a2.g(a.j.Toolbar_titleMargins) ? a2.d(a.j.Toolbar_titleMargins, d2) : d2;
        this.t = d2;
        this.s = d2;
        this.r = d2;
        this.q = d2;
        int d3 = a2.d(a.j.Toolbar_titleMarginStart, -1);
        if (d3 >= 0) {
            this.q = d3;
        }
        int d4 = a2.d(a.j.Toolbar_titleMarginEnd, -1);
        if (d4 >= 0) {
            this.r = d4;
        }
        int d5 = a2.d(a.j.Toolbar_titleMarginTop, -1);
        if (d5 >= 0) {
            this.s = d5;
        }
        int d6 = a2.d(a.j.Toolbar_titleMarginBottom, -1);
        if (d6 >= 0) {
            this.t = d6;
        }
        this.p = a2.e(a.j.Toolbar_maxButtonHeight, -1);
        int d7 = a2.d(a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d8 = a2.d(a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e2 = a2.e(a.j.Toolbar_contentInsetLeft, 0);
        int e3 = a2.e(a.j.Toolbar_contentInsetRight, 0);
        s();
        this.u.b(e2, e3);
        if (!(d7 == Integer.MIN_VALUE && d8 == Integer.MIN_VALUE)) {
            this.u.a(d7, d8);
        }
        this.v = a2.d(a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = a2.d(a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.j = a2.a(a.j.Toolbar_collapseIcon);
        this.k = a2.c(a.j.Toolbar_collapseContentDescription);
        CharSequence c2 = a2.c(a.j.Toolbar_title);
        if (!TextUtils.isEmpty(c2)) {
            setTitle(c2);
        }
        CharSequence c3 = a2.c(a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.l = getContext();
        setPopupTheme(a2.g(a.j.Toolbar_popupTheme, 0));
        Drawable a3 = a2.a(a.j.Toolbar_navigationIcon);
        if (a3 != null) {
            setNavigationIcon(a3);
        }
        CharSequence c4 = a2.c(a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c4)) {
            setNavigationContentDescription(c4);
        }
        Drawable a4 = a2.a(a.j.Toolbar_logo);
        if (a4 != null) {
            setLogo(a4);
        }
        CharSequence c5 = a2.c(a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c5)) {
            setLogoDescription(c5);
        }
        if (a2.g(a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.b(a.j.Toolbar_titleTextColor, -1));
        }
        if (a2.g(a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.b(a.j.Toolbar_subtitleTextColor, -1));
        }
        a2.a();
    }

    private int a(int i2) {
        int i3 = i2 & a.j.AppCompatTheme_windowActionModeOverlay;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.x & a.j.AppCompatTheme_windowActionModeOverlay;
    }

    private int a(View view, int i2) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int a2 = a(bVar.a);
        if (a2 == 48) {
            return getPaddingTop() - i3;
        }
        if (a2 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (i4 < bVar.topMargin) {
            i4 = bVar.topMargin;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            if (i5 < bVar.bottomMargin) {
                i4 = Math.max(0, i4 - (bVar.bottomMargin - i5));
            }
        }
        return paddingTop + i4;
    }

    private int a(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i2, int[] iArr, int i3) {
        b bVar = (b) view.getLayoutParams();
        int i4 = bVar.leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + bVar.rightMargin;
    }

    private int a(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = i3;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            b bVar = (b) view.getLayoutParams();
            int i7 = bVar.leftMargin - i2;
            int i8 = bVar.rightMargin - i4;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            int max3 = Math.max(0, -i7);
            int max4 = Math.max(0, -i8);
            i6 += max + view.getMeasuredWidth() + max2;
            i5++;
            i4 = max4;
            i2 = max3;
        }
        return i6;
    }

    private void a(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        b j2 = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (b) layoutParams;
        j2.b = 1;
        if (!z2 || this.b == null) {
            addView(view, j2);
            return;
        }
        view.setLayoutParams(j2);
        this.F.add(view);
    }

    private void a(List<View> list, int i2) {
        boolean z2 = p.b(this) == 1;
        int childCount = getChildCount();
        int a2 = android.support.v4.g.d.a(i2, p.b(this));
        list.clear();
        if (z2) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && a(childAt) && b(bVar.a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.b == 0 && a(childAt2) && b(bVar2.a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i2) {
        int b2 = p.b(this);
        int a2 = android.support.v4.g.d.a(i2, b2) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : b2 == 1 ? 5 : 3;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return f.a(marginLayoutParams) + f.b(marginLayoutParams);
    }

    private int b(View view, int i2, int[] iArr, int i3) {
        b bVar = (b) view.getLayoutParams();
        int i4 = bVar.rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + bVar.leftMargin);
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    private void m() {
        if (this.i == null) {
            this.i = new q(getContext());
        }
    }

    private void n() {
        o();
        if (this.e.d() == null) {
            h hVar = (h) this.e.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.e.setExpandedActionViewsExclusive(true);
            hVar.a((o) this.K, this.l);
        }
    }

    private void o() {
        if (this.e == null) {
            this.e = new ActionMenuView(getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            b j2 = generateDefaultLayoutParams();
            j2.a = 8388613 | (this.c & a.j.AppCompatTheme_windowActionModeOverlay);
            this.e.setLayoutParams(j2);
            a((View) this.e, false);
        }
    }

    private void p() {
        if (this.h == null) {
            this.h = new o(getContext(), (AttributeSet) null, a.C0011a.toolbarNavigationButtonStyle);
            b j2 = generateDefaultLayoutParams();
            j2.a = 8388611 | (this.c & a.j.AppCompatTheme_windowActionModeOverlay);
            this.h.setLayoutParams(j2);
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean r() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.u == null) {
            this.u = new ao();
        }
    }

    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b ? new b((b) layoutParams) : layoutParams instanceof a.C0013a ? new b((a.C0013a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(int i2, int i3) {
        s();
        this.u.a(i2, i3);
    }

    public void a(Context context, int i2) {
        this.n = i2;
        if (this.f != null) {
            this.f.setTextAppearance(context, i2);
        }
    }

    public void a(h hVar, d dVar) {
        if (hVar != null || this.e != null) {
            o();
            h d2 = this.e.d();
            if (d2 != hVar) {
                if (d2 != null) {
                    d2.b((o) this.J);
                    d2.b((o) this.K);
                }
                if (this.K == null) {
                    this.K = new a();
                }
                dVar.d(true);
                if (hVar != null) {
                    hVar.a((o) dVar, this.l);
                    hVar.a((o) this.K, this.l);
                } else {
                    dVar.a(this.l, (h) null);
                    this.K.a(this.l, (h) null);
                    dVar.b(true);
                    this.K.b(true);
                }
                this.e.setPopupTheme(this.m);
                this.e.setPresenter(dVar);
                this.J = dVar;
            }
        }
    }

    public void a(o.a aVar, h.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        if (this.e != null) {
            this.e.a(aVar, aVar2);
        }
    }

    public boolean a() {
        return getVisibility() == 0 && this.e != null && this.e.a();
    }

    public void b(Context context, int i2) {
        this.o = i2;
        if (this.g != null) {
            this.g.setTextAppearance(context, i2);
        }
    }

    public boolean b() {
        return this.e != null && this.e.g();
    }

    public boolean c() {
        return this.e != null && this.e.h();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public boolean d() {
        return this.e != null && this.e.e();
    }

    public boolean e() {
        return this.e != null && this.e.f();
    }

    public void f() {
        if (this.e != null) {
            this.e.i();
        }
    }

    public boolean g() {
        return (this.K == null || this.K.b == null) ? false : true;
    }

    public int getContentInsetEnd() {
        if (this.u != null) {
            return this.u.d();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        return this.w != Integer.MIN_VALUE ? this.w : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        if (this.u != null) {
            return this.u.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.u != null) {
            return this.u.b();
        }
        return 0;
    }

    public int getContentInsetStart() {
        if (this.u != null) {
            return this.u.c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.v != Integer.MIN_VALUE ? this.v : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.e.d();
     */
    public int getCurrentContentInsetEnd() {
        h d2;
        boolean z2 = (this.e == null || d2 == null || !d2.hasVisibleItems()) ? false : true;
        return z2 ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return p.b(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return p.b(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        if (this.i != null) {
            return this.i.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        if (this.i != null) {
            return this.i.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        n();
        return this.e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        if (this.h != null) {
            return this.h.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        if (this.h != null) {
            return this.h.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public d getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        n();
        return this.e.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.l;
    }

    public int getPopupTheme() {
        return this.m;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public ae getWrapper() {
        if (this.I == null) {
            this.I = new ax(this, true);
        }
        return this.I;
    }

    public void h() {
        j jVar = this.K == null ? null : this.K.b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (this.a == null) {
            this.a = new o(getContext(), (AttributeSet) null, a.C0011a.toolbarNavigationButtonStyle);
            this.a.setImageDrawable(this.j);
            this.a.setContentDescription(this.k);
            b j2 = generateDefaultLayoutParams();
            j2.a = 8388611 | (this.c & a.j.AppCompatTheme_windowActionModeOverlay);
            j2.b = 2;
            this.a.setLayoutParams(j2);
            this.a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.h();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    /* access modifiers changed from: package-private */
    public void k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((b) childAt.getLayoutParams()).b == 2 || childAt == this.e)) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02aa A[LOOP:0: B:101:0x02a8->B:102:0x02aa, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02cc A[LOOP:1: B:104:0x02ca->B:105:0x02cc, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0306 A[LOOP:2: B:112:0x0304->B:113:0x0306, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022b  */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        boolean a2;
        boolean a3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int size;
        int i15;
        int i16;
        int size2;
        int i17;
        int i18;
        int size3;
        boolean z3;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        char c2;
        int i26;
        int i27;
        boolean z4 = p.b(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i28 = width - paddingRight;
        int[] iArr = this.G;
        iArr[1] = 0;
        iArr[0] = 0;
        int c3 = p.c(this);
        int min = c3 >= 0 ? Math.min(c3, i5 - i3) : 0;
        if (!a((View) this.h)) {
            i6 = paddingLeft;
        } else if (z4) {
            i7 = b(this.h, i28, iArr, min);
            i6 = paddingLeft;
            if (a((View) this.a)) {
                if (z4) {
                    i7 = b(this.a, i7, iArr, min);
                } else {
                    i6 = a(this.a, i6, iArr, min);
                }
            }
            if (a((View) this.e)) {
                if (z4) {
                    i6 = a(this.e, i6, iArr, min);
                } else {
                    i7 = b(this.e, i7, iArr, min);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i6);
            iArr[1] = Math.max(0, currentContentInsetRight - (i28 - i7));
            int max = Math.max(i6, currentContentInsetLeft);
            int min2 = Math.min(i7, i28 - currentContentInsetRight);
            if (a(this.b)) {
                if (z4) {
                    min2 = b(this.b, min2, iArr, min);
                } else {
                    max = a(this.b, max, iArr, min);
                }
            }
            if (a((View) this.i)) {
                if (z4) {
                    min2 = b(this.i, min2, iArr, min);
                } else {
                    max = a(this.i, max, iArr, min);
                }
            }
            a2 = a((View) this.f);
            a3 = a((View) this.g);
            if (!a2) {
                b bVar = (b) this.f.getLayoutParams();
                i9 = paddingRight;
                i10 = bVar.topMargin + this.f.getMeasuredHeight() + bVar.bottomMargin + 0;
            } else {
                i9 = paddingRight;
                i10 = 0;
            }
            if (!a3) {
                b bVar2 = (b) this.g.getLayoutParams();
                i11 = width;
                i10 += bVar2.topMargin + this.g.getMeasuredHeight() + bVar2.bottomMargin;
            } else {
                i11 = width;
            }
            if (!a2 || a3) {
                TextView textView = !a2 ? this.f : this.g;
                TextView textView2 = !a3 ? this.g : this.f;
                b bVar3 = (b) textView.getLayoutParams();
                b bVar4 = (b) textView2.getLayoutParams();
                if ((!a2 || this.f.getMeasuredWidth() <= 0) && (!a3 || this.g.getMeasuredWidth() <= 0)) {
                    i13 = paddingLeft;
                    z3 = false;
                } else {
                    i13 = paddingLeft;
                    z3 = true;
                }
                i19 = this.x & a.j.AppCompatTheme_windowActionModeOverlay;
                i12 = min;
                if (i19 == 48) {
                    i20 = max;
                    i21 = getPaddingTop() + bVar3.topMargin + this.s;
                } else if (i19 != 80) {
                    int i29 = (((height - paddingTop) - paddingBottom) - i10) / 2;
                    i20 = max;
                    if (i29 < bVar3.topMargin + this.s) {
                        i29 = bVar3.topMargin + this.s;
                    } else {
                        int i30 = (((height - paddingBottom) - i10) - i29) - paddingTop;
                        if (i30 < bVar3.bottomMargin + this.t) {
                            i29 = Math.max(0, i29 - ((bVar4.bottomMargin + this.t) - i30));
                        }
                    }
                    i21 = paddingTop + i29;
                } else {
                    i20 = max;
                    i21 = (((height - paddingBottom) - bVar4.bottomMargin) - this.t) - i10;
                }
                if (z4) {
                    if (z3) {
                        i25 = this.q;
                        c2 = 1;
                    } else {
                        c2 = 1;
                        i25 = 0;
                    }
                    int i31 = i25 - iArr[c2];
                    i8 -= Math.max(0, i31);
                    iArr[c2] = Math.max(0, -i31);
                    if (a2) {
                        int measuredWidth = i8 - this.f.getMeasuredWidth();
                        int measuredHeight = this.f.getMeasuredHeight() + i21;
                        this.f.layout(measuredWidth, i21, i8, measuredHeight);
                        i26 = measuredWidth - this.r;
                        i21 = measuredHeight + ((b) this.f.getLayoutParams()).bottomMargin;
                    } else {
                        i26 = i8;
                    }
                    if (a3) {
                        b bVar5 = (b) this.g.getLayoutParams();
                        int i32 = i21 + bVar5.topMargin;
                        this.g.layout(i8 - this.g.getMeasuredWidth(), i32, i8, this.g.getMeasuredHeight() + i32);
                        i27 = i8 - this.r;
                        int i33 = bVar5.bottomMargin;
                    } else {
                        i27 = i8;
                    }
                    if (z3) {
                        i8 = Math.min(i26, i27);
                    }
                    max = i20;
                } else {
                    if (z3) {
                        i22 = this.q;
                        i14 = 0;
                    } else {
                        i14 = 0;
                        i22 = 0;
                    }
                    int i34 = i22 - iArr[i14];
                    max = i20 + Math.max(i14, i34);
                    iArr[i14] = Math.max(i14, -i34);
                    if (a2) {
                        int measuredWidth2 = this.f.getMeasuredWidth() + max;
                        int measuredHeight2 = this.f.getMeasuredHeight() + i21;
                        this.f.layout(max, i21, measuredWidth2, measuredHeight2);
                        i23 = measuredWidth2 + this.r;
                        i21 = measuredHeight2 + ((b) this.f.getLayoutParams()).bottomMargin;
                    } else {
                        i23 = max;
                    }
                    if (a3) {
                        b bVar6 = (b) this.g.getLayoutParams();
                        int i35 = i21 + bVar6.topMargin;
                        int measuredWidth3 = this.g.getMeasuredWidth() + max;
                        this.g.layout(max, i35, measuredWidth3, this.g.getMeasuredHeight() + i35);
                        i24 = measuredWidth3 + this.r;
                        int i36 = bVar6.bottomMargin;
                    } else {
                        i24 = max;
                    }
                    if (z3) {
                        max = Math.max(i23, i24);
                    }
                    a((List<View>) this.E, 3);
                    size = this.E.size();
                    i15 = max;
                    for (i16 = 0; i16 < size; i16++) {
                        i15 = a(this.E.get(i16), i15, iArr, i12);
                    }
                    int i37 = i12;
                    a((List<View>) this.E, 5);
                    size2 = this.E.size();
                    for (i17 = 0; i17 < size2; i17++) {
                        i8 = b(this.E.get(i17), i8, iArr, i37);
                    }
                    a((List<View>) this.E, 1);
                    int a4 = a((List<View>) this.E, iArr);
                    i18 = (i13 + (((i11 - i13) - i9) / 2)) - (a4 / 2);
                    int i38 = a4 + i18;
                    if (i18 >= i15) {
                        i15 = i38 > i8 ? i18 - (i38 - i8) : i18;
                    }
                    size3 = this.E.size();
                    while (i14 < size3) {
                        i15 = a(this.E.get(i14), i15, iArr, i37);
                        i14++;
                    }
                    this.E.clear();
                    return;
                }
            } else {
                i13 = paddingLeft;
                i12 = min;
            }
            i14 = 0;
            a((List<View>) this.E, 3);
            size = this.E.size();
            i15 = max;
            while (i16 < size) {
            }
            int i372 = i12;
            a((List<View>) this.E, 5);
            size2 = this.E.size();
            while (i17 < size2) {
            }
            a((List<View>) this.E, 1);
            int a42 = a((List<View>) this.E, iArr);
            i18 = (i13 + (((i11 - i13) - i9) / 2)) - (a42 / 2);
            int i382 = a42 + i18;
            if (i18 >= i15) {
            }
            size3 = this.E.size();
            while (i14 < size3) {
            }
            this.E.clear();
            return;
        } else {
            i6 = a(this.h, paddingLeft, iArr, min);
        }
        i7 = i28;
        if (a((View) this.a)) {
        }
        if (a((View) this.e)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i6);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i28 - i7));
        int max2 = Math.max(i6, currentContentInsetLeft2);
        int min22 = Math.min(i7, i28 - currentContentInsetRight2);
        if (a(this.b)) {
        }
        if (a((View) this.i)) {
        }
        a2 = a((View) this.f);
        a3 = a((View) this.g);
        if (!a2) {
        }
        if (!a3) {
        }
        if (!a2) {
        }
        if (!a2) {
        }
        if (!a3) {
        }
        b bVar32 = (b) textView.getLayoutParams();
        b bVar42 = (b) textView2.getLayoutParams();
        if (!a2 || this.f.getMeasuredWidth() <= 0) {
            i13 = paddingLeft;
            z3 = false;
            i19 = this.x & a.j.AppCompatTheme_windowActionModeOverlay;
            i12 = min;
            if (i19 == 48) {
            }
            if (z4) {
            }
        }
        i13 = paddingLeft;
        z3 = true;
        i19 = this.x & a.j.AppCompatTheme_windowActionModeOverlay;
        i12 = min;
        if (i19 == 48) {
        }
        if (z4) {
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.G;
        if (bc.a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c3 = 0;
            c2 = 1;
        }
        if (a((View) this.h)) {
            a((View) this.h, i2, 0, i3, 0, this.p);
            i6 = this.h.getMeasuredWidth() + b((View) this.h);
            i5 = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
            i4 = View.combineMeasuredStates(0, this.h.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (a((View) this.a)) {
            a((View) this.a, i2, 0, i3, 0, this.p);
            i6 = this.a.getMeasuredWidth() + b((View) this.a);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + c(this.a));
            i4 = View.combineMeasuredStates(i4, this.a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i6) + 0;
        iArr[c3] = Math.max(0, currentContentInsetStart - i6);
        if (a((View) this.e)) {
            a((View) this.e, i2, max, i3, 0, this.p);
            i7 = this.e.getMeasuredWidth() + b((View) this.e);
            i5 = Math.max(i5, this.e.getMeasuredHeight() + c(this.e));
            i4 = View.combineMeasuredStates(i4, this.e.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (a(this.b)) {
            max2 += a(this.b, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.b.getMeasuredHeight() + c(this.b));
            i4 = View.combineMeasuredStates(i4, this.b.getMeasuredState());
        }
        if (a((View) this.i)) {
            max2 += a((View) this.i, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + c(this.i));
            i4 = View.combineMeasuredStates(i4, this.i.getMeasuredState());
        }
        int childCount = getChildCount();
        int i11 = i5;
        int i12 = max2;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((b) childAt.getLayoutParams()).b == 0 && a(childAt)) {
                i12 += a(childAt, i2, i12, i3, 0, iArr);
                i11 = Math.max(i11, childAt.getMeasuredHeight() + c(childAt));
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int i14 = this.s + this.t;
        int i15 = this.q + this.r;
        if (a((View) this.f)) {
            a((View) this.f, i2, i12 + i15, i3, i14, iArr);
            int measuredWidth = this.f.getMeasuredWidth() + b((View) this.f);
            i8 = this.f.getMeasuredHeight() + c(this.f);
            i10 = View.combineMeasuredStates(i4, this.f.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i10 = i4;
            i9 = 0;
            i8 = 0;
        }
        if (a((View) this.g)) {
            int i16 = i8 + i14;
            i9 = Math.max(i9, a((View) this.g, i2, i12 + i15, i3, i16, iArr));
            i8 += this.g.getMeasuredHeight() + c(this.g);
            i10 = View.combineMeasuredStates(i10, this.g.getMeasuredState());
        } else {
            int i17 = i10;
        }
        int max3 = Math.max(i11, i8);
        int paddingLeft = i12 + i9 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, -16777216 & i10);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, i10 << 16);
        if (r()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        h d2 = this.e != null ? this.e.d() : null;
        if (!(dVar.b == 0 || this.K == null || d2 == null || (findItem = d2.findItem(dVar.b)) == null)) {
            findItem.expandActionView();
        }
        if (dVar.c) {
            q();
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        s();
        ao aoVar = this.u;
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        aoVar.a(z2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        if (!(this.K == null || this.K.b == null)) {
            dVar.b = this.K.b.getItemId();
        }
        dVar.c = b();
        return dVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapsible(boolean z2) {
        this.N = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.w) {
            this.w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.v) {
            this.v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(android.support.v7.b.a.b.b(getContext(), i2));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!d(this.i)) {
                a((View) this.i, true);
            }
        } else if (this.i != null && d(this.i)) {
            removeView(this.i);
            this.F.remove(this.i);
        }
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        if (this.i != null) {
            this.i.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            p();
        }
        if (this.h != null) {
            this.h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(android.support.v7.b.a.b.b(getContext(), i2));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            p();
            if (!d(this.h)) {
                a((View) this.h, true);
            }
        } else if (this.h != null && d(this.h)) {
            removeView(this.h);
            this.F.remove(this.h);
        }
        if (this.h != null) {
            this.h.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        p();
        this.h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.d = cVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        n();
        this.e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.m != i2) {
            this.m = i2;
            if (i2 == 0) {
                this.l = getContext();
            } else {
                this.l = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new ab(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TextUtils.TruncateAt.END);
                if (this.o != 0) {
                    this.g.setTextAppearance(context, this.o);
                }
                if (this.B != 0) {
                    this.g.setTextColor(this.B);
                }
            }
            if (!d(this.g)) {
                a((View) this.g, true);
            }
        } else if (this.g != null && d(this.g)) {
            removeView(this.g);
            this.F.remove(this.g);
        }
        if (this.g != null) {
            this.g.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(int i2) {
        this.B = i2;
        if (this.g != null) {
            this.g.setTextColor(i2);
        }
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f == null) {
                Context context = getContext();
                this.f = new ab(context);
                this.f.setSingleLine();
                this.f.setEllipsize(TextUtils.TruncateAt.END);
                if (this.n != 0) {
                    this.f.setTextAppearance(context, this.n);
                }
                if (this.A != 0) {
                    this.f.setTextColor(this.A);
                }
            }
            if (!d(this.f)) {
                a((View) this.f, true);
            }
        } else if (this.f != null && d(this.f)) {
            removeView(this.f);
            this.F.remove(this.f);
        }
        if (this.f != null) {
            this.f.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i2) {
        this.t = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        this.A = i2;
        if (this.f != null) {
            this.f.setTextColor(i2);
        }
    }
}
