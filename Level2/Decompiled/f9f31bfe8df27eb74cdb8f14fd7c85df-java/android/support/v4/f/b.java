package android.support.v4.f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] a = new int[0];
    private static final Object[] b = new Object[0];
    private static Object[] c;
    private static int d;
    private static Object[] e;
    private static int f;
    private int[] g;
    /* access modifiers changed from: private */
    public Object[] h;
    /* access modifiers changed from: private */
    public int i;
    private h<E, E> j;

    public b() {
        this(0);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.g = a;
            this.h = b;
        } else {
            d(i2);
        }
        this.i = 0;
    }

    private int a() {
        int i2 = this.i;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.g, i2, 0);
        if (a2 < 0 || this.h[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.g[i3] == 0) {
            if (this.h[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.g[i4] == 0) {
            if (this.h[i4] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private int a(Object obj, int i2) {
        int i3 = this.i;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.g, i3, i2);
        if (a2 < 0 || obj.equals(this.h[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.g[i4] == i2) {
            if (obj.equals(this.h[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.g[i5] == i2) {
            if (obj.equals(this.h[i5])) {
                return i5;
            }
            i5--;
        }
        return i4 ^ -1;
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    e = objArr;
                    f++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (d < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    c = objArr;
                    d++;
                }
            }
        }
    }

    private h<E, E> b() {
        if (this.j == null) {
            this.j = new h<E, E>() {
                /* access modifiers changed from: protected */
                public int a() {
                    return b.this.i;
                }

                /* access modifiers changed from: protected */
                public int a(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public Object a(int i, int i2) {
                    return b.this.h[i];
                }

                /* access modifiers changed from: protected */
                public E a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public void a(int i) {
                    b.this.c(i);
                }

                /* access modifiers changed from: protected */
                public void a(E e, E e2) {
                    b.this.add(e);
                }

                /* access modifiers changed from: protected */
                public int b(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public void c() {
                    b.this.clear();
                }
            };
        }
        return this.j;
    }

    private void d(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (e != null) {
                    Object[] objArr = e;
                    this.h = objArr;
                    e = (Object[]) objArr[0];
                    this.g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (c != null) {
                    Object[] objArr2 = c;
                    this.h = objArr2;
                    c = (Object[]) objArr2[0];
                    this.g = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    d--;
                    return;
                }
            }
        }
        this.g = new int[i2];
        this.h = new Object[i2];
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public void a(int i2) {
        if (this.g.length < i2) {
            int[] iArr = this.g;
            Object[] objArr = this.h;
            d(i2);
            if (this.i > 0) {
                System.arraycopy(iArr, 0, this.g, 0, this.i);
                System.arraycopy(objArr, 0, this.h, 0, this.i);
            }
            a(iArr, objArr, this.i);
        }
    }

    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = a(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = i3 ^ -1;
        if (this.i >= this.g.length) {
            int i5 = 4;
            if (this.i >= 8) {
                i5 = (this.i >> 1) + this.i;
            } else if (this.i >= 4) {
                i5 = 8;
            }
            int[] iArr = this.g;
            Object[] objArr = this.h;
            d(i5);
            if (this.g.length > 0) {
                System.arraycopy(iArr, 0, this.g, 0, iArr.length);
                System.arraycopy(objArr, 0, this.h, 0, objArr.length);
            }
            a(iArr, objArr, this.i);
        }
        if (i4 < this.i) {
            int i6 = i4 + 1;
            System.arraycopy(this.g, i4, this.g, i6, this.i - i4);
            System.arraycopy(this.h, i4, this.h, i6, this.i - i4);
        }
        this.g[i4] = i2;
        this.h[i4] = e2;
        this.i++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        a(this.i + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public E b(int i2) {
        return this.h[i2];
    }

    public E c(int i2) {
        E e2 = this.h[i2];
        if (this.i <= 1) {
            a(this.g, this.h, this.i);
            this.g = a;
            this.h = b;
            this.i = 0;
        } else {
            int i3 = 8;
            if (this.g.length <= 8 || this.i >= this.g.length / 3) {
                this.i--;
                if (i2 < this.i) {
                    int i4 = i2 + 1;
                    System.arraycopy(this.g, i4, this.g, i2, this.i - i2);
                    System.arraycopy(this.h, i4, this.h, i2, this.i - i2);
                }
                this.h[this.i] = null;
            } else {
                if (this.i > 8) {
                    i3 = (this.i >> 1) + this.i;
                }
                int[] iArr = this.g;
                Object[] objArr = this.h;
                d(i3);
                this.i--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.g, 0, i2);
                    System.arraycopy(objArr, 0, this.h, 0, i2);
                }
                if (i2 < this.i) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, this.g, i2, this.i - i2);
                    System.arraycopy(objArr, i5, this.h, i2, this.i - i2);
                }
            }
        }
        return e2;
    }

    public void clear() {
        if (this.i != 0) {
            a(this.g, this.h, this.i);
            this.g = a;
            this.h = b;
            this.i = 0;
        }
    }

    public boolean contains(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.i) {
                try {
                    if (!set.contains(b(i2))) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.g;
        int i2 = this.i;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public boolean isEmpty() {
        return this.i <= 0;
    }

    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    public boolean remove(Object obj) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        c(a2);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.i - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.h[i2])) {
                c(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.i;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[this.i];
        System.arraycopy(this.h, 0, objArr, 0, this.i);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.i) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.i);
        }
        System.arraycopy(this.h, 0, tArr, 0, this.i);
        if (tArr.length > this.i) {
            tArr[this.i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object b2 = b(i2);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
