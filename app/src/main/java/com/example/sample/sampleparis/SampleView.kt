package com.example.sample.sampleparis

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.paris.annotations.Attr
import com.airbnb.paris.annotations.Styleable
import com.airbnb.paris.annotations.StyleableChild
import com.airbnb.paris.extensions.style

@Styleable("SampleView")
class SampleView : LinearLayout {

    @StyleableChild(R.styleable.SampleView_titleStyle)
    val titleView by lazy { findViewById<TextView>(R.id.title)!! }

    @StyleableChild(R.styleable.SampleView_contentStyle)
    val contentView by lazy { findViewById<TextView>(R.id.content)!! }

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.view_sample, this, true)
        // This call is necessary to support custom attributes (in this case `titleText`, `contentText`, etc) when this view is inflated from XML.
        style(attrs)
    }

    @Attr(R.styleable.SampleView_titleText)
    fun setTitleText(titleText: CharSequence) {
        titleView.text = titleText
    }

    @Attr(R.styleable.SampleView_contentText)
    fun setContentText(contentText: CharSequence) {
        contentView.text = contentText
    }
}
