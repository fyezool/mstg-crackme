package android.arch.lifecycle;

import java.util.HashMap;

public class p {
    private final HashMap<String, n> a = new HashMap<>();

    public final void a() {
        for (n a2 : this.a.values()) {
            a2.a();
        }
        this.a.clear();
    }
}
