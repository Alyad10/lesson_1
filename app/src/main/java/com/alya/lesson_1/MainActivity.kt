package com.alya.lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.alya.lesson_1.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

//Первоначально добавляем в массив 5 рандомных url картинок.
//В xml вы добавляете ImageView, EditText, Button, RandomButton
//При ввводе и нажатии кнопки submit в массив добавляете урл картинки
//при нажатии на рандомБаттон вы рандомно через глайд выводите картинку
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val data = arrayListOf(
       "https://klike.net/uploads/posts/2019-01/1547365376_1.jpg",
        "https://www.kartinki24.ru/uploads/gallery/main/430/kartinki24_ru_spring_166.jpg",
        "https://natworld.info/wp-content/uploads/2018/08/solnechnyj-den.jpg",
        "https://julia-flower.ru/wp-content/uploads/2022/10/vip-buket.jpg",
        "https://www.moscvettorg.com/upload/resize_cache/iblock/5ae/999_999_14d11571e4295db598e18fe87b0046293/buket_tsvetov_love_story.jpg"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            btnSubmit.setOnClickListener {
                if (binding.edText.text.isNotEmpty() && Patterns.WEB_URL.matcher(binding.edText.text.toString())
                        .matches()
                ) {
                    data.add(binding.edText.text.toString())
                    Toast.makeText(this@MainActivity, getString(R.string.image_in_list), Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@MainActivity, getString(R.string.image_is_not_available), Toast.LENGTH_SHORT).show()

                }
                binding.edText.text.clear()

            }
        }
        binding.btnRandom.setOnClickListener {
            Glide.with(this).load(data.random()).into(binding.ivImage)
        }
    }
}