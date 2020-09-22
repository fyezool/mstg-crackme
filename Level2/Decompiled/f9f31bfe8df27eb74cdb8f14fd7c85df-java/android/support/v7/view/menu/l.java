package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.c.a.b;
import android.support.v4.g.c;
import android.support.v7.view.menu.k;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class l extends k {

    class a extends k.a implements ActionProvider.VisibilityListener {
        c.b c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public void a(c.b bVar) {
            this.c = bVar;
            this.a.setVisibilityListener(bVar != null ? this : null);
        }

        public boolean b() {
            return this.a.overridesItemVisibility();
        }

        public boolean c() {
            return this.a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.c != null) {
                this.c.a(z);
            }
        }
    }

    l(Context context, b bVar) {
        super(context, bVar);
    }

    /* access modifiers changed from: package-private */
    public k.a a(ActionProvider actionProvider) {
        return new a(this.a, actionProvider);
    }
}
