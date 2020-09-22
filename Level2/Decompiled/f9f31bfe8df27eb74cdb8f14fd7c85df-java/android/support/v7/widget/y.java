package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.g.o;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.support.v7.view.d;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class y extends Spinner implements o {
    private static final int[] a = {16843505};
    private final g b;
    private final Context c;
    private ai d;
    private SpinnerAdapter e;
    private final boolean f;
    /* access modifiers changed from: private */
    public b g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public final Rect i;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof as) {
                as asVar = (as) spinnerAdapter;
                if (asVar.a() == null) {
                    asVar.a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.a == null) {
                return null;
            }
            return this.a.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            if (this.a == null) {
                return null;
            }
            return this.a.getItem(i);
        }

        public long getItemId(int i) {
            if (this.a == null) {
                return -1;
            }
            return this.a.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.a != null && this.a.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class b extends ak {
        ListAdapter a;
        private CharSequence h;
        private final Rect i = new Rect();

        public b(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            b((View) y.this);
            a(true);
            a(0);
            a((AdapterView.OnItemClickListener) new AdapterView.OnItemClickListener(y.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    y.this.setSelection(i);
                    if (y.this.getOnItemClickListener() != null) {
                        y.this.performItemClick(view, i, b.this.a.getItemId(i));
                    }
                    b.this.c();
                }
            });
        }

        public void a() {
            ViewTreeObserver viewTreeObserver;
            boolean d = d();
            f();
            h(2);
            super.a();
            e().setChoiceMode(1);
            i(y.this.getSelectedItemPosition());
            if (!d && (viewTreeObserver = y.this.getViewTreeObserver()) != null) {
                final AnonymousClass2 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (!b.this.a((View) y.this)) {
                            b.this.c();
                            return;
                        }
                        b.this.f();
                        b.super.a();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r1);
                a((PopupWindow.OnDismissListener) new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = y.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r1);
                        }
                    }
                });
            }
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.a = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view) {
            return p.m(view) && view.getGlobalVisibleRect(this.i);
        }

        public CharSequence b() {
            return this.h;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int c;
            Drawable h2 = h();
            int i2 = 0;
            if (h2 != null) {
                h2.getPadding(y.this.i);
                i2 = bc.a(y.this) ? y.this.i.right : -y.this.i.left;
            } else {
                Rect b2 = y.this.i;
                y.this.i.right = 0;
                b2.left = 0;
            }
            int paddingLeft = y.this.getPaddingLeft();
            int paddingRight = y.this.getPaddingRight();
            int width = y.this.getWidth();
            if (y.this.h == -2) {
                int a2 = y.this.a((SpinnerAdapter) this.a, h());
                int i3 = (y.this.getContext().getResources().getDisplayMetrics().widthPixels - y.this.i.left) - y.this.i.right;
                if (a2 > i3) {
                    a2 = i3;
                }
                c = Math.max(a2, (width - paddingLeft) - paddingRight);
            } else {
                c = y.this.h == -1 ? (width - paddingLeft) - paddingRight : y.this.h;
            }
            g(c);
            c(bc.a(y.this) ? i2 + ((width - paddingRight) - l()) : i2 + paddingLeft);
        }
    }

    public y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.spinnerStyle);
    }

    public y(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public y(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r12 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
        if (r12 != null) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cc  */
    public y(Context context, AttributeSet attributeSet, int i2, int i3, Resources.Theme theme) {
        super(context, attributeSet, i2);
        CharSequence[] f2;
        TypedArray typedArray;
        d dVar;
        this.i = new Rect();
        aw a2 = aw.a(context, attributeSet, a.j.Spinner, i2, 0);
        this.b = new g(this);
        if (theme != null) {
            dVar = new d(context, theme);
        } else {
            int g2 = a2.g(a.j.Spinner_popupTheme, 0);
            if (g2 != 0) {
                dVar = new d(context, g2);
            } else {
                this.c = Build.VERSION.SDK_INT < 23 ? context : null;
                if (this.c != null) {
                    if (i3 == -1) {
                        try {
                            typedArray = context.obtainStyledAttributes(attributeSet, a, i2, 0);
                            try {
                                i3 = typedArray.hasValue(0) ? typedArray.getInt(0, 0) : i3;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                } catch (Throwable th) {
                                    th = th;
                                    if (typedArray != null) {
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            typedArray = null;
                            Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        } catch (Throwable th2) {
                            th = th2;
                            typedArray = null;
                            if (typedArray != null) {
                                typedArray.recycle();
                            }
                            throw th;
                        }
                    }
                    if (i3 == 1) {
                        final b bVar = new b(this.c, attributeSet, i2);
                        aw a3 = aw.a(this.c, attributeSet, a.j.Spinner, i2, 0);
                        this.h = a3.f(a.j.Spinner_android_dropDownWidth, -2);
                        bVar.a(a3.a(a.j.Spinner_android_popupBackground));
                        bVar.a((CharSequence) a2.d(a.j.Spinner_android_prompt));
                        a3.a();
                        this.g = bVar;
                        this.d = new ai(this) {
                            public s a() {
                                return bVar;
                            }

                            public boolean b() {
                                if (y.this.g.d()) {
                                    return true;
                                }
                                y.this.g.a();
                                return true;
                            }
                        };
                    }
                }
                f2 = a2.f(a.j.Spinner_android_entries);
                if (f2 != null) {
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, f2);
                    arrayAdapter.setDropDownViewResource(a.g.support_simple_spinner_dropdown_item);
                    setAdapter((SpinnerAdapter) arrayAdapter);
                }
                a2.a();
                this.f = true;
                if (this.e != null) {
                    setAdapter(this.e);
                    this.e = null;
                }
                this.b.a(attributeSet, i2);
            }
        }
        this.c = dVar;
        if (this.c != null) {
        }
        f2 = a2.f(a.j.Spinner_android_entries);
        if (f2 != null) {
        }
        a2.a();
        this.f = true;
        if (this.e != null) {
        }
        this.b.a(attributeSet, i2);
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.i);
        return i3 + this.i.left + this.i.right;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.g != null) {
            return this.g.j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        if (this.g != null) {
            return this.g.k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.g != null) {
            return this.h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public Drawable getPopupBackground() {
        if (this.g != null) {
            return this.g.h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        if (this.g != null) {
            return this.c;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public CharSequence getPrompt() {
        return this.g != null ? this.g.b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.b != null) {
            return this.b.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g != null && this.g.d()) {
            this.g.c();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.g != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d == null || !this.d.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        if (this.g == null) {
            return super.performClick();
        }
        if (this.g.d()) {
            return true;
        }
        this.g.a();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f) {
            this.e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.g != null) {
            this.g.a((ListAdapter) new a(spinnerAdapter, (this.c == null ? getContext() : this.c).getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (this.b != null) {
            this.b.a(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        if (this.g != null) {
            this.g.c(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    public void setDropDownVerticalOffset(int i2) {
        if (this.g != null) {
            this.g.d(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.g != null) {
            this.h = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.g != null) {
            this.g.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(android.support.v7.b.a.b.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.g != null) {
            this.g.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }
}
