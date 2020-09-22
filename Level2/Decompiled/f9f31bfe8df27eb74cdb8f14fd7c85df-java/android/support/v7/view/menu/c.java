package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.c.a.b;
import android.support.v4.f.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class c<T> extends d<T> {
    final Context a;
    private Map<b, MenuItem> c;
    private Map<android.support.v4.c.a.c, SubMenu> d;

    c(Context context, T t) {
        super(t);
        this.a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.c == null) {
            this.c = new a();
        }
        MenuItem menuItem2 = this.c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem a2 = q.a(this.a, bVar);
        this.c.put(bVar, a2);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.c.a.c)) {
            return subMenu;
        }
        android.support.v4.c.a.c cVar = (android.support.v4.c.a.c) subMenu;
        if (this.d == null) {
            this.d = new a();
        }
        SubMenu subMenu2 = this.d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu a2 = q.a(this.a, cVar);
        this.d.put(cVar, a2);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        if (this.c != null) {
            Iterator<b> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i) {
        if (this.c != null) {
            Iterator<b> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
