package android.support.v4.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.a.a.a;
import android.support.v4.b.c;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b {

    public static abstract class a {
        public abstract void a(int i);

        public final void a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    a.this.a(i);
                }
            });
        }

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    a.this.a(typeface);
                }
            });
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, aVar, (Handler) null, true);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a2 != null || aVar != null) {
            return a2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a  */
    private static Typeface a(Context context, Resources resources, TypedValue typedValue, int i, int i2, a aVar, Handler handler, boolean z) {
        String str;
        StringBuilder sb;
        String str2;
        Resources resources2 = resources;
        TypedValue typedValue2 = typedValue;
        int i3 = i;
        int i4 = i2;
        a aVar2 = aVar;
        Handler handler2 = handler;
        if (typedValue2.string != null) {
            String charSequence = typedValue2.string.toString();
            if (!charSequence.startsWith("res/")) {
                if (aVar2 != null) {
                    aVar2.a(-3, handler2);
                }
                return null;
            }
            Typeface a2 = c.a(resources, i3, i4);
            if (a2 != null) {
                if (aVar2 != null) {
                    aVar2.a(a2, handler2);
                }
                return a2;
            }
            try {
                if (charSequence.toLowerCase().endsWith(".xml")) {
                    a.C0003a a3 = a.a((XmlPullParser) resources.getXml(i3), resources);
                    if (a3 != null) {
                        return c.a(context, a3, resources, i, i2, aVar, handler, z);
                    }
                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                    if (aVar2 != null) {
                        aVar2.a(-3, handler2);
                    }
                    return null;
                }
                Context context2 = context;
                Typeface a4 = c.a(context, resources, i3, charSequence, i4);
                if (aVar2 != null) {
                    if (a4 != null) {
                        aVar2.a(a4, handler2);
                    } else {
                        aVar2.a(-3, handler2);
                    }
                }
                return a4;
            } catch (XmlPullParserException e) {
                e = e;
                str2 = "ResourcesCompat";
                sb = new StringBuilder();
                str = "Failed to parse xml resource ";
                sb.append(str);
                sb.append(charSequence);
                Log.e(str2, sb.toString(), e);
                if (aVar2 != null) {
                    aVar2.a(-3, handler2);
                }
                return null;
            } catch (IOException e2) {
                e = e2;
                str2 = "ResourcesCompat";
                sb = new StringBuilder();
                str = "Failed to read xml resource ";
                sb.append(str);
                sb.append(charSequence);
                Log.e(str2, sb.toString(), e);
                if (aVar2 != null) {
                }
                return null;
            }
        } else {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i3) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue2);
        }
    }

    public static Drawable a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }
}
