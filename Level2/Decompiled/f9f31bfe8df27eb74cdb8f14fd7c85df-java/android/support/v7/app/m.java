package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ae;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;

class m extends a {
    ae a;
    Window.Callback b;
    private boolean c;
    private boolean d;
    private ArrayList<a.b> e;
    private final Runnable f;

    private final class a implements o.a {
        private boolean b;

        a() {
        }

        public void a(h hVar, boolean z) {
            if (!this.b) {
                this.b = true;
                m.this.a.n();
                if (m.this.b != null) {
                    m.this.b.onPanelClosed(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
                }
                this.b = false;
            }
        }

        public boolean a(h hVar) {
            if (m.this.b == null) {
                return false;
            }
            m.this.b.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
            return true;
        }
    }

    private final class b implements h.a {
        b() {
        }

        public void a(h hVar) {
            if (m.this.b == null) {
                return;
            }
            if (m.this.a.i()) {
                m.this.b.onPanelClosed(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
            } else if (m.this.b.onPreparePanel(0, (View) null, hVar)) {
                m.this.b.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
            }
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return false;
        }
    }

    private Menu h() {
        if (!this.c) {
            this.a.a((o.a) new a(), (h.a) new b());
            this.c = true;
        }
        return this.a.q();
    }

    public int a() {
        return this.a.o();
    }

    public void a(float f2) {
        p.a((View) this.a.a(), f2);
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public void a(boolean z) {
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu h = h();
        if (h == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        h.setQwertyMode(z);
        return h.performShortcut(i, keyEvent, 0);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    public Context b() {
        return this.a.b();
    }

    public void c(boolean z) {
    }

    public boolean c() {
        return this.a.k();
    }

    public void d(boolean z) {
    }

    public boolean d() {
        return this.a.l();
    }

    public void e(boolean z) {
        if (z != this.d) {
            this.d = z;
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                this.e.get(i).a(z);
            }
        }
    }

    public boolean e() {
        this.a.a().removeCallbacks(this.f);
        p.a((View) this.a.a(), this.f);
        return true;
    }

    public boolean f() {
        if (!this.a.c()) {
            return false;
        }
        this.a.d();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.a.a().removeCallbacks(this.f);
    }
}
