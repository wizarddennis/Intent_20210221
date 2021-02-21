package kr.co.tjoeun.intent_20210221

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        okBtn.setOnClickListener {
            val inputNickName = newNicknameEdt.text.toString()

            //데이터 첨부 전용  Intent 생성.
            //복귀용 이므로 출발/도착지 정보 필요 없다. 빈칸유지.
            val resultIntent = Intent()
            resultIntent.putExtra("nick", inputNickName)

            // 확인버튼을 누른게 맞다 명시 + 그때 들고갈 데이터 첨부.
            // 이 화면에 온 결과를 세팅
            setResult(Activity.RESULT_OK, resultIntent)

            //실제로 이전화면으로 복귀.
            finish()
        }


    }
}