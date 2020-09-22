package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.f;
import android.support.v7.view.b;
import android.support.v7.view.f;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;

class h extends j {
    private int t = -100;
    private boolean u;
    private boolean v = true;
    private b w;

    class a extends f.a {
        a(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(h.this.a, callback);
            android.support.v7.view.b b = h.this.b((b.a) aVar);
            if (b != null) {
                return aVar.b(b);
            }
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return h.this.o() ? a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    final class b {
        private o b;
        private boolean c;
        private BroadcastReceiver d;
        private IntentFilter e;

        b(o oVar) {
            this.b = oVar;
            this.c = oVar.a();
        }

        /* access modifiers changed from: package-private */
        public final int a() {
            this.c = this.b.a();
            return this.c ? 2 : 1;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            boolean a2 = this.b.a();
            if (a2 != this.c) {
                this.c = a2;
                h.this.i();
            }
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            d();
            if (this.d == null) {
                this.d = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        b.this.b();
                    }
                };
            }
            if (this.e == null) {
                this.e = new IntentFilter();
                this.e.addAction("android.intent.action.TIME_SET");
                this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.e.addAction("android.intent.action.TIME_TICK");
            }
            h.this.a.registerReceiver(this.d, this.e);
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            if (this.d != null) {
                h.this.a.unregisterReceiver(this.d);
                this.d = null;
            }
        }
    }

    h(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    private boolean h(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (y()) {
            ((Activity) this.a).recreate();
            return true;
        }
        Configuration configuration2 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, displayMetrics);
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        l.a(resources);
        return true;
    }

    private int w() {
        return this.t != -100 ? this.t : j();
    }

    private void x() {
        if (this.w == null) {
            this.w = new b(o.a(this.a));
        }
    }

    private boolean y() {
        if (!this.u || !(this.a instanceof Activity)) {
            return false;
        }
        try {
            return (this.a.getPackageManager().getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 512) == 0;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null && this.t == -100) {
            this.t = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void c() {
        super.c();
        i();
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.t);
        }
    }

    /* access modifiers changed from: package-private */
    public int d(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        x();
        return this.w.a();
    }

    public void d() {
        super.d();
        if (this.w != null) {
            this.w.d();
        }
    }

    public void g() {
        super.g();
        if (this.w != null) {
            this.w.d();
        }
    }

    public boolean i() {
        int w2 = w();
        int d = d(w2);
        boolean h = d != -1 ? h(d) : false;
        if (w2 == 0) {
            x();
            this.w.c();
        }
        this.u = true;
        return h;
    }

    public boolean o() {
        return this.v;
    }
}
