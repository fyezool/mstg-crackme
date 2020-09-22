package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.a.a;
import android.view.LayoutInflater;

public class d extends ContextWrapper {
    private int a;
    private Resources.Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public d() {
        super((Context) null);
    }

    public d(Context context, int i) {
        super(context);
        this.a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }

    private Resources b() {
        Resources resources;
        if (this.e == null) {
            if (this.d == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(this.d).getResources();
            }
            this.e = resources;
        }
        return this.e;
    }

    private void c() {
        boolean z = this.b == null;
        if (z) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        a(this.b, this.a, z);
    }

    public int a() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    public Resources.Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = a.i.Theme_AppCompat_Light;
        }
        c();
        return this.b;
    }

    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            c();
        }
    }
}
