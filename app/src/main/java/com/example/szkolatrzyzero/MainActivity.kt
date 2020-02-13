package com.example.szkolatrzyzero

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ocenLiczbe(v: View) {
        hideKeyboard(this)
        text_wyniku.text = ""
        text_wyniku.visibility = View.VISIBLE

        val twojaLiczba: Int = Integer.parseInt(twoja_liczba.text.toString())

        if (twojaLiczba > 100 || twojaLiczba < 1) {
            text_wyniku.text = "Podałeś liczbę spoza zakresu"
            image.setImageResource(R.drawable.error)
        } else {
            when {
                twojaLiczba <= 10 -> {
                    text_wyniku.text = "Twoja liczba jest mala"
                    image.setImageResource(R.drawable.mouse)
                }
                twojaLiczba in 11..40 -> {
                    text_wyniku.text = "Twoja liczba jest w miare mala"
                    image.setImageResource(R.drawable.dog)
                }
                twojaLiczba in 41..89 -> {
                    text_wyniku.text = "Twoja liczba jest calkiem duza"
                    image.setImageResource(R.drawable.tiger)
                }
                else -> {
                    text_wyniku.text = "Twoja liczba jest bardzo duza"
                    image.setImageResource(R.drawable.elephant)
                }
            }
        }
    }

    fun zgadnijLiczbe(v: View) {
        hideKeyboard(this)
        text_wyniku.visibility = View.VISIBLE

        val liczbaZgadywana = 47
        val twojaLiczba: Int = Integer.parseInt(twoja_liczba.text.toString())

        if (twojaLiczba > 100 || twojaLiczba < 1) {
            text_wyniku.text = "Podałeś liczbę spoza zakresu"
            image.setImageResource(R.drawable.error)
        } else {
            when {
                twojaLiczba < liczbaZgadywana -> {
                    text_wyniku.text = "Ustalona liczba jest większa"
                    image.setImageResource(R.drawable.more)
                }
                twojaLiczba == liczbaZgadywana -> {
                    text_wyniku.text = "Yuhu zgadles!"
                    image.setImageResource(R.drawable.success)
                }
                twojaLiczba > liczbaZgadywana -> {
                    text_wyniku.text = "Ustalona liczba jest mniejsza"
                    image.setImageResource(R.drawable.less)
                }
            }
        }
    }

    private fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}