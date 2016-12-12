package io.micro.roundedview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 圆角的TextView
 * <p>
 * TODO:
 * 纯颜色背景用GradientDrawable 来实现
 * <br/>
 * 图片背景用RoundedBitmapDrawable来实现
 *
 * @author act262@gmail.com
 */
public class RoundedTextView extends TextView {

    private float mRadius = 0;

    public RoundedTextView(Context context) {
        super(context);
    }

    public RoundedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundedTextView);
        mRadius = typedArray.getDimension(R.styleable.RoundedTextView_radius, 0);

        // 跟随colorStateList状态颜色
        ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.RoundedTextView_backgroundColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(mRadius);
            gradientDrawable.setColor(colorStateList);
            ViewCompat.setBackground(this, gradientDrawable);
            int[] state = gradientDrawable.getState();
        } else {
            GradientDrawable normalDrawable = new GradientDrawable();
            normalDrawable.setCornerRadius(mRadius);
            normalDrawable.setColor(typedArray.getColor(R.styleable.RoundedTextView_backgroundNormalColor, -1));

            GradientDrawable pressedDrawable = new GradientDrawable();
            pressedDrawable.setCornerRadius(mRadius);
            pressedDrawable.setColor(typedArray.getColor(R.styleable.RoundedTextView_backgroundPressedColor, -1));

            // 单独设置状态颜色
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
            stateListDrawable.addState(new int[]{}, normalDrawable);
            ViewCompat.setBackground(this, stateListDrawable);
        }

        typedArray.recycle();
    }

    public RoundedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mRadius = h / 2;
    }
}
