package com.example.android.toastapp

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var clickCount = 0
    private var showClickCount: TextView? = null
    private var clickButton:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showClickCount = findViewById<View>(R.id.show_count) as TextView
        clickButton = findViewById<View>(R.id.button_count) as Button

        if (savedInstanceState!=null){
            clickCount=savedInstanceState.getInt("COUNT")
            showClickCount!!.text = Integer.toString(clickCount)

        }

        clickButton?.setOnLongClickListener(View.OnLongClickListener {
             v:View->
                clickCount=0;
                showClickCount?.setText(Integer.toString(clickCount))
                true
        })
    }

    fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countUp(view: View) {
        clickCount++
        if (showClickCount != null) {
            showClickCount!!.text = Integer.toString(clickCount)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNT", clickCount);
    }
}
