package com.neppplus.intent_20220521

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    1000이라는 숫자가, 닉네임을 가지러 가는거다. 구별하기.
    val REQ_CODE_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMove.setOnClickListener {

//            다른 화면으로 이동하기

            val myIntent = Intent( this, OtherActivity::class.java )
            startActivity(myIntent)


        }

        btnSend.setOnClickListener {

//            1. 입력된 메세지를 변수에 저장
            val inputMessage = edtMessage.text.toString()

//            2. 메세지를 "들고" ViewMessage 화면으로 이동
            val myIntent = Intent( this, ViewMessageActivity::class.java )

//            myIntent에, 메세지를 첨부
            myIntent.putExtra("msg", inputMessage)

            startActivity(myIntent)

        }

        btnEditNickname.setOnClickListener {

            val myIntent = Intent( this, EditNicknameActivity::class.java )

            startActivityForResult( myIntent, REQ_CODE_NICKNAME )

        }

    }
}