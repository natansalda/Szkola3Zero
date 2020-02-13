package com.example.szkolatrzyzero

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ocenLiczbe(v: View) {
        text_wyniku.text = ""
        text_wyniku.visibility = View.VISIBLE

        val twojaLiczba: Int = Integer.parseInt(twoja_liczba.text.toString())

        if (twojaLiczba > 100 || twojaLiczba < 1) {
            text_wyniku.text = "Podałeś liczbę spoza zakresu"
        } else {
            when {
                twojaLiczba <= 10 -> {
                    text_wyniku.text = "Twoja liczba jest mala"
                }
                twojaLiczba in 11..40 -> {
                    text_wyniku.text = "Twoja liczba jest w miare mala"
                }
                twojaLiczba in 41..89 -> {
                    text_wyniku.text = "Twoja liczba jest calkiem duza"
                }
                else -> {
                    text_wyniku.text = "Twoja liczba jest bardzo duza"
                }
            }
        }
    }

    fun zgadnijLiczbe(v: View) {
        text_wyniku.visibility = View.VISIBLE

        val liczbaZgadywana = 47

        val twojaLiczba: Int = Integer.parseInt(twoja_liczba.text.toString())

        if (twojaLiczba > 100 || twojaLiczba < 1) {
            text_wyniku.text = "Podałeś liczbę spoza zakresu"
        } else {
            when {
                twojaLiczba < liczbaZgadywana -> {
                    text_wyniku.text = "Ustalona liczba jest większa"
                }
                twojaLiczba == liczbaZgadywana -> {
                    text_wyniku.text = "Yuhu zgadles!"
                }
                twojaLiczba > liczbaZgadywana -> {
                    text_wyniku.text = "Ustalona liczba jest mniejsza"
                }
            }
        }
    }
}