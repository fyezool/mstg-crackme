package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.g.p;
import android.support.v4.g.s;
import android.support.v4.g.t;
import android.support.v4.g.u;
import android.support.v7.a.a;
import android.support.v7.b.a.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class ax implements ae {
    Toolbar a;
    CharSequence b;
    Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private d n;
    private int o;
    private int p;
    private Drawable q;

    public ax(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material);
    }

    public ax(Toolbar toolbar, boolean z, int i2, int i3) {
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.b != null;
        this.j = toolbar.getNavigationIcon();
        aw a2 = aw.a(toolbar.getContext(), (AttributeSet) null, a.j.ActionBar, a.C0011a.actionBarStyle, 0);
        this.q = a2.a(a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c2 = a2.c(a.j.ActionBar_title);
            if (!TextUtils.isEmpty(c2)) {
                b(c2);
            }
            CharSequence c3 = a2.c(a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c3)) {
                c(c3);
            }
            Drawable a3 = a2.a(a.j.ActionBar_logo);
            if (a3 != null) {
                b(a3);
            }
            Drawable a4 = a2.a(a.j.ActionBar_icon);
            if (a4 != null) {
                a(a4);
            }
            if (this.j == null && this.q != null) {
                c(this.q);
            }
            c(a2.a(a.j.ActionBar_displayOptions, 0));
            int g2 = a2.g(a.j.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.a.getContext()).inflate(g2, this.a, false));
                c(this.e | 16);
            }
            int f2 = a2.f(a.j.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = f2;
                this.a.setLayoutParams(layoutParams);
            }
            int d2 = a2.d(a.j.ActionBar_contentInsetStart, -1);
            int d3 = a2.d(a.j.ActionBar_contentInsetEnd, -1);
            if (d2 >= 0 || d3 >= 0) {
                this.a.a(Math.max(d2, 0), Math.max(d3, 0));
            }
            int g3 = a2.g(a.j.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                this.a.a(this.a.getContext(), g3);
            }
            int g4 = a2.g(a.j.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                this.a.b(this.a.getContext(), g4);
            }
            int g5 = a2.g(a.j.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.a.setPopupTheme(g5);
            }
        } else {
            this.e = r();
        }
        a2.a();
        e(i2);
        this.m = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new View.OnClickListener() {
            final android.support.v7.view.menu.a a = new android.support.v7.view.menu.a(ax.this.a.getContext(), 0, 16908332, 0, 0, ax.this.b);

            public void onClick(View view) {
                if (ax.this.c != null && ax.this.d) {
                    ax.this.c.onMenuItemSelected(0, this.a);
                }
            }
        });
    }

    private void e(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private int r() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    private void s() {
        this.a.setLogo((this.e & 2) != 0 ? ((this.e & 1) == 0 || this.i == null) ? this.h : this.i : null);
    }

    private void t() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.e & 4) != 0) {
            toolbar = this.a;
            drawable = this.j != null ? this.j : this.q;
        } else {
            toolbar = this.a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void u() {
        if ((this.e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.m)) {
            this.a.setNavigationContentDescription(this.p);
        } else {
            this.a.setNavigationContentDescription(this.m);
        }
    }

    public s a(final int i2, long j2) {
        return p.d(this.a).a(i2 == 0 ? 1.0f : 0.0f).a(j2).a((t) new u() {
            private boolean c = false;

            public void a(View view) {
                ax.this.a.setVisibility(0);
            }

            public void b(View view) {
                if (!this.c) {
                    ax.this.a.setVisibility(i2);
                }
            }

            public void c(View view) {
                this.c = true;
            }
        });
    }

    public ViewGroup a() {
        return this.a;
    }

    public void a(int i2) {
        a(i2 != 0 ? b.b(b(), i2) : null);
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        s();
    }

    public void a(o.a aVar, h.a aVar2) {
        this.a.a(aVar, aVar2);
    }

    public void a(ap apVar) {
        if (this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }
        this.f = apVar;
        if (apVar != null && this.o == 2) {
            this.a.addView(this.f, 0);
            Toolbar.b bVar = (Toolbar.b) this.f.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.a = 8388691;
            apVar.setAllowCollapse(true);
        }
    }

    public void a(Menu menu, o.a aVar) {
        if (this.n == null) {
            this.n = new d(this.a.getContext());
            this.n.a(a.f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.a.a((h) menu, this.n);
    }

    public void a(View view) {
        if (!(this.g == null || (this.e & 16) == 0)) {
            this.a.removeView(this.g);
        }
        this.g = view;
        if (view != null && (this.e & 16) != 0) {
            this.a.addView(this.g);
        }
    }

    public void a(Window.Callback callback) {
        this.c = callback;
    }

    public void a(CharSequence charSequence) {
        if (!this.k) {
            e(charSequence);
        }
    }

    public void a(boolean z) {
        this.a.setCollapsible(z);
    }

    public Context b() {
        return this.a.getContext();
    }

    public void b(int i2) {
        b(i2 != 0 ? b.b(b(), i2) : null);
    }

    public void b(Drawable drawable) {
        this.i = drawable;
        s();
    }

    public void b(CharSequence charSequence) {
        this.k = true;
        e(charSequence);
    }

    public void b(boolean z) {
    }

    public void c(int i2) {
        CharSequence charSequence;
        Toolbar toolbar;
        int i3 = this.e ^ i2;
        this.e = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    u();
                }
                t();
            }
            if ((i3 & 3) != 0) {
                s();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.a.setTitle(this.b);
                    toolbar = this.a;
                    charSequence = this.l;
                } else {
                    charSequence = null;
                    this.a.setTitle((CharSequence) null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i3 & 16) != 0 && this.g != null) {
                if ((i2 & 16) != 0) {
                    this.a.addView(this.g);
                } else {
                    this.a.removeView(this.g);
                }
            }
        }
    }

    public void c(Drawable drawable) {
        this.j = drawable;
        t();
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public boolean c() {
        return this.a.g();
    }

    public void d() {
        this.a.h();
    }

    public void d(int i2) {
        this.a.setVisibility(i2);
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        u();
    }

    public CharSequence e() {
        return this.a.getTitle();
    }

    public void e(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                f(this.p);
            }
        }
    }

    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void f(int i2) {
        d((CharSequence) i2 == 0 ? null : b().getString(i2));
    }

    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean h() {
        return this.a.a();
    }

    public boolean i() {
        return this.a.b();
    }

    public boolean j() {
        return this.a.c();
    }

    public boolean k() {
        return this.a.d();
    }

    public boolean l() {
        return this.a.e();
    }

    public void m() {
        this.d = true;
    }

    public void n() {
        this.a.f();
    }

    public int o() {
        return this.e;
    }

    public int p() {
        return this.o;
    }

    public Menu q() {
        return this.a.getMenu();
    }
}
