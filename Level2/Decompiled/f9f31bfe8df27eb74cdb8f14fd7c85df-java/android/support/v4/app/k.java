package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class k<E> extends i {
    private final Activity a;
    final Context b;
    final int c;
    final m d;
    private final Handler e;

    k(Activity activity, Context context, Handler handler, int i) {
        this.d = new m();
        this.a = activity;
        this.b = context;
        this.e = handler;
        this.c = i;
    }

    k(h hVar) {
        this(hVar, hVar, hVar.c, 0);
    }

    public View a(int i) {
        return null;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(g gVar) {
        return true;
    }

    public LayoutInflater b() {
        return LayoutInflater.from(this.b);
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar) {
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public Activity f() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public Context g() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public Handler h() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public m i() {
        return this.d;
    }
}
