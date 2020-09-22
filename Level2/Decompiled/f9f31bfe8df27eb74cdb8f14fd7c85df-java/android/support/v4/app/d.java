package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.c;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: a */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public d(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public d(c cVar) {
        int size = cVar.b.size();
        this.a = new int[(size * 6)];
        if (cVar.i) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                c.a aVar = cVar.b.get(i2);
                int i4 = i3 + 1;
                this.a[i3] = aVar.a;
                int i5 = i4 + 1;
                this.a[i4] = aVar.b != null ? aVar.b.f : -1;
                int i6 = i5 + 1;
                this.a[i5] = aVar.c;
                int i7 = i6 + 1;
                this.a[i6] = aVar.d;
                int i8 = i7 + 1;
                this.a[i7] = aVar.e;
                this.a[i8] = aVar.f;
                i2++;
                i3 = i8 + 1;
            }
            this.b = cVar.g;
            this.c = cVar.h;
            this.d = cVar.k;
            this.e = cVar.m;
            this.f = cVar.n;
            this.g = cVar.o;
            this.h = cVar.p;
            this.i = cVar.q;
            this.j = cVar.r;
            this.k = cVar.s;
            this.l = cVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public c a(m mVar) {
        c cVar = new c(mVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.a.length) {
            c.a aVar = new c.a();
            int i4 = i2 + 1;
            aVar.a = this.a[i2];
            if (m.a) {
                Log.v("FragmentManager", "Instantiate " + cVar + " op #" + i3 + " base fragment #" + this.a[i4]);
            }
            int i5 = i4 + 1;
            int i6 = this.a[i4];
            aVar.b = i6 >= 0 ? mVar.f.get(i6) : null;
            int i7 = i5 + 1;
            aVar.c = this.a[i5];
            int i8 = i7 + 1;
            aVar.d = this.a[i7];
            int i9 = i8 + 1;
            aVar.e = this.a[i8];
            aVar.f = this.a[i9];
            cVar.c = aVar.c;
            cVar.d = aVar.d;
            cVar.e = aVar.e;
            cVar.f = aVar.f;
            cVar.a(aVar);
            i3++;
            i2 = i9 + 1;
        }
        cVar.g = this.b;
        cVar.h = this.c;
        cVar.k = this.d;
        cVar.m = this.e;
        cVar.i = true;
        cVar.n = this.f;
        cVar.o = this.g;
        cVar.p = this.h;
        cVar.q = this.i;
        cVar.r = this.j;
        cVar.s = this.k;
        cVar.t = this.l;
        cVar.a(1);
        return cVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }
}
