package kr.co.tjoeun.intent_20210221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 목적지에 도착한 상황 => 첨부한 데이터를 받아주자. (어떤 형태의 자료인가를 생각하고 받아주자)
        val receivedMessage = intent.getStringExtra("message")

        //수신문구 표현 텍스트뷰의 문구로 설정
        receivedMessageTxt.text = receivedMessage

        // 첨부된 출생년도 받는예시 => Int, Double, Boolean 등 기본형(에 가까운)변수들은,
        // 첨부가 안됐을 때 뭘로 꺼낼지
        val  myBirthYear = intent.getIntExtra("출생년도", defaultValue:0)
    }
}