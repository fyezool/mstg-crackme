package android.support.v4.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class s {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    static class a implements t {
        s a;
        boolean b;

        a(s sVar) {
            this.a = sVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.support.v4.g.t} */
        /* JADX WARNING: Multi-variable type inference failed */
        public void a(View view) {
            this.b = false;
            t tVar = null;
            if (this.a.c > -1) {
                view.setLayerType(2, (Paint) null);
            }
            if (this.a.a != null) {
                Runnable runnable = this.a.a;
                this.a.a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof t) {
                tVar = tag;
            }
            if (tVar != null) {
                tVar.a(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.support.v4.g.t} */
        /* JADX WARNING: Multi-variable type inference failed */
        public void b(View view) {
            t tVar = null;
            if (this.a.c > -1) {
                view.setLayerType(this.a.c, (Paint) null);
                this.a.c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                if (this.a.b != null) {
                    Runnable runnable = this.a.b;
                    this.a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof t) {
                    tVar = tag;
                }
                if (tVar != null) {
                    tVar.b(view);
                }
                this.b = true;
            }
        }

        public void c(View view) {
            Object tag = view.getTag(2113929216);
            t tVar = tag instanceof t ? (t) tag : null;
            if (tVar != null) {
                tVar.c(view);
            }
        }
    }

    s(View view) {
        this.d = new WeakReference<>(view);
    }

    private void a(final View view, final t tVar) {
        if (tVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    tVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    tVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    tVar.a(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public long a() {
        View view = (View) this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public s a(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public s a(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public s a(t tVar) {
        View view = (View) this.d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, tVar);
                tVar = new a(this);
            }
            a(view, tVar);
        }
        return this;
    }

    public s a(final v vVar) {
        final View view = (View) this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            AnonymousClass2 r1 = null;
            if (vVar != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        vVar.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }

    public s a(Interpolator interpolator) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public s b(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public s b(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
