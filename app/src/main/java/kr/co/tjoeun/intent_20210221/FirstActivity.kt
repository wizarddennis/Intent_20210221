package kr.co.tjoeun.intent_20210221

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        moveToFirstActivity.setOnClickListener {
            //firstActivity로 넘어가기
            val myIntent = Intent(this, FirstActivity::class.java)

            startActivity(myIntent)

        }
    }
}