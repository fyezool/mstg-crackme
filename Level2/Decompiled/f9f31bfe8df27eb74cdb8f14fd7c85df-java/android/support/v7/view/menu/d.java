package android.support.v7.view.menu;

class d<T> {
    final T b;

    d(T t) {
        if (t != null) {
            this.b = t;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
}
