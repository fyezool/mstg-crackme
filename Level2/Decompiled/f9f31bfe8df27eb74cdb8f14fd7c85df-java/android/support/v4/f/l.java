package android.support.v4.f;

public class l<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public l() {
        this(10);
    }

    public l(int i) {
        Object[] objArr;
        this.b = false;
        if (i == 0) {
            this.c = c.a;
            objArr = c.c;
        } else {
            int a2 = c.a(i);
            this.c = new int[a2];
            objArr = new Object[a2];
        }
        this.d = objArr;
        this.e = 0;
    }

    private void d() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    /* renamed from: a */
    public l<E> clone() {
        try {
            l<E> lVar = (l) super.clone();
            try {
                lVar.c = (int[]) this.c.clone();
                lVar.d = (Object[]) this.d.clone();
                return lVar;
            } catch (CloneNotSupportedException unused) {
                return lVar;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public E a(int i) {
        return a(i, (Object) null);
    }

    public E a(int i, E e2) {
        int a2 = c.a(this.c, this.e, i);
        return (a2 < 0 || this.d[a2] == a) ? e2 : this.d[a2];
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public void b(int i) {
        int a2 = c.a(this.c, this.e, i);
        if (a2 >= 0 && this.d[a2] != a) {
            this.d[a2] = a;
            this.b = true;
        }
    }

    public void b(int i, E e2) {
        int a2 = c.a(this.c, this.e, i);
        if (a2 >= 0) {
            this.d[a2] = e2;
            return;
        }
        int i2 = a2 ^ -1;
        if (i2 >= this.e || this.d[i2] != a) {
            if (this.b && this.e >= this.c.length) {
                d();
                i2 = c.a(this.c, this.e, i) ^ -1;
            }
            if (this.e >= this.c.length) {
                int a3 = c.a(this.e + 1);
                int[] iArr = new int[a3];
                Object[] objArr = new Object[a3];
                System.arraycopy(this.c, 0, iArr, 0, this.c.length);
                System.arraycopy(this.d, 0, objArr, 0, this.d.length);
                this.c = iArr;
                this.d = objArr;
            }
            if (this.e - i2 != 0) {
                int i3 = i2 + 1;
                System.arraycopy(this.c, i2, this.c, i3, this.e - i2);
                System.arraycopy(this.d, i2, this.d, i3, this.e - i2);
            }
            this.c[i2] = i;
            this.d[i2] = e2;
            this.e++;
            return;
        }
        this.c[i2] = i;
        this.d[i2] = e2;
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void c(int i) {
        b(i);
    }

    public void c(int i, E e2) {
        if (this.e == 0 || i > this.c[this.e - 1]) {
            if (this.b && this.e >= this.c.length) {
                d();
            }
            int i2 = this.e;
            if (i2 >= this.c.length) {
                int a2 = c.a(i2 + 1);
                int[] iArr = new int[a2];
                Object[] objArr = new Object[a2];
                System.arraycopy(this.c, 0, iArr, 0, this.c.length);
                System.arraycopy(this.d, 0, objArr, 0, this.d.length);
                this.c = iArr;
                this.d = objArr;
            }
            this.c[i2] = i;
            this.d[i2] = e2;
            this.e = i2 + 1;
            return;
        }
        b(i, e2);
    }

    public int d(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public E e(int i) {
        if (this.b) {
            d();
        }
        return this.d[i];
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(d(i));
            sb.append('=');
            Object e2 = e(i);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
