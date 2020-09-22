package android.support.v7.widget;

import android.support.v4.g.p;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

class az implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static az i;
    private static az j;
    private final View a;
    private final CharSequence b;
    private final Runnable c = new Runnable() {
        public void run() {
            az.this.a(false);
        }
    };
    private final Runnable d = new Runnable() {
        public void run() {
            az.this.a();
        }
    };
    private int e;
    private int f;
    private ba g;
    private boolean h;

    private az(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.a.setOnLongClickListener(this);
        this.a.setOnHoverListener(this);
    }

    /* access modifiers changed from: private */
    public void a() {
        if (j == this) {
            j = null;
            if (this.g != null) {
                this.g.a();
                this.g = null;
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (i == this) {
            b((az) null);
        }
        this.a.removeCallbacks(this.d);
    }

    public static void a(View view, CharSequence charSequence) {
        if (i != null && i.a == view) {
            b((az) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (j != null && j.a == view) {
                j.a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new az(view, charSequence);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        long j2;
        if (p.m(this.a)) {
            b((az) null);
            if (j != null) {
                j.a();
            }
            j = this;
            this.h = z;
            this.g = new ba(this.a.getContext());
            this.g.a(this.a, this.e, this.f, this.h, this.b);
            this.a.addOnAttachStateChangeListener(this);
            if (this.h) {
                j2 = 2500;
            } else {
                j2 = ((p.f(this.a) & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.a.removeCallbacks(this.d);
            this.a.postDelayed(this.d, j2);
        }
    }

    private void b() {
        this.a.postDelayed(this.c, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void b(az azVar) {
        if (i != null) {
            i.c();
        }
        i = azVar;
        if (i != null) {
            i.b();
        }
    }

    private void c() {
        this.a.removeCallbacks(this.c);
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.g != null && this.h) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                a();
            }
        } else if (this.a.isEnabled() && this.g == null) {
            this.e = (int) motionEvent.getX();
            this.f = (int) motionEvent.getY();
            b(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.e = view.getWidth() / 2;
        this.f = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
