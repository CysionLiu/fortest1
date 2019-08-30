package com.cysion.img

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cysion.img.other.PicassoImageLoader
import com.isseiaoki.simplecropview.FreeCropImageView
import com.lzy.imagepicker.ImagePicker
import com.lzy.imagepicker.bean.ImageItem
import com.lzy.imagepicker.ui.ImageGridActivity
import com.lzy.imagepicker.view.CropImageView
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    val IMAGE_PICKER=200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initImageConfig()
        vTvSelectImg.setOnClickListener {
            Toast.makeText(this,"sdf",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ImageGridActivity::class.java)
            startActivityForResult(intent, IMAGE_PICKER)
        }
        vBtn1.setOnClickListener {
            Log.d("--","hello")
            Toast.makeText(this,"22",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initImageConfig() {
        val imagePicker = ImagePicker.getInstance()
        imagePicker.imageLoader = PicassoImageLoader()   //设置图片加载器
        imagePicker.isShowCamera = true  //显示拍照按钮
        imagePicker.isCrop = true        //允许裁剪（单选才有效）
        imagePicker.setFreeCrop(true, FreeCropImageView.CropMode.FREE)//新版添加,自由裁剪，优先于setCrop
        imagePicker.isSaveRectangle = true //是否按矩形区域保存
        imagePicker.selectLimit = 9    //选中数量限制
        imagePicker.style = CropImageView.Style.RECTANGLE  //裁剪框的形状
        imagePicker.focusWidth = 800   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.focusHeight = 800  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.outPutX = 1000//保存文件的宽度。单位像素
        imagePicker.outPutY = 1000//保存文件的高度。单位像素
        Toast.makeText(this,"111",Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                val images =
                    data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS) as ArrayList<ImageItem>
                images.forEach {
                    Log.d("--","${it.name}")
                }
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show()
            }
        }

    }
    /*
    WeDialog.loading()
    WeDialog.dismiss()
    WeDialog.title().msg().lText().rText().cancelable().touchCancelable()
    .yes{
    }
    .no{
    }.show(activity)



     */
}
