package com.neppplus.intent_20220521

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_message.*

class ViewMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_message)

//        화면에 들어오자마자 > 보내준 메세지 추출 > 텍스트뷰에 반영.
//        이벤트 처리 X. 바로 실행

        val receivedMessage =  intent.getStringExtra("msg")

        txtMessage.text = receivedMessage

    }
}