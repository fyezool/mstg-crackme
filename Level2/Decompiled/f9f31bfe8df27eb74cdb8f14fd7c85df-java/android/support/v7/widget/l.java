package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.b.a.i;
import android.support.v4.f.f;
import android.support.v4.f.g;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class l {
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private static l b;
    private static final b c = new b(6);
    private static final int[] d = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
    private static final int[] i = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material};
    private WeakHashMap<Context, android.support.v4.f.l<ColorStateList>> j;
    private android.support.v4.f.a<String, c> k;
    private android.support.v4.f.l<String> l;
    private final Object m = new Object();
    private final WeakHashMap<Context, f<WeakReference<Drawable.ConstantState>>> n = new WeakHashMap<>(0);
    private TypedValue o;
    private boolean p;

    private static class a implements c {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.b.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class b extends g<Integer, PorterDuffColorFilter> {
        public b(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) a(Integer.valueOf(b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) a(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    private interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    private static class d implements c {
        d() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 == a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public static PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2 = c.a(i2, mode);
        if (a2 != null) {
            return a2;
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
        c.a(i2, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        LayerDrawable layerDrawable;
        Drawable findDrawableByLayerId;
        int i3;
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (af.b(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable f2 = android.support.v4.b.a.a.f(drawable);
            android.support.v4.b.a.a.a(f2, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 == null) {
                return f2;
            }
            android.support.v4.b.a.a.a(f2, a2);
            return f2;
        }
        if (i2 == a.e.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ar.a(context, a.C0011a.colorControlNormal), a);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i3 = a.C0011a.colorControlNormal;
        } else if (i2 == a.e.abc_ratingbar_material || i2 == a.e.abc_ratingbar_indicator_material || i2 == a.e.abc_ratingbar_small_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ar.c(context, a.C0011a.colorControlNormal), a);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i3 = a.C0011a.colorControlActivated;
        } else if (a(context, i2, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
        a(findDrawableByLayerId, ar.a(context, i3), a);
        a(layerDrawable.findDrawableByLayerId(16908301), ar.a(context, a.C0011a.colorControlActivated), a);
        return drawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return null;
     */
    private Drawable a(Context context, long j2) {
        synchronized (this.m) {
            f fVar = this.n.get(context);
            if (fVar == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) fVar.a(j2);
            if (weakReference != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    Drawable newDrawable = constantState.newDrawable(context.getResources());
                    return newDrawable;
                }
                fVar.b(j2);
            }
        }
    }

    public static l a() {
        if (b == null) {
            b = new l();
            a(b);
        }
        return b;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap<>();
        }
        android.support.v4.f.l lVar = this.j.get(context);
        if (lVar == null) {
            lVar = new android.support.v4.f.l();
            this.j.put(context, lVar);
        }
        lVar.c(i2, colorStateList);
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (af.b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    static void a(Drawable drawable, au auVar, int[] iArr) {
        if (!af.b(drawable) || drawable.mutate() == drawable) {
            if (auVar.d || auVar.c) {
                drawable.setColorFilter(a(auVar.d ? auVar.a : null, auVar.c ? auVar.b : a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    private static void a(l lVar) {
        if (Build.VERSION.SDK_INT < 24) {
            lVar.a("vector", (c) new d());
            lVar.a("animated-vector", (c) new a());
        }
    }

    private void a(String str, c cVar) {
        if (this.k == null) {
            this.k = new android.support.v4.f.a<>();
        }
        this.k.put(str, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    static boolean a(Context context, int i2, Drawable drawable) {
        boolean z;
        int i3;
        PorterDuff.Mode mode = a;
        int i4 = 16842801;
        if (a(d, i2)) {
            i4 = a.C0011a.colorControlNormal;
        } else if (a(f, i2)) {
            i4 = a.C0011a.colorControlActivated;
        } else if (a(g, i2)) {
            mode = PorterDuff.Mode.MULTIPLY;
        } else {
            if (i2 == a.e.abc_list_divider_mtrl_alpha) {
                i4 = 16842800;
                i3 = Math.round(40.8f);
                z = true;
            } else if (i2 != a.e.abc_dialog_material_background) {
                z = false;
                i3 = -1;
                i4 = 0;
            }
            if (z) {
                return false;
            }
            if (af.b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(a(ar.a(context, i4), mode));
            if (i3 != -1) {
                drawable.setAlpha(i3);
            }
            return true;
        }
        z = true;
        i3 = -1;
        if (z) {
        }
    }

    private boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.m) {
            f fVar = this.n.get(context);
            if (fVar == null) {
                fVar = new f();
                this.n.put(context, fVar);
            }
            fVar.b(j2, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList b(Context context) {
        return f(context, ar.a(context, a.C0011a.colorButtonNormal));
    }

    private ColorStateList c(Context context) {
        return f(context, 0);
    }

    private Drawable c(Context context, int i2) {
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == a.e.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{a(context, a.e.abc_cab_background_internal_bg), a(context, a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    private ColorStateList d(Context context) {
        return f(context, ar.a(context, a.C0011a.colorAccent));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A[Catch:{ Exception -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0 A[Catch:{ Exception -> 0x00a8 }] */
    private Drawable d(Context context, int i2) {
        int next;
        if (this.k == null || this.k.isEmpty()) {
            return null;
        }
        if (this.l != null) {
            String a2 = this.l.a(i2);
            if ("appcompat_skip_skip".equals(a2) || (a2 != null && this.k.get(a2) == null)) {
                return null;
            }
        } else {
            this.l = new android.support.v4.f.l<>();
        }
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a3 = a(typedValue);
        Drawable a4 = a(context, a3);
        if (a4 != null) {
            return a4;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        if (next != 2) {
                            String name = xml.getName();
                            this.l.c(i2, name);
                            c cVar = this.k.get(name);
                            if (cVar != null) {
                                a4 = cVar.a(context, xml, asAttributeSet, context.getTheme());
                            }
                            if (a4 != null) {
                                a4.setChangingConfigurations(typedValue.changingConfigurations);
                                a(context, a3, a4);
                            }
                        } else {
                            throw new XmlPullParserException("No start tag found");
                        }
                    }
                }
                if (next != 2) {
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (a4 == null) {
            this.l.c(i2, "appcompat_skip_skip");
        }
        return a4;
    }

    private ColorStateList e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b2 = ar.b(context, a.C0011a.colorSwitchThumbNormal);
        if (b2 == null || !b2.isStateful()) {
            iArr[0] = ar.a;
            iArr2[0] = ar.c(context, a.C0011a.colorSwitchThumbNormal);
            iArr[1] = ar.e;
            iArr2[1] = ar.a(context, a.C0011a.colorControlActivated);
            iArr[2] = ar.h;
            iArr2[2] = ar.a(context, a.C0011a.colorSwitchThumbNormal);
        } else {
            iArr[0] = ar.a;
            iArr2[0] = b2.getColorForState(iArr[0], 0);
            iArr[1] = ar.e;
            iArr2[1] = ar.a(context, a.C0011a.colorControlActivated);
            iArr[2] = ar.h;
            iArr2[2] = b2.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList e(Context context, int i2) {
        android.support.v4.f.l lVar;
        if (this.j == null || (lVar = this.j.get(context)) == null) {
            return null;
        }
        return (ColorStateList) lVar.a(i2);
    }

    private ColorStateList f(Context context, int i2) {
        int a2 = ar.a(context, a.C0011a.colorControlHighlight);
        int c2 = ar.c(context, a.C0011a.colorButtonNormal);
        return new ColorStateList(new int[][]{ar.a, ar.d, ar.b, ar.h}, new int[]{c2, android.support.v4.b.a.a(a2, i2), android.support.v4.b.a.a(a2, i2), i2});
    }

    private void f(Context context) {
        if (!this.p) {
            this.p = true;
            Drawable a2 = a(context, a.e.abc_vector_test);
            if (a2 == null || !a(a2)) {
                this.p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    public Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    public Drawable a(Context context, int i2, boolean z) {
        f(context);
        Drawable d2 = d(context, i2);
        if (d2 == null) {
            d2 = c(context, i2);
        }
        if (d2 == null) {
            d2 = android.support.v4.a.a.a(context, i2);
        }
        if (d2 != null) {
            d2 = a(context, i2, z, d2);
        }
        if (d2 != null) {
            af.a(d2);
        }
        return d2;
    }

    /* access modifiers changed from: package-private */
    public Drawable a(Context context, bb bbVar, int i2) {
        Drawable d2 = d(context, i2);
        if (d2 == null) {
            d2 = bbVar.a(i2);
        }
        if (d2 != null) {
            return a(context, i2, false, d2);
        }
        return null;
    }

    public void a(Context context) {
        synchronized (this.m) {
            f fVar = this.n.get(context);
            if (fVar != null) {
                fVar.c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077  */
    public ColorStateList b(Context context, int i2) {
        int i3;
        ColorStateList e2 = e(context, i2);
        if (e2 == null) {
            if (i2 == a.e.abc_edit_text_material) {
                i3 = a.c.abc_tint_edittext;
            } else if (i2 == a.e.abc_switch_track_mtrl_alpha) {
                i3 = a.c.abc_tint_switch_track;
            } else {
                if (i2 == a.e.abc_switch_thumb_material) {
                    e2 = e(context);
                } else if (i2 == a.e.abc_btn_default_mtrl_shape) {
                    e2 = b(context);
                } else if (i2 == a.e.abc_btn_borderless_material) {
                    e2 = c(context);
                } else if (i2 == a.e.abc_btn_colored_material) {
                    e2 = d(context);
                } else if (i2 == a.e.abc_spinner_mtrl_am_alpha || i2 == a.e.abc_spinner_textfield_background_material) {
                    i3 = a.c.abc_tint_spinner;
                } else if (a(e, i2)) {
                    e2 = ar.b(context, a.C0011a.colorControlNormal);
                } else if (a(h, i2)) {
                    i3 = a.c.abc_tint_default;
                } else if (a(i, i2)) {
                    i3 = a.c.abc_tint_btn_checkable;
                } else if (i2 == a.e.abc_seekbar_thumb_material) {
                    i3 = a.c.abc_tint_seek_thumb;
                }
                if (e2 != null) {
                    a(context, i2, e2);
                }
            }
            e2 = android.support.v7.b.a.b.a(context, i3);
            if (e2 != null) {
            }
        }
        return e2;
    }
}
