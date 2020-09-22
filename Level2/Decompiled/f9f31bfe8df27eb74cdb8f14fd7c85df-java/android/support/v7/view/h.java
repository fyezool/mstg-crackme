package android.support.v7.view;

import android.support.v4.g.s;
import android.support.v4.g.t;
import android.support.v4.g.u;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
    final ArrayList<s> a = new ArrayList<>();
    t b;
    private long c = -1;
    private Interpolator d;
    private boolean e;
    private final u f = new u() {
        private boolean b = false;
        private int c = 0;

        /* access modifiers changed from: package-private */
        public void a() {
            this.c = 0;
            this.b = false;
            h.this.b();
        }

        public void a(View view) {
            if (!this.b) {
                this.b = true;
                if (h.this.b != null) {
                    h.this.b.a((View) null);
                }
            }
        }

        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == h.this.a.size()) {
                if (h.this.b != null) {
                    h.this.b.b((View) null);
                }
                a();
            }
        }
    };

    public h a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public h a(s sVar) {
        if (!this.e) {
            this.a.add(sVar);
        }
        return this;
    }

    public h a(s sVar, s sVar2) {
        this.a.add(sVar);
        sVar2.b(sVar.a());
        this.a.add(sVar2);
        return this;
    }

    public h a(t tVar) {
        if (!this.e) {
            this.b = tVar;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator<s> it = this.a.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (this.c >= 0) {
                    next.a(this.c);
                }
                if (this.d != null) {
                    next.a(this.d);
                }
                if (this.b != null) {
                    next.a((t) this.f);
                }
                next.c();
            }
            this.e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator<s> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }
}
