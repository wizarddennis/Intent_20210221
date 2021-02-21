package kr.co.tjoeun.intent_20210221

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 닉네임변경 요청  - 1001 이라는 것을 아예 변수로 넣어두고 사용하자.
    val REQ_FOR_NICKNAME = 1001

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
            val myIntent = Intent(this, SecondActivity::class.java) // 비행기티켓발권

            // 인텐트의 부가정보로, 들고갈 데이터들을 붙여주자
            myIntent.putExtra("message", inputContent)

            // 필요시 여러개의 데이트를 첨부 가능.(단순 예시)
            myIntent.putExtra("출생년도", 1988)

            startActivity(myIntent) //비행기에 타는 행동
        }

        changeNicknameBtn.setOnClickListener {
            val myIntent = Intent(this, EditNicknameActivity::class.java)

            // 어떤 데이터를 받으러 가는건지를 숫자로 구별해야 함. ex. 닉네임변경 - 1001
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }
    }
}