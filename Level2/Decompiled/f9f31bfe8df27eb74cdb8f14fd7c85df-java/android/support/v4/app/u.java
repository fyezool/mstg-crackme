package android.support.v4.app;

import android.support.v4.a.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class u {

    public interface a<D> {
        void a(b<D> bVar);

        void a(b<D> bVar, D d);
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
