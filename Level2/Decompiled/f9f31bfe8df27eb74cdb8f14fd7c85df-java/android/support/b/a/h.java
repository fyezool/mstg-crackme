package android.support.b.a;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.support.v4.b.a.b;

abstract class h extends Drawable implements b {
    Drawable b;

    h() {
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.b != null) {
            a.a(this.b, theme);
        }
    }

    public void clearColorFilter() {
        if (this.b != null) {
            this.b.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public ColorFilter getColorFilter() {
        if (this.b != null) {
            return a.e(this.b);
        }
        return null;
    }

    public Drawable getCurrent() {
        return this.b != null ? this.b.getCurrent() : super.getCurrent();
    }

    public int getMinimumHeight() {
        return this.b != null ? this.b.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.b != null ? this.b.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        return this.b != null ? this.b.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        return this.b != null ? this.b.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        return this.b != null ? this.b.getTransparentRegion() : super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        if (this.b != null) {
            a.a(this.b);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.b != null ? this.b.setLevel(i) : super.onLevelChange(i);
    }

    public void setChangingConfigurations(int i) {
        if (this.b != null) {
            this.b.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, PorterDuff.Mode mode) {
        if (this.b != null) {
            this.b.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.b != null) {
            this.b.setFilterBitmap(z);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.b != null) {
            a.a(this.b, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.b != null) {
            a.a(this.b, i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.b != null ? this.b.setState(iArr) : super.setState(iArr);
    }
}
