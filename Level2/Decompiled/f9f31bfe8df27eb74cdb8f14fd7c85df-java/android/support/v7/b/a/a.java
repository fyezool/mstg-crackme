package android.support.v7.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class a {
    private static int a(int i, float f) {
        return android.support.v4.b.a.b(i, Math.round(((float) Color.alpha(i)) * f));
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2 || next == 1) {
                if (next != 2) {
                    return a(resources, xmlPullParser, asAttributeSet, theme);
                }
                throw new XmlPullParserException("No start tag found");
            }
            next = xmlPullParser.next();
            break;
        } while (next == 1);
        if (next != 2) {
        }
    }

    private static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009c  */
    private static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int attributeCount;
        int i;
        int i2;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[iArr.length];
        int i4 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i3 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                int[] iArr3 = new int[i4];
                int[][] iArr4 = new int[i4][];
                System.arraycopy(iArr2, 0, iArr3, 0, i4);
                System.arraycopy(iArr, 0, iArr4, 0, i4);
            } else {
                if (next != 2 || depth > depth2 || !xmlPullParser.getName().equals("item")) {
                    Resources resources2 = resources;
                    Resources.Theme theme2 = theme;
                } else {
                    TypedArray a = a(resources, theme, attributeSet2, a.j.ColorStateListItem);
                    int color = a.getColor(a.j.ColorStateListItem_android_color, -65281);
                    float f = 1.0f;
                    if (a.hasValue(a.j.ColorStateListItem_android_alpha)) {
                        i2 = a.j.ColorStateListItem_android_alpha;
                    } else {
                        if (a.hasValue(a.j.ColorStateListItem_alpha)) {
                            i2 = a.j.ColorStateListItem_alpha;
                        }
                        a.recycle();
                        attributeCount = attributeSet.getAttributeCount();
                        int[] iArr5 = new int[attributeCount];
                        int i5 = 0;
                        for (i = 0; i < attributeCount; i++) {
                            int attributeNameResource = attributeSet2.getAttributeNameResource(i);
                            if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == a.C0011a.alpha)) {
                                int i6 = i5 + 1;
                                if (!attributeSet2.getAttributeBooleanValue(i, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr5[i5] = attributeNameResource;
                                i5 = i6;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr5, i5);
                        int a2 = a(color, f);
                        if (i4 != 0) {
                            int length = trimStateSet.length;
                        }
                        iArr2 = c.a(iArr2, i4, a2);
                        iArr = c.a((T[]) iArr, i4, trimStateSet);
                        i4++;
                    }
                    f = a.getFloat(i2, 1.0f);
                    a.recycle();
                    attributeCount = attributeSet.getAttributeCount();
                    int[] iArr52 = new int[attributeCount];
                    int i52 = 0;
                    while (i < attributeCount) {
                    }
                    int[] trimStateSet2 = StateSet.trimStateSet(iArr52, i52);
                    int a22 = a(color, f);
                    if (i4 != 0) {
                    }
                    iArr2 = c.a(iArr2, i4, a22);
                    iArr = c.a((T[]) iArr, i4, trimStateSet2);
                    i4++;
                }
                i3 = 1;
            }
        }
        int[] iArr32 = new int[i4];
        int[][] iArr42 = new int[i4][];
        System.arraycopy(iArr2, 0, iArr32, 0, i4);
        System.arraycopy(iArr, 0, iArr42, 0, i4);
        return new ColorStateList(iArr42, iArr32);
    }
}
