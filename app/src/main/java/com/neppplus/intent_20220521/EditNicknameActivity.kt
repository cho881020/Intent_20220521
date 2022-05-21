package com.neppplus.intent_20220521

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        btnOk.setOnClickListener {

//            입력한 닉네임을 들고 돌아가기.

//            1. 입력한 내용 변수로.
            val inputNickname = edtNickname.text.toString()

//            2. 화면을 이동하는 길에 > 데이터 첨부 : Intent / putExtra 활용

            val resultIntent = Intent() // 데이터를 첨부하기 위한 용도. 출발/도착지 알려주는 목적 없다.

            resultIntent.putExtra("nick", inputNickname)

//            3. 화면의 결과 설정 (OK 누른게 맞다 + 데이터 들고 돌아가도록)

            setResult( RESULT_OK, resultIntent )

//            4. 이전으로 복귀.
            finish()


        }

    }
}