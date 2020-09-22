package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.g.s;
import android.support.v4.g.t;
import android.support.v4.g.u;
import android.support.v4.g.v;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ae;
import android.support.v7.widget.ap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class p extends a implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s = (!p.class.desiredAssertionStatus());
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private ArrayList<a.b> C = new ArrayList<>();
    private boolean D;
    private int E = 0;
    private boolean F;
    private boolean G = true;
    private boolean H;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    ae d;
    ActionBarContextView e;
    View f;
    ap g;
    a h;
    b i;
    b.a j;
    boolean k = true;
    boolean l;
    boolean m;
    h n;
    boolean o;
    final t p = new u() {
        public void b(View view) {
            if (p.this.k && p.this.f != null) {
                p.this.f.setTranslationY(0.0f);
                p.this.c.setTranslationY(0.0f);
            }
            p.this.c.setVisibility(8);
            p.this.c.setTransitioning(false);
            p.this.n = null;
            p.this.h();
            if (p.this.b != null) {
                android.support.v4.g.p.g(p.this.b);
            }
        }
    };
    final t q = new u() {
        public void b(View view) {
            p.this.n = null;
            p.this.c.requestLayout();
        }
    };
    final v r = new v() {
        public void a(View view) {
            ((View) p.this.c.getParent()).invalidate();
        }
    };
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList<>();
    private int z = -1;

    public class a extends b implements h.a {
        private final Context b;
        private final android.support.v7.view.menu.h c;
        private b.a d;
        private WeakReference<View> e;

        public a(Context context, b.a aVar) {
            this.b = context;
            this.d = aVar;
            this.c = new android.support.v7.view.menu.h(context).a(1);
            this.c.a((h.a) this);
        }

        public MenuInflater a() {
            return new g(this.b);
        }

        public void a(int i) {
            b((CharSequence) p.this.a.getResources().getString(i));
        }

        public void a(android.support.v7.view.menu.h hVar) {
            if (this.d != null) {
                d();
                p.this.e.a();
            }
        }

        public void a(View view) {
            p.this.e.setCustomView(view);
            this.e = new WeakReference<>(view);
        }

        public void a(CharSequence charSequence) {
            p.this.e.setSubtitle(charSequence);
        }

        public void a(boolean z) {
            super.a(z);
            p.this.e.setTitleOptional(z);
        }

        public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            if (this.d != null) {
                return this.d.a((b) this, menuItem);
            }
            return false;
        }

        public Menu b() {
            return this.c;
        }

        public void b(int i) {
            a((CharSequence) p.this.a.getResources().getString(i));
        }

        public void b(CharSequence charSequence) {
            p.this.e.setTitle(charSequence);
        }

        public void c() {
            if (p.this.h == this) {
                if (!p.a(p.this.l, p.this.m, false)) {
                    p.this.i = this;
                    p.this.j = this.d;
                } else {
                    this.d.a(this);
                }
                this.d = null;
                p.this.j(false);
                p.this.e.b();
                p.this.d.a().sendAccessibilityEvent(32);
                p.this.b.setHideOnContentScrollEnabled(p.this.o);
                p.this.h = null;
            }
        }

        public void d() {
            if (p.this.h == this) {
                this.c.g();
                try {
                    this.d.b(this, this.c);
                } finally {
                    this.c.h();
                }
            }
        }

        public boolean e() {
            this.c.g();
            try {
                return this.d.a((b) this, (Menu) this.c);
            } finally {
                this.c.h();
            }
        }

        public CharSequence f() {
            return p.this.e.getTitle();
        }

        public CharSequence g() {
            return p.this.e.getSubtitle();
        }

        public boolean h() {
            return p.this.e.d();
        }

        public View i() {
            if (this.e != null) {
                return (View) this.e.get();
            }
            return null;
        }
    }

    public p(Activity activity, boolean z2) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z2) {
            this.f = decorView.findViewById(16908290);
        }
    }

    public p(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.b = (ActionBarOverlayLayout) view.findViewById(a.f.decor_content_parent);
        if (this.b != null) {
            this.b.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(a.f.action_bar));
        this.e = (ActionBarContextView) view.findViewById(a.f.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(a.f.action_bar_container);
        if (this.d == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.a = this.d.b();
        boolean z2 = (this.d.o() & 4) != 0;
        if (z2) {
            this.A = true;
        }
        android.support.v7.view.a a2 = android.support.v7.view.a.a(this.a);
        a(a2.f() || z2);
        k(a2.d());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes((AttributeSet) null, a.j.ActionBar, a.C0011a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
            b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    static boolean a(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private ae b(View view) {
        if (view instanceof ae) {
            return (ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        throw new IllegalStateException(sb.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private void k(boolean z2) {
        this.D = z2;
        if (!this.D) {
            this.d.a((ap) null);
            this.c.setTabContainer(this.g);
        } else {
            this.c.setTabContainer((ap) null);
            this.d.a(this.g);
        }
        boolean z3 = true;
        boolean z4 = i() == 2;
        if (this.g != null) {
            if (z4) {
                this.g.setVisibility(0);
                if (this.b != null) {
                    android.support.v4.g.p.g(this.b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        this.d.a(!this.D && z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        if (this.D || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z3);
    }

    private void l(boolean z2) {
        if (a(this.l, this.m, this.F)) {
            if (!this.G) {
                this.G = true;
                h(z2);
            }
        } else if (this.G) {
            this.G = false;
            i(z2);
        }
    }

    private void n() {
        if (!this.F) {
            this.F = true;
            if (this.b != null) {
                this.b.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    private void o() {
        if (this.F) {
            this.F = false;
            if (this.b != null) {
                this.b.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private boolean p() {
        return android.support.v4.g.p.l(this.c);
    }

    public int a() {
        return this.d.o();
    }

    public b a(b.a aVar) {
        if (this.h != null) {
            this.h.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        a aVar2 = new a(this.e.getContext(), aVar);
        if (!aVar2.e()) {
            return null;
        }
        this.h = aVar2;
        aVar2.d();
        this.e.a(aVar2);
        j(true);
        this.e.sendAccessibilityEvent(32);
        return aVar2;
    }

    public void a(float f2) {
        android.support.v4.g.p.a((View) this.c, f2);
    }

    public void a(int i2) {
        this.E = i2;
    }

    public void a(int i2, int i3) {
        int o2 = this.d.o();
        if ((i3 & 4) != 0) {
            this.A = true;
        }
        this.d.c((i2 & i3) | ((i3 ^ -1) & o2));
    }

    public void a(Configuration configuration) {
        k(android.support.v7.view.a.a(this.a).d());
    }

    public void a(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    public void a(boolean z2) {
        this.d.b(z2);
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        Menu b2;
        if (this.h == null || (b2 = this.h.b()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        b2.setQwertyMode(z2);
        return b2.performShortcut(i2, keyEvent, 0);
    }

    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(a.C0011a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.v = new ContextThemeWrapper(this.a, i2);
            } else {
                this.v = this.a;
            }
        }
        return this.v;
    }

    public void b(boolean z2) {
        if (!z2 || this.b.a()) {
            this.o = z2;
            this.b.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void c(boolean z2) {
        if (!this.A) {
            f(z2);
        }
    }

    public void d(boolean z2) {
        this.H = z2;
        if (!z2 && this.n != null) {
            this.n.c();
        }
    }

    public void e(boolean z2) {
        if (z2 != this.B) {
            this.B = z2;
            int size = this.C.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.C.get(i2).a(z2);
            }
        }
    }

    public void f(boolean z2) {
        a(z2 ? 4 : 0, 4);
    }

    public boolean f() {
        if (this.d == null || !this.d.c()) {
            return false;
        }
        this.d.d();
        return true;
    }

    public void g(boolean z2) {
        this.k = z2;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.j != null) {
            this.j.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    public void h(boolean z2) {
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.E != 0 || (!this.H && !z2)) {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.b((View) null);
        } else {
            this.c.setTranslationY(0.0f);
            float f2 = (float) (-this.c.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.c.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.c.setTranslationY(f2);
            android.support.v7.view.h hVar = new android.support.v7.view.h();
            s b2 = android.support.v4.g.p.d(this.c).b(0.0f);
            b2.a(this.r);
            hVar.a(b2);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f2);
                hVar.a(android.support.v4.g.p.d(this.f).b(0.0f));
            }
            hVar.a(u);
            hVar.a(250);
            hVar.a(this.q);
            this.n = hVar;
            hVar.a();
        }
        if (this.b != null) {
            android.support.v4.g.p.g(this.b);
        }
    }

    public int i() {
        return this.d.p();
    }

    public void i(boolean z2) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.E != 0 || (!this.H && !z2)) {
            this.p.b((View) null);
            return;
        }
        this.c.setAlpha(1.0f);
        this.c.setTransitioning(true);
        android.support.v7.view.h hVar = new android.support.v7.view.h();
        float f2 = (float) (-this.c.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.c.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        s b2 = android.support.v4.g.p.d(this.c).b(f2);
        b2.a(this.r);
        hVar.a(b2);
        if (this.k && this.f != null) {
            hVar.a(android.support.v4.g.p.d(this.f).b(f2));
        }
        hVar.a(t);
        hVar.a(250);
        hVar.a(this.p);
        this.n = hVar;
        hVar.a();
    }

    public void j() {
        if (this.m) {
            this.m = false;
            l(true);
        }
    }

    public void j(boolean z2) {
        s sVar;
        s sVar2;
        if (z2) {
            n();
        } else {
            o();
        }
        if (p()) {
            if (z2) {
                sVar = this.d.a(4, 100);
                sVar2 = this.e.a(0, 200);
            } else {
                sVar2 = this.d.a(0, 200);
                sVar = this.e.a(8, 100);
            }
            android.support.v7.view.h hVar = new android.support.v7.view.h();
            hVar.a(sVar, sVar2);
            hVar.a();
        } else if (z2) {
            this.d.d(4);
            this.e.setVisibility(0);
        } else {
            this.d.d(0);
            this.e.setVisibility(8);
        }
    }

    public void k() {
        if (!this.m) {
            this.m = true;
            l(true);
        }
    }

    public void l() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    public void m() {
    }
}
