package android.support.v4.widget;

import android.os.Build;
import android.support.v4.g.p;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class j {
    static final d a = (Build.VERSION.SDK_INT >= 23 ? new c() : Build.VERSION.SDK_INT >= 21 ? new b() : Build.VERSION.SDK_INT >= 19 ? new a() : new d());

    static class a extends d {
        a() {
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    static class b extends a {
        private static Field a;

        static {
            try {
                a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        b() {
        }

        public void a(PopupWindow popupWindow, boolean z) {
            if (a != null) {
                try {
                    a.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
                }
            }
        }
    }

    static class c extends b {
        c() {
        }

        public void a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }

        public void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }
    }

    static class d {
        private static Method a;
        private static boolean b;

        d() {
        }

        public void a(PopupWindow popupWindow, int i) {
            if (!b) {
                Class<PopupWindow> cls = PopupWindow.class;
                try {
                    a = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    a.setAccessible(true);
                } catch (Exception unused) {
                }
                b = true;
            }
            if (a != null) {
                try {
                    a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception unused2) {
                }
            }
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((android.support.v4.g.d.a(i3, p.b(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void a(PopupWindow popupWindow, boolean z) {
        }
    }

    public static void a(PopupWindow popupWindow, int i) {
        a.a(popupWindow, i);
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        a.a(popupWindow, z);
    }
}
