package android.arch.lifecycle;

import android.arch.a.b.b;
import android.arch.lifecycle.c;
import java.util.Map;

public abstract class LiveData<T> {
    private static final Object a = new Object();
    private b<k<T>, LiveData<T>.a> b;
    /* access modifiers changed from: private */
    public int c;
    private volatile Object d;
    private int e;
    private boolean f;
    private boolean g;

    class LifecycleBoundObserver extends LiveData<T>.a implements GenericLifecycleObserver {
        final e a;

        LifecycleBoundObserver(e eVar, k<T> kVar) {
            super(kVar);
            this.a = eVar;
        }

        public void a(e eVar, c.a aVar) {
            if (this.a.a().a() == c.b.DESTROYED) {
                LiveData.this.a(this.c);
            } else {
                a(a());
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.a.a().a().a(c.b.STARTED);
        }

        /* access modifiers changed from: package-private */
        public boolean a(e eVar) {
            return this.a == eVar;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.a.a().b(this);
        }
    }

    private abstract class a {
        final k<T> c;
        boolean d;
        int e = -1;

        a(k<T> kVar) {
            this.c = kVar;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (z != this.d) {
                this.d = z;
                int i = 1;
                boolean z2 = LiveData.this.c == 0;
                LiveData liveData = LiveData.this;
                int a = liveData.c;
                if (!this.d) {
                    i = -1;
                }
                int unused = liveData.c = a + i;
                if (z2 && this.d) {
                    LiveData.this.b();
                }
                if (LiveData.this.c == 0 && !this.d) {
                    LiveData.this.c();
                }
                if (this.d) {
                    LiveData.this.b(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a();

        /* access modifiers changed from: package-private */
        public boolean a(e eVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }
    }

    private void a(LiveData<T>.a aVar) {
        if (aVar.d) {
            if (!aVar.a()) {
                aVar.a(false);
            } else if (aVar.e < this.e) {
                aVar.e = this.e;
                aVar.c.a(this.d);
            }
        }
    }

    private static void a(String str) {
        if (!android.arch.a.a.a.a().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }

    /* access modifiers changed from: private */
    public void b(LiveData<T>.a aVar) {
        if (this.f) {
            this.g = true;
            return;
        }
        this.f = true;
        do {
            this.g = false;
            if (aVar == null) {
                b<K, V>.d c2 = this.b.c();
                while (c2.hasNext()) {
                    a((LiveData<T>.a) (a) ((Map.Entry) c2.next()).getValue());
                    if (this.g) {
                        break;
                    }
                }
            } else {
                a(aVar);
                aVar = null;
            }
        } while (this.g);
        this.f = false;
    }

    public T a() {
        T t = this.d;
        if (t != a) {
            return t;
        }
        return null;
    }

    public void a(e eVar, k<T> kVar) {
        if (eVar.a().a() != c.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(eVar, kVar);
            a a2 = this.b.a(kVar, lifecycleBoundObserver);
            if (a2 != null && !a2.a(eVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (a2 == null) {
                eVar.a().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(k<T> kVar) {
        a("removeObserver");
        a b2 = this.b.b(kVar);
        if (b2 != null) {
            b2.b();
            b2.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public boolean d() {
        return this.c > 0;
    }
}
