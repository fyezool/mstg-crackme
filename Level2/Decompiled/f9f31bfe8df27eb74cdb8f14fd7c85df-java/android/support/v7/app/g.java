package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.i;
import android.support.v7.app.j;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import java.util.List;

class g extends i {

    class a extends i.a {
        a(Window.Callback callback) {
            super(callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            j.d a = g.this.a(0, true);
            if (!(a == null || a.j == null)) {
                menu = a.j;
            }
            super.onProvideKeyboardShortcuts(list, menu, i);
        }
    }

    g(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    /* access modifiers changed from: package-private */
    public Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }
}
