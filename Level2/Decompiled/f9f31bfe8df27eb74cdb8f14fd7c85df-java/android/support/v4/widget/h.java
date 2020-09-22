package android.support.v4.widget;

import android.widget.ListView;

public class h extends a {
    private final ListView f;

    public h(ListView listView) {
        super(listView);
        this.f = listView;
    }

    public void a(int i, int i2) {
        i.a(this.f, i2);
    }

    public boolean e(int i) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    public boolean f(int i) {
        ListView listView = this.f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            return i2 < count || listView.getChildAt(childCount - 1).getBottom() > listView.getHeight();
        }
        if (i >= 0) {
            return false;
        }
        if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
            return false;
        }
    }
}
