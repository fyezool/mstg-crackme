package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class c extends b {
    public c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        if (this.a.d) {
            if (this.a.c != null) {
                drawable = this.a.c;
            } else {
                return;
            }
        } else if (this.a.a != null) {
            drawable = this.a.a;
        } else {
            return;
        }
        drawable.getOutline(outline);
    }
}
