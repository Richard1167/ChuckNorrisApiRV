package com.example.chucknorrisapirv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.core.widget.doOnTextChanged
import com.bumptech.glide.Glide
import com.example.chucknorrisapirv.api.controllers.ChuckServiceImpl
import com.example.chucknorrisapirv.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            mainET.doOnTextChanged { text, start, before, count ->
                getSearch(text.toString())
            }
        }
    }

    private fun getSearch(search: String) {
        GlobalScope.launch {
            val chuckRequest = ChuckServiceImpl().getChuckJokesRandom(
                search
            )

            try {
                launch(Dispatchers.Main) {
                    if (chuckRequest.second == null) {
                        chuckRequest.first?.let {
                            binding.run {
                                chuckRequest.first?.result?.let {
                                    mainRV.adapter = JokeAdapter(
                                        it
                                    )
                                }
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("errorChuck", "chuckckckc", e)
            }
        }
    }

    fun getTen(): Int {

        val a: Int? = 10
        a?.let {
            return it
        }

        return 0
    }
}