package com.cysion.img.other

import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import com.cysion.img.R
import com.lzy.imagepicker.loader.ImageLoader
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import java.io.File

class PicassoImageLoader:ImageLoader {
    override fun clearMemoryCache() {


    }

    override fun displayImagePreview(
        activity: Activity?,
        path: String?,
        imageView: ImageView?,
        width: Int,
        height: Int
    ) {
        Picasso.get()//
            .load(Uri.fromFile(File(path)))//
            .placeholder(R.mipmap.ic_launcher)//
            .error(R.mipmap.ic_launcher)//
            .resize(width, height)//
            .centerInside()//
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
            .into(imageView);
    }

    override fun displayImage(
        activity: Activity?,
        path: String?,
        imageView: ImageView?,
        width: Int,
        height: Int
    ) {

        Picasso.get()//
            .load(Uri.fromFile(File(path)))//
            .placeholder(R.mipmap.ic_launcher)//
            .error(R.mipmap.ic_launcher)//
            .resize(width, height)//
            .centerInside()//
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
            .into(imageView);

    }
}