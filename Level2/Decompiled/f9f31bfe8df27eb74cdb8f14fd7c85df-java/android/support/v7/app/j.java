package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.v;
import android.support.v4.g.n;
import android.support.v4.g.p;
import android.support.v4.g.s;
import android.support.v4.g.t;
import android.support.v4.g.u;
import android.support.v4.g.w;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ad;
import android.support.v7.widget.ah;
import android.support.v7.widget.bb;
import android.support.v7.widget.bc;
import android.support.v7.widget.l;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

class j extends f implements h.a, LayoutInflater.Factory2 {
    private static final boolean t = (Build.VERSION.SDK_INT < 21);
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private d[] E;
    private d F;
    private boolean G;
    private final Runnable H = new Runnable() {
        public void run() {
            if ((j.this.s & 1) != 0) {
                j.this.f(0);
            }
            if ((j.this.s & 4096) != 0) {
                j.this.f(a.j.AppCompatTheme_tooltipFrameBackground);
            }
            j.this.r = false;
            j.this.s = 0;
        }
    };
    private boolean I;
    private Rect J;
    private Rect K;
    private AppCompatViewInflater L;
    android.support.v7.view.b m;
    ActionBarContextView n;
    PopupWindow o;
    Runnable p;
    s q = null;
    boolean r;
    int s;
    private ad u;
    private a v;
    private e w;
    private boolean x;
    private ViewGroup y;
    private TextView z;

    private final class a implements o.a {
        a() {
        }

        public void a(h hVar, boolean z) {
            j.this.b(hVar);
        }

        public boolean a(h hVar) {
            Window.Callback q = j.this.q();
            if (q == null) {
                return true;
            }
            q.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
            return true;
        }
    }

    class b implements b.a {
        private b.a b;

        public b(b.a aVar) {
            this.b = aVar;
        }

        public void a(android.support.v7.view.b bVar) {
            this.b.a(bVar);
            if (j.this.o != null) {
                j.this.b.getDecorView().removeCallbacks(j.this.p);
            }
            if (j.this.n != null) {
                j.this.t();
                j.this.q = p.d(j.this.n).a(0.0f);
                j.this.q.a((t) new u() {
                    public void b(View view) {
                        j.this.n.setVisibility(8);
                        if (j.this.o != null) {
                            j.this.o.dismiss();
                        } else if (j.this.n.getParent() instanceof View) {
                            p.g((View) j.this.n.getParent());
                        }
                        j.this.n.removeAllViews();
                        j.this.q.a((t) null);
                        j.this.q = null;
                    }
                });
            }
            if (j.this.e != null) {
                j.this.e.b(j.this.m);
            }
            j.this.m = null;
        }

        public boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.b.a(bVar, menu);
        }

        public boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.b.a(bVar, menuItem);
        }

        public boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.b.b(bVar, menu);
        }
    }

    private class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return j.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            j.this.e(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(android.support.v7.b.a.b.b(getContext(), i));
        }
    }

    protected static final class d {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        h j;
        f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        d(int i2) {
            this.a = i2;
        }

        /* access modifiers changed from: package-private */
        public android.support.v7.view.menu.p a(o.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new f(this.l, a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a((o) this.k);
            }
            return this.k.a(this.g);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.C0011a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(a.C0011a.panelMenuListTheme, typedValue, true);
            newTheme.applyStyle(typedValue.resourceId != 0 ? typedValue.resourceId : a.i.Theme_AppCompat_CompactMenu, true);
            android.support.v7.view.d dVar = new android.support.v7.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.j.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar) {
            if (hVar != this.j) {
                if (this.j != null) {
                    this.j.b((o) this.k);
                }
                this.j = hVar;
                if (hVar != null && this.k != null) {
                    hVar.a((o) this.k);
                }
            }
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }
    }

    private final class e implements o.a {
        e() {
        }

        public void a(h hVar, boolean z) {
            h p = hVar.p();
            boolean z2 = p != hVar;
            j jVar = j.this;
            if (z2) {
                hVar = p;
            }
            d a2 = jVar.a((Menu) hVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                j.this.a(a2.a, a2, p);
                j.this.a(a2, true);
                return;
            }
            j.this.a(a2, z);
        }

        public boolean a(h hVar) {
            Window.Callback q;
            if (hVar != null || !j.this.h || (q = j.this.q()) == null || j.this.p()) {
                return true;
            }
            q.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
            return true;
        }
    }

    j(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    private void a(d dVar, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (!dVar.o && !p()) {
            if (dVar.a == 0) {
                if ((this.a.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback q2 = q();
            if (q2 == null || q2.onMenuOpened(dVar.a, dVar.j)) {
                WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
                if (windowManager != null && b(dVar, keyEvent)) {
                    if (dVar.g == null || dVar.q) {
                        if (dVar.g == null) {
                            if (!a(dVar) || dVar.g == null) {
                                return;
                            }
                        } else if (dVar.q && dVar.g.getChildCount() > 0) {
                            dVar.g.removeAllViews();
                        }
                        if (c(dVar) && dVar.a()) {
                            ViewGroup.LayoutParams layoutParams2 = dVar.h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            dVar.g.setBackgroundResource(dVar.b);
                            ViewParent parent = dVar.h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(dVar.h);
                            }
                            dVar.g.addView(dVar.h, layoutParams2);
                            if (!dVar.h.hasFocus()) {
                                dVar.h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else if (!(dVar.i == null || (layoutParams = dVar.i.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i = -1;
                        dVar.n = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, dVar.d, dVar.e, 1002, 8519680, -3);
                        layoutParams3.gravity = dVar.c;
                        layoutParams3.windowAnimations = dVar.f;
                        windowManager.addView(dVar.g, layoutParams3);
                        dVar.o = true;
                        return;
                    }
                    i = -2;
                    dVar.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, dVar.d, dVar.e, 1002, 8519680, -3);
                    layoutParams32.gravity = dVar.c;
                    layoutParams32.windowAnimations = dVar.f;
                    windowManager.addView(dVar.g, layoutParams32);
                    dVar.o = true;
                    return;
                }
                return;
            }
            a(dVar, true);
        }
    }

    private void a(h hVar, boolean z2) {
        if (this.u == null || !this.u.e() || (ViewConfiguration.get(this.a).hasPermanentMenuKey() && !this.u.g())) {
            d a2 = a(0, true);
            a2.q = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Window.Callback q2 = q();
        if (this.u.f() && z2) {
            this.u.i();
            if (!p()) {
                q2.onPanelClosed(a.j.AppCompatTheme_tooltipFrameBackground, a(0, true).j);
            }
        } else if (q2 != null && !p()) {
            if (this.r && (this.s & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.H);
                this.H.run();
            }
            d a3 = a(0, true);
            if (a3.j != null && !a3.r && q2.onPreparePanel(0, a3.i, a3.j)) {
                q2.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, a3.j);
                this.u.h();
            }
        }
    }

    private boolean a(d dVar) {
        dVar.a(n());
        dVar.g = new c(dVar.l);
        dVar.c = 81;
        return true;
    }

    private boolean a(d dVar, int i, KeyEvent keyEvent, int i2) {
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((dVar.m || b(dVar, keyEvent)) && dVar.j != null) {
            z2 = dVar.j.performShortcut(i, keyEvent, i2);
        }
        if (z2 && (i2 & 1) == 0 && this.u == null) {
            a(dVar, true);
        }
        return z2;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.b.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || p.m((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean b(d dVar) {
        Context context = this.a;
        if ((dVar.a == 0 || dVar.a == 108) && this.u != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.C0011a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.C0011a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.C0011a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                android.support.v7.view.d dVar2 = new android.support.v7.view.d(context, 0);
                dVar2.getTheme().setTo(theme2);
                context = dVar2;
            }
        }
        h hVar = new h(context);
        hVar.a((h.a) this);
        dVar.a(hVar);
        return true;
    }

    private boolean b(d dVar, KeyEvent keyEvent) {
        if (p()) {
            return false;
        }
        if (dVar.m) {
            return true;
        }
        if (!(this.F == null || this.F == dVar)) {
            a(this.F, false);
        }
        Window.Callback q2 = q();
        if (q2 != null) {
            dVar.i = q2.onCreatePanelView(dVar.a);
        }
        boolean z2 = dVar.a == 0 || dVar.a == 108;
        if (z2 && this.u != null) {
            this.u.j();
        }
        if (dVar.i == null && (!z2 || !(m() instanceof m))) {
            if (dVar.j == null || dVar.r) {
                if (dVar.j == null && (!b(dVar) || dVar.j == null)) {
                    return false;
                }
                if (z2 && this.u != null) {
                    if (this.v == null) {
                        this.v = new a();
                    }
                    this.u.a(dVar.j, this.v);
                }
                dVar.j.g();
                if (!q2.onCreatePanelMenu(dVar.a, dVar.j)) {
                    dVar.a((h) null);
                    if (z2 && this.u != null) {
                        this.u.a((Menu) null, this.v);
                    }
                    return false;
                }
                dVar.r = false;
            }
            dVar.j.g();
            if (dVar.s != null) {
                dVar.j.b(dVar.s);
                dVar.s = null;
            }
            if (!q2.onPreparePanel(0, dVar.i, dVar.j)) {
                if (z2 && this.u != null) {
                    this.u.a((Menu) null, this.v);
                }
                dVar.j.h();
                return false;
            }
            dVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            dVar.j.setQwertyMode(dVar.p);
            dVar.j.h();
        }
        dVar.m = true;
        dVar.n = false;
        this.F = dVar;
        return true;
    }

    private boolean c(d dVar) {
        if (dVar.i != null) {
            dVar.h = dVar.i;
            return true;
        } else if (dVar.j == null) {
            return false;
        } else {
            if (this.w == null) {
                this.w = new e();
            }
            dVar.h = (View) dVar.a((o.a) this.w);
            return dVar.h != null;
        }
    }

    private void d(int i) {
        this.s = (1 << i) | this.s;
        if (!this.r) {
            p.a(this.b.getDecorView(), this.H);
            this.r = true;
        }
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        d a2 = a(i, true);
        if (!a2.o) {
            return b(a2, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    private boolean e(int i, KeyEvent keyEvent) {
        boolean z2;
        boolean z3;
        if (this.m != null) {
            return false;
        }
        d a2 = a(i, true);
        if (i == 0 && this.u != null && this.u.e() && !ViewConfiguration.get(this.a).hasPermanentMenuKey()) {
            if (this.u.f()) {
                z2 = this.u.i();
            } else if (!p() && b(a2, keyEvent)) {
                z2 = this.u.h();
            }
            if (z2) {
            }
            return z2;
        } else if (a2.o || a2.n) {
            z2 = a2.o;
            a(a2, true);
            if (z2) {
                AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                } else {
                    Log.w("AppCompatDelegate", "Couldn't get audio manager");
                }
            }
            return z2;
        } else if (a2.m) {
            if (a2.r) {
                a2.m = false;
                z3 = b(a2, keyEvent);
            } else {
                z3 = true;
            }
            if (z3) {
                a(a2, keyEvent);
                z2 = true;
                if (z2) {
                }
                return z2;
            }
        }
        z2 = false;
        if (z2) {
        }
        return z2;
    }

    private int h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return a.j.AppCompatTheme_tooltipFrameBackground;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return a.j.AppCompatTheme_viewInflaterClass;
        }
    }

    private void w() {
        if (!this.x) {
            this.y = x();
            CharSequence r2 = r();
            if (!TextUtils.isEmpty(r2)) {
                b(r2);
            }
            y();
            a(this.y);
            this.x = true;
            d a2 = a(0, false);
            if (p()) {
                return;
            }
            if (a2 == null || a2.j == null) {
                d(a.j.AppCompatTheme_tooltipFrameBackground);
            }
        }
    }

    private ViewGroup x() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(a.j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
                c(1);
            } else if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
                c((int) a.j.AppCompatTheme_tooltipFrameBackground);
            }
            if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
                c((int) a.j.AppCompatTheme_viewInflaterClass);
            }
            if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
                c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                viewGroup = (ViewGroup) from.inflate(this.j ? a.g.abc_screen_simple_overlay_action_mode : a.g.abc_screen_simple, (ViewGroup) null);
                if (Build.VERSION.SDK_INT >= 21) {
                    p.a((View) viewGroup, (n) new n() {
                        public w a(View view, w wVar) {
                            int b = wVar.b();
                            int g = j.this.g(b);
                            if (b != g) {
                                wVar = wVar.a(wVar.a(), g, wVar.c(), wVar.d());
                            }
                            return p.a(view, wVar);
                        }
                    });
                } else {
                    ((ah) viewGroup).setOnFitSystemWindowsListener(new ah.a() {
                        public void a(Rect rect) {
                            rect.top = j.this.g(rect.top);
                        }
                    });
                }
            } else if (this.k) {
                viewGroup = (ViewGroup) from.inflate(a.g.abc_dialog_title_material, (ViewGroup) null);
                this.i = false;
                this.h = false;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(a.C0011a.actionBarTheme, typedValue, true);
                viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.a, typedValue.resourceId) : this.a).inflate(a.g.abc_screen_toolbar, (ViewGroup) null);
                this.u = (ad) viewGroup.findViewById(a.f.decor_content_parent);
                this.u.setWindowCallback(q());
                if (this.i) {
                    this.u.a(a.j.AppCompatTheme_viewInflaterClass);
                }
                if (this.B) {
                    this.u.a(2);
                }
                if (this.C) {
                    this.u.a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.u == null) {
                    this.z = (TextView) viewGroup.findViewById(a.f.title);
                }
                bc.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.b.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.a() {
                    public void a() {
                    }

                    public void b() {
                        j.this.v();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.y.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void z() {
        if (this.x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* access modifiers changed from: protected */
    public d a(int i, boolean z2) {
        d[] dVarArr = this.E;
        if (dVarArr == null || dVarArr.length <= i) {
            d[] dVarArr2 = new d[(i + 1)];
            if (dVarArr != null) {
                System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
            }
            this.E = dVarArr2;
            dVarArr = dVarArr2;
        }
        d dVar = dVarArr[i];
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(i);
        dVarArr[i] = dVar2;
        return dVar2;
    }

    /* access modifiers changed from: package-private */
    public d a(Menu menu) {
        d[] dVarArr = this.E;
        int length = dVarArr != null ? dVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            d dVar = dVarArr[i];
            if (dVar != null && dVar.j == menu) {
                return dVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    public android.support.v7.view.b a(b.a aVar) {
        android.support.v7.view.b bVar;
        Context context;
        t();
        if (this.m != null) {
            this.m.c();
        }
        if (!(aVar instanceof b)) {
            aVar = new b(aVar);
        }
        if (this.e != null && !p()) {
            try {
                bVar = this.e.a(aVar);
            } catch (AbstractMethodError unused) {
            }
            if (bVar == null) {
                this.m = bVar;
            } else {
                boolean z2 = true;
                if (this.n == null) {
                    if (this.k) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = this.a.getTheme();
                        theme.resolveAttribute(a.C0011a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme newTheme = this.a.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            context = new android.support.v7.view.d(this.a, 0);
                            context.getTheme().setTo(newTheme);
                        } else {
                            context = this.a;
                        }
                        this.n = new ActionBarContextView(context);
                        this.o = new PopupWindow(context, (AttributeSet) null, a.C0011a.actionModePopupWindowStyle);
                        android.support.v4.widget.j.a(this.o, 2);
                        this.o.setContentView(this.n);
                        this.o.setWidth(-1);
                        context.getTheme().resolveAttribute(a.C0011a.actionBarSize, typedValue, true);
                        this.n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.o.setHeight(-2);
                        this.p = new Runnable() {
                            public void run() {
                                j.this.o.showAtLocation(j.this.n, 55, 0, 0);
                                j.this.t();
                                if (j.this.s()) {
                                    j.this.n.setAlpha(0.0f);
                                    j.this.q = p.d(j.this.n).a(1.0f);
                                    j.this.q.a((t) new u() {
                                        public void a(View view) {
                                            j.this.n.setVisibility(0);
                                        }

                                        public void b(View view) {
                                            j.this.n.setAlpha(1.0f);
                                            j.this.q.a((t) null);
                                            j.this.q = null;
                                        }
                                    });
                                    return;
                                }
                                j.this.n.setAlpha(1.0f);
                                j.this.n.setVisibility(0);
                            }
                        };
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.y.findViewById(a.f.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(n()));
                            this.n = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.n != null) {
                    t();
                    this.n.c();
                    Context context2 = this.n.getContext();
                    ActionBarContextView actionBarContextView = this.n;
                    if (this.o != null) {
                        z2 = false;
                    }
                    android.support.v7.view.e eVar = new android.support.v7.view.e(context2, actionBarContextView, aVar, z2);
                    if (aVar.a((android.support.v7.view.b) eVar, eVar.b())) {
                        eVar.d();
                        this.n.a(eVar);
                        this.m = eVar;
                        if (s()) {
                            this.n.setAlpha(0.0f);
                            this.q = p.d(this.n).a(1.0f);
                            this.q.a((t) new u() {
                                public void a(View view) {
                                    j.this.n.setVisibility(0);
                                    j.this.n.sendAccessibilityEvent(32);
                                    if (j.this.n.getParent() instanceof View) {
                                        p.g((View) j.this.n.getParent());
                                    }
                                }

                                public void b(View view) {
                                    j.this.n.setAlpha(1.0f);
                                    j.this.q.a((t) null);
                                    j.this.q = null;
                                }
                            });
                        } else {
                            this.n.setAlpha(1.0f);
                            this.n.setVisibility(0);
                            this.n.sendAccessibilityEvent(32);
                            if (this.n.getParent() instanceof View) {
                                p.g((View) this.n.getParent());
                            }
                        }
                        if (this.o != null) {
                            this.b.getDecorView().post(this.p);
                        }
                    } else {
                        this.m = null;
                    }
                }
            }
            if (!(this.m == null || this.e == null)) {
                this.e.a(this.m);
            }
            return this.m;
        }
        bVar = null;
        if (bVar == null) {
        }
        this.e.a(this.m);
        return this.m;
    }

    public <T extends View> T a(int i) {
        w();
        return this.b.findViewById(i);
    }

    /* access modifiers changed from: package-private */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        if (!(this.c instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, d dVar, Menu menu) {
        if (menu == null) {
            if (dVar == null && i >= 0 && i < this.E.length) {
                dVar = this.E[i];
            }
            if (dVar != null) {
                menu = dVar.j;
            }
        }
        if ((dVar == null || dVar.o) && !p()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Menu menu) {
        if (i == 108) {
            a a2 = a();
            if (a2 != null) {
                a2.e(false);
            }
        } else if (i == 0) {
            d a3 = a(i, true);
            if (a3.o) {
                a(a3, false);
            }
        }
    }

    public void a(Configuration configuration) {
        a a2;
        if (this.h && this.x && (a2 = a()) != null) {
            a2.a(configuration);
        }
        l.a().a(this.a);
        i();
    }

    public void a(Bundle bundle) {
        if ((this.c instanceof Activity) && v.b((Activity) this.c) != null) {
            a m2 = m();
            if (m2 == null) {
                this.I = true;
            } else {
                m2.c(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar, boolean z2) {
        if (!z2 || dVar.a != 0 || this.u == null || !this.u.f()) {
            WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
            if (!(windowManager == null || !dVar.o || dVar.g == null)) {
                windowManager.removeView(dVar.g);
                if (z2) {
                    a(dVar.a, dVar, (Menu) null);
                }
            }
            dVar.m = false;
            dVar.n = false;
            dVar.o = false;
            dVar.h = null;
            dVar.q = true;
            if (this.F == dVar) {
                this.F = null;
                return;
            }
            return;
        }
        b(dVar.j);
    }

    public void a(h hVar) {
        a(hVar, true);
    }

    public void a(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i, KeyEvent keyEvent) {
        a a2 = a();
        if (a2 != null && a2.a(i, keyEvent)) {
            return true;
        }
        if (this.F == null || !a(this.F, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.F == null) {
                d a3 = a(0, true);
                b(a3, keyEvent);
                boolean a4 = a(a3, keyEvent.getKeyCode(), keyEvent, 1);
                a3.m = false;
                if (a4) {
                    return true;
                }
            }
            return false;
        }
        if (this.F != null) {
            this.F.n = true;
        }
        return true;
    }

    public boolean a(h hVar, MenuItem menuItem) {
        d a2;
        Window.Callback q2 = q();
        if (q2 == null || p() || (a2 = a((Menu) hVar.p())) == null) {
            return false;
        }
        return q2.onMenuItemSelected(a2.a, menuItem);
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        boolean z2 = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    public android.support.v7.view.b b(b.a aVar) {
        if (aVar != null) {
            if (this.m != null) {
                this.m.c();
            }
            b bVar = new b(aVar);
            a a2 = a();
            if (a2 != null) {
                this.m = a2.a((b.a) bVar);
                if (!(this.m == null || this.e == null)) {
                    this.e.a(this.m);
                }
            }
            if (this.m == null) {
                this.m = a((b.a) bVar);
            }
            return this.m;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public View b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        AppCompatViewInflater appCompatViewInflater;
        boolean z3 = false;
        if (this.L == null) {
            String string = this.a.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.L = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.L = appCompatViewInflater;
        }
        if (t) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.L.a(view, str, context, attributeSet, z2, t, true, bb.a());
    }

    public void b(int i) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void b(Bundle bundle) {
        w();
    }

    /* access modifiers changed from: package-private */
    public void b(h hVar) {
        if (!this.D) {
            this.D = true;
            this.u.k();
            Window.Callback q2 = q();
            if (q2 != null && !p()) {
                q2.onPanelClosed(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
            }
            this.D = false;
        }
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ((ViewGroup) this.y.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence) {
        if (this.u != null) {
            this.u.setWindowTitle(charSequence);
        } else if (m() != null) {
            m().a(charSequence);
        } else if (this.z != null) {
            this.z.setText(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z2 = this.G;
            this.G = false;
            d a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            } else if (u()) {
                return true;
            }
        } else if (i == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        a a2 = a();
        if (a2 != null) {
            a2.e(true);
        }
        return true;
    }

    public boolean c(int i) {
        int h = h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                z();
                this.l = true;
                return true;
            case 2:
                z();
                this.B = true;
                return true;
            case 5:
                z();
                this.C = true;
                return true;
            case 10:
                z();
                this.j = true;
                return true;
            case a.j.AppCompatTheme_tooltipFrameBackground:
                z();
                this.h = true;
                return true;
            case a.j.AppCompatTheme_viewInflaterClass:
                z();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.G = z2;
        } else if (i == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    public void d() {
        a a2 = a();
        if (a2 != null) {
            a2.d(false);
        }
    }

    public void e() {
        a a2 = a();
        if (a2 != null) {
            a2.d(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i) {
        a(a(i, true), true);
    }

    public void f() {
        a a2 = a();
        if (a2 == null || !a2.e()) {
            d(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i) {
        d a2;
        d a3 = a(i, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.a(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.g();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i == 108 || i == 0) && this.u != null && (a2 = a(0, false)) != null) {
            a2.m = false;
            b(a2, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: package-private */
    public int g(int i) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i2 = 0;
        if (this.n == null || !(this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
            z2 = true;
            if (this.n.isShown()) {
                if (this.J == null) {
                    this.J = new Rect();
                    this.K = new Rect();
                }
                Rect rect = this.J;
                Rect rect2 = this.K;
                rect.set(0, i, 0, 0);
                bc.a(this.y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.A == null) {
                        this.A = new View(this.a);
                        this.A.setBackgroundColor(this.a.getResources().getColor(a.c.abc_input_method_navigation_guard));
                        this.y.addView(this.A, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.A.setLayoutParams(layoutParams);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.A == null) {
                    z2 = false;
                }
                if (!this.j && z2) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z4 = true;
                } else {
                    z4 = false;
                }
                z2 = false;
            }
            if (z3) {
                this.n.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.A != null) {
            View view = this.A;
            if (!z2) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        return i;
    }

    public void g() {
        if (this.r) {
            this.b.getDecorView().removeCallbacks(this.H);
        }
        super.g();
        if (this.f != null) {
            this.f.g();
        }
    }

    public void h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            android.support.v4.g.e.b(from, this);
        } else if (!(from.getFactory2() instanceof j)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public void l() {
        p pVar;
        w();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                pVar = new p((Activity) this.c, this.i);
            } else {
                if (this.c instanceof Dialog) {
                    pVar = new p((Dialog) this.c);
                }
                if (this.f == null) {
                    this.f.c(this.I);
                    return;
                }
                return;
            }
            this.f = pVar;
            if (this.f == null) {
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 != null ? a2 : b(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public final boolean s() {
        return this.x && this.y != null && p.l(this.y);
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.q != null) {
            this.q.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        if (this.m != null) {
            this.m.c();
            return true;
        }
        a a2 = a();
        return a2 != null && a2.f();
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (this.u != null) {
            this.u.k();
        }
        if (this.o != null) {
            this.b.getDecorView().removeCallbacks(this.p);
            if (this.o.isShowing()) {
                try {
                    this.o.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.o = null;
        }
        t();
        d a2 = a(0, false);
        if (a2 != null && a2.j != null) {
            a2.j.close();
        }
    }
}
