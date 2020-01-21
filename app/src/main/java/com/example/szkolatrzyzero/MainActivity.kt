package com.example.szkolatrzyzero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ocenLiczbe(v: View) {
        text_wyniku.visibility = View.VISIBLE
        val twojaLiczba: Int = Integer.parseInt(twoja_liczba.text.toString())

        if (twojaLiczba <= 10) {
            text_wyniku.text = "Twoja liczba jest mala"
        } else if (twojaLiczba in 11..40) {
            text_wyniku.text = "Twoja liczba jest w miare mala"
        } else if (twojaLiczba in 41..89) {
            text_wyniku.text = "Twoja liczba jest calkiem duza"
        } else {
            text_wyniku.text = "Twoja liczba jest bardzo duza"
        }
    }
}
