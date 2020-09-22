package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.h;
import android.view.ActionMode;
import android.view.Window;

class i extends h {
    private final UiModeManager t;

    class a extends h.a {
        a(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (!i.this.o() || i != 0) ? super.onWindowStartingActionMode(callback, i) : a(callback);
        }
    }

    i(Context context, Window window, d dVar) {
        super(context, window, dVar);
        this.t = (UiModeManager) context.getSystemService("uimode");
    }

    /* access modifiers changed from: package-private */
    public Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    /* access modifiers changed from: package-private */
    public int d(int i) {
        if (i == 0 && this.t.getNightMode() == 0) {
            return -1;
        }
        return super.d(i);
    }
}
