package com.wwq.genesislaw.view.widget.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.wwq.genesislaw.view.base.BaseApplication;

import static com.wwq.genesislaw.controller.library.typefacehelper.TypefaceHelper.typeface;

/**
 * Created by wwq on 2017/4/28.
 */

public class TypefaceTextView extends TextView {
    public TypefaceTextView(Context context) {
        this(context, null);
    }

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        typeface(this, BaseApplication.getApplication().getMicrosoftAccor());
    }

    public TypefaceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        typeface(this, BaseApplication.getApplication().getMicrosoftAccor());
    }
}
