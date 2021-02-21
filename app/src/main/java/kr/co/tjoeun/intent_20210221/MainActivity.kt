package kr.co.tjoeun.intent_20210221

import android.app.Activity
import android.content.Intent
import android.net.Uri
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

        dialBtn.setOnClickListener {
            val phoneNum = phoneNumEdt.text.toString()
            //폰번호(010-1111-2222) => 안드로이드의 연결정보 (Uri) 로 변환
            val myUri = Uri.parse("tel:${phoneNum}")

            // Intent를 활용해서 => 안드로이드 전화 하면 띄우자
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

        // Dial 과 다른 건 반드시 권한이 필요하다는 것이다.
        callBtn.setOnClickListener {
            val phoneNum = phoneNumEdt.text.toString()
            //폰번호(010-1111-2222) => 안드로이드의 연결정보 (Uri) 로 변환
            val myUri = Uri.parse("tel:${phoneNum}")

            // Intent를 활용해서 => 안드로이드 전화 하면 띄우자
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

        smsBtn.setOnClickListener {
            val smsNum = phoneNumEdt.text.toString()

            // URI 필요
            val myUri = Uri.parse("smsto:${smsNum}")

            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            
            //문자 내용 기본값 입력. => 문자화면에 데이터 첨부.
            myIntent.putExtra("sms_body", "원하는 기본 메세지")
            startActivity(myIntent)
        }

        naverBtn.setOnClickListener {
            val myUri = Uri.parse("https://www.naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        kakaoBtn.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //requestCode 값 확인 => 닉네임을 가지러 갔다온게 맞는가?
        if(requestCode == REQ_FOR_NICKNAME) {
            //확인 버튼을 누른게 맞는지? 확인
            if(resultCode == Activity.RESULT_OK) {
                // 새 닉네임을 받아서 => 닉네임 테스트뷰에 반영.

                val newNickName = data?.getStringExtra("nick")
                nicknameTxt.text = newNickName
            }
        }
    }
}