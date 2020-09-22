package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.g.p;
import android.support.v4.widget.j;
import android.support.v7.a.a;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class ak implements s {
    private static Method a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    ag c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ak.this.m();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            if (ak.this.d()) {
                ak.this.a();
            }
        }

        public void onInvalidated() {
            ak.this.c();
        }
    }

    private class c implements AbsListView.OnScrollListener {
        c() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ak.this.n() && ak.this.g.getContentView() != null) {
                ak.this.f.removeCallbacks(ak.this.e);
                ak.this.e.run();
            }
        }
    }

    private class d implements View.OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ak.this.g != null && ak.this.g.isShowing() && x >= 0 && x < ak.this.g.getWidth() && y >= 0 && y < ak.this.g.getHeight()) {
                ak.this.f.postDelayed(ak.this.e, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ak.this.f.removeCallbacks(ak.this.e);
                return false;
            }
        }
    }

    private class e implements Runnable {
        e() {
        }

        public void run() {
            if (ak.this.c != null && p.m(ak.this.c) && ak.this.c.getCount() > ak.this.c.getChildCount() && ak.this.c.getChildCount() <= ak.this.d) {
                ak.this.g.setInputMethodMode(2);
                ak.this.a();
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        Class<PopupWindow> cls2 = PopupWindow.class;
        try {
            b = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ak(Context context) {
        this(context, (AttributeSet) null, a.C0011a.listPopupWindowStyle);
    }

    public ak(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ak(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, i2, i3);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.g = new s(context, attributeSet, i2, i3);
        this.g.setInputMethodMode(1);
    }

    private int a(View view, int i2, boolean z2) {
        if (b != null) {
            try {
                return ((Integer) b.invoke(this.g, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i2);
    }

    private void b() {
        if (this.w != null) {
            ViewParent parent = this.w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    private void c(boolean z2) {
        if (a != null) {
            try {
                a.invoke(this.g, new Object[]{Boolean.valueOf(z2)});
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: android.support.v7.widget.ag} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: android.support.v7.widget.ag} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: android.support.v7.widget.ag} */
    /* JADX WARNING: Multi-variable type inference failed */
    private int f() {
        int i2;
        int i3;
        int makeMeasureSpec;
        int i4;
        int i5;
        int i6;
        boolean z2 = true;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable() {
                public void run() {
                    View i = ak.this.i();
                    if (i != null && i.getWindowToken() != null) {
                        ak.this.a();
                    }
                }
            };
            this.c = a(context, !this.J);
            if (this.A != null) {
                this.c.setSelector(this.A);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    ag agVar;
                    if (i != -1 && (agVar = ak.this.c) != null) {
                        agVar.setListSelectionHidden(false);
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener(this.E);
            if (this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }
            ag agVar = this.c;
            View view = this.w;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view);
                        linearLayout.addView(agVar, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(agVar, layoutParams);
                        linearLayout.addView(view);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                }
                if (this.l >= 0) {
                    i6 = this.l;
                    i5 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i5 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i6, i5), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i2 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                agVar = linearLayout;
            } else {
                i2 = 0;
            }
            this.g.setContentView(agVar);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.g.getContentView();
            View view2 = this.w;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i2 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            i3 = this.H.top + this.H.bottom;
            if (!this.p) {
                this.n = -this.H.top;
            }
        } else {
            this.H.setEmpty();
            i3 = 0;
        }
        if (this.g.getInputMethodMode() != 2) {
            z2 = false;
        }
        int a2 = a(i(), this.n, z2);
        if (this.u || this.k == -1) {
            return a2 + i3;
        }
        switch (this.l) {
            case -2:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
                break;
            case -1:
                i4 = this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right);
                break;
            default:
                i4 = this.l;
                break;
        }
        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int a3 = this.c.a(makeMeasureSpec, 0, -1, a2 - i2, -1);
        if (a3 > 0) {
            i2 += i3 + this.c.getPaddingTop() + this.c.getPaddingBottom();
        }
        return a3 + i2;
    }

    /* access modifiers changed from: package-private */
    public ag a(Context context, boolean z2) {
        return new ag(context, z2);
    }

    public void a() {
        int f2 = f();
        boolean n2 = n();
        j.a(this.g, this.o);
        boolean z2 = true;
        if (!this.g.isShowing()) {
            int width = this.l == -1 ? -1 : this.l == -2 ? i().getWidth() : this.l;
            if (this.k == -1) {
                f2 = -1;
            } else if (this.k != -2) {
                f2 = this.k;
            }
            this.g.setWidth(width);
            this.g.setHeight(f2);
            c(true);
            this.g.setOutsideTouchable(!this.v && !this.u);
            this.g.setTouchInterceptor(this.D);
            if (this.s) {
                j.a(this.g, this.r);
            }
            if (h != null) {
                try {
                    h.invoke(this.g, new Object[]{this.I});
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
            j.a(this.g, i(), this.m, this.n, this.t);
            this.c.setSelection(-1);
            if (!this.J || this.c.isInTouchMode()) {
                m();
            }
            if (!this.J) {
                this.f.post(this.F);
            }
        } else if (p.m(i())) {
            int width2 = this.l == -1 ? -1 : this.l == -2 ? i().getWidth() : this.l;
            if (this.k == -1) {
                if (!n2) {
                    f2 = -1;
                }
                if (n2) {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(0);
                } else {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(-1);
                }
            } else if (this.k != -2) {
                f2 = this.k;
            }
            PopupWindow popupWindow = this.g;
            if (this.v || this.u) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.g.update(i(), this.m, this.n, width2 < 0 ? -1 : width2, f2 < 0 ? -1 : f2);
        }
    }

    public void a(int i2) {
        this.x = i2;
    }

    public void a(Rect rect) {
        this.I = rect;
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        if (this.y == null) {
            this.y = new b();
        } else if (this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        if (this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z2) {
        this.J = z2;
        this.g.setFocusable(z2);
    }

    public void b(int i2) {
        this.g.setAnimationStyle(i2);
    }

    public void b(View view) {
        this.z = view;
    }

    public void b(boolean z2) {
        this.s = true;
        this.r = z2;
    }

    public void c() {
        this.g.dismiss();
        b();
        this.g.setContentView((View) null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void c(int i2) {
        this.m = i2;
    }

    public void d(int i2) {
        this.n = i2;
        this.p = true;
    }

    public boolean d() {
        return this.g.isShowing();
    }

    public ListView e() {
        return this.c;
    }

    public void e(int i2) {
        this.t = i2;
    }

    public void f(int i2) {
        this.l = i2;
    }

    public void g(int i2) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = this.H.left + this.H.right + i2;
            return;
        }
        f(i2);
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void h(int i2) {
        this.g.setInputMethodMode(i2);
    }

    public View i() {
        return this.z;
    }

    public void i(int i2) {
        ag agVar = this.c;
        if (d() && agVar != null) {
            agVar.setListSelectionHidden(false);
            agVar.setSelection(i2);
            if (agVar.getChoiceMode() != 0) {
                agVar.setItemChecked(i2, true);
            }
        }
    }

    public int j() {
        return this.m;
    }

    public int k() {
        if (!this.p) {
            return 0;
        }
        return this.n;
    }

    public int l() {
        return this.l;
    }

    public void m() {
        ag agVar = this.c;
        if (agVar != null) {
            agVar.setListSelectionHidden(true);
            agVar.requestLayout();
        }
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }
}
