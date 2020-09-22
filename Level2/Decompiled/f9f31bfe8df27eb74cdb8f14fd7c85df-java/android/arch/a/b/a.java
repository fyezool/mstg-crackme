package android.arch.a.b;

import android.arch.a.b.b;
import java.util.HashMap;
import java.util.Map;

public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> a = new HashMap<>();

    /* access modifiers changed from: protected */
    public b.c<K, V> a(K k) {
        return this.a.get(k);
    }

    public V a(K k, V v) {
        b.c a2 = a(k);
        if (a2 != null) {
            return a2.b;
        }
        this.a.put(k, b(k, v));
        return null;
    }

    public V b(K k) {
        V b = super.b(k);
        this.a.remove(k);
        return b;
    }

    public boolean c(K k) {
        return this.a.containsKey(k);
    }

    public Map.Entry<K, V> d(K k) {
        if (c(k)) {
            return this.a.get(k).d;
        }
        return null;
    }
}
