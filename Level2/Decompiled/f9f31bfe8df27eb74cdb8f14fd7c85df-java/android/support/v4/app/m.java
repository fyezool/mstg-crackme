package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.g;
import android.support.v4.app.l;
import android.support.v4.f.i;
import android.support.v4.g.p;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class m extends l implements LayoutInflater.Factory2 {
    static final Interpolator F = new DecelerateInterpolator(2.5f);
    static final Interpolator G = new DecelerateInterpolator(1.5f);
    static final Interpolator H = new AccelerateInterpolator(2.5f);
    static final Interpolator I = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static Field q;
    Bundle A = null;
    SparseArray<Parcelable> B = null;
    ArrayList<h> C;
    n D;
    Runnable E = new Runnable() {
        public void run() {
            m.this.e();
        }
    };
    private final CopyOnWriteArrayList<i<l.a, Boolean>> J = new CopyOnWriteArrayList<>();
    ArrayList<g> b;
    boolean c;
    int d = 0;
    final ArrayList<g> e = new ArrayList<>();
    SparseArray<g> f;
    ArrayList<c> g;
    ArrayList<g> h;
    ArrayList<c> i;
    ArrayList<Integer> j;
    ArrayList<l.b> k;
    int l = 0;
    k m;
    i n;
    g o;
    g p;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    ArrayList<c> x;
    ArrayList<Boolean> y;
    ArrayList<g> z;

    private static class a extends b {
        View a;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (p.m(this.a) || Build.VERSION.SDK_INT >= 24) {
                this.a.post(new Runnable() {
                    public void run() {
                        a.this.a.setLayerType(0, (Paint) null);
                    }
                });
            } else {
                this.a.setLayerType(0, (Paint) null);
            }
            super.onAnimationEnd(animation);
        }
    }

    private static class b implements Animation.AnimationListener {
        private final Animation.AnimationListener a;

        private b(Animation.AnimationListener animationListener) {
            this.a = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationStart(animation);
            }
        }
    }

    private static class c {
        public final Animation a;
        public final Animator b;

        private c(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        private c(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static class d extends AnimatorListenerAdapter {
        View a;

        d(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.setLayerType(0, (Paint) null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.a.setLayerType(2, (Paint) null);
        }
    }

    private static class e extends AnimationSet implements Runnable {
        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean d;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.a = viewGroup;
            this.b = view;
            addAnimation(animation);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                w.a(this.a, this);
            }
            return true;
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                w.a(this.a, this);
            }
            return true;
        }

        public void run() {
            this.a.endViewTransition(this.b);
            this.d = true;
        }
    }

    static class f {
        public static final int[] a = {16842755, 16842960, 16842961};
    }

    interface g {
        boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2);
    }

    static class h implements g.c {
        /* access modifiers changed from: private */
        public final boolean a;
        /* access modifiers changed from: private */
        public final c b;
        private int c;

        h(c cVar, boolean z) {
            this.a = z;
            this.b = cVar;
        }

        public void a() {
            this.c--;
            if (this.c == 0) {
                this.b.a.y();
            }
        }

        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            boolean z = this.c > 0;
            m mVar = this.b.a;
            int size = mVar.e.size();
            for (int i = 0; i < size; i++) {
                g gVar = mVar.e.get(i);
                gVar.a((g.c) null);
                if (z && gVar.W()) {
                    gVar.C();
                }
            }
            this.b.a.a(this.b, this.a, !z, true);
        }

        public void e() {
            this.b.a.a(this.b, this.a, false, false);
        }
    }

    m() {
    }

    private void A() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private void B() {
        int size = this.f == null ? 0 : this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g valueAt = this.f.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.T() != null) {
                    int V = valueAt.V();
                    View T = valueAt.T();
                    Animation animation = T.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        T.clearAnimation();
                    }
                    valueAt.a((View) null);
                    a(valueAt, V, 0, 0, false);
                } else if (valueAt.U() != null) {
                    valueAt.U().end();
                }
            }
        }
    }

    private void C() {
        if (this.f != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    this.f.delete(this.f.keyAt(size));
                }
            }
        }
    }

    private int a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, android.support.v4.f.b<g> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            c cVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (cVar.c() && !cVar.a(arrayList, i5 + 1, i3)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                h hVar = new h(cVar, booleanValue);
                this.C.add(hVar);
                cVar.a((g.c) hVar);
                if (booleanValue) {
                    cVar.b();
                } else {
                    cVar.a(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, cVar);
                }
                b(bVar);
            }
        }
        return i4;
    }

    static c a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220);
        return new c((Animation) alphaAnimation);
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new c((Animation) animationSet);
    }

    private static Animation.AnimationListener a(Animation animation) {
        String str;
        String str2;
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (Animation.AnimationListener) q.get(animation);
        } catch (NoSuchFieldException e2) {
            e = e2;
            str2 = "FragmentManager";
            str = "No field with the name mListener is found in Animation class";
            Log.e(str2, str, e);
            return null;
        } catch (IllegalAccessException e3) {
            e = e3;
            str2 = "FragmentManager";
            str = "Cannot access Animation's mListener field";
            Log.e(str2, str, e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(c cVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            cVar.a(z4);
        } else {
            cVar.b();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(cVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            r.a(this, (ArrayList<c>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z4) {
            a(this.l, true);
        }
        if (this.f != null) {
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                g valueAt = this.f.valueAt(i2);
                if (valueAt != null && valueAt.J != null && valueAt.P && cVar.b(valueAt.z)) {
                    if (valueAt.R > 0.0f) {
                        valueAt.J.setAlpha(valueAt.R);
                    }
                    if (z4) {
                        valueAt.R = 0.0f;
                    } else {
                        valueAt.R = -1.0f;
                        valueAt.P = false;
                    }
                }
            }
        }
    }

    private void a(final g gVar, c cVar, int i2) {
        final View view = gVar.J;
        final ViewGroup viewGroup = gVar.I;
        viewGroup.startViewTransition(view);
        gVar.b(i2);
        if (cVar.a != null) {
            e eVar = new e(cVar.a, viewGroup, view);
            gVar.a(gVar.J);
            eVar.setAnimationListener(new b(a((Animation) eVar)) {
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() {
                        public void run() {
                            if (gVar.T() != null) {
                                gVar.a((View) null);
                                m.this.a(gVar, gVar.V(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            b(view, cVar);
            gVar.J.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.b;
        gVar.a(cVar.b);
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator U = gVar.U();
                gVar.a((Animator) null);
                if (U != null && viewGroup.indexOfChild(view) < 0) {
                    m.this.a(gVar, gVar.V(), 0, 0, false);
                }
            }
        });
        animator.setTarget(gVar.J);
        b(gVar.J, cVar);
        animator.start();
    }

    private static void a(n nVar) {
        if (nVar != null) {
            List<g> a2 = nVar.a();
            if (a2 != null) {
                for (g gVar : a2) {
                    gVar.E = true;
                }
            }
            List<n> b2 = nVar.b();
            if (b2 != null) {
                for (n a3 : b2) {
                    a(a3);
                }
            }
        }
    }

    private void a(android.support.v4.f.b<g> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            g b2 = bVar.b(i2);
            if (!b2.l) {
                View k2 = b2.k();
                b2.R = k2.getAlpha();
                k2.setAlpha(0.0f);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new android.support.v4.f.e("FragmentManager"));
        if (this.m != null) {
            try {
                this.m.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    private void a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        int size = this.C == null ? 0 : this.C.size();
        int i2 = 0;
        while (i2 < size) {
            h hVar = this.C.get(i2);
            if (arrayList == null || hVar.a || (indexOf2 = arrayList.indexOf(hVar.b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (hVar.c() || (arrayList != null && hVar.b.a(arrayList, 0, arrayList.size()))) {
                    this.C.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || hVar.a || (indexOf = arrayList.indexOf(hVar.b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        hVar.d();
                    }
                }
                i2++;
            }
            hVar.e();
            i2++;
        }
    }

    private void a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        ArrayList<c> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i2;
        int i6 = i3;
        boolean z2 = arrayList3.get(i5).t;
        if (this.z == null) {
            this.z = new ArrayList<>();
        } else {
            this.z.clear();
        }
        this.z.addAll(this.e);
        g v2 = v();
        boolean z3 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            c cVar = arrayList3.get(i7);
            v2 = !arrayList4.get(i7).booleanValue() ? cVar.a(this.z, v2) : cVar.b(this.z, v2);
            z3 = z3 || cVar.i;
        }
        this.z.clear();
        if (!z2) {
            r.a(this, arrayList, arrayList2, i2, i3, false);
        }
        b(arrayList, arrayList2, i2, i3);
        if (z2) {
            android.support.v4.f.b bVar = new android.support.v4.f.b();
            b((android.support.v4.f.b<g>) bVar);
            int a2 = a(arrayList, arrayList2, i2, i3, (android.support.v4.f.b<g>) bVar);
            a((android.support.v4.f.b<g>) bVar);
            i4 = a2;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z2) {
            r.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.l, true);
        }
        while (i5 < i6) {
            c cVar2 = arrayList3.get(i5);
            if (arrayList4.get(i5).booleanValue() && cVar2.m >= 0) {
                c(cVar2.m);
                cVar2.m = -1;
            }
            cVar2.a();
            i5++;
        }
        if (z3) {
            g();
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (a(childAnimations.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(c cVar) {
        if (cVar.a instanceof AlphaAnimation) {
            return true;
        }
        if (!(cVar.a instanceof AnimationSet)) {
            return a(cVar.b);
        }
        List<Animation> animations = ((AnimationSet) cVar.a).getAnimations();
        for (int i2 = 0; i2 < animations.size(); i2++) {
            if (animations.get(i2) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean a(View view, c cVar) {
        return view != null && cVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && p.h(view) && a(cVar);
    }

    private boolean a(String str, int i2, int i3) {
        l j2;
        e();
        c(true);
        if (this.p != null && i2 < 0 && str == null && (j2 = this.p.j()) != null && j2.a()) {
            return true;
        }
        boolean a2 = a(this.x, this.y, str, i2, i3);
        if (a2) {
            this.c = true;
            try {
                b(this.x, this.y);
            } finally {
                z();
            }
        }
        f();
        C();
        return a2;
    }

    public static int b(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? 1 : 2;
        }
        if (i2 == 4099) {
            return z2 ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? 3 : 4;
    }

    private void b(android.support.v4.f.b<g> bVar) {
        if (this.l >= 1) {
            int min = Math.min(this.l, 4);
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = this.e.get(i2);
                if (gVar.b < min) {
                    a(gVar, min, gVar.O(), gVar.P(), false);
                    if (gVar.J != null && !gVar.B && gVar.P) {
                        bVar.add(gVar);
                    }
                }
            }
        }
    }

    private static void b(View view, c cVar) {
        if (view != null && cVar != null && a(view, cVar)) {
            if (cVar.b != null) {
                cVar.b.addListener(new d(view));
                return;
            }
            Animation.AnimationListener a2 = a(cVar.a);
            view.setLayerType(2, (Paint) null);
            cVar.a.setAnimationListener(new a(view, a2));
        }
    }

    private void b(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).t) {
                    if (i3 != i2) {
                        a(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).t) {
                            i3++;
                        }
                    }
                    a(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                a(arrayList, arrayList2, i3, size);
            }
        }
    }

    private static void b(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            c cVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                cVar.a(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                cVar.a(z2);
            } else {
                cVar.a(1);
                cVar.b();
            }
            i2++;
        }
    }

    private void c(boolean z2) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.m.h().getLooper()) {
            if (!z2) {
                x();
            }
            if (this.x == null) {
                this.x = new ArrayList<>();
                this.y = new ArrayList<>();
            }
            this.c = true;
            try {
                a((ArrayList<c>) null, (ArrayList<Boolean>) null);
            } finally {
                this.c = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    private boolean c(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.b != null) {
                if (this.b.size() != 0) {
                    int size = this.b.size();
                    boolean z2 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z2 |= this.b.get(i2).a(arrayList, arrayList2);
                    }
                    this.b.clear();
                    this.m.h().removeCallbacks(this.E);
                    return z2;
                }
            }
        }
    }

    public static int d(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* JADX INFO: finally extract failed */
    private void e(int i2) {
        try {
            this.c = true;
            a(i2, false);
            this.c = false;
            e();
        } catch (Throwable th) {
            this.c = false;
            throw th;
        }
    }

    private g p(g gVar) {
        ViewGroup viewGroup = gVar.I;
        View view = gVar.J;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.e.indexOf(gVar) - 1; indexOf >= 0; indexOf--) {
                g gVar2 = this.e.get(indexOf);
                if (gVar2.I == viewGroup && gVar2.J != null) {
                    return gVar2;
                }
            }
        }
        return null;
    }

    private void x() {
        if (c()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        synchronized (this) {
            boolean z2 = false;
            boolean z3 = this.C != null && !this.C.isEmpty();
            if (this.b != null && this.b.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.m.h().removeCallbacks(this.E);
                this.m.h().post(this.E);
            }
        }
    }

    private void z() {
        this.c = false;
        this.y.clear();
        this.x.clear();
    }

    public g a(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        g gVar = this.f.get(i2);
        if (gVar == null) {
            a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        }
        return gVar;
    }

    public g a(String str) {
        if (str != null) {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                g gVar = this.e.get(size);
                if (gVar != null && str.equals(gVar.A)) {
                    return gVar;
                }
            }
        }
        if (this.f == null || str == null) {
            return null;
        }
        for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
            g valueAt = this.f.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.A)) {
                return valueAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public c a(g gVar, int i2, boolean z2, int i3) {
        int b2;
        int O = gVar.O();
        Animation a2 = gVar.a(i2, z2, O);
        if (a2 != null) {
            return new c(a2);
        }
        Animator b3 = gVar.b(i2, z2, O);
        if (b3 != null) {
            return new c(b3);
        }
        if (O != 0) {
            boolean equals = "anim".equals(this.m.g().getResources().getResourceTypeName(O));
            boolean z3 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.m.g(), O);
                    if (loadAnimation != null) {
                        return new c(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.m.g(), O);
                    if (loadAnimator != null) {
                        return new c(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.m.g(), O);
                        if (loadAnimation2 != null) {
                            return new c(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 == 0 || (b2 = b(i2, z2)) < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.m.g(), 0.0f, 1.0f);
            case 6:
                return a(this.m.g(), 1.0f, 0.0f);
            default:
                if (i3 == 0 && this.m.d()) {
                    i3 = this.m.e();
                }
                if (i3 == 0) {
                }
                return null;
        }
    }

    public void a(int i2, c cVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i2 < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + cVar);
                }
                this.i.set(i2, cVar);
            } else {
                while (size < i2) {
                    this.i.add((Object) null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + cVar);
                }
                this.i.add(cVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2) {
        if (this.m == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.l) {
            this.l = i2;
            if (this.f != null) {
                int size = this.e.size();
                for (int i3 = 0; i3 < size; i3++) {
                    e(this.e.get(i3));
                }
                int size2 = this.f.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    g valueAt = this.f.valueAt(i4);
                    if (valueAt != null && ((valueAt.m || valueAt.C) && !valueAt.P)) {
                        e(valueAt);
                    }
                }
                d();
                if (this.r && this.m != null && this.l == 5) {
                    this.m.c();
                    this.r = false;
                }
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null) {
                gVar.a(configuration);
            }
        }
    }

    public void a(Bundle bundle, String str, g gVar) {
        if (gVar.f < 0) {
            a((RuntimeException) new IllegalStateException("Fragment " + gVar + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, gVar.f);
    }

    /* access modifiers changed from: package-private */
    public void a(Parcelable parcelable, n nVar) {
        List<android.arch.lifecycle.p> list;
        List<n> list2;
        if (parcelable != null) {
            o oVar = (o) parcelable;
            if (oVar.a != null) {
                if (nVar != null) {
                    List<g> a2 = nVar.a();
                    list2 = nVar.b();
                    list = nVar.c();
                    int size = a2 != null ? a2.size() : 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        g gVar = a2.get(i2);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + gVar);
                        }
                        int i3 = 0;
                        while (i3 < oVar.a.length && oVar.a[i3].b != gVar.f) {
                            i3++;
                        }
                        if (i3 == oVar.a.length) {
                            a((RuntimeException) new IllegalStateException("Could not find active fragment with index " + gVar.f));
                        }
                        p pVar = oVar.a[i3];
                        pVar.l = gVar;
                        gVar.d = null;
                        gVar.r = 0;
                        gVar.o = false;
                        gVar.l = false;
                        gVar.i = null;
                        if (pVar.k != null) {
                            pVar.k.setClassLoader(this.m.g().getClassLoader());
                            gVar.d = pVar.k.getSparseParcelableArray("android:view_state");
                            gVar.c = pVar.k;
                        }
                    }
                } else {
                    list2 = null;
                    list = null;
                }
                this.f = new SparseArray<>(oVar.a.length);
                int i4 = 0;
                while (i4 < oVar.a.length) {
                    p pVar2 = oVar.a[i4];
                    if (pVar2 != null) {
                        g a3 = pVar2.a(this.m, this.n, this.o, (list2 == null || i4 >= list2.size()) ? null : list2.get(i4), (list == null || i4 >= list.size()) ? null : list.get(i4));
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i4 + ": " + a3);
                        }
                        this.f.put(a3.f, a3);
                        pVar2.l = null;
                    }
                    i4++;
                }
                if (nVar != null) {
                    List<g> a4 = nVar.a();
                    int size2 = a4 != null ? a4.size() : 0;
                    for (int i5 = 0; i5 < size2; i5++) {
                        g gVar2 = a4.get(i5);
                        if (gVar2.j >= 0) {
                            gVar2.i = this.f.get(gVar2.j);
                            if (gVar2.i == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + gVar2 + " target no longer exists: " + gVar2.j);
                            }
                        }
                    }
                }
                this.e.clear();
                if (oVar.b != null) {
                    int i6 = 0;
                    while (i6 < oVar.b.length) {
                        g gVar3 = this.f.get(oVar.b[i6]);
                        if (gVar3 == null) {
                            a((RuntimeException) new IllegalStateException("No instantiated fragment for index #" + oVar.b[i6]));
                        }
                        gVar3.l = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i6 + ": " + gVar3);
                        }
                        if (!this.e.contains(gVar3)) {
                            synchronized (this.e) {
                                this.e.add(gVar3);
                            }
                            i6++;
                        } else {
                            throw new IllegalStateException("Already added!");
                        }
                    }
                }
                if (oVar.c != null) {
                    this.g = new ArrayList<>(oVar.c.length);
                    for (int i7 = 0; i7 < oVar.c.length; i7++) {
                        c a5 = oVar.c[i7].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + a5.m + "): " + a5);
                            PrintWriter printWriter = new PrintWriter(new android.support.v4.f.e("FragmentManager"));
                            a5.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.g.add(a5);
                        if (a5.m >= 0) {
                            a(a5.m, a5);
                        }
                    }
                } else {
                    this.g = null;
                }
                if (oVar.d >= 0) {
                    this.p = this.f.get(oVar.d);
                }
                this.d = oVar.e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(cVar);
    }

    public void a(g gVar) {
        if (!gVar.L) {
            return;
        }
        if (this.c) {
            this.w = true;
            return;
        }
        gVar.L = false;
        a(gVar, this.l, 0, 0, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        r1 = r16.g().getResourceName(r7.z);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0214, code lost:
        r1 = "unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0246, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0328, code lost:
        if (r11 >= 4) goto L_0x034a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x032c, code lost:
        if (a == false) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x032e, code lost:
        android.util.Log.v("FragmentManager", "movefrom STARTED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0344, code lost:
        r16.J();
        e(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x034a, code lost:
        if (r11 >= 3) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x034e, code lost:
        if (a == false) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0350, code lost:
        android.util.Log.v("FragmentManager", "movefrom STOPPED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0366, code lost:
        r16.K();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0369, code lost:
        if (r11 >= 2) goto L_0x03e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x036d, code lost:
        if (a == false) goto L_0x0385;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x036f, code lost:
        android.util.Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0387, code lost:
        if (r7.J == null) goto L_0x0398;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x038f, code lost:
        if (r6.m.a(r7) == false) goto L_0x0398;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0393, code lost:
        if (r7.d != null) goto L_0x0398;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0395, code lost:
        m(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0398, code lost:
        r16.L();
        f(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03a0, code lost:
        if (r7.J == null) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03a4, code lost:
        if (r7.I == null) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03a6, code lost:
        r7.I.endViewTransition(r7.J);
        r7.J.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03b5, code lost:
        if (r6.l <= 0) goto L_0x03d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03b9, code lost:
        if (r6.u != false) goto L_0x03d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03c1, code lost:
        if (r7.J.getVisibility() != 0) goto L_0x03d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03c7, code lost:
        if (r7.R < 0.0f) goto L_0x03d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03c9, code lost:
        r0 = a(r7, r18, false, r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03d2, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03d3, code lost:
        r7.R = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03d5, code lost:
        if (r0 == null) goto L_0x03da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03d7, code lost:
        a(r7, r0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03da, code lost:
        r7.I.removeView(r7.J);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03e1, code lost:
        r7.I = null;
        r7.J = null;
        r7.K = null;
        r7.o = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03e9, code lost:
        if (r11 >= 1) goto L_0x045f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03ed, code lost:
        if (r6.u == false) goto L_0x0410;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03f3, code lost:
        if (r16.T() == null) goto L_0x0400;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03f5, code lost:
        r0 = r16.T();
        r7.a((android.view.View) null);
        r0.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0404, code lost:
        if (r16.U() == null) goto L_0x0410;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0406, code lost:
        r0 = r16.U();
        r7.a((android.animation.Animator) null);
        r0.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0414, code lost:
        if (r16.T() != null) goto L_0x045b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x041a, code lost:
        if (r16.U() == null) goto L_0x041d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x041f, code lost:
        if (a == false) goto L_0x0437;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0421, code lost:
        android.util.Log.v("FragmentManager", "movefrom CREATED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0439, code lost:
        if (r7.E != false) goto L_0x0442;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x043b, code lost:
        r16.M();
        g(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0442, code lost:
        r7.b = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0444, code lost:
        r16.N();
        h(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x044a, code lost:
        if (r20 != false) goto L_0x045f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x044e, code lost:
        if (r7.E != false) goto L_0x0454;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0450, code lost:
        g(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0454, code lost:
        r7.t = null;
        r7.x = null;
        r7.s = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x045b, code lost:
        r7.b(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01af, code lost:
        c(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b2, code lost:
        if (r11 <= 1) goto L_0x02ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b6, code lost:
        if (a == false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b8, code lost:
        android.util.Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d0, code lost:
        if (r7.n != false) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d4, code lost:
        if (r7.z == 0) goto L_0x0246;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d9, code lost:
        if (r7.z != -1) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01db, code lost:
        a((java.lang.RuntimeException) new java.lang.IllegalArgumentException("Cannot create fragment " + r7 + " for a container view with no id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01f9, code lost:
        r0 = (android.view.ViewGroup) r6.n.a(r7.z);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0203, code lost:
        if (r0 != null) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0207, code lost:
        if (r7.p != false) goto L_0x0247;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    public void a(g gVar, int i2, int i3, int i4, boolean z2) {
        int i5;
        ViewGroup viewGroup;
        String str;
        g gVar2 = gVar;
        boolean z3 = 1;
        if (!gVar2.l || gVar2.C) {
            i5 = i2;
            if (i5 > 1) {
                i5 = 1;
            }
        } else {
            i5 = i2;
        }
        if (gVar2.m && i5 > gVar2.b) {
            i5 = (gVar2.b != 0 || !gVar.b()) ? gVar2.b : 1;
        }
        int i6 = (!gVar2.L || gVar2.b >= 4 || i5 <= 3) ? i5 : 3;
        if (gVar2.b > i6) {
            if (gVar2.b > i6) {
                switch (gVar2.b) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        if (i6 < 5) {
                            if (a) {
                                Log.v("FragmentManager", "movefrom RESUMED: " + gVar2);
                            }
                            gVar.I();
                            d(gVar2, false);
                            break;
                        }
                        break;
                }
            }
        } else if (!gVar2.n || gVar2.o) {
            if (!(gVar.T() == null && gVar.U() == null)) {
                gVar2.a((View) null);
                gVar2.a((Animator) null);
                a(gVar, gVar.V(), 0, 0, true);
            }
            switch (gVar2.b) {
                case 0:
                    if (i6 > 0) {
                        if (a) {
                            Log.v("FragmentManager", "moveto CREATED: " + gVar2);
                        }
                        if (gVar2.c != null) {
                            gVar2.c.setClassLoader(this.m.g().getClassLoader());
                            gVar2.d = gVar2.c.getSparseParcelableArray("android:view_state");
                            gVar2.i = a(gVar2.c, "android:target_state");
                            if (gVar2.i != null) {
                                gVar2.k = gVar2.c.getInt("android:target_req_state", 0);
                            }
                            if (gVar2.e != null) {
                                gVar2.M = gVar2.e.booleanValue();
                                gVar2.e = null;
                            } else {
                                gVar2.M = gVar2.c.getBoolean("android:user_visible_hint", true);
                            }
                            if (!gVar2.M) {
                                gVar2.L = true;
                                if (i6 > 3) {
                                    i6 = 3;
                                }
                            }
                        }
                        gVar2.t = this.m;
                        gVar2.x = this.o;
                        gVar2.s = this.o != null ? this.o.u : this.m.i();
                        if (gVar2.i != null) {
                            if (this.f.get(gVar2.i.f) != gVar2.i) {
                                throw new IllegalStateException("Fragment " + gVar2 + " declared target fragment " + gVar2.i + " that does not belong to this FragmentManager!");
                            } else if (gVar2.i.b < 1) {
                                a(gVar2.i, 1, 0, 0, true);
                            }
                        }
                        a(gVar2, this.m.g(), false);
                        gVar2.H = false;
                        gVar2.a(this.m.g());
                        if (gVar2.H) {
                            if (gVar2.x == null) {
                                this.m.b(gVar2);
                            } else {
                                gVar2.x.a(gVar2);
                            }
                            b(gVar2, this.m.g(), false);
                            if (!gVar2.T) {
                                a(gVar2, gVar2.c, false);
                                gVar2.k(gVar2.c);
                                b(gVar2, gVar2.c, false);
                            } else {
                                gVar2.g(gVar2.c);
                                gVar2.b = 1;
                            }
                            gVar2.E = false;
                            break;
                        } else {
                            throw new y("Fragment " + gVar2 + " did not call through to super.onAttach()");
                        }
                    }
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } else {
            return;
        }
        z3 = i6;
        if (gVar2.b == z3) {
            Log.w("FragmentManager", "moveToState: Fragment state for " + gVar2 + " not updated inline; " + "expected state " + z3 + " found " + gVar2.b);
            gVar2.b = z3;
            return;
        }
        return;
        a((RuntimeException) new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(gVar2.z) + " (" + str + ") for fragment " + gVar2));
        gVar2.I = viewGroup;
        gVar2.J = gVar2.b(gVar2.d(gVar2.c), viewGroup, gVar2.c);
        if (gVar2.J != null) {
            gVar2.K = gVar2.J;
            gVar2.J.setSaveFromParentEnabled(false);
            if (viewGroup != null) {
                viewGroup.addView(gVar2.J);
            }
            if (gVar2.B) {
                gVar2.J.setVisibility(8);
            }
            gVar2.a(gVar2.J, gVar2.c);
            a(gVar2, gVar2.J, gVar2.c, false);
            if (gVar2.J.getVisibility() != 0 || gVar2.I == null) {
                z3 = 0;
            }
            gVar2.P = z3;
        } else {
            gVar2.K = null;
        }
        gVar2.l(gVar2.c);
        c(gVar2, gVar2.c, false);
        if (gVar2.J != null) {
            gVar2.a(gVar2.c);
        }
        gVar2.c = null;
        if (i6 > 2) {
            gVar2.b = 3;
        }
        if (i6 > 3) {
            if (a) {
                Log.v("FragmentManager", "moveto STARTED: " + gVar2);
            }
            gVar.E();
            b(gVar2, false);
        }
        if (i6 > 4) {
            if (a) {
                Log.v("FragmentManager", "moveto RESUMED: " + gVar2);
            }
            gVar.F();
            c(gVar2, false);
            gVar2.c = null;
            gVar2.d = null;
        }
        z3 = i6;
        if (gVar2.b == z3) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar, Context context, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).a(gVar, context, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).a((l) this, gVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar, Bundle bundle, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).a(gVar, bundle, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).a((l) this, gVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar, View view, Bundle bundle, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).a(gVar, view, bundle, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).a(this, gVar, view, bundle);
            }
        }
    }

    public void a(g gVar, boolean z2) {
        if (a) {
            Log.v("FragmentManager", "add: " + gVar);
        }
        f(gVar);
        if (gVar.C) {
            return;
        }
        if (!this.e.contains(gVar)) {
            synchronized (this.e) {
                this.e.add(gVar);
            }
            gVar.l = true;
            gVar.m = false;
            if (gVar.J == null) {
                gVar.Q = false;
            }
            if (gVar.F && gVar.G) {
                this.r = true;
            }
            if (z2) {
                b(gVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + gVar);
    }

    public void a(k kVar, i iVar, g gVar) {
        if (this.m == null) {
            this.m = kVar;
            this.n = iVar;
            this.o = gVar;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        if (this.f != null && (size5 = this.f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size5; i2++) {
                g valueAt = this.f.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size6; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.e.get(i3).toString());
            }
        }
        if (this.h != null && (size4 = this.h.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.h.get(i4).toString());
            }
        }
        if (this.g != null && (size3 = this.g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                c cVar = this.g.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(cVar.toString());
                cVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(this.i.get(i6));
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        if (this.b != null && (size = this.b.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(this.b.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
    }

    public void a(boolean z2) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            g gVar = this.e.get(size);
            if (gVar != null) {
                gVar.d(z2);
            }
        }
    }

    public boolean a() {
        x();
        return a((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return this.l >= i2;
    }

    public boolean a(Menu menu) {
        if (this.l < 1) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null && gVar.c(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.l < 1) {
            return false;
        }
        ArrayList<g> arrayList = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null && gVar.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(gVar);
                z2 = true;
            }
        }
        if (this.h != null) {
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                g gVar2 = this.h.get(i3);
                if (arrayList == null || !arrayList.contains(gVar2)) {
                    gVar2.t();
                }
            }
        }
        this.h = arrayList;
        return z2;
    }

    public boolean a(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null && gVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        if (this.g == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = this.g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                i4 = this.g.size() - 1;
                while (i4 >= 0) {
                    c cVar = this.g.get(i4);
                    if ((str != null && str.equals(cVar.d())) || (i2 >= 0 && i2 == cVar.m)) {
                        break;
                    }
                    i4--;
                }
                if (i4 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        i4--;
                        if (i4 < 0) {
                            break;
                        }
                        c cVar2 = this.g.get(i4);
                        if ((str == null || !str.equals(cVar2.d())) && (i2 < 0 || i2 != cVar2.m)) {
                            break;
                        }
                    }
                }
            } else {
                i4 = -1;
            }
            if (i4 == this.g.size() - 1) {
                return false;
            }
            for (int size2 = this.g.size() - 1; size2 > i4; size2--) {
                arrayList.add(this.g.remove(size2));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public g b(int i2) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            g gVar = this.e.get(size);
            if (gVar != null && gVar.y == i2) {
                return gVar;
            }
        }
        if (this.f == null) {
            return null;
        }
        for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
            g valueAt = this.f.valueAt(size2);
            if (valueAt != null && valueAt.y == i2) {
                return valueAt;
            }
        }
        return null;
    }

    public g b(String str) {
        g a2;
        if (this.f == null || str == null) {
            return null;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            g valueAt = this.f.valueAt(size);
            if (valueAt != null && (a2 = valueAt.a(str)) != null) {
                return a2;
            }
        }
        return null;
    }

    public List<g> b() {
        List<g> list;
        if (this.e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar) {
        a(gVar, this.l, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar, Context context, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).b(gVar, context, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).b((l) this, gVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar, Bundle bundle, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).b(gVar, bundle, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).b((l) this, gVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).b(gVar, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).a(this, gVar);
            }
        }
    }

    public void b(Menu menu) {
        if (this.l >= 1) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                g gVar = this.e.get(i2);
                if (gVar != null) {
                    gVar.d(menu);
                }
            }
        }
    }

    public void b(boolean z2) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            g gVar = this.e.get(size);
            if (gVar != null) {
                gVar.e(z2);
            }
        }
    }

    public boolean b(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null && gVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void c(int i2) {
        synchronized (this) {
            this.i.set(i2, (Object) null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.j.add(Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: package-private */
    public void c(g gVar) {
        if (gVar.n && !gVar.q) {
            gVar.J = gVar.b(gVar.d(gVar.c), (ViewGroup) null, gVar.c);
            if (gVar.J != null) {
                gVar.K = gVar.J;
                gVar.J.setSaveFromParentEnabled(false);
                if (gVar.B) {
                    gVar.J.setVisibility(8);
                }
                gVar.a(gVar.J, gVar.c);
                a(gVar, gVar.J, gVar.c, false);
                return;
            }
            gVar.K = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(g gVar, Bundle bundle, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).c(gVar, bundle, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).c(this, gVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(g gVar, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).c(gVar, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).b(this, gVar);
            }
        }
    }

    public boolean c() {
        return this.s || this.t;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.f != null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                g valueAt = this.f.valueAt(i2);
                if (valueAt != null) {
                    a(valueAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(final g gVar) {
        if (gVar.J != null) {
            c a2 = a(gVar, gVar.P(), !gVar.B, gVar.Q());
            if (a2 == null || a2.b == null) {
                if (a2 != null) {
                    b(gVar.J, a2);
                    gVar.J.startAnimation(a2.a);
                    a2.a.start();
                }
                gVar.J.setVisibility((!gVar.B || gVar.X()) ? 0 : 8);
                if (gVar.X()) {
                    gVar.f(false);
                }
            } else {
                a2.b.setTarget(gVar.J);
                if (!gVar.B) {
                    gVar.J.setVisibility(0);
                } else if (gVar.X()) {
                    gVar.f(false);
                } else {
                    final ViewGroup viewGroup = gVar.I;
                    final View view = gVar.J;
                    viewGroup.startViewTransition(view);
                    a2.b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (gVar.J != null) {
                                gVar.J.setVisibility(8);
                            }
                        }
                    });
                }
                b(gVar.J, a2);
                a2.b.start();
            }
        }
        if (gVar.l && gVar.F && gVar.G) {
            this.r = true;
        }
        gVar.Q = false;
        gVar.a(gVar.B);
    }

    /* access modifiers changed from: package-private */
    public void d(g gVar, Bundle bundle, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).d(gVar, bundle, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).d(this, gVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(g gVar, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).d(gVar, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).c(this, gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r0 = r0.J;
        r1 = r11.I;
     */
    public void e(g gVar) {
        View view;
        ViewGroup viewGroup;
        int indexOfChild;
        int indexOfChild2;
        if (gVar != null) {
            int i2 = this.l;
            if (gVar.m) {
                i2 = gVar.b() ? Math.min(i2, 1) : Math.min(i2, 0);
            }
            a(gVar, i2, gVar.P(), gVar.Q(), false);
            if (gVar.J != null) {
                g p2 = p(gVar);
                if (p2 != null && (indexOfChild2 = viewGroup.indexOfChild(gVar.J)) < (indexOfChild = viewGroup.indexOfChild(view))) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(gVar.J, indexOfChild);
                }
                if (gVar.P && gVar.I != null) {
                    if (gVar.R > 0.0f) {
                        gVar.J.setAlpha(gVar.R);
                    }
                    gVar.R = 0.0f;
                    gVar.P = false;
                    c a2 = a(gVar, gVar.P(), true, gVar.Q());
                    if (a2 != null) {
                        b(gVar.J, a2);
                        if (a2.a != null) {
                            gVar.J.startAnimation(a2.a);
                        } else {
                            a2.b.setTarget(gVar.J);
                            a2.b.start();
                        }
                    }
                }
            }
            if (gVar.Q) {
                d(gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(g gVar, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).e(gVar, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).d(this, gVar);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean e() {
        c(true);
        boolean z2 = false;
        while (c(this.x, this.y)) {
            this.c = true;
            try {
                b(this.x, this.y);
                z();
                z2 = true;
            } catch (Throwable th) {
                z();
                throw th;
            }
        }
        f();
        C();
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.w) {
            this.w = false;
            d();
        }
    }

    /* access modifiers changed from: package-private */
    public void f(g gVar) {
        if (gVar.f < 0) {
            int i2 = this.d;
            this.d = i2 + 1;
            gVar.a(i2, this.o);
            if (this.f == null) {
                this.f = new SparseArray<>();
            }
            this.f.put(gVar.f, gVar);
            if (a) {
                Log.v("FragmentManager", "Allocated fragment index " + gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(g gVar, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).f(gVar, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).e(this, gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                this.k.get(i2).a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(g gVar) {
        if (gVar.f >= 0) {
            if (a) {
                Log.v("FragmentManager", "Freeing fragment index " + gVar);
            }
            this.f.put(gVar.f, (Object) null);
            gVar.r();
        }
    }

    /* access modifiers changed from: package-private */
    public void g(g gVar, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).g(gVar, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).f(this, gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public n h() {
        a(this.D);
        return this.D;
    }

    public void h(g gVar) {
        if (a) {
            Log.v("FragmentManager", "remove: " + gVar + " nesting=" + gVar.r);
        }
        boolean z2 = !gVar.b();
        if (!gVar.C || z2) {
            synchronized (this.e) {
                this.e.remove(gVar);
            }
            if (gVar.F && gVar.G) {
                this.r = true;
            }
            gVar.l = false;
            gVar.m = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void h(g gVar, boolean z2) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).h(gVar, true);
            }
        }
        Iterator<i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).g(this, gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        n nVar;
        if (this.f != null) {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                g valueAt = this.f.valueAt(i2);
                if (valueAt != null) {
                    if (valueAt.D) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(valueAt);
                        valueAt.j = valueAt.i != null ? valueAt.i.f : -1;
                        if (a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    if (valueAt.u != null) {
                        valueAt.u.i();
                        nVar = valueAt.u.D;
                    } else {
                        nVar = valueAt.v;
                    }
                    if (arrayList2 == null && nVar != null) {
                        arrayList2 = new ArrayList(this.f.size());
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList2.add((Object) null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(nVar);
                    }
                    if (arrayList == null && valueAt.w != null) {
                        arrayList = new ArrayList(this.f.size());
                        for (int i4 = 0; i4 < i2; i4++) {
                            arrayList.add((Object) null);
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(valueAt.w);
                    }
                }
            }
        } else {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList3 == null && arrayList2 == null && arrayList == null) {
            this.D = null;
        } else {
            this.D = new n(arrayList3, arrayList2, arrayList);
        }
    }

    public void i(g gVar) {
        if (a) {
            Log.v("FragmentManager", "hide: " + gVar);
        }
        if (!gVar.B) {
            gVar.B = true;
            gVar.Q = true ^ gVar.Q;
        }
    }

    /* access modifiers changed from: package-private */
    public Parcelable j() {
        int[] iArr;
        int size;
        A();
        B();
        e();
        this.s = true;
        d[] dVarArr = null;
        this.D = null;
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size2 = this.f.size();
        p[] pVarArr = new p[size2];
        boolean z2 = false;
        for (int i2 = 0; i2 < size2; i2++) {
            g valueAt = this.f.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.f < 0) {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.f));
                }
                p pVar = new p(valueAt);
                pVarArr[i2] = pVar;
                if (valueAt.b <= 0 || pVar.k != null) {
                    pVar.k = valueAt.c;
                } else {
                    pVar.k = n(valueAt);
                    if (valueAt.i != null) {
                        if (valueAt.i.f < 0) {
                            a((RuntimeException) new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.i));
                        }
                        if (pVar.k == null) {
                            pVar.k = new Bundle();
                        }
                        a(pVar.k, "android:target_state", valueAt.i);
                        if (valueAt.k != 0) {
                            pVar.k.putInt("android:target_req_state", valueAt.k);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + valueAt + ": " + pVar.k);
                }
                z2 = true;
            }
        }
        if (!z2) {
            if (a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i3 = 0; i3 < size3; i3++) {
                iArr[i3] = this.e.get(i3).f;
                if (iArr[i3] < 0) {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + this.e.get(i3) + " has cleared index: " + iArr[i3]));
                }
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i3 + ": " + this.e.get(i3));
                }
            }
        } else {
            iArr = null;
        }
        if (this.g != null && (size = this.g.size()) > 0) {
            dVarArr = new d[size];
            for (int i4 = 0; i4 < size; i4++) {
                dVarArr[i4] = new d(this.g.get(i4));
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.g.get(i4));
                }
            }
        }
        o oVar = new o();
        oVar.a = pVarArr;
        oVar.b = iArr;
        oVar.c = dVarArr;
        if (this.p != null) {
            oVar.d = this.p.f;
        }
        oVar.e = this.d;
        i();
        return oVar;
    }

    public void j(g gVar) {
        if (a) {
            Log.v("FragmentManager", "show: " + gVar);
        }
        if (gVar.B) {
            gVar.B = false;
            gVar.Q = !gVar.Q;
        }
    }

    public void k() {
        this.D = null;
        this.s = false;
        this.t = false;
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null) {
                gVar.G();
            }
        }
    }

    public void k(g gVar) {
        if (a) {
            Log.v("FragmentManager", "detach: " + gVar);
        }
        if (!gVar.C) {
            gVar.C = true;
            if (gVar.l) {
                if (a) {
                    Log.v("FragmentManager", "remove from detach: " + gVar);
                }
                synchronized (this.e) {
                    this.e.remove(gVar);
                }
                if (gVar.F && gVar.G) {
                    this.r = true;
                }
                gVar.l = false;
            }
        }
    }

    public void l() {
        this.s = false;
        this.t = false;
        e(1);
    }

    public void l(g gVar) {
        if (a) {
            Log.v("FragmentManager", "attach: " + gVar);
        }
        if (gVar.C) {
            gVar.C = false;
            if (gVar.l) {
                return;
            }
            if (!this.e.contains(gVar)) {
                if (a) {
                    Log.v("FragmentManager", "add from attach: " + gVar);
                }
                synchronized (this.e) {
                    this.e.add(gVar);
                }
                gVar.l = true;
                if (gVar.F && gVar.G) {
                    this.r = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + gVar);
        }
    }

    public void m() {
        this.s = false;
        this.t = false;
        e(2);
    }

    /* access modifiers changed from: package-private */
    public void m(g gVar) {
        if (gVar.K != null) {
            if (this.B == null) {
                this.B = new SparseArray<>();
            } else {
                this.B.clear();
            }
            gVar.K.saveHierarchyState(this.B);
            if (this.B.size() > 0) {
                gVar.d = this.B;
                this.B = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle n(g gVar) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        gVar.m(this.A);
        d(gVar, this.A, false);
        if (!this.A.isEmpty()) {
            bundle = this.A;
            this.A = null;
        } else {
            bundle = null;
        }
        if (gVar.J != null) {
            m(gVar);
        }
        if (gVar.d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", gVar.d);
        }
        if (!gVar.M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", gVar.M);
        }
        return bundle;
    }

    public void n() {
        this.s = false;
        this.t = false;
        e(4);
    }

    public void o() {
        this.s = false;
        this.t = false;
        e(5);
    }

    public void o(g gVar) {
        if (gVar == null || (this.f.get(gVar.f) == gVar && (gVar.t == null || gVar.h() == this))) {
            this.p = gVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + gVar + " is not an active fragment of FragmentManager " + this);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        g gVar;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, f.a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!g.a(this.m.g(), str3)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str3);
        }
        g b2 = resourceId != -1 ? b(resourceId) : null;
        if (b2 == null && string != null) {
            b2 = a(string);
        }
        if (b2 == null && i2 != -1) {
            b2 = b(i2);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str3 + " existing=" + b2);
        }
        if (b2 == null) {
            g a2 = this.n.a(context2, str3, (Bundle) null);
            a2.n = true;
            a2.y = resourceId != 0 ? resourceId : i2;
            a2.z = i2;
            a2.A = string;
            a2.o = true;
            a2.s = this;
            a2.t = this.m;
            a2.a(this.m.g(), attributeSet2, a2.c);
            a(a2, true);
            gVar = a2;
        } else if (!b2.o) {
            b2.o = true;
            b2.t = this.m;
            if (!b2.E) {
                b2.a(this.m.g(), attributeSet2, b2.c);
            }
            gVar = b2;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + str3);
        }
        if (this.l >= 1 || !gVar.n) {
            b(gVar);
        } else {
            a(gVar, 1, 0, 0, false);
        }
        if (gVar.J != null) {
            if (resourceId != 0) {
                gVar.J.setId(resourceId);
            }
            if (gVar.J.getTag() == null) {
                gVar.J.setTag(string);
            }
            return gVar.J;
        }
        throw new IllegalStateException("Fragment " + str3 + " did not create a view.");
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public void p() {
        e(4);
    }

    public void q() {
        this.t = true;
        e(3);
    }

    public void r() {
        e(2);
    }

    public void s() {
        e(1);
    }

    public void t() {
        this.u = true;
        e();
        e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.f.d.a(this.o != null ? this.o : this.m, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void u() {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null) {
                gVar.H();
            }
        }
    }

    public g v() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 w() {
        return this;
    }
}
