package kr.co.tjoeun.intent_20210221

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToFirstActivity.setOnClickListener {
            //firstActivity로 넘어가기
            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)
        }

        sendBtn.setOnClickListener {
            //입력한 문구를 String으로 추출
            val inputContent = contentEdit.text.toString()

            //두번째 화면으로 이동 => inputContent의 값을 들고.

        }
    }
}