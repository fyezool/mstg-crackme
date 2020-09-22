package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.v4.a.a.c;
import android.support.v4.b.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e {

    private static class a implements TypeEvaluator<b.C0005b[]> {
        private b.C0005b[] a;

        private a() {
        }

        /* renamed from: a */
        public b.C0005b[] evaluate(float f, b.C0005b[] bVarArr, b.C0005b[] bVarArr2) {
            if (b.a(bVarArr, bVarArr2)) {
                if (this.a == null || !b.a(this.a, bVarArr)) {
                    this.a = b.a(bVarArr);
                }
                for (int i = 0; i < bVarArr.length; i++) {
                    this.a[i].a(bVarArr[i], bVarArr2[i], f);
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a2 = c.a(resources, theme, attributeSet, a.j);
        int i = 0;
        TypedValue b = c.b(a2, xmlPullParser, "value", 0);
        if ((b != null) && a(b.type)) {
            i = 3;
        }
        a2.recycle();
        return i;
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = true;
        boolean z2 = peekValue != null;
        int i3 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        if (peekValue2 == null) {
            z = false;
        }
        return ((!z2 || !a(i3)) && (!z || !a(z ? peekValue2.type : 0))) ? 0 : 3;
    }

    public static Animator a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : a(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i) {
        return a(context, resources, theme, i, 1.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i, float f) {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = resources.getAnimation(i);
            try {
                Animator a2 = a(context, resources, theme, (XmlPullParser) animation, f);
                if (animation != null) {
                    animation.close();
                }
                return a2;
            } catch (XmlPullParserException e) {
                e = e;
                XmlResourceParser xmlResourceParser2 = animation;
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (IOException e2) {
                e = e2;
                xmlResourceParser = animation;
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e);
                throw notFoundException2;
            } catch (Throwable th) {
                th = th;
                xmlResourceParser = animation;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw th;
            }
        } catch (XmlPullParserException e3) {
            e = e3;
            Resources.NotFoundException notFoundException3 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException3.initCause(e);
            throw notFoundException3;
        } catch (IOException e4) {
            e = e4;
            Resources.NotFoundException notFoundException22 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException22.initCause(e);
            throw notFoundException22;
        } catch (Throwable th2) {
            th = th2;
            if (xmlResourceParser != null) {
            }
            throw th;
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), (AnimatorSet) null, 0, f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc  */
    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) {
        int i2;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AnimatorSet animatorSet2 = animatorSet;
        int depth = xmlPullParser.getDepth();
        AnimatorSet animatorSet3 = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animatorSet3 = a(context, resources, theme, attributeSet, f, xmlPullParser);
                    } else if (name.equals("animator")) {
                        animatorSet3 = a(context, resources, theme, attributeSet, (ValueAnimator) null, f, xmlPullParser);
                    } else {
                        if (name.equals("set")) {
                            AnimatorSet animatorSet4 = new AnimatorSet();
                            TypedArray a2 = c.a(resources2, theme2, attributeSet, a.h);
                            a(context, resources, theme, xmlPullParser, attributeSet, animatorSet4, c.a(a2, xmlPullParser2, "ordering", 0, 0), f);
                            a2.recycle();
                            Context context2 = context;
                            animatorSet3 = animatorSet4;
                        } else if (name.equals("propertyValuesHolder")) {
                            PropertyValuesHolder[] a3 = a(context, resources2, theme2, xmlPullParser2, Xml.asAttributeSet(xmlPullParser));
                            if (!(a3 == null || animatorSet3 == null || !(animatorSet3 instanceof ValueAnimator))) {
                                ((ValueAnimator) animatorSet3).setValues(a3);
                            }
                            i2 = 1;
                        } else {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        if (animatorSet2 != null && i2 == 0) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(animatorSet3);
                        }
                    }
                    Context context3 = context;
                    if (arrayList == null) {
                    }
                    arrayList.add(animatorSet3);
                }
            }
        }
        if (!(animatorSet2 == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet2.playTogether(animatorArr);
            } else {
                animatorSet2.playSequentially(animatorArr);
            }
        }
        return animatorSet3;
    }

    private static Keyframe a(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    private static Keyframe a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        Keyframe keyframe;
        TypedArray a2 = c.a(resources, theme, attributeSet, a.j);
        float a3 = c.a(a2, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue b = c.b(a2, xmlPullParser, "value", 0);
        boolean z = b != null;
        if (i == 4) {
            i = (!z || !a(b.type)) ? 0 : 3;
        }
        if (z) {
            if (i != 3) {
                switch (i) {
                    case 0:
                        keyframe = Keyframe.ofFloat(a3, c.a(a2, xmlPullParser, "value", 0, 0.0f));
                        break;
                    case 1:
                        break;
                    default:
                        keyframe = null;
                        break;
                }
            }
            keyframe = Keyframe.ofInt(a3, c.a(a2, xmlPullParser, "value", 0, 0));
        } else {
            keyframe = i == 0 ? Keyframe.ofFloat(a3) : Keyframe.ofInt(a3);
        }
        int c = c.c(a2, xmlPullParser, "interpolator", 1, 0);
        if (c > 0) {
            keyframe.setInterpolator(d.a(context, c));
        }
        a2.recycle();
        return keyframe;
    }

    private static ObjectAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e3  */
    private static PropertyValuesHolder a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        int size;
        int i2;
        float fraction;
        float fraction2;
        PropertyValuesHolder propertyValuesHolder = null;
        int i3 = i;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    Keyframe keyframe = (Keyframe) arrayList.get(0);
                    Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
                    fraction = keyframe2.getFraction();
                    if (fraction < 1.0f) {
                        if (fraction < 0.0f) {
                            keyframe2.setFraction(1.0f);
                        } else {
                            arrayList.add(arrayList.size(), a(keyframe2, 1.0f));
                            size++;
                        }
                    }
                    fraction2 = keyframe.getFraction();
                    if (fraction2 != 0.0f) {
                        if (fraction2 < 0.0f) {
                            keyframe.setFraction(0.0f);
                        } else {
                            arrayList.add(0, a(keyframe, 0.0f));
                            size++;
                        }
                    }
                    Keyframe[] keyframeArr = new Keyframe[size];
                    arrayList.toArray(keyframeArr);
                    for (i2 = 0; i2 < size; i2++) {
                        Keyframe keyframe3 = keyframeArr[i2];
                        if (keyframe3.getFraction() < 0.0f) {
                            if (i2 == 0) {
                                keyframe3.setFraction(0.0f);
                            } else {
                                int i4 = size - 1;
                                if (i2 == i4) {
                                    keyframe3.setFraction(1.0f);
                                } else {
                                    int i5 = i2 + 1;
                                    int i6 = i2;
                                    while (i5 < i4 && keyframeArr[i5].getFraction() < 0.0f) {
                                        i6 = i5;
                                        i5++;
                                    }
                                    a(keyframeArr, keyframeArr[i6 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i6);
                                }
                            }
                        }
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                    if (i3 == 3) {
                        propertyValuesHolder.setEvaluator(f.a());
                    }
                }
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i3 == 4) {
                    i3 = a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe a2 = a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                if (a2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(a2);
                }
                xmlPullParser.next();
            }
        }
        Keyframe keyframe4 = (Keyframe) arrayList.get(0);
        Keyframe keyframe22 = (Keyframe) arrayList.get(size - 1);
        fraction = keyframe22.getFraction();
        if (fraction < 1.0f) {
        }
        fraction2 = keyframe4.getFraction();
        if (fraction2 != 0.0f) {
        }
        Keyframe[] keyframeArr2 = new Keyframe[size];
        arrayList.toArray(keyframeArr2);
        while (i2 < size) {
        }
        propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr2);
        if (i3 == 3) {
        }
        return propertyValuesHolder;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static PropertyValuesHolder a(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolder;
        Object[] objArr;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i5 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((!z || !a(i4)) && (!z2 || !a(i5))) ? 0 : 3;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            b.C0005b[] b = b.b(string);
            b.C0005b[] b2 = b.b(string2);
            if (b == null && b2 == null) {
                return null;
            }
            if (b != null) {
                a aVar = new a();
                if (b2 == null) {
                    objArr = new Object[]{b};
                } else if (b.a(b, b2)) {
                    objArr = new Object[]{b, b2};
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                return PropertyValuesHolder.ofObject(str, aVar, objArr);
            } else if (b2 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new a(), new Object[]{b2});
            }
        } else {
            f a2 = i == 3 ? f.a() : null;
            if (z3) {
                if (z) {
                    float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                    if (z2) {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f)});
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{dimension});
                    }
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f)});
                }
                propertyValuesHolder2 = propertyValuesHolder;
            } else if (z) {
                int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : a(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
                if (z2) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofInt(str, new int[]{dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0)});
                } else {
                    propertyValuesHolder2 = PropertyValuesHolder.ofInt(str, new int[]{dimension2});
                }
            } else if (z2) {
                propertyValuesHolder2 = PropertyValuesHolder.ofInt(str, new int[]{i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0)});
            }
            if (propertyValuesHolder2 == null || a2 == null) {
                return propertyValuesHolder2;
            }
            propertyValuesHolder2.setEvaluator(a2);
            return propertyValuesHolder2;
        }
    }

    private static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray a2 = c.a(resources, theme, attributeSet, a.g);
        TypedArray a3 = c.a(resources, theme, attributeSet, a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, a2, a3, f, xmlPullParser);
        int c = c.c(a2, xmlPullParser, "interpolator", 0, 0);
        if (c > 0) {
            valueAnimator.setInterpolator(d.a(context, c));
        }
        a2.recycle();
        if (a3 != null) {
            a3.recycle();
        }
        return valueAnimator;
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String a2 = c.a(typedArray, xmlPullParser, "pathData", 1);
        if (a2 != null) {
            String a3 = c.a(typedArray, xmlPullParser, "propertyXName", 2);
            String a4 = c.a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (a3 == null && a4 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            a(b.a(a2), objectAnimator, f * 0.5f, a3, a4);
            return;
        }
        objectAnimator.setPropertyName(c.a(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long a2 = (long) c.a(typedArray, xmlPullParser, "duration", 1, 300);
        long a3 = (long) c.a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a4 = c.a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (c.a(xmlPullParser, "valueFrom") && c.a(xmlPullParser, "valueTo")) {
            if (a4 == 4) {
                a4 = a(typedArray, 5, 6);
            }
            PropertyValuesHolder a5 = a(typedArray, a4, 5, 6, "");
            if (a5 != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{a5});
            }
        }
        valueAnimator.setDuration(a2);
        valueAnimator.setStartDelay(a3);
        valueAnimator.setRepeatCount(c.a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(c.a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            a(valueAnimator, typedArray2, a4, f, xmlPullParser);
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        char c = 0;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f3 = f2 / ((float) (min - 1));
        int i = 0;
        float f4 = 0.0f;
        int i2 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i >= min) {
                break;
            }
            pathMeasure2.getPosTan(f4, fArr3, (float[]) null);
            fArr[i] = fArr3[c];
            fArr2[i] = fArr3[1];
            f4 += f3;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f4 > ((Float) arrayList.get(i3)).floatValue()) {
                f4 -= ((Float) arrayList.get(i3)).floatValue();
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
            c = 0;
        }
        PropertyValuesHolder ofFloat = str3 != null ? PropertyValuesHolder.ofFloat(str3, fArr) : null;
        if (str4 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (ofFloat == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
        } else {
            objectAnimator2.setValues(propertyValuesHolder == null ? new PropertyValuesHolder[]{ofFloat} : new PropertyValuesHolder[]{ofFloat, propertyValuesHolder});
        }
    }

    private static void a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((float) ((i2 - i) + 2));
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static boolean a(int i) {
        return i >= 28 && i <= 31;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    private static PropertyValuesHolder[] a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 3 && eventType != 1) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                        TypedArray a2 = c.a(resources, theme, attributeSet, a.i);
                        String a3 = c.a(a2, xmlPullParser2, "propertyName", 3);
                        int a4 = c.a(a2, xmlPullParser2, "valueType", 2, 4);
                        int i = a4;
                        PropertyValuesHolder a5 = a(context, resources, theme, xmlPullParser, a3, a4);
                        if (a5 == null) {
                            a5 = a(a2, i, 0, 1, a3);
                        }
                        if (a5 != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(a5);
                        }
                        a2.recycle();
                    } else {
                        Resources resources2 = resources;
                        Resources.Theme theme2 = theme;
                        AttributeSet attributeSet2 = attributeSet;
                    }
                }
                xmlPullParser.next();
            } else if (arrayList != null) {
                int size = arrayList.size();
                propertyValuesHolderArr = new PropertyValuesHolder[size];
                for (int i2 = 0; i2 < size; i2++) {
                    propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
                }
            }
        }
        if (arrayList != null) {
        }
        return propertyValuesHolderArr;
    }
}
