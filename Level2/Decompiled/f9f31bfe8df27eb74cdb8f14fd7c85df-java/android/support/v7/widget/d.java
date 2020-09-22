package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.g.c;
import android.support.v7.a.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class d extends android.support.v7.view.menu.b implements c.a {
    private b A;
    C0015d g;
    e h;
    a i;
    c j;
    final f k = new f();
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y = new SparseBooleanArray();
    private View z;

    private class a extends n {
        public a(Context context, u uVar, View view) {
            super(context, uVar, view, false, a.C0011a.actionOverflowMenuStyle);
            if (!((j) uVar.getItem()).j()) {
                a(d.this.g == null ? (View) d.this.f : d.this.g);
            }
            a((o.a) d.this.k);
        }

        /* access modifiers changed from: protected */
        public void e() {
            d.this.i = null;
            d.this.l = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        public s a() {
            if (d.this.i != null) {
                return d.this.i.b();
            }
            return null;
        }
    }

    private class c implements Runnable {
        private e b;

        public c(e eVar) {
            this.b = eVar;
        }

        public void run() {
            if (d.this.c != null) {
                d.this.c.f();
            }
            View view = (View) d.this.f;
            if (!(view == null || view.getWindowToken() == null || !this.b.c())) {
                d.this.h = this.b;
            }
            d.this.j = null;
        }
    }

    /* renamed from: android.support.v7.widget.d$d  reason: collision with other inner class name */
    private class C0015d extends q implements ActionMenuView.a {
        private final float[] b = new float[2];

        public C0015d(Context context) {
            super(context, (AttributeSet) null, a.C0011a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            ay.a(this, getContentDescription());
            setOnTouchListener(new ai(this, d.this) {
                public s a() {
                    if (d.this.h == null) {
                        return null;
                    }
                    return d.this.h.b();
                }

                public boolean b() {
                    d.this.d();
                    return true;
                }

                public boolean c() {
                    if (d.this.j != null) {
                        return false;
                    }
                    d.this.e();
                    return true;
                }
            });
        }

        public boolean c() {
            return false;
        }

        public boolean d() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            d.this.d();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class e extends n {
        public e(Context context, h hVar, View view, boolean z) {
            super(context, hVar, view, z, a.C0011a.actionOverflowMenuStyle);
            a(8388613);
            a((o.a) d.this.k);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (d.this.c != null) {
                d.this.c.close();
            }
            d.this.h = null;
            super.e();
        }
    }

    private class f implements o.a {
        f() {
        }

        public void a(h hVar, boolean z) {
            if (hVar instanceof u) {
                hVar.p().a(false);
            }
            o.a a2 = d.this.a();
            if (a2 != null) {
                a2.a(hVar, z);
            }
        }

        public boolean a(h hVar) {
            if (hVar == null) {
                return false;
            }
            d.this.l = ((u) hVar).getItem().getItemId();
            o.a a2 = d.this.a();
            if (a2 != null) {
                return a2.a(hVar);
            }
            return false;
        }
    }

    public d(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof p.a) && ((p.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public p a(ViewGroup viewGroup) {
        p pVar = this.f;
        p a2 = super.a(viewGroup);
        if (pVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.n()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public void a(Context context, h hVar) {
        super.a(context, hVar);
        Resources resources = context.getResources();
        android.support.v7.view.a a2 = android.support.v7.view.a.a(context);
        if (!this.p) {
            this.o = a2.b();
        }
        if (!this.v) {
            this.q = a2.c();
        }
        if (!this.t) {
            this.s = a2.a();
        }
        int i2 = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new C0015d(this.a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i2;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.z = null;
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = android.support.v7.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void a(Drawable drawable) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    public void a(h hVar, boolean z2) {
        f();
        super.a(hVar, z2);
    }

    public void a(j jVar, p.a aVar) {
        aVar.a(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    public void a(boolean z2) {
        if (z2) {
            super.a((u) null);
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    public boolean a(int i2, j jVar) {
        return jVar.j();
    }

    public boolean a(u uVar) {
        boolean z2 = false;
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        u uVar2 = uVar;
        while (uVar2.s() != this.c) {
            uVar2 = (u) uVar2.s();
        }
        View a2 = a(uVar2.getItem());
        if (a2 == null) {
            return false;
        }
        this.l = uVar.getItem().getItemId();
        int size = uVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = uVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        this.i = new a(this.b, uVar, a2);
        this.i.a(z2);
        this.i.a();
        super.a(uVar);
        return true;
    }

    public boolean a(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.g) {
            return false;
        }
        return super.a(viewGroup, i2);
    }

    public void b(boolean z2) {
        super.b(z2);
        ((View) this.f).requestLayout();
        boolean z3 = false;
        if (this.c != null) {
            ArrayList<j> k2 = this.c.k();
            int size = k2.size();
            for (int i2 = 0; i2 < size; i2++) {
                android.support.v4.g.c a2 = k2.get(i2).a();
                if (a2 != null) {
                    a2.a((c.a) this);
                }
            }
        }
        ArrayList<j> l2 = this.c != null ? this.c.l() : null;
        if (this.o && l2 != null) {
            int size2 = l2.size();
            if (size2 == 1) {
                z3 = !l2.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.g == null) {
                this.g = new C0015d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    public boolean b() {
        int i2;
        ArrayList<j> arrayList;
        int i3;
        int i4;
        int i5;
        boolean z2;
        d dVar = this;
        int i6 = 0;
        if (dVar.c != null) {
            arrayList = dVar.c.i();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = dVar.s;
        int i8 = dVar.r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) dVar.f;
        int i9 = i7;
        int i10 = 0;
        boolean z3 = false;
        int i11 = 0;
        for (int i12 = 0; i12 < i2; i12++) {
            j jVar = arrayList.get(i12);
            if (jVar.l()) {
                i10++;
            } else if (jVar.k()) {
                i11++;
            } else {
                z3 = true;
            }
            if (dVar.w && jVar.isActionViewExpanded()) {
                i9 = 0;
            }
        }
        if (dVar.o && (z3 || i11 + i10 > i9)) {
            i9--;
        }
        int i13 = i9 - i10;
        SparseBooleanArray sparseBooleanArray = dVar.y;
        sparseBooleanArray.clear();
        if (dVar.u) {
            i4 = i8 / dVar.x;
            i3 = ((i8 % dVar.x) / i4) + dVar.x;
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i14 = i8;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i2) {
            j jVar2 = arrayList.get(i15);
            if (jVar2.l()) {
                View a2 = dVar.a(jVar2, dVar.z, viewGroup);
                if (dVar.z == null) {
                    dVar.z = a2;
                }
                if (dVar.u) {
                    i4 -= ActionMenuView.a(a2, i3, i4, makeMeasureSpec, i6);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    z2 = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z2 = true;
                }
                jVar2.d(z2);
                i5 = i2;
                i16 = measuredWidth;
            } else if (jVar2.k()) {
                int groupId2 = jVar2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i13 > 0 || z4) && i14 > 0 && (!dVar.u || i4 > 0);
                if (z5) {
                    boolean z6 = z5;
                    View a3 = dVar.a(jVar2, dVar.z, viewGroup);
                    i5 = i2;
                    if (dVar.z == null) {
                        dVar.z = a3;
                    }
                    if (dVar.u) {
                        int a4 = ActionMenuView.a(a3, i3, i4, makeMeasureSpec, 0);
                        i4 -= a4;
                        if (a4 == 0) {
                            z6 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z5 = z6 & (!dVar.u ? i14 + i16 > 0 : i14 >= 0);
                } else {
                    boolean z7 = z5;
                    i5 = i2;
                }
                if (z5 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i17 = 0;
                    while (i17 < i15) {
                        j jVar3 = arrayList.get(i17);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.j()) {
                                i13++;
                            }
                            jVar3.d(false);
                        }
                        i17++;
                    }
                }
                if (z5) {
                    i13--;
                }
                jVar2.d(z5);
            } else {
                i5 = i2;
                jVar2.d(false);
                i15++;
                i2 = i5;
                dVar = this;
                i6 = 0;
            }
            i15++;
            i2 = i5;
            dVar = this;
            i6 = 0;
        }
        return true;
    }

    public Drawable c() {
        if (this.g != null) {
            return this.g.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    public void c(boolean z2) {
        this.o = z2;
        this.p = true;
    }

    public void d(boolean z2) {
        this.w = z2;
    }

    public boolean d() {
        if (!this.o || h() || this.c == null || this.f == null || this.j != null || this.c.l().isEmpty()) {
            return false;
        }
        this.j = new c(new e(this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.a((u) null);
        return true;
    }

    public boolean e() {
        if (this.j == null || this.f == null) {
            e eVar = this.h;
            if (eVar == null) {
                return false;
            }
            eVar.d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.j);
        this.j = null;
        return true;
    }

    public boolean f() {
        return e() | g();
    }

    public boolean g() {
        if (this.i == null) {
            return false;
        }
        this.i.d();
        return true;
    }

    public boolean h() {
        return this.h != null && this.h.f();
    }

    public boolean i() {
        return this.j != null || h();
    }
}
