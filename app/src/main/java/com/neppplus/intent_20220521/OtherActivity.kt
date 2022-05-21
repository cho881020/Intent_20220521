package com.neppplus.intent_20220521

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        btnMoveBack.setOnClickListener {

//            메인 화면으로 돌아가기 (현재 화면 종료)

//            val myIntent = Intent( this, MainActivity::class.java )
//            startActivity(myIntent)

            finish()

        }

    }
}