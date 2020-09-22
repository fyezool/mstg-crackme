package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.c;
import android.support.v4.g.p;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class r {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final t b = (Build.VERSION.SDK_INT >= 21 ? new s() : null);
    private static final t c = a();

    static class a {
        public g a;
        public boolean b;
        public c c;
        public g d;
        public boolean e;
        public c f;

        a() {
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }

    private static t a() {
        try {
            return (t) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static t a(g gVar, g gVar2) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null) {
            Object w = gVar.w();
            if (w != null) {
                arrayList.add(w);
            }
            Object v = gVar.v();
            if (v != null) {
                arrayList.add(v);
            }
            Object z = gVar.z();
            if (z != null) {
                arrayList.add(z);
            }
        }
        if (gVar2 != null) {
            Object u = gVar2.u();
            if (u != null) {
                arrayList.add(u);
            }
            Object x = gVar2.x();
            if (x != null) {
                arrayList.add(x);
            }
            Object y = gVar2.y();
            if (y != null) {
                arrayList.add(y);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (b != null && a(b, (List<Object>) arrayList)) {
            return b;
        }
        if (c != null && a(c, (List<Object>) arrayList)) {
            return c;
        }
        if (b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static android.support.v4.f.a<String, String> a(int i, ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        android.support.v4.f.a<String, String> aVar = new android.support.v4.f.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            c cVar = arrayList.get(i4);
            if (cVar.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (cVar.r != null) {
                    int size = cVar.r.size();
                    if (booleanValue) {
                        arrayList3 = cVar.r;
                        arrayList4 = cVar.s;
                    } else {
                        ArrayList<String> arrayList5 = cVar.r;
                        arrayList3 = cVar.s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static Object a(t tVar, g gVar, g gVar2, boolean z) {
        if (gVar == null || gVar2 == null) {
            return null;
        }
        return tVar.c(tVar.b(z ? gVar2.z() : gVar.y()));
    }

    private static Object a(t tVar, g gVar, boolean z) {
        if (gVar == null) {
            return null;
        }
        return tVar.b(z ? gVar.x() : gVar.u());
    }

    private static Object a(t tVar, ViewGroup viewGroup, View view, android.support.v4.f.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View view2;
        t tVar2 = tVar;
        View view3 = view;
        android.support.v4.f.a<String, String> aVar3 = aVar;
        a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj4 = obj;
        g gVar = aVar4.a;
        g gVar2 = aVar4.d;
        if (gVar != null) {
            gVar.k().setVisibility(0);
        }
        if (gVar == null || gVar2 == null) {
            return null;
        }
        boolean z = aVar4.b;
        Object a2 = aVar.isEmpty() ? null : a(tVar2, gVar, gVar2, z);
        android.support.v4.f.a<String, View> b2 = b(tVar2, aVar3, a2, aVar4);
        android.support.v4.f.a<String, View> c2 = c(tVar2, aVar3, a2, aVar4);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (c2 != null) {
                c2.clear();
            }
            obj3 = null;
        } else {
            a(arrayList3, b2, (Collection<String>) aVar.keySet());
            a(arrayList4, c2, aVar.values());
            obj3 = a2;
        }
        if (obj4 == null && obj2 == null && obj3 == null) {
            return null;
        }
        b(gVar, gVar2, z, b2, true);
        if (obj3 != null) {
            arrayList4.add(view3);
            tVar2.a(obj3, view3, arrayList3);
            a(tVar, obj3, obj2, b2, aVar4.e, aVar4.f);
            Rect rect2 = new Rect();
            View b3 = b(c2, aVar4, obj4, z);
            if (b3 != null) {
                tVar2.a(obj4, rect2);
            }
            rect = rect2;
            view2 = b3;
        } else {
            view2 = null;
            rect = null;
        }
        final g gVar3 = gVar;
        final g gVar4 = gVar2;
        final boolean z2 = z;
        final android.support.v4.f.a<String, View> aVar5 = c2;
        final t tVar3 = tVar;
        w.a(viewGroup, new Runnable() {
            public void run() {
                r.b(gVar3, gVar4, z2, (android.support.v4.f.a<String, View>) aVar5, false);
                if (view2 != null) {
                    tVar3.a(view2, rect);
                }
            }
        });
        return obj3;
    }

    private static Object a(t tVar, Object obj, Object obj2, Object obj3, g gVar, boolean z) {
        return (obj == null || obj2 == null || gVar == null) ? true : z ? gVar.B() : gVar.A() ? tVar.a(obj2, obj, obj3) : tVar.b(obj2, obj, obj3);
    }

    private static String a(android.support.v4.f.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r10.l != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006b, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006d, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0078, code lost:
        r13 = r1;
        r1 = false;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0087, code lost:
        if (r10.B == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0089, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0097  */
    private static void a(c cVar, c.a aVar, SparseArray<a> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        a aVar2;
        m mVar;
        boolean z4;
        c cVar2 = cVar;
        c.a aVar3 = aVar;
        SparseArray<a> sparseArray2 = sparseArray;
        boolean z5 = z;
        g gVar = aVar3.b;
        if (gVar != null && (i = gVar.z) != 0) {
            int i2 = z5 ? a[aVar3.a] : aVar3.a;
            boolean z6 = false;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                    case 6:
                        if (z2) {
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (z2) {
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (z2) {
                            if (gVar.Q) {
                                if (!gVar.B) {
                                    break;
                                }
                            }
                        } else {
                            z4 = gVar.B;
                            break;
                        }
                        break;
                    case 7:
                        break;
                    default:
                        z3 = false;
                        break;
                }
            }
            if (z2) {
                z4 = gVar.P;
                z6 = z4;
                z3 = true;
                boolean z7 = false;
                boolean z8 = false;
                a aVar4 = sparseArray2.get(i);
                if (z6) {
                    aVar4 = a(aVar4, sparseArray2, i);
                    aVar4.a = gVar;
                    aVar4.b = z5;
                    aVar4.c = cVar2;
                }
                aVar2 = aVar4;
                if (!z2 && z3) {
                    if (aVar2 != null && aVar2.d == gVar) {
                        aVar2.d = null;
                    }
                    mVar = cVar2.a;
                    if (gVar.b < 1 && mVar.l >= 1 && !cVar2.t) {
                        mVar.f(gVar);
                        mVar.a(gVar, 1, 0, 0, false);
                    }
                }
                if (z8 && (aVar2 == null || aVar2.d == null)) {
                    aVar2 = a(aVar2, sparseArray2, i);
                    aVar2.d = gVar;
                    aVar2.e = z5;
                    aVar2.f = cVar2;
                }
                if (!z2 && z7 && aVar2 != null && aVar2.a == gVar) {
                    aVar2.a = null;
                    return;
                }
                return;
            }
            if (!gVar.l) {
            }
            z4 = false;
            z6 = z4;
            z3 = true;
            boolean z72 = false;
            boolean z82 = false;
            a aVar42 = sparseArray2.get(i);
            if (z6) {
            }
            aVar2 = aVar42;
            aVar2.d = null;
            mVar = cVar2.a;
            mVar.f(gVar);
            mVar.a(gVar, 1, 0, 0, false);
            aVar2 = a(aVar2, sparseArray2, i);
            aVar2.d = gVar;
            aVar2.e = z5;
            aVar2.f = cVar2;
            if (!z2) {
            }
        }
    }

    public static void a(c cVar, SparseArray<a> sparseArray, boolean z) {
        int size = cVar.b.size();
        for (int i = 0; i < size; i++) {
            a(cVar, cVar.b.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r11 = r4.a;
     */
    private static void a(m mVar, int i, a aVar, View view, android.support.v4.f.a<String, String> aVar2) {
        g gVar;
        g gVar2;
        t a2;
        Object obj;
        m mVar2 = mVar;
        a aVar3 = aVar;
        View view2 = view;
        ViewGroup viewGroup = mVar2.n.a() ? (ViewGroup) mVar2.n.a(i) : null;
        if (viewGroup != null && (a2 = a(gVar2, gVar)) != null) {
            boolean z = aVar3.b;
            boolean z2 = aVar3.e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object a3 = a(a2, gVar, z);
            Object b2 = b(a2, (gVar2 = aVar3.d), z2);
            ViewGroup viewGroup2 = viewGroup;
            ArrayList arrayList3 = arrayList2;
            Object a4 = a(a2, viewGroup, view, aVar2, aVar, (ArrayList<View>) arrayList2, (ArrayList<View>) arrayList, a3, b2);
            Object obj2 = a3;
            if (obj2 == null && a4 == null) {
                obj = b2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = b2;
            }
            ArrayList<View> b3 = b(a2, obj, gVar2, (ArrayList<View>) arrayList3, view2);
            ArrayList<View> b4 = b(a2, obj2, gVar, (ArrayList<View>) arrayList, view2);
            b(b4, 4);
            g gVar3 = gVar;
            ArrayList<View> arrayList4 = b3;
            Object a5 = a(a2, obj2, obj, a4, gVar3, z);
            if (a5 != null) {
                a(a2, obj, gVar2, arrayList4);
                ArrayList<String> a6 = a2.a((ArrayList<View>) arrayList);
                a2.a(a5, obj2, b4, obj, arrayList4, a4, arrayList);
                ViewGroup viewGroup3 = viewGroup2;
                a2.a(viewGroup3, a5);
                a2.a(viewGroup3, arrayList3, arrayList, a6, aVar2);
                b(b4, 0);
                a2.a(a4, (ArrayList<View>) arrayList3, (ArrayList<View>) arrayList);
            }
        }
    }

    static void a(m mVar, ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (mVar.l >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                c cVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    b(cVar, (SparseArray<a>) sparseArray, z);
                } else {
                    a(cVar, (SparseArray<a>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(mVar.m.g());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    android.support.v4.f.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                    a aVar = (a) sparseArray.valueAt(i4);
                    if (z) {
                        a(mVar, keyAt, aVar, view, a2);
                    } else {
                        b(mVar, keyAt, aVar, view, a2);
                    }
                }
            }
        }
    }

    private static void a(t tVar, ViewGroup viewGroup, g gVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final t tVar2 = tVar;
        final View view2 = view;
        final g gVar2 = gVar;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ViewGroup viewGroup2 = viewGroup;
        w.a(viewGroup, new Runnable() {
            public void run() {
                if (obj3 != null) {
                    tVar2.c(obj3, view2);
                    arrayList5.addAll(r.b(tVar2, obj3, gVar2, (ArrayList<View>) arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        tVar2.b(obj4, (ArrayList<View>) arrayList6, (ArrayList<View>) arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void a(t tVar, Object obj, g gVar, final ArrayList<View> arrayList) {
        if (gVar != null && obj != null && gVar.l && gVar.B && gVar.Q) {
            gVar.f(true);
            tVar.b(obj, gVar.k(), arrayList);
            w.a(gVar.I, new Runnable() {
                public void run() {
                    r.b(arrayList, 4);
                }
            });
        }
    }

    private static void a(t tVar, Object obj, Object obj2, android.support.v4.f.a<String, View> aVar, boolean z, c cVar) {
        if (cVar.r != null && !cVar.r.isEmpty()) {
            View view = aVar.get((z ? cVar.s : cVar.r).get(0));
            tVar.a(obj, view);
            if (obj2 != null) {
                tVar.a(obj2, view);
            }
        }
    }

    private static void a(android.support.v4.f.a<String, String> aVar, android.support.v4.f.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, android.support.v4.f.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(p.e(c2))) {
                arrayList.add(c2);
            }
        }
    }

    private static boolean a(t tVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!tVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static android.support.v4.f.a<String, View> b(t tVar, android.support.v4.f.a<String, String> aVar, Object obj, a aVar2) {
        x xVar;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        g gVar = aVar2.d;
        android.support.v4.f.a<String, View> aVar3 = new android.support.v4.f.a<>();
        tVar.a((Map<String, View>) aVar3, gVar.k());
        c cVar = aVar2.f;
        if (aVar2.e) {
            xVar = gVar.R();
            arrayList = cVar.s;
        } else {
            xVar = gVar.S();
            arrayList = cVar.r;
        }
        aVar3.a(arrayList);
        if (xVar != null) {
            xVar.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(p.e(view))) {
                    aVar.put(p.e(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a(aVar3.keySet());
        }
        return aVar3;
    }

    /* access modifiers changed from: private */
    public static View b(android.support.v4.f.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        c cVar = aVar2.c;
        if (obj == null || aVar == null || cVar.r == null || cVar.r.isEmpty()) {
            return null;
        }
        return aVar.get((z ? cVar.r : cVar.s).get(0));
    }

    private static Object b(t tVar, g gVar, boolean z) {
        if (gVar == null) {
            return null;
        }
        return tVar.b(z ? gVar.v() : gVar.w());
    }

    private static Object b(t tVar, ViewGroup viewGroup, View view, android.support.v4.f.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        android.support.v4.f.a<String, String> aVar3;
        Object obj3;
        Object obj4;
        Rect rect;
        t tVar2 = tVar;
        a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        g gVar = aVar4.a;
        g gVar2 = aVar4.d;
        if (gVar == null || gVar2 == null) {
            return null;
        }
        boolean z = aVar4.b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            obj3 = null;
        } else {
            obj3 = a(tVar2, gVar, gVar2, z);
            aVar3 = aVar;
        }
        android.support.v4.f.a<String, View> b2 = b(tVar2, aVar3, obj3, aVar4);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b2.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        b(gVar, gVar2, z, b2, true);
        if (obj4 != null) {
            rect = new Rect();
            tVar2.a(obj4, view, arrayList3);
            a(tVar, obj4, obj2, b2, aVar4.e, aVar4.f);
            if (obj5 != null) {
                tVar2.a(obj5, rect);
            }
        } else {
            rect = null;
        }
        final t tVar3 = tVar;
        final android.support.v4.f.a<String, String> aVar5 = aVar;
        final Object obj6 = obj4;
        final a aVar6 = aVar2;
        AnonymousClass4 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final g gVar3 = gVar;
        final g gVar4 = gVar2;
        final boolean z2 = z;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj7 = obj;
        final Rect rect2 = rect;
        AnonymousClass4 r0 = new Runnable() {
            public void run() {
                android.support.v4.f.a a2 = r.c(tVar3, aVar5, obj6, aVar6);
                if (a2 != null) {
                    arrayList4.addAll(a2.values());
                    arrayList4.add(view2);
                }
                r.b(gVar3, gVar4, z2, (android.support.v4.f.a<String, View>) a2, false);
                if (obj6 != null) {
                    tVar3.a(obj6, (ArrayList<View>) arrayList5, (ArrayList<View>) arrayList4);
                    View a3 = r.b((android.support.v4.f.a<String, View>) a2, aVar6, obj7, z2);
                    if (a3 != null) {
                        tVar3.a(a3, rect2);
                    }
                }
            }
        };
        w.a(viewGroup, r13);
        return obj4;
    }

    /* access modifiers changed from: private */
    public static ArrayList<View> b(t tVar, Object obj, g gVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View k = gVar.k();
        if (k != null) {
            tVar.a(arrayList2, k);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        tVar.a(obj, arrayList2);
        return arrayList2;
    }

    public static void b(c cVar, SparseArray<a> sparseArray, boolean z) {
        if (cVar.a.n.a()) {
            for (int size = cVar.b.size() - 1; size >= 0; size--) {
                a(cVar, cVar.b.get(size), sparseArray, true, z);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(g gVar, g gVar2, boolean z, android.support.v4.f.a<String, View> aVar, boolean z2) {
        x R = z ? gVar2.R() : gVar.R();
        if (R != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                R.a(arrayList2, arrayList, (List<View>) null);
            } else {
                R.b(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    private static void b(m mVar, int i, a aVar, View view, android.support.v4.f.a<String, String> aVar2) {
        g gVar;
        g gVar2;
        t a2;
        Object obj;
        m mVar2 = mVar;
        a aVar3 = aVar;
        View view2 = view;
        android.support.v4.f.a<String, String> aVar4 = aVar2;
        ViewGroup viewGroup = mVar2.n.a() ? (ViewGroup) mVar2.n.a(i) : null;
        if (viewGroup != null && (a2 = a(gVar2, gVar)) != null) {
            boolean z = aVar3.b;
            boolean z2 = aVar3.e;
            Object a3 = a(a2, (gVar = aVar3.a), z);
            Object b2 = b(a2, (gVar2 = aVar3.d), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = b2;
            t tVar = a2;
            Object b3 = b(a2, viewGroup, view, aVar2, aVar, arrayList, arrayList2, a3, obj2);
            Object obj3 = a3;
            if (obj3 == null && b3 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> b4 = b(tVar, obj, gVar2, (ArrayList<View>) arrayList3, view2);
            Object obj4 = (b4 == null || b4.isEmpty()) ? null : obj;
            tVar.b(obj3, view2);
            Object a4 = a(tVar, obj3, obj4, b3, gVar, aVar3.b);
            if (a4 != null) {
                ArrayList arrayList4 = new ArrayList();
                t tVar2 = tVar;
                tVar2.a(a4, obj3, arrayList4, obj4, b4, b3, arrayList2);
                a(tVar2, viewGroup, gVar, view, (ArrayList<View>) arrayList2, obj3, (ArrayList<View>) arrayList4, obj4, b4);
                ArrayList arrayList5 = arrayList2;
                tVar.a((View) viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) aVar4);
                tVar.a(viewGroup, a4);
                tVar.a(viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) aVar4);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* access modifiers changed from: private */
    public static android.support.v4.f.a<String, View> c(t tVar, android.support.v4.f.a<String, String> aVar, Object obj, a aVar2) {
        x xVar;
        ArrayList<String> arrayList;
        String a2;
        g gVar = aVar2.a;
        View k = gVar.k();
        if (aVar.isEmpty() || obj == null || k == null) {
            aVar.clear();
            return null;
        }
        android.support.v4.f.a<String, View> aVar3 = new android.support.v4.f.a<>();
        tVar.a((Map<String, View>) aVar3, k);
        c cVar = aVar2.c;
        if (aVar2.b) {
            xVar = gVar.S();
            arrayList = cVar.r;
        } else {
            xVar = gVar.R();
            arrayList = cVar.s;
        }
        if (arrayList != null) {
            aVar3.a(arrayList);
            aVar3.a(aVar.values());
        }
        if (xVar != null) {
            xVar.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(p.e(view)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, p.e(view));
                }
            }
        } else {
            a(aVar, aVar3);
        }
        return aVar3;
    }
}
