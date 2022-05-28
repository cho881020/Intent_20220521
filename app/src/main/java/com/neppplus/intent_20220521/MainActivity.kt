package com.neppplus.intent_20220521

import android.content.Intent
import android.net.Uri
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

        btnDial.setOnClickListener {

//            1. 입력된 폰번 변수 저장

            val inputPhoneNum = edtPhoneNum.text.toString()

//            2. 안드로이드 기본 전화앱으로 이동

//            2.1  어느 번호에? => Uri로 저장
            val myUri = Uri.parse("tel:${ inputPhoneNum }") // 띄어쓰기 끼어있으면 앱이 죽는다.

//            2.2 Uri + DIAL => Intent로 화면 이동
            val myIntent = Intent( Intent.ACTION_DIAL,  myUri )
            startActivity(myIntent)

        }

        btnCall.setOnClickListener {

            val phoneNum = edtPhoneNum.text.toString()
            val myUri = Uri.parse("tel:${phoneNum}")
            val myIntent = Intent( Intent.ACTION_CALL, myUri )
            startActivity(myIntent)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        다른화면에서 결과를 받아서 돌아오면, 종류와 무관하게 무조건 실행되는 코드 영역 (함수)

//        닉네임을 받으러 다녀온게 맞는지? => 대처방안만 코딩.

        if ( requestCode == REQ_CODE_NICKNAME ) {

//            확인 버튼을 누른게 맞는지?

            if (resultCode == RESULT_OK) {

//                닉네임변경 OK, 확인도 OK => 첨부된 닉네임 추출 > UI에 반영.

                val newNickname = data?.getStringExtra("nick")
                txtNickname.text = newNickname

            }


        }


    }

}