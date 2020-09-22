package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.c;
import android.arch.lifecycle.e;
import android.arch.lifecycle.f;
import android.arch.lifecycle.m;
import android.os.Bundle;
import android.support.v4.f.k;

public class z extends Activity implements e {
    private k<Class<? extends Object>, Object> a = new k<>();
    private f b = new f(this);

    public c a() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m.a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.b.a(c.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
