package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.g.c;
import android.support.v7.a.a;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h implements android.support.v4.c.a.a {
    private static final int[] d = {1, 4, 5, 3, 2, 0};
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private a i;
    private ArrayList<j> j;
    private ArrayList<j> k;
    private boolean l;
    private ArrayList<j> m;
    private ArrayList<j> n;
    private boolean o;
    private int p = 0;
    private ContextMenu.ContextMenuInfo q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<j> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<o>> x = new CopyOnWriteArrayList<>();
    private j y;
    private boolean z;

    public interface a {
        void a(h hVar);

        boolean a(h hVar, MenuItem menuItem);
    }

    public interface b {
        boolean a(j jVar);
    }

    public h(Context context) {
        this.e = context;
        this.f = context.getResources();
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.l = true;
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = true;
        e(true);
    }

    private static int a(ArrayList<j> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    private j a(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new j(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources d2 = d();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (i2 > 0) {
                this.a = d2.getText(i2);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (i3 > 0) {
                this.b = android.support.v4.a.a.a(e(), i3);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        b(false);
    }

    private void a(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.j.size()) {
            this.j.remove(i2);
            if (z2) {
                b(true);
            }
        }
    }

    private boolean a(u uVar, o oVar) {
        boolean z2 = false;
        if (this.x.isEmpty()) {
            return false;
        }
        if (oVar != null) {
            z2 = oVar.a(uVar);
        }
        Iterator<WeakReference<o>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            o oVar2 = (o) next.get();
            if (oVar2 == null) {
                this.x.remove(next);
            } else if (!z2) {
                z2 = oVar2.a(uVar);
            }
        }
        return z2;
    }

    private void d(boolean z2) {
        if (!this.x.isEmpty()) {
            g();
            Iterator<WeakReference<o>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                o oVar = (o) next.get();
                if (oVar == null) {
                    this.x.remove(next);
                } else {
                    oVar.b(z2);
                }
            }
            h();
        }
    }

    private void e(boolean z2) {
        boolean z3 = true;
        if (!z2 || this.f.getConfiguration().keyboard == 1 || !this.f.getBoolean(a.b.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z3 = false;
        }
        this.h = z3;
    }

    private static int f(int i2) {
        int i3 = (-65536 & i2) >> 16;
        if (i3 < 0 || i3 >= d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (i2 & 65535) | (d[i3] << 16);
    }

    public int a(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.j.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public h a(int i2) {
        this.p = i2;
        return this;
    }

    /* access modifiers changed from: protected */
    public h a(Drawable drawable) {
        a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public h a(View view) {
        a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* access modifiers changed from: protected */
    public h a(CharSequence charSequence) {
        a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: package-private */
    public j a(int i2, KeyEvent keyEvent) {
        ArrayList<j> arrayList = this.w;
        arrayList.clear();
        a((List<j>) arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean b2 = b();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = arrayList.get(i3);
            char alphabeticShortcut = b2 ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (b2 && alphabeticShortcut == 8 && i2 == 67))) {
                return jVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int f2 = f(i4);
        j a2 = a(i2, i3, i4, f2, charSequence, this.p);
        if (this.q != null) {
            a2.a(this.q);
        }
        this.j.add(a(this.j, f2), a2);
        b(true);
        return a2;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "android:menu:actionviewstates";
    }

    public void a(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((u) item.getSubMenu()).a(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar) {
        this.l = true;
        b(true);
    }

    public void a(o oVar) {
        a(oVar, this.e);
    }

    public void a(o oVar, Context context) {
        this.x.add(new WeakReference(oVar));
        oVar.a(context, this);
        this.o = true;
    }

    /* access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        g();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.j.get(i2);
            if (jVar.getGroupId() == groupId && jVar.g() && jVar.isCheckable()) {
                jVar.b(jVar == menuItem);
            }
        }
        h();
    }

    /* access modifiers changed from: package-private */
    public void a(List<j> list, int i2, KeyEvent keyEvent) {
        boolean b2 = b();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.j.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar = this.j.get(i3);
                if (jVar.hasSubMenu()) {
                    ((h) jVar.getSubMenu()).a(list, i2, keyEvent);
                }
                char alphabeticShortcut = b2 ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
                if (((modifiers & 69647) == ((b2 ? jVar.getAlphabeticModifiers() : jVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b2 && alphabeticShortcut == 8 && i2 == 67)) && jVar.isEnabled())) {
                    list.add(jVar);
                }
            }
        }
    }

    public final void a(boolean z2) {
        if (!this.v) {
            this.v = true;
            Iterator<WeakReference<o>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                o oVar = (o) next.get();
                if (oVar == null) {
                    this.x.remove(next);
                } else {
                    oVar.a(this, z2);
                }
            }
            this.v = false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(h hVar, MenuItem menuItem) {
        return this.i != null && this.i.a(hVar, menuItem);
    }

    public boolean a(MenuItem menuItem, int i2) {
        return a(menuItem, (o) null, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if ((r9 & 1) == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        if (r1 == false) goto L_0x002d;
     */
    public boolean a(MenuItem menuItem, o oVar, int i2) {
        j jVar = (j) menuItem;
        if (jVar == null || !jVar.isEnabled()) {
            return false;
        }
        boolean b2 = jVar.b();
        c a2 = jVar.a();
        boolean z2 = a2 != null && a2.e();
        if (jVar.n()) {
            b2 |= jVar.expandActionView();
        } else if (jVar.hasSubMenu() || z2) {
            if ((i2 & 4) == 0) {
                a(false);
            }
            if (!jVar.hasSubMenu()) {
                jVar.a(new u(e(), this, jVar));
            }
            u uVar = (u) jVar.getSubMenu();
            if (z2) {
                a2.a((SubMenu) uVar);
            }
            b2 |= a(uVar, oVar);
        }
        a(true);
        return b2;
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f.getString(i2));
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f.getString(i5));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f.getString(i2));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.f.getString(i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        j jVar = (j) a(i2, i3, i4, charSequence);
        u uVar = new u(this.e, this, jVar);
        jVar.a(uVar);
        return uVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.j.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void b(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((u) item.getSubMenu()).b(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(j jVar) {
        this.o = true;
        b(true);
    }

    public void b(o oVar) {
        Iterator<WeakReference<o>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            o oVar2 = (o) next.get();
            if (oVar2 == null || oVar2 == oVar) {
                this.x.remove(next);
            }
        }
    }

    public void b(boolean z2) {
        if (!this.r) {
            if (z2) {
                this.l = true;
                this.o = true;
            }
            d(z2);
            return;
        }
        this.s = true;
        if (z2) {
            this.t = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.g;
    }

    public int c(int i2) {
        return a(i2, 0);
    }

    public void c(boolean z2) {
        this.z = z2;
    }

    public boolean c() {
        return this.h;
    }

    public boolean c(j jVar) {
        boolean z2 = false;
        if (this.x.isEmpty()) {
            return false;
        }
        g();
        Iterator<WeakReference<o>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            o oVar = (o) next.get();
            if (oVar == null) {
                this.x.remove(next);
            } else {
                z2 = oVar.a(this, jVar);
                if (z2) {
                    break;
                }
            }
        }
        h();
        if (z2) {
            this.y = jVar;
        }
        return z2;
    }

    public void clear() {
        if (this.y != null) {
            d(this.y);
        }
        this.j.clear();
        b(true);
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        b(false);
    }

    public void close() {
        a(true);
    }

    /* access modifiers changed from: package-private */
    public Resources d() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public h d(int i2) {
        a(i2, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public boolean d(j jVar) {
        boolean z2 = false;
        if (!this.x.isEmpty() && this.y == jVar) {
            g();
            Iterator<WeakReference<o>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                o oVar = (o) next.get();
                if (oVar == null) {
                    this.x.remove(next);
                } else {
                    z2 = oVar.b(this, jVar);
                    if (z2) {
                        break;
                    }
                }
            }
            h();
            if (z2) {
                this.y = null;
            }
        }
        return z2;
    }

    public Context e() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public h e(int i2) {
        a(0, (CharSequence) null, i2, (Drawable) null, (View) null);
        return this;
    }

    public void f() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.j.get(i3);
            if (jVar.getItemId() == i2) {
                return jVar;
            }
            if (jVar.hasSubMenu() && (findItem = jVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public void g() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public MenuItem getItem(int i2) {
        return this.j.get(i2);
    }

    public void h() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.j.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<j> i() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.j.get(i2);
            if (jVar.isVisible()) {
                this.k.add(jVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public void j() {
        ArrayList<j> i2 = i();
        if (this.o) {
            Iterator<WeakReference<o>> it = this.x.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                o oVar = (o) next.get();
                if (oVar == null) {
                    this.x.remove(next);
                } else {
                    z2 |= oVar.b();
                }
            }
            if (z2) {
                this.m.clear();
                this.n.clear();
                int size = i2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    j jVar = i2.get(i3);
                    (jVar.j() ? this.m : this.n).add(jVar);
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(i());
            }
            this.o = false;
        }
    }

    public ArrayList<j> k() {
        j();
        return this.m;
    }

    public ArrayList<j> l() {
        j();
        return this.n;
    }

    public CharSequence m() {
        return this.a;
    }

    public Drawable n() {
        return this.b;
    }

    public View o() {
        return this.c;
    }

    public h p() {
        return this;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        j a2 = a(i2, keyEvent);
        boolean a3 = a2 != null ? a((MenuItem) a2, i3) : false;
        if ((i3 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.u;
    }

    public j r() {
        return this.y;
    }

    public void removeGroup(int i2) {
        int c2 = c(i2);
        if (c2 >= 0) {
            int size = this.j.size() - c2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.j.get(c2).getGroupId() != i2) {
                    b(true);
                } else {
                    a(c2, false);
                    i3 = i4;
                }
            }
            b(true);
        }
    }

    public void removeItem(int i2) {
        a(b(i2), true);
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.j.size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.j.get(i3);
            if (jVar.getGroupId() == i2) {
                jVar.a(z3);
                jVar.setCheckable(z2);
            }
        }
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.j.size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.j.get(i3);
            if (jVar.getGroupId() == i2) {
                jVar.setEnabled(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.j.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.j.get(i3);
            if (jVar.getGroupId() == i2 && jVar.c(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            b(true);
        }
    }

    public void setQwertyMode(boolean z2) {
        this.g = z2;
        b(false);
    }

    public int size() {
        return this.j.size();
    }
}
