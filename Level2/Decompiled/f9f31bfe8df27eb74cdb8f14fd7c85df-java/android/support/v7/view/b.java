package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class b {
    private Object a;
    private boolean b;

    public interface a {
        void a(b bVar);

        boolean a(b bVar, Menu menu);

        boolean a(b bVar, MenuItem menuItem);

        boolean b(b bVar, Menu menu);
    }

    public abstract MenuInflater a();

    public abstract void a(int i);

    public abstract void a(View view);

    public abstract void a(CharSequence charSequence);

    public void a(Object obj) {
        this.a = obj;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public abstract Menu b();

    public abstract void b(int i);

    public abstract void b(CharSequence charSequence);

    public abstract void c();

    public abstract void d();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public boolean h() {
        return false;
    }

    public abstract View i();

    public Object j() {
        return this.a;
    }

    public boolean k() {
        return this.b;
    }
}
