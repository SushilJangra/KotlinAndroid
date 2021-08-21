package com.example.kotlinandroidproject.activity

import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kotlinandroidproject.R
import com.example.kotlinandroidproject.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spannableString = SpannableString(getString(R.string.no_account)).apply {
            setSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    Toast.makeText(this@LoginActivity, "Open signup page", Toast.LENGTH_SHORT)
                        .show()
                }
            },this.length - 14, this.length, 0)
            setSpan(UnderlineSpan(), this.length - 14, this.length, 0)
        }
        binding.tvCreateAccount.apply {
            text = spannableString
            setLinkTextColor(ContextCompat.getColor(this@LoginActivity, R.color.theme_mid))
            movementMethod = LinkMovementMethod()
        }
    }
}