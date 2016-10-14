package de.stetro.booking.application.util.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

public class RoundBitmapImageViewTarget extends BitmapImageViewTarget {
    private final ImageView view;
    private final Context context;

    public RoundBitmapImageViewTarget(ImageView view, Context context) {
        super(view);
        this.view = view;
        this.context = context;
    }

    @Override
    protected void setResource(Bitmap resource) {
        RoundedBitmapDrawable circularBitmapDrawable =
                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
        circularBitmapDrawable.setCircular(true);
        view.setImageDrawable(circularBitmapDrawable);
    }
}
