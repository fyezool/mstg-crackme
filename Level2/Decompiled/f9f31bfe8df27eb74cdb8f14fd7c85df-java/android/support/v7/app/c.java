package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.a;
import android.support.v4.app.aa;
import android.support.v4.app.h;
import android.support.v4.app.v;
import android.support.v7.view.b;
import android.support.v7.widget.bb;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class c extends h implements aa.a, d {
    private e m;
    private int n = 0;
    private Resources o;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r2 = getWindow();
     */
    private boolean a(int i, KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && window != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    public b a(b.a aVar) {
        return null;
    }

    public void a(aa aaVar) {
        aaVar.a((Activity) this);
    }

    public void a(b bVar) {
    }

    public boolean a(Intent intent) {
        return v.a((Activity) this, intent);
    }

    public Intent a_() {
        return v.a(this);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j().b(view, layoutParams);
    }

    public void b(Intent intent) {
        v.b((Activity) this, intent);
    }

    public void b(aa aaVar) {
    }

    public void b(b bVar) {
    }

    public void closeOptionsMenu() {
        a g = g();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (g == null || !g.d()) {
            super.closeOptionsMenu();
        }
    }

    public void d() {
        j().f();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a g = g();
        if (keyCode != 82 || g == null || !g.a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i) {
        return j().a(i);
    }

    public a g() {
        return j().a();
    }

    public MenuInflater getMenuInflater() {
        return j().b();
    }

    public Resources getResources() {
        if (this.o == null && bb.a()) {
            this.o = new bb(this, super.getResources());
        }
        return this.o == null ? super.getResources() : this.o;
    }

    public boolean h() {
        Intent a_ = a_();
        if (a_ == null) {
            return false;
        }
        if (a(a_)) {
            aa a = aa.a((Context) this);
            a(a);
            b(a);
            a.a();
            try {
                a.a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            b(a_);
            return true;
        }
    }

    @Deprecated
    public void i() {
    }

    public void invalidateOptionsMenu() {
        j().f();
    }

    public e j() {
        if (this.m == null) {
            this.m = e.a((Activity) this, (d) this);
        }
        return this.m;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j().a(configuration);
        if (this.o != null) {
            this.o.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        i();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        e j = j();
        j.h();
        j.a(bundle);
        if (j.i() && this.n != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.n, false);
            } else {
                setTheme(this.n);
            }
        }
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        j().g();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a g = g();
        if (menuItem.getItemId() != 16908332 || g == null || (g.a() & 4) == 0) {
            return false;
        }
        return h();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        j().b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        j().e();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j().c(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        j().c();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        j().d();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        j().a(charSequence);
    }

    public void openOptionsMenu() {
        a g = g();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (g == null || !g.c()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i) {
        j().b(i);
    }

    public void setContentView(View view) {
        j().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j().a(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.n = i;
    }
}
