package com.example.guruapp_1


import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import java.io.File
import java.io.FileOutputStream

class DormitoryCafeteria : AppCompatActivity() {


    private val resultLauncher: ActivityResultLauncher<Intent>? = null

    lateinit var dormitoryImageView1: ImageView

    var dormitoryImgName1 = "DormitoryCafeteria1.png" // 이미지 이름


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dormitory_cafeteria)

        dormitoryImageView1 = findViewById(R.id.dormitoryImageView1)

        dormitoryImageView1.setOnClickListener { clickEvent(it,1) }


        try {
            val imgpath1 = "$cacheDir/$dormitoryImgName1" // 내부 저장소에 저장되어 있는 이미지 경로
            val bm1 = BitmapFactory.decodeFile(imgpath1)
            dormitoryImageView1.setImageBitmap(bm1) // 내부 저장소에 저장된 이미지를 이미지뷰에 셋
            Toast.makeText(applicationContext, "파일 로드 성공", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "파일 로드 실패", Toast.LENGTH_SHORT).show()
        }

    }

    private fun clickEvent(view: View, pos: Int) { // ImageView 클릭 시 실행되도록 구성
        val intent = Intent(this, ImageActivity2::class.java)
        intent.putExtra("pos", pos)
        val opt = ActivityOptions.makeSceneTransitionAnimation(this, view, "imgTrans") // 파라미터 3번 째 String 값은 layout의 ImageView의 추가된 transitionName 값으로 이는 전환 될 Activity의 ImageView에도 똑같이 설정
        startActivity(intent, opt.toBundle())
    }


    fun bt1(view1: View?) {    // 이미지 선택 누르면 실행됨 이미지 고를 갤러리 오픈
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        getResult1.launch(intent)
    }

    private val getResult1 =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {
                RESULT_OK -> {
                    val fileUri = result.data!!.data
                    val resolver = contentResolver
                    try {
                        val instream = resolver.openInputStream(fileUri!!)
                        val imgBitmap = BitmapFactory.decodeStream(instream)
                        dormitoryImageView1!!.setImageBitmap(imgBitmap) // 선택한 이미지 이미지뷰에 셋
                        instream!!.close() // 스트림 닫아주기
                        saveBitmapToJpeg1(imgBitmap) // 내부 저장소에 저장
                        Toast.makeText(applicationContext, "파일 불러오기 성공", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        Toast.makeText(applicationContext, "파일 불러오기 실패", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


    fun saveBitmapToJpeg1(bitmap: Bitmap) {   // 선택한 이미지 내부 저장소에 저장
        val tempFile = File(cacheDir, dormitoryImgName1) // 파일 경로와 이름 넣기
        try {
            tempFile.createNewFile() // 자동으로 빈 파일을 생성하기
            val out = FileOutputStream(tempFile) // 파일을 쓸 수 있는 스트림을 준비하기
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out) // compress 함수를 사용해 스트림에 비트맵을 저장하기
            out.close() // 스트림 닫아주기
            Toast.makeText(applicationContext, "파일 저장 성공", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "파일 저장 실패", Toast.LENGTH_SHORT).show()
        }
    }
}
