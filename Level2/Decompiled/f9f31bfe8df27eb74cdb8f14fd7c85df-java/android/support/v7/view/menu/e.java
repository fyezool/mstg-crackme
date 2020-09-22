package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.g.d;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.support.v7.view.menu.o;
import android.support.v7.widget.al;
import android.support.v7.widget.am;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

final class e extends m implements o, View.OnKeyListener, PopupWindow.OnDismissListener {
    final Handler a;
    final List<a> b = new ArrayList();
    View c;
    boolean d;
    private final Context e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final List<h> j = new ArrayList();
    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener k = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (e.this.d() && e.this.b.size() > 0 && !e.this.b.get(0).a.g()) {
                View view = e.this.c;
                if (view == null || !view.isShown()) {
                    e.this.c();
                    return;
                }
                for (a aVar : e.this.b) {
                    aVar.a.a();
                }
            }
        }
    };
    private final View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (e.this.y != null) {
                if (!e.this.y.isAlive()) {
                    ViewTreeObserver unused = e.this.y = view.getViewTreeObserver();
                }
                e.this.y.removeGlobalOnLayoutListener(e.this.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final al m = new al() {
        public void a(h hVar, MenuItem menuItem) {
            e.this.a.removeCallbacksAndMessages(hVar);
        }

        public void b(final h hVar, final MenuItem menuItem) {
            final a aVar = null;
            e.this.a.removeCallbacksAndMessages((Object) null);
            int size = e.this.b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (hVar == e.this.b.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < e.this.b.size()) {
                    aVar = e.this.b.get(i2);
                }
                e.this.a.postAtTime(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            e.this.d = true;
                            aVar.b.a(false);
                            e.this.d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hVar.a(menuItem, 4);
                        }
                    }
                }, hVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int n = 0;
    private int o = 0;
    private View p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private o.a x;
    /* access modifiers changed from: private */
    public ViewTreeObserver y;
    private PopupWindow.OnDismissListener z;

    private static class a {
        public final am a;
        public final h b;
        public final int c;

        public a(am amVar, h hVar, int i) {
            this.a = amVar;
            this.b = hVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.e();
        }
    }

    public e(Context context, View view, int i2, int i3, boolean z2) {
        this.e = context;
        this.p = view;
        this.g = i2;
        this.h = i3;
        this.i = z2;
        this.v = false;
        this.q = i();
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    private MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = hVar.getItem(i2);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, h hVar) {
        int i2;
        g gVar;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.b, hVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            i2 = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (a2 == gVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private void c(h hVar) {
        View view;
        a aVar;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.e);
        g gVar = new g(hVar, from, this.i);
        if (!d() && this.v) {
            gVar.a(true);
        } else if (d()) {
            gVar.a(m.b(hVar));
        }
        int a2 = a(gVar, (ViewGroup) null, this.e, this.f);
        am h2 = h();
        h2.a((ListAdapter) gVar);
        h2.g(a2);
        h2.e(this.o);
        if (this.b.size() > 0) {
            aVar = this.b.get(this.b.size() - 1);
            view = a(aVar, hVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            h2.c(false);
            h2.a((Object) null);
            int d2 = d(a2);
            boolean z2 = d2 == 1;
            this.q = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                h2.b(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) != 5) {
                if (z2) {
                    a2 = view.getWidth();
                }
                i4 = i2 - a2;
                h2.c(i4);
                h2.b(true);
                h2.d(i3);
            } else if (!z2) {
                a2 = view.getWidth();
                i4 = i2 - a2;
                h2.c(i4);
                h2.b(true);
                h2.d(i3);
            }
            i4 = i2 + a2;
            h2.c(i4);
            h2.b(true);
            h2.d(i3);
        } else {
            if (this.r) {
                h2.c(this.t);
            }
            if (this.s) {
                h2.d(this.u);
            }
            h2.a(g());
        }
        this.b.add(new a(h2, hVar, this.q));
        h2.a();
        ListView e2 = h2.e();
        e2.setOnKeyListener(this);
        if (aVar == null && this.w && hVar.m() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(a.g.abc_popup_menu_header_item_layout, e2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(hVar.m());
            e2.addHeaderView(frameLayout, (Object) null, false);
            h2.a();
        }
    }

    private int d(int i2) {
        ListView a2 = this.b.get(this.b.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.c.getWindowVisibleDisplayFrame(rect);
        return this.q == 1 ? (iArr[0] + a2.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private int d(h hVar) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (hVar == this.b.get(i2).b) {
                return i2;
            }
        }
        return -1;
    }

    private am h() {
        am amVar = new am(this.e, (AttributeSet) null, this.g, this.h);
        amVar.a(this.m);
        amVar.a((AdapterView.OnItemClickListener) this);
        amVar.a((PopupWindow.OnDismissListener) this);
        amVar.b(this.p);
        amVar.e(this.o);
        amVar.a(true);
        amVar.h(2);
        return amVar;
    }

    private int i() {
        return p.b(this.p) == 1 ? 0 : 1;
    }

    public void a() {
        if (!d()) {
            for (h c2 : this.j) {
                c(c2);
            }
            this.j.clear();
            this.c = this.p;
            if (this.c != null) {
                boolean z2 = this.y == null;
                this.y = this.c.getViewTreeObserver();
                if (z2) {
                    this.y.addOnGlobalLayoutListener(this.k);
                }
                this.c.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    public void a(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.o = d.a(i2, p.b(this.p));
        }
    }

    public void a(h hVar) {
        hVar.a((o) this, this.e);
        if (d()) {
            c(hVar);
        } else {
            this.j.add(hVar);
        }
    }

    public void a(h hVar, boolean z2) {
        int d2 = d(hVar);
        if (d2 >= 0) {
            int i2 = d2 + 1;
            if (i2 < this.b.size()) {
                this.b.get(i2).b.a(false);
            }
            a remove = this.b.remove(d2);
            remove.b.b((o) this);
            if (this.d) {
                remove.a.b((Object) null);
                remove.a.b(0);
            }
            remove.a.c();
            int size = this.b.size();
            this.q = size > 0 ? this.b.get(size - 1).c : i();
            if (size == 0) {
                c();
                if (this.x != null) {
                    this.x.a(hVar, true);
                }
                if (this.y != null) {
                    if (this.y.isAlive()) {
                        this.y.removeGlobalOnLayoutListener(this.k);
                    }
                    this.y = null;
                }
                this.c.removeOnAttachStateChangeListener(this.l);
                this.z.onDismiss();
            } else if (z2) {
                this.b.get(0).b.a(false);
            }
        }
    }

    public void a(o.a aVar) {
        this.x = aVar;
    }

    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = d.a(this.n, p.b(this.p));
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    public void a(boolean z2) {
        this.v = z2;
    }

    public boolean a(u uVar) {
        for (a next : this.b) {
            if (uVar == next.b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        a((h) uVar);
        if (this.x != null) {
            this.x.a(uVar);
        }
        return true;
    }

    public void b(int i2) {
        this.r = true;
        this.t = i2;
    }

    public void b(boolean z2) {
        for (a a2 : this.b) {
            a(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public void c() {
        int size = this.b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.b.toArray(new a[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = aVarArr[i2];
                if (aVar.a.d()) {
                    aVar.a.c();
                }
            }
        }
    }

    public void c(int i2) {
        this.s = true;
        this.u = i2;
    }

    public void c(boolean z2) {
        this.w = z2;
    }

    public boolean d() {
        return this.b.size() > 0 && this.b.get(0).a.d();
    }

    public ListView e() {
        if (this.b.isEmpty()) {
            return null;
        }
        return this.b.get(this.b.size() - 1).a();
    }

    /* access modifiers changed from: protected */
    public boolean f() {
        return false;
    }

    public void onDismiss() {
        a aVar;
        int size = this.b.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = this.b.get(i2);
            if (!aVar.a.d()) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            aVar.b.a(false);
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        c();
        return true;
    }
}
