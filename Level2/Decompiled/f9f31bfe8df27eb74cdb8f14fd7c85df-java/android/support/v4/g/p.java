package android.support.v4.g;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class p {
    static final j a = (Build.VERSION.SDK_INT >= 26 ? new i() : Build.VERSION.SDK_INT >= 24 ? new h() : Build.VERSION.SDK_INT >= 23 ? new g() : Build.VERSION.SDK_INT >= 21 ? new f() : Build.VERSION.SDK_INT >= 19 ? new e() : Build.VERSION.SDK_INT >= 18 ? new d() : Build.VERSION.SDK_INT >= 17 ? new c() : Build.VERSION.SDK_INT >= 16 ? new b() : Build.VERSION.SDK_INT >= 15 ? new a() : new j());

    static class a extends j {
        a() {
        }

        public boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class b extends a {
        b() {
        }

        public void a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public void a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public void b(View view) {
            view.postInvalidateOnAnimation();
        }

        public int c(View view) {
            return view.getMinimumHeight();
        }

        public void d(View view) {
            view.requestFitSystemWindows();
        }

        public boolean e(View view) {
            return view.hasOverlappingRendering();
        }
    }

    static class c extends b {
        c() {
        }

        public int f(View view) {
            return view.getLayoutDirection();
        }

        public int g(View view) {
            return view.getWindowSystemUiVisibility();
        }
    }

    static class d extends c {
        d() {
        }
    }

    static class e extends d {
        e() {
        }

        public boolean h(View view) {
            return view.isLaidOut();
        }

        public boolean i(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class f extends e {
        f() {
        }

        public w a(View view, w wVar) {
            WindowInsets windowInsets = (WindowInsets) w.a(wVar);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (onApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(onApplyWindowInsets);
            }
            return w.a((Object) windowInsets);
        }

        public void a(View view, float f) {
            view.setElevation(f);
        }

        public void a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public void a(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public void a(View view, final n nVar) {
            if (nVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) w.a(nVar.a(view, w.a((Object) windowInsets)));
                    }
                });
            }
        }

        public void a(View view, String str) {
            view.setTransitionName(str);
        }

        public void d(View view) {
            view.requestApplyInsets();
        }

        public String j(View view) {
            return view.getTransitionName();
        }

        public void k(View view) {
            view.stopNestedScroll();
        }

        public ColorStateList l(View view) {
            return view.getBackgroundTintList();
        }

        public PorterDuff.Mode m(View view) {
            return view.getBackgroundTintMode();
        }
    }

    static class g extends f {
        g() {
        }

        public void a(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    static class h extends g {
        h() {
        }
    }

    static class i extends h {
        i() {
        }
    }

    static class j {
        static boolean b = false;
        private static Field c;
        private static boolean d;
        private static WeakHashMap<View, String> e;
        private static final AtomicInteger f = new AtomicInteger(1);
        WeakHashMap<View, s> a = null;

        j() {
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return ValueAnimator.getFrameDelay();
        }

        public w a(View view, w wVar) {
            return wVar;
        }

        public void a(View view, float f2) {
        }

        public void a(View view, int i, int i2) {
        }

        public void a(View view, ColorStateList colorStateList) {
            if (view instanceof o) {
                ((o) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        public void a(View view, PorterDuff.Mode mode) {
            if (view instanceof o) {
                ((o) view).setSupportBackgroundTintMode(mode);
            }
        }

        public void a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public void a(View view, b bVar) {
            view.setAccessibilityDelegate(bVar == null ? null : bVar.a());
        }

        public void a(View view, n nVar) {
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        public void a(View view, String str) {
            if (e == null) {
                e = new WeakHashMap<>();
            }
            e.put(view, str);
        }

        public boolean a(View view) {
            return false;
        }

        public void b(View view) {
            view.postInvalidate();
        }

        public int c(View view) {
            if (!d) {
                try {
                    c = View.class.getDeclaredField("mMinHeight");
                    c.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                d = true;
            }
            if (c == null) {
                return 0;
            }
            try {
                return ((Integer) c.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }

        public void d(View view) {
        }

        public boolean e(View view) {
            return true;
        }

        public int f(View view) {
            return 0;
        }

        public int g(View view) {
            return 0;
        }

        public boolean h(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public boolean i(View view) {
            return view.getWindowToken() != null;
        }

        public String j(View view) {
            if (e == null) {
                return null;
            }
            return e.get(view);
        }

        public void k(View view) {
            if (view instanceof h) {
                ((h) view).stopNestedScroll();
            }
        }

        public ColorStateList l(View view) {
            if (view instanceof o) {
                return ((o) view).getSupportBackgroundTintList();
            }
            return null;
        }

        public PorterDuff.Mode m(View view) {
            if (view instanceof o) {
                return ((o) view).getSupportBackgroundTintMode();
            }
            return null;
        }

        public s n(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap<>();
            }
            s sVar = this.a.get(view);
            if (sVar != null) {
                return sVar;
            }
            s sVar2 = new s(view);
            this.a.put(view, sVar2);
            return sVar2;
        }
    }

    public static w a(View view, w wVar) {
        return a.a(view, wVar);
    }

    public static void a(View view) {
        a.b(view);
    }

    public static void a(View view, float f2) {
        a.a(view, f2);
    }

    public static void a(View view, int i2, int i3) {
        a.a(view, i2, i3);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static void a(View view, PorterDuff.Mode mode) {
        a.a(view, mode);
    }

    public static void a(View view, Drawable drawable) {
        a.a(view, drawable);
    }

    public static void a(View view, b bVar) {
        a.a(view, bVar);
    }

    public static void a(View view, n nVar) {
        a.a(view, nVar);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j2) {
        a.a(view, runnable, j2);
    }

    public static void a(View view, String str) {
        a.a(view, str);
    }

    public static int b(View view) {
        return a.f(view);
    }

    public static int c(View view) {
        return a.c(view);
    }

    public static s d(View view) {
        return a.n(view);
    }

    public static String e(View view) {
        return a.j(view);
    }

    public static int f(View view) {
        return a.g(view);
    }

    public static void g(View view) {
        a.d(view);
    }

    public static boolean h(View view) {
        return a.e(view);
    }

    public static ColorStateList i(View view) {
        return a.l(view);
    }

    public static PorterDuff.Mode j(View view) {
        return a.m(view);
    }

    public static void k(View view) {
        a.k(view);
    }

    public static boolean l(View view) {
        return a.h(view);
    }

    public static boolean m(View view) {
        return a.i(view);
    }

    public static boolean n(View view) {
        return a.a(view);
    }
}
