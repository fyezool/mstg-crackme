package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

public class k extends Dialog implements d {
    private e a;

    public k(Context context, int i) {
        super(context, a(context, i));
        a().a((Bundle) null);
        a().i();
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0011a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public e a() {
        if (this.a == null) {
            this.a = e.a((Dialog) this, (d) this);
        }
        return this.a;
    }

    public b a(b.a aVar) {
        return null;
    }

    public void a(b bVar) {
    }

    public boolean a(int i) {
        return a().c(i);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    public void b(b bVar) {
    }

    public <T extends View> T findViewById(int i) {
        return a().a(i);
    }

    public void invalidateOptionsMenu() {
        a().f();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a().h();
        super.onCreate(bundle);
        a().a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a().d();
    }

    public void setContentView(int i) {
        a().b(i);
    }

    public void setContentView(View view) {
        a().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        a().a((CharSequence) getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }
}
