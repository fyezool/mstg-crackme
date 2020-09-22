package android.arch.lifecycle;

import android.arch.a.b.b;
import android.arch.lifecycle.c;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class f extends c {
    private android.arch.a.b.a<d, a> a = new android.arch.a.b.a<>();
    private c.b b;
    private final WeakReference<e> c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<c.b> g = new ArrayList<>();

    static class a {
        c.b a;
        GenericLifecycleObserver b;

        a(d dVar, c.b bVar) {
            this.b = h.a((Object) dVar);
            this.a = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(e eVar, c.a aVar) {
            c.b b2 = f.b(aVar);
            this.a = f.a(this.a, b2);
            this.b.a(eVar, aVar);
            this.a = b2;
        }
    }

    public f(e eVar) {
        this.c = new WeakReference<>(eVar);
        this.b = c.b.INITIALIZED;
    }

    static c.b a(c.b bVar, c.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void a(e eVar) {
        b<K, V>.d c2 = this.a.c();
        while (c2.hasNext() && !this.f) {
            Map.Entry entry = (Map.Entry) c2.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.b) < 0 && !this.f && this.a.c(entry.getKey())) {
                c(aVar.a);
                aVar.a(eVar, e(aVar.a));
                c();
            }
        }
    }

    static c.b b(c.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return c.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return c.b.STARTED;
            case ON_RESUME:
                return c.b.RESUMED;
            case ON_DESTROY:
                return c.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void b(c.b bVar) {
        if (this.b != bVar) {
            this.b = bVar;
            if (this.e || this.d != 0) {
                this.f = true;
                return;
            }
            this.e = true;
            d();
            this.e = false;
        }
    }

    private void b(e eVar) {
        Iterator<Map.Entry<d, a>> b2 = this.a.b();
        while (b2.hasNext() && !this.f) {
            Map.Entry next = b2.next();
            a aVar = (a) next.getValue();
            while (aVar.a.compareTo(this.b) > 0 && !this.f && this.a.c(next.getKey())) {
                c.a d2 = d(aVar.a);
                c(b(d2));
                aVar.a(eVar, d2);
                c();
            }
        }
    }

    private boolean b() {
        if (this.a.a() == 0) {
            return true;
        }
        c.b bVar = this.a.d().getValue().a;
        c.b bVar2 = this.a.e().getValue().a;
        return bVar == bVar2 && this.b == bVar2;
    }

    private c.b c(d dVar) {
        Map.Entry<d, a> d2 = this.a.d(dVar);
        c.b bVar = null;
        c.b bVar2 = d2 != null ? d2.getValue().a : null;
        if (!this.g.isEmpty()) {
            bVar = this.g.get(this.g.size() - 1);
        }
        return a(a(this.b, bVar2), bVar);
    }

    private void c() {
        this.g.remove(this.g.size() - 1);
    }

    private void c(c.b bVar) {
        this.g.add(bVar);
    }

    private static c.a d(c.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return c.a.ON_DESTROY;
            case STARTED:
                return c.a.ON_STOP;
            case RESUMED:
                return c.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void d() {
        e eVar = (e) this.c.get();
        if (eVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.b.compareTo(this.a.d().getValue().a) < 0) {
                b(eVar);
            }
            Map.Entry<d, a> e2 = this.a.e();
            if (!this.f && e2 != null && this.b.compareTo(e2.getValue().a) > 0) {
                a(eVar);
            }
        }
        this.f = false;
    }

    private static c.a e(c.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return c.a.ON_CREATE;
            case CREATED:
                return c.a.ON_START;
            case STARTED:
                return c.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    public c.b a() {
        return this.b;
    }

    public void a(c.a aVar) {
        b(b(aVar));
    }

    public void a(c.b bVar) {
        b(bVar);
    }

    public void a(d dVar) {
        e eVar;
        a aVar = new a(dVar, this.b == c.b.DESTROYED ? c.b.DESTROYED : c.b.INITIALIZED);
        if (this.a.a(dVar, aVar) == null && (eVar = (e) this.c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            c.b c2 = c(dVar);
            this.d++;
            while (aVar.a.compareTo(c2) < 0 && this.a.c(dVar)) {
                c(aVar.a);
                aVar.a(eVar, e(aVar.a));
                c();
                c2 = c(dVar);
            }
            if (!z) {
                d();
            }
            this.d--;
        }
    }

    public void b(d dVar) {
        this.a.b(dVar);
    }
}
