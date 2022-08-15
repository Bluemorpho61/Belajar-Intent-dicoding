package com.alkindi.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveactivity : Button =findViewById(R.id.btn_move_activity)
        btnMoveactivity.setOnClickListener(this)

        val btnmoveActivitywithData:Button =findViewById(R.id.btn_move_activity_with_data)
        btnmoveActivitywithData.setOnClickListener(this)

        val btnDialANumber:Button=findViewById(R.id.btn_dial_number)
        btnDialANumber.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity ->{
            val moveIntent =Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_data ->{
                val moveWithDataIntent =Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"Al Kindi F. was here!")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,20)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_dial_number ->{
                val dialNumber ="085704808767"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$dialNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}