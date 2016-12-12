package io.micro.roundedview;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 圆形的ImageView
 *
 * @author act262@gmail.com
 */
public class CircleImageView extends ImageView {
    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setBackground(Drawable background) {
        Drawable finalDrawable = background;
        if (background instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmapDrawable.getBitmap());
            drawable.setCircular(true);
            finalDrawable = drawable;
        } else if (background instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) background;
//            Bitmap bitmap = Bitmap.createBitmap(colorDrawable.getIntrinsicWidth(), colorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
//            Canvas canvas = new Canvas(bitmap);
//            canvas.drawColor(colorDrawable.getColor());
//            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
//            roundedBitmapDrawable.setCircular(true);
//            finalDrawable = roundedBitmapDrawable;
        }
        super.setBackground(finalDrawable);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        Drawable finalDrawable = drawable;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            RoundedBitmapDrawable drawable1 = RoundedBitmapDrawableFactory.create(getResources(), bitmapDrawable.getBitmap());
            drawable1.setCircular(true);
            finalDrawable = drawable1;
        }
        super.setImageDrawable(finalDrawable);
    }

}
