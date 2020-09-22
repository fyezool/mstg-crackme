package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class at extends ContextWrapper {
    private static final Object a = new Object();
    private static ArrayList<WeakReference<at>> b;
    private final Resources c;
    private final Resources.Theme d;

    private at(Context context) {
        super(context);
        if (bb.a()) {
            this.c = new bb(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
            return;
        }
        this.c = new av(this, context.getResources());
        this.d = null;
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (a) {
            if (b == null) {
                b = new ArrayList<>();
            } else {
                for (int size = b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        b.remove(size);
                    }
                }
                for (int size2 = b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = b.get(size2);
                    at atVar = weakReference2 != null ? (at) weakReference2.get() : null;
                    if (atVar != null && atVar.getBaseContext() == context) {
                        return atVar;
                    }
                }
            }
            at atVar2 = new at(context);
            b.add(new WeakReference(atVar2));
            return atVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof at) || (context.getResources() instanceof av) || (context.getResources() instanceof bb)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || bb.a();
    }

    public AssetManager getAssets() {
        return this.c.getAssets();
    }

    public Resources getResources() {
        return this.c;
    }

    public Resources.Theme getTheme() {
        return this.d == null ? super.getTheme() : this.d;
    }

    public void setTheme(int i) {
        if (this.d == null) {
            super.setTheme(i);
        } else {
            this.d.applyStyle(i, true);
        }
    }
}
