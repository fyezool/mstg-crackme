package android.support.v4.app;

import android.support.v4.app.g;
import android.support.v4.app.m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class c extends q implements m.g {
    final m a;
    ArrayList<a> b = new ArrayList<>();
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j = true;
    String k;
    boolean l;
    int m = -1;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    boolean t = false;
    ArrayList<Runnable> u;

    static final class a {
        int a;
        g b;
        int c;
        int d;
        int e;
        int f;

        a() {
        }

        a(int i, g gVar) {
            this.a = i;
            this.b = gVar;
        }
    }

    public c(m mVar) {
        this.a = mVar;
    }

    private static boolean b(a aVar) {
        g gVar = aVar.b;
        return gVar != null && gVar.l && gVar.J != null && !gVar.C && !gVar.B && gVar.W();
    }

    /* access modifiers changed from: package-private */
    public g a(ArrayList<g> arrayList, g gVar) {
        g gVar2 = gVar;
        int i2 = 0;
        while (i2 < this.b.size()) {
            a aVar = this.b.get(i2);
            switch (aVar.a) {
                case 1:
                case 7:
                    arrayList.add(aVar.b);
                    break;
                case 2:
                    g gVar3 = aVar.b;
                    int i3 = gVar3.z;
                    g gVar4 = gVar2;
                    int i4 = i2;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        g gVar5 = arrayList.get(size);
                        if (gVar5.z == i3) {
                            if (gVar5 == gVar3) {
                                z = true;
                            } else {
                                if (gVar5 == gVar4) {
                                    this.b.add(i4, new a(9, gVar5));
                                    i4++;
                                    gVar4 = null;
                                }
                                a aVar2 = new a(3, gVar5);
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.b.add(i4, aVar2);
                                arrayList.remove(gVar5);
                                i4++;
                            }
                        }
                    }
                    if (z) {
                        this.b.remove(i4);
                        i4--;
                    } else {
                        aVar.a = 1;
                        arrayList.add(gVar3);
                    }
                    i2 = i4;
                    gVar2 = gVar4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.b);
                    if (aVar.b != gVar2) {
                        break;
                    } else {
                        this.b.add(i2, new a(9, aVar.b));
                        i2++;
                        gVar2 = null;
                        break;
                    }
                case 8:
                    this.b.add(i2, new a(9, gVar2));
                    i2++;
                    gVar2 = aVar.b;
                    break;
            }
            i2++;
        }
        return gVar2;
    }

    public void a() {
        if (this.u != null) {
            int size = this.u.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.u.get(i2).run();
            }
            this.u = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.i) {
            if (m.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.b.get(i3);
                if (aVar.b != null) {
                    aVar.b.r += i2;
                    if (m.a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.r);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.b.add(aVar);
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
    }

    /* access modifiers changed from: package-private */
    public void a(g.c cVar) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            a aVar = this.b.get(i2);
            if (b(aVar)) {
                aVar.b.a(cVar);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.c == 0 && this.d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (!(this.e == 0 && this.f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (!(this.n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (!(this.p == 0 && this.q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.b.get(i2);
                switch (aVar.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            a aVar = this.b.get(size);
            g gVar = aVar.b;
            if (gVar != null) {
                gVar.a(m.d(this.g), this.h);
            }
            int i2 = aVar.a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        gVar.a(aVar.e);
                        this.a.a(gVar, false);
                        break;
                    case 4:
                        gVar.a(aVar.e);
                        this.a.j(gVar);
                        break;
                    case 5:
                        gVar.a(aVar.f);
                        this.a.i(gVar);
                        break;
                    case 6:
                        gVar.a(aVar.e);
                        this.a.l(gVar);
                        break;
                    case 7:
                        gVar.a(aVar.f);
                        this.a.k(gVar);
                        break;
                    case 8:
                        this.a.o((g) null);
                        break;
                    case 9:
                        this.a.o(gVar);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                }
            } else {
                gVar.a(aVar.f);
                this.a.h(gVar);
            }
            if (!(this.t || aVar.a == 3 || gVar == null)) {
                this.a.e(gVar);
            }
        }
        if (!this.t && z) {
            this.a.a(this.a.l, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<c> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.b.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = this.b.get(i5);
            int i6 = aVar.b != null ? aVar.b.z : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    c cVar = arrayList.get(i7);
                    int size2 = cVar.b.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        a aVar2 = cVar.b.get(i8);
                        if ((aVar2.b != null ? aVar2.b.z : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    public boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        if (m.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.i) {
            return true;
        }
        this.a.a(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public g b(ArrayList<g> arrayList, g gVar) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            a aVar = this.b.get(i2);
            int i3 = aVar.a;
            if (i3 != 1) {
                if (i3 != 3) {
                    switch (i3) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            gVar = null;
                            break;
                        case 9:
                            gVar = aVar.b;
                            break;
                    }
                }
                arrayList.add(aVar.b);
            }
            arrayList.remove(aVar.b);
        }
        return gVar;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.b.get(i2);
            g gVar = aVar.b;
            if (gVar != null) {
                gVar.a(this.g, this.h);
            }
            int i3 = aVar.a;
            if (i3 != 1) {
                switch (i3) {
                    case 3:
                        gVar.a(aVar.d);
                        this.a.h(gVar);
                        break;
                    case 4:
                        gVar.a(aVar.d);
                        this.a.i(gVar);
                        break;
                    case 5:
                        gVar.a(aVar.c);
                        this.a.j(gVar);
                        break;
                    case 6:
                        gVar.a(aVar.d);
                        this.a.k(gVar);
                        break;
                    case 7:
                        gVar.a(aVar.c);
                        this.a.l(gVar);
                        break;
                    case 8:
                        this.a.o(gVar);
                        break;
                    case 9:
                        this.a.o((g) null);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                }
            } else {
                gVar.a(aVar.c);
                this.a.a(gVar, false);
            }
            if (!(this.t || aVar.a == 1 || gVar == null)) {
                this.a.e(gVar);
            }
        }
        if (!this.t) {
            this.a.a(this.a.l, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        int size = this.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = this.b.get(i3);
            int i4 = aVar.b != null ? aVar.b.z : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (b(this.b.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public String d() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }
}
