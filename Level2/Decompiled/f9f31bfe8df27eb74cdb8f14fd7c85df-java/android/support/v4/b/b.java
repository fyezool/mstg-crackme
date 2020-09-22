package android.support.v4.b;

import android.graphics.Path;
import android.support.v7.a.a;
import android.util.Log;
import java.util.ArrayList;

public class b {

    private static class a {
        int a;
        boolean b;

        a() {
        }
    }

    /* renamed from: android.support.v4.b.b$b  reason: collision with other inner class name */
    public static class C0005b {
        public char a;
        public float[] b;

        C0005b(char c, float[] fArr) {
            this.a = c;
            this.b = fArr;
        }

        C0005b(C0005b bVar) {
            this.a = bVar.a;
            this.b = b.a(bVar.b, 0, bVar.b.length);
        }

        private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = d11 * sin;
            double d15 = d4 * cos;
            double d16 = (sin2 * d14) + (cos2 * d15);
            double d17 = (double) ceil;
            Double.isNaN(d17);
            double d18 = d9 / d17;
            int i = 0;
            double d19 = d6;
            double d20 = d16;
            double d21 = (d12 * sin2) - (d13 * cos2);
            double d22 = d5;
            double d23 = d8;
            while (i < ceil) {
                double d24 = d23 + d18;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = d18;
                double d26 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d27 = d2 + (d10 * sin * cos3) + (d15 * sin3);
                double d28 = (d12 * sin3) - (d13 * cos3);
                double d29 = (sin3 * d14) + (cos3 * d15);
                double d30 = d24 - d23;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d31 = d15;
                double d32 = d14;
                path.rLineTo(0.0f, 0.0f);
                float f = (float) (d19 + (d20 * sin4));
                float f2 = (float) (d26 - (sin4 * d28));
                path.cubicTo((float) (d22 + (d21 * sin4)), f, f2, (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                i++;
                d19 = d27;
                d22 = d26;
                d23 = d24;
                d20 = d29;
                d21 = d28;
                d18 = d25;
                d15 = d31;
                d14 = d32;
                ceil = ceil;
                cos = cos;
                sin = sin;
                d10 = d3;
            }
        }

        private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            boolean z3 = z2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (double) f8;
            Double.isNaN(d3);
            double d4 = d3 * cos;
            double d5 = d3;
            double d6 = (double) f2;
            Double.isNaN(d6);
            double d7 = (double) f10;
            Double.isNaN(d7);
            double d8 = (d4 + (d6 * sin)) / d7;
            double d9 = (double) (-f8);
            Double.isNaN(d9);
            Double.isNaN(d6);
            double d10 = d6;
            double d11 = (double) f6;
            Double.isNaN(d11);
            double d12 = (double) f9;
            Double.isNaN(d12);
            double d13 = ((d9 * sin) + (d6 * cos)) / d11;
            double d14 = (double) f4;
            Double.isNaN(d14);
            Double.isNaN(d7);
            double d15 = ((d12 * cos) + (d14 * sin)) / d7;
            double d16 = d7;
            double d17 = (double) (-f9);
            Double.isNaN(d17);
            Double.isNaN(d14);
            Double.isNaN(d11);
            double d18 = ((d17 * sin) + (d14 * cos)) / d11;
            double d19 = d8 - d15;
            double d20 = d13 - d18;
            double d21 = (d8 + d15) / 2.0d;
            double d22 = (d13 + d18) / 2.0d;
            double d23 = sin;
            double d24 = (d19 * d19) + (d20 * d20);
            if (d24 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d25 = (1.0d / d24) - 0.25d;
            if (d25 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d24);
                float sqrt = (float) (Math.sqrt(d24) / 1.99999d);
                a(path, f, f2, f3, f4, f10 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d25);
            double d26 = d19 * sqrt2;
            double d27 = sqrt2 * d20;
            boolean z4 = z2;
            if (z == z4) {
                d2 = d21 - d27;
                d = d22 + d26;
            } else {
                d2 = d21 + d27;
                d = d22 - d26;
            }
            double atan2 = Math.atan2(d13 - d, d8 - d2);
            double atan22 = Math.atan2(d18 - d, d15 - d2) - atan2;
            if (z4 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d16);
            double d28 = d2 * d16;
            Double.isNaN(d11);
            double d29 = d * d11;
            a(path, (d28 * cos) - (d29 * d23), (d28 * d23) + (d29 * cos), d16, d11, d5, d10, radians, atan2, atan22);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            r25 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0115, code lost:
            r7 = r7 + r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x014c, code lost:
            r7 = r7 + r2;
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0230, code lost:
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x02e4, code lost:
            r3 = r7;
            r2 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x02e6, code lost:
            r9 = r25 + r20;
            r0 = r30;
         */
        private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            int i3;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            Path path2 = path;
            float[] fArr3 = fArr2;
            float f15 = fArr[0];
            float f16 = fArr[1];
            float f17 = fArr[2];
            float f18 = fArr[3];
            float f19 = fArr[4];
            float f20 = fArr[5];
            switch (c2) {
                case a.j.AppCompatTheme_editTextBackground /*65*/:
                case a.j.AppCompatTheme_textAppearanceListItemSecondary /*97*/:
                    i = 7;
                    break;
                case a.j.AppCompatTheme_editTextStyle /*67*/:
                case a.j.AppCompatTheme_textAppearancePopupMenuHeader /*99*/:
                    i = 6;
                    break;
                case a.j.AppCompatTheme_listMenuViewStyle /*72*/:
                case a.j.AppCompatTheme_ratingBarStyleIndicator /*86*/:
                case a.j.AppCompatTheme_textColorSearchUrl /*104*/:
                case a.j.AppCompatTheme_windowMinWidthMinor /*118*/:
                    i = 1;
                    break;
                case a.j.AppCompatTheme_panelMenuListWidth /*81*/:
                case a.j.AppCompatTheme_popupWindowStyle /*83*/:
                case a.j.AppCompatTheme_windowFixedHeightMajor /*113*/:
                case a.j.AppCompatTheme_windowFixedWidthMajor /*115*/:
                    i = 4;
                    break;
                case a.j.AppCompatTheme_selectableItemBackground /*90*/:
                case 'z':
                    path.close();
                    path2.moveTo(f19, f20);
                    f15 = f19;
                    f17 = f15;
                    f16 = f20;
                    f18 = f16;
                    break;
            }
            i = 2;
            float f21 = f15;
            float f22 = f16;
            float f23 = f19;
            float f24 = f20;
            int i4 = 0;
            char c3 = c;
            while (i4 < fArr3.length) {
                float f25 = 0.0f;
                switch (c2) {
                    case a.j.AppCompatTheme_editTextBackground /*65*/:
                        i3 = i4;
                        int i5 = i3 + 5;
                        int i6 = i3 + 6;
                        a(path, f21, f22, fArr3[i5], fArr3[i6], fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                        f = fArr3[i5];
                        f2 = fArr3[i6];
                        break;
                    case a.j.AppCompatTheme_editTextStyle /*67*/:
                        i2 = i4;
                        int i7 = i2 + 2;
                        int i8 = i2 + 3;
                        int i9 = i2 + 4;
                        int i10 = i2 + 5;
                        path.cubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i7], fArr3[i8], fArr3[i9], fArr3[i10]);
                        f21 = fArr3[i9];
                        float f26 = fArr3[i10];
                        float f27 = fArr3[i7];
                        float f28 = fArr3[i8];
                        f22 = f26;
                        f18 = f28;
                        f17 = f27;
                        break;
                    case a.j.AppCompatTheme_listMenuViewStyle /*72*/:
                        i2 = i4;
                        int i11 = i2 + 0;
                        path2.lineTo(fArr3[i11], f22);
                        f21 = fArr3[i11];
                        break;
                    case a.j.AppCompatTheme_listPreferredItemHeightSmall /*76*/:
                        i2 = i4;
                        int i12 = i2 + 0;
                        int i13 = i2 + 1;
                        path2.lineTo(fArr3[i12], fArr3[i13]);
                        f21 = fArr3[i12];
                        f22 = fArr3[i13];
                        break;
                    case a.j.AppCompatTheme_listPreferredItemPaddingLeft /*77*/:
                        i2 = i4;
                        int i14 = i2 + 0;
                        f21 = fArr3[i14];
                        int i15 = i2 + 1;
                        f22 = fArr3[i15];
                        if (i2 <= 0) {
                            path2.moveTo(fArr3[i14], fArr3[i15]);
                            f24 = f22;
                            f23 = f21;
                            break;
                        } else {
                            path2.lineTo(fArr3[i14], fArr3[i15]);
                            break;
                        }
                    case a.j.AppCompatTheme_panelMenuListWidth /*81*/:
                        i2 = i4;
                        int i16 = i2 + 0;
                        int i17 = i2 + 1;
                        int i18 = i2 + 2;
                        int i19 = i2 + 3;
                        path2.quadTo(fArr3[i16], fArr3[i17], fArr3[i18], fArr3[i19]);
                        f4 = fArr3[i16];
                        f3 = fArr3[i17];
                        f5 = fArr3[i18];
                        f22 = fArr3[i19];
                        break;
                    case a.j.AppCompatTheme_popupWindowStyle /*83*/:
                        float f29 = f22;
                        float f30 = f21;
                        i2 = i4;
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f31 = (f30 * 2.0f) - f17;
                            f6 = (f29 * 2.0f) - f18;
                            f7 = f31;
                        } else {
                            f7 = f30;
                            f6 = f29;
                        }
                        int i20 = i2 + 0;
                        int i21 = i2 + 1;
                        int i22 = i2 + 2;
                        int i23 = i2 + 3;
                        path.cubicTo(f7, f6, fArr3[i20], fArr3[i21], fArr3[i22], fArr3[i23]);
                        f4 = fArr3[i20];
                        f3 = fArr3[i21];
                        f5 = fArr3[i22];
                        f22 = fArr3[i23];
                        break;
                    case a.j.AppCompatTheme_radioButtonStyle /*84*/:
                        float f32 = f22;
                        float f33 = f21;
                        i2 = i4;
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f32 = (f32 * 2.0f) - f18;
                            f33 = (f33 * 2.0f) - f17;
                        }
                        int i24 = i2 + 0;
                        int i25 = i2 + 1;
                        path2.quadTo(f33, f32, fArr3[i24], fArr3[i25]);
                        f21 = fArr3[i24];
                        f22 = fArr3[i25];
                        f17 = f33;
                        f18 = f32;
                        break;
                    case a.j.AppCompatTheme_ratingBarStyleIndicator /*86*/:
                        i2 = i4;
                        int i26 = i2 + 0;
                        path2.lineTo(f21, fArr3[i26]);
                        f22 = fArr3[i26];
                        break;
                    case a.j.AppCompatTheme_textAppearanceListItemSecondary /*97*/:
                        int i27 = i4 + 5;
                        float f34 = fArr3[i27] + f21;
                        int i28 = i4 + 6;
                        float f35 = fArr3[i28] + f22;
                        float f36 = fArr3[i4 + 0];
                        float f37 = fArr3[i4 + 1];
                        float f38 = fArr3[i4 + 2];
                        float f39 = f21;
                        boolean z = fArr3[i4 + 3] != 0.0f;
                        i3 = i4;
                        a(path, f21, f22, f34, f35, f36, f37, f38, z, fArr3[i4 + 4] != 0.0f);
                        f = f39 + fArr3[i27];
                        f2 = f22 + fArr3[i28];
                        break;
                    case a.j.AppCompatTheme_textAppearancePopupMenuHeader /*99*/:
                        int i29 = i4 + 2;
                        int i30 = i4 + 3;
                        int i31 = i4 + 4;
                        int i32 = i4 + 5;
                        path.rCubicTo(fArr3[i4 + 0], fArr3[i4 + 1], fArr3[i29], fArr3[i30], fArr3[i31], fArr3[i32]);
                        f10 = fArr3[i29] + f21;
                        f9 = fArr3[i30] + f22;
                        f21 += fArr3[i31];
                        f8 = fArr3[i32];
                        break;
                    case a.j.AppCompatTheme_textColorSearchUrl /*104*/:
                        int i33 = i4 + 0;
                        path2.rLineTo(fArr3[i33], 0.0f);
                        f21 += fArr3[i33];
                        break;
                    case a.j.AppCompatTheme_tooltipFrameBackground /*108*/:
                        int i34 = i4 + 0;
                        int i35 = i4 + 1;
                        path2.rLineTo(fArr3[i34], fArr3[i35]);
                        f21 += fArr3[i34];
                        f11 = fArr3[i35];
                        break;
                    case a.j.AppCompatTheme_viewInflaterClass /*109*/:
                        int i36 = i4 + 0;
                        f21 += fArr3[i36];
                        int i37 = i4 + 1;
                        f22 += fArr3[i37];
                        if (i4 <= 0) {
                            path2.rMoveTo(fArr3[i36], fArr3[i37]);
                            f24 = f22;
                            f23 = f21;
                            break;
                        } else {
                            path2.rLineTo(fArr3[i36], fArr3[i37]);
                            break;
                        }
                    case a.j.AppCompatTheme_windowFixedHeightMajor /*113*/:
                        int i38 = i4 + 0;
                        int i39 = i4 + 1;
                        int i40 = i4 + 2;
                        int i41 = i4 + 3;
                        path2.rQuadTo(fArr3[i38], fArr3[i39], fArr3[i40], fArr3[i41]);
                        f10 = fArr3[i38] + f21;
                        f9 = fArr3[i39] + f22;
                        f21 += fArr3[i40];
                        f8 = fArr3[i41];
                        break;
                    case a.j.AppCompatTheme_windowFixedWidthMajor /*115*/:
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f40 = f21 - f17;
                            f12 = f22 - f18;
                            f13 = f40;
                        } else {
                            f13 = 0.0f;
                            f12 = 0.0f;
                        }
                        int i42 = i4 + 0;
                        int i43 = i4 + 1;
                        int i44 = i4 + 2;
                        int i45 = i4 + 3;
                        path.rCubicTo(f13, f12, fArr3[i42], fArr3[i43], fArr3[i44], fArr3[i45]);
                        f10 = fArr3[i42] + f21;
                        f9 = fArr3[i43] + f22;
                        f21 += fArr3[i44];
                        f8 = fArr3[i45];
                        break;
                    case a.j.AppCompatTheme_windowFixedWidthMinor /*116*/:
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f25 = f21 - f17;
                            f14 = f22 - f18;
                        } else {
                            f14 = 0.0f;
                        }
                        int i46 = i4 + 0;
                        int i47 = i4 + 1;
                        path2.rQuadTo(f25, f14, fArr3[i46], fArr3[i47]);
                        float f41 = f25 + f21;
                        float f42 = f14 + f22;
                        f21 += fArr3[i46];
                        f22 += fArr3[i47];
                        f18 = f42;
                        f17 = f41;
                        break;
                    case a.j.AppCompatTheme_windowMinWidthMinor /*118*/:
                        int i48 = i4 + 0;
                        path2.rLineTo(0.0f, fArr3[i48]);
                        f11 = fArr3[i48];
                        break;
                    default:
                        float f43 = f22;
                        float f44 = f21;
                        break;
                }
            }
            fArr[0] = f21;
            fArr[1] = f22;
            fArr[2] = f17;
            fArr[3] = f18;
            fArr[4] = f23;
            fArr[5] = f24;
        }

        public static void a(C0005b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < bVarArr.length; i++) {
                a(path, fArr, c, bVarArr[i].a, bVarArr[i].b);
                c = bVarArr[i].a;
            }
        }

        public void a(C0005b bVar, C0005b bVar2, float f) {
            for (int i = 0; i < bVar.b.length; i++) {
                this.b[i] = (bVar.b[i] * (1.0f - f)) + (bVar2.b[i] * f);
            }
        }
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static Path a(String str) {
        Path path = new Path();
        C0005b[] b = b(str);
        if (b == null) {
            return null;
        }
        try {
            C0005b.a(b, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r10.b = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r2 == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[LOOP:0: B:1:0x0007->B:19:0x0038, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A[SYNTHETIC] */
    private static void a(String str, int i, a aVar) {
        aVar.b = false;
        int i2 = i;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt != 'E' && charAt != 'e') {
                    switch (charAt) {
                        case a.j.AppCompatTheme_buttonStyle /*44*/:
                            break;
                        case a.j.AppCompatTheme_buttonStyleSmall /*45*/:
                            if (i2 != i) {
                            }
                            break;
                        case a.j.AppCompatTheme_checkboxStyle /*46*/:
                            if (!z2) {
                                z = false;
                                z2 = true;
                                break;
                            }
                            break;
                    }
                } else {
                    z = true;
                    if (!z3) {
                        aVar.a = i2;
                    }
                    i2++;
                }
            }
            z = false;
            z3 = true;
            if (!z3) {
            }
        }
        aVar.a = i2;
    }

    private static void a(ArrayList<C0005b> arrayList, char c, float[] fArr) {
        arrayList.add(new C0005b(c, fArr));
    }

    public static boolean a(C0005b[] bVarArr, C0005b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i = 0; i < bVarArr.length; i++) {
            if (bVarArr[i].a != bVarArr2[i].a || bVarArr[i].b.length != bVarArr2[i].b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] a(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static C0005b[] a(C0005b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        C0005b[] bVarArr2 = new C0005b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new C0005b(bVarArr[i]);
        }
        return bVarArr2;
    }

    public static void b(C0005b[] bVarArr, C0005b[] bVarArr2) {
        for (int i = 0; i < bVarArr2.length; i++) {
            bVarArr[i].a = bVarArr2[i].a;
            for (int i2 = 0; i2 < bVarArr2[i].b.length; i2++) {
                bVarArr[i].b[i2] = bVarArr2[i].b[i2];
            }
        }
    }

    public static C0005b[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a2 = a(str, i);
            String trim = str.substring(i2, a2).trim();
            if (trim.length() > 0) {
                a((ArrayList<C0005b>) arrayList, trim.charAt(0), c(trim));
            }
            i2 = a2;
            i = a2 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a((ArrayList<C0005b>) arrayList, str.charAt(i2), new float[0]);
        }
        return (C0005b[]) arrayList.toArray(new C0005b[arrayList.size()]);
    }

    private static float[] c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                a(str, i, aVar);
                int i3 = aVar.a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = aVar.b ? i3 : i3 + 1;
            }
            return a(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }
}
