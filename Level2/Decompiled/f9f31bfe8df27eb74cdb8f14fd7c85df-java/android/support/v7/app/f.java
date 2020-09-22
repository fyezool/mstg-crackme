package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.widget.aw;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import java.lang.Thread;

abstract class f extends e {
    private static boolean m = true;
    private static final boolean n = (Build.VERSION.SDK_INT < 21);
    private static final int[] o = {16842836};
    final Context a;
    final Window b;
    final Window.Callback c = this.b.getCallback();
    final Window.Callback d;
    final d e;
    a f;
    MenuInflater g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private CharSequence p;
    private boolean q;
    private boolean r;

    class a extends i {
        a(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.a(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            h hVar = menu instanceof h ? (h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar != null) {
                hVar.c(false);
            }
            return onPreparePanel;
        }
    }

    static {
        if (n && !m) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                private boolean a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }

                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    f(Context context, Window window, d dVar) {
        this.a = context;
        this.b = window;
        this.e = dVar;
        if (!(this.c instanceof a)) {
            this.d = a(this.c);
            this.b.setCallback(this.d);
            aw a2 = aw.a(context, (AttributeSet) null, o);
            Drawable b2 = a2.b(0);
            if (b2 != null) {
                this.b.setBackgroundDrawable(b2);
            }
            a2.a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public a a() {
        l();
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public abstract b a(b.a aVar);

    /* access modifiers changed from: package-private */
    public Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(int i2, Menu menu);

    public final void a(CharSequence charSequence) {
        this.p = charSequence;
        b(charSequence);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(int i2, KeyEvent keyEvent);

    /* access modifiers changed from: package-private */
    public abstract boolean a(KeyEvent keyEvent);

    public MenuInflater b() {
        if (this.g == null) {
            l();
            this.g = new g(this.f != null ? this.f.b() : this.a);
        }
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public abstract void b(CharSequence charSequence);

    /* access modifiers changed from: package-private */
    public abstract boolean b(int i2, Menu menu);

    public void c() {
        this.q = true;
    }

    public void c(Bundle bundle) {
    }

    public void d() {
        this.q = false;
    }

    public void g() {
        this.r = true;
    }

    public boolean i() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract void l();

    /* access modifiers changed from: package-private */
    public final a m() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public final Context n() {
        a a2 = a();
        Context b2 = a2 != null ? a2.b() : null;
        return b2 == null ? this.a : b2;
    }

    public boolean o() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean p() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback q() {
        return this.b.getCallback();
    }

    /* access modifiers changed from: package-private */
    public final CharSequence r() {
        return this.c instanceof Activity ? ((Activity) this.c).getTitle() : this.p;
    }
}
