package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b implements o {
    protected Context a;
    protected Context b;
    protected h c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected p f;
    private o.a g;
    private int h;
    private int i;
    private int j;

    public b(Context context, int i2, int i3) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.h = i2;
        this.i = i3;
    }

    public o.a a() {
        return this.g;
    }

    public p a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (p) this.d.inflate(this.h, viewGroup, false);
            this.f.a(this.c);
            b(true);
        }
        return this.f;
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        p.a b2 = view instanceof p.a ? (p.a) view : b(viewGroup);
        a(jVar, b2);
        return (View) b2;
    }

    public void a(int i2) {
        this.j = i2;
    }

    public void a(Context context, h hVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = hVar;
    }

    public void a(h hVar, boolean z) {
        if (this.g != null) {
            this.g.a(hVar, z);
        }
    }

    public abstract void a(j jVar, p.a aVar);

    public void a(o.a aVar) {
        this.g = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i2);
    }

    public boolean a(int i2, j jVar) {
        return true;
    }

    public boolean a(h hVar, j jVar) {
        return false;
    }

    public boolean a(u uVar) {
        if (this.g != null) {
            return this.g.a(uVar);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public p.a b(ViewGroup viewGroup) {
        return (p.a) this.d.inflate(this.i, viewGroup, false);
    }

    public void b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup != null) {
            int i2 = 0;
            if (this.c != null) {
                this.c.j();
                ArrayList<j> i3 = this.c.i();
                int size = i3.size();
                int i4 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    j jVar = i3.get(i5);
                    if (a(i4, jVar)) {
                        View childAt = viewGroup.getChildAt(i4);
                        j itemData = childAt instanceof p.a ? ((p.a) childAt).getItemData() : null;
                        View a2 = a(jVar, childAt, viewGroup);
                        if (jVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            a(a2, i4);
                        }
                        i4++;
                    }
                }
                i2 = i4;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!a(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    public boolean b() {
        return false;
    }

    public boolean b(h hVar, j jVar) {
        return false;
    }
}
