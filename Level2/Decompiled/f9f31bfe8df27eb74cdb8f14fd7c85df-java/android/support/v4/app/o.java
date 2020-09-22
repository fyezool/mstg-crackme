package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new Parcelable.Creator<o>() {
        /* renamed from: a */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        /* renamed from: a */
        public o[] newArray(int i) {
            return new o[i];
        }
    };
    p[] a;
    int[] b;
    d[] c;
    int d = -1;
    int e;

    public o() {
    }

    public o(Parcel parcel) {
        this.a = (p[]) parcel.createTypedArray(p.CREATOR);
        this.b = parcel.createIntArray();
        this.c = (d[]) parcel.createTypedArray(d.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.a, i);
        parcel.writeIntArray(this.b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
