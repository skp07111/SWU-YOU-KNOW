package com.example.guruapp_1

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_image2.*
import java.io.File

class ImageActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image2)

        val imgFile1 = File("/data/user/0/com.example.guruapp_1/cache/" + DormitoryCafeteria().dormitoryImgName1)
        val imgFile2 = File("/data/user/0/com.example.guruapp_1/cache/" + DormitoryCafeteria().dormitoryImgName2)
        val imgFile3 = File("/data/user/0/com.example.guruapp_1/cache/" + DormitoryCafeteria().dormitoryImgName3)

        val path1 = BitmapFactory.decodeFile(imgFile1.getAbsolutePath())
        val path2 = BitmapFactory.decodeFile(imgFile2.getAbsolutePath())
        val path3 = BitmapFactory.decodeFile(imgFile3.getAbsolutePath())



        val img = when(intent.getIntExtra("pos", 1)) {
            1 -> path1
            2 -> path2
            else -> path3
        }
        image_full.setImageBitmap(img)

        image_full.setOnClickListener {
            supportFinishAfterTransition()
        }

    }

}