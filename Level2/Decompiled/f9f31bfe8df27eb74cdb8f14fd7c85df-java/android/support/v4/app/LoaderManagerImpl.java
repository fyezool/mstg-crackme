package android.support.v4.app;

import android.arch.lifecycle.e;
import android.arch.lifecycle.j;
import android.arch.lifecycle.k;
import android.arch.lifecycle.n;
import android.arch.lifecycle.o;
import android.os.Bundle;
import android.support.v4.a.b;
import android.support.v4.app.u;
import android.support.v4.f.d;
import android.support.v4.f.l;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl extends u {
    static boolean a = false;
    private final e b;
    private final LoaderViewModel c;

    static class LoaderViewModel extends n {
        private static final o.a a = new o.a() {
        };
        private l<a> b = new l<>();

        LoaderViewModel() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            super.a();
            int b2 = this.b.b();
            for (int i = 0; i < b2; i++) {
                this.b.e(i).a(true);
            }
            this.b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.b.b(); i++) {
                    a e = this.b.e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.d(i));
                    printWriter.print(": ");
                    printWriter.println(e.toString());
                    e.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int b2 = this.b.b();
            for (int i = 0; i < b2; i++) {
                this.b.e(i).f();
            }
        }
    }

    public static class a<D> extends j<D> implements b.a<D> {
        private final int a;
        private final Bundle b;
        private final android.support.v4.a.b<D> c;
        private e d;
        private b<D> e;
        private android.support.v4.a.b<D> f;

        /* access modifiers changed from: package-private */
        public android.support.v4.a.b<D> a(boolean z) {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.c.c();
            this.c.g();
            b<D> bVar = this.e;
            if (bVar != null) {
                a(bVar);
                if (z) {
                    bVar.b();
                }
            }
            this.c.a(this);
            if ((bVar == null || bVar.a()) && !z) {
                return this.c;
            }
            this.c.i();
            return this.f;
        }

        public void a(k<D> kVar) {
            super.a(kVar);
            this.d = null;
            this.e = null;
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.c);
            android.support.v4.a.b<D> bVar = this.c;
            bVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.e);
                b<D> bVar2 = this.e;
                bVar2.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().a(a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.c.a();
        }

        /* access modifiers changed from: protected */
        public void c() {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.c.e();
        }

        /* access modifiers changed from: package-private */
        public android.support.v4.a.b<D> e() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            e eVar = this.d;
            b<D> bVar = this.e;
            if (eVar != null && bVar != null) {
                super.a(bVar);
                a(eVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.a);
            sb.append(" : ");
            d.a(this.c, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    static class b<D> implements k<D> {
        private final android.support.v4.a.b<D> a;
        private final u.a<D> b;
        private boolean c;

        public void a(D d) {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.a(d));
            }
            this.b.a(this.a, d);
            this.c = true;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.c) {
                if (LoaderManagerImpl.a) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.a(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.c.b();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a(this.b, sb);
        sb.append("}}");
        return sb.toString();
    }
}
