package android.support.v7.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.support.v7.a.a;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class f implements o, AdapterView.OnItemClickListener {
    Context a;
    LayoutInflater b;
    h c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private o.a i;

    private class a extends BaseAdapter {
        private int b = -1;

        public a() {
            a();
        }

        /* renamed from: a */
        public j getItem(int i) {
            ArrayList<j> l = f.this.c.l();
            int i2 = i + f.this.e;
            if (this.b >= 0 && i2 >= this.b) {
                i2++;
            }
            return l.get(i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            j r = f.this.c.r();
            if (r != null) {
                ArrayList<j> l = f.this.c.l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (l.get(i) == r) {
                        this.b = i;
                        return;
                    }
                }
            }
            this.b = -1;
        }

        public int getCount() {
            int size = f.this.c.l().size() - f.this.e;
            return this.b < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = f.this.b.inflate(f.this.g, viewGroup, false);
            }
            ((p.a) view).a(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public f(int i2, int i3) {
        this.g = i2;
        this.f = i3;
    }

    public f(Context context, int i2) {
        this(i2, 0);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public p a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.d.setAdapter(this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r2.b == null) goto L_0x000d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    public void a(Context context, h hVar) {
        if (this.f != 0) {
            this.a = new ContextThemeWrapper(context, this.f);
        } else {
            if (this.a != null) {
                this.a = context;
            }
            this.c = hVar;
            if (this.h == null) {
                this.h.notifyDataSetChanged();
                return;
            }
            return;
        }
        this.b = LayoutInflater.from(this.a);
        this.c = hVar;
        if (this.h == null) {
        }
    }

    public void a(h hVar, boolean z) {
        if (this.i != null) {
            this.i.a(hVar, z);
        }
    }

    public void a(o.a aVar) {
        this.i = aVar;
    }

    public boolean a(h hVar, j jVar) {
        return false;
    }

    public boolean a(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        new i(uVar).a((IBinder) null);
        if (this.i == null) {
            return true;
        }
        this.i.a(uVar);
        return true;
    }

    public void b(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public boolean b(h hVar, j jVar) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        this.c.a((MenuItem) this.h.getItem(i2), (o) this, 0);
    }
}
