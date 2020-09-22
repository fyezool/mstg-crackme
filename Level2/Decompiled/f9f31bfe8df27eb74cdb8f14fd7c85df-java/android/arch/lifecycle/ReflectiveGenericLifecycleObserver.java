package android.arch.lifecycle;

import android.arch.lifecycle.a;
import android.arch.lifecycle.c;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    private final Object a;
    private final a.C0001a b = a.a.b(this.a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
    }

    public void a(e eVar, c.a aVar) {
        this.b.a(eVar, aVar, this.a);
    }
}
