package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

public class g {
    static final b a = (Build.VERSION.SDK_INT >= 21 ? new c() : new a());

    static class a implements b {
        a() {
        }

        public ColorStateList a(ImageView imageView) {
            if (imageView instanceof m) {
                return ((m) imageView).getSupportImageTintList();
            }
            return null;
        }

        public void a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof m) {
                ((m) imageView).setSupportImageTintList(colorStateList);
            }
        }

        public void a(ImageView imageView, PorterDuff.Mode mode) {
            if (imageView instanceof m) {
                ((m) imageView).setSupportImageTintMode(mode);
            }
        }

        public PorterDuff.Mode b(ImageView imageView) {
            if (imageView instanceof m) {
                return ((m) imageView).getSupportImageTintMode();
            }
            return null;
        }
    }

    interface b {
        ColorStateList a(ImageView imageView);

        void a(ImageView imageView, ColorStateList colorStateList);

        void a(ImageView imageView, PorterDuff.Mode mode);

        PorterDuff.Mode b(ImageView imageView);
    }

    static class c extends a {
        c() {
        }

        public ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        public void a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable != null && z) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        public void a(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable != null && z) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        public PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    public static ColorStateList a(ImageView imageView) {
        return a.a(imageView);
    }

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        a.a(imageView, colorStateList);
    }

    public static void a(ImageView imageView, PorterDuff.Mode mode) {
        a.a(imageView, mode);
    }

    public static PorterDuff.Mode b(ImageView imageView) {
        return a.b(imageView);
    }
}
