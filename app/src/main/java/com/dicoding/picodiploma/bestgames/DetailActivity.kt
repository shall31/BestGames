package com.dicoding.picodiploma.bestgames

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //mengenalkan 6 data
        val detailTvName: TextView = findViewById(R.id.detail_name)
        val detailTvDesc: TextView = findViewById(R.id.detail_description)
        val detailTvRating: TextView = findViewById(R.id.detail_rating)
        val detailIvPhoto: ImageView = findViewById(R.id.detail_image)
        val detailIvProfile: ImageView = findViewById(R.id.detail_profile_image)
        val detailTvCreator: TextView = findViewById(R.id.detail_creator)
        val detailButton: Button = findViewById(R.id.action_share)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Game>("key_game", Game::class.java) as Game
        }else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Game>("key_game")
        }

        if (person != null){
            detailTvName.text = person.name
            detailTvDesc.text = person.description
            detailTvRating.text = person.rating
            detailIvPhoto.setImageResource(person.photo)
            detailIvProfile.setImageResource(person.profile)
            detailTvCreator.text = person.creator

            detailButton.setOnClickListener{
                val message: Game = person

                val intent = Intent()

                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Game Name : ${message.name}\nCreator : ${message.creator}\nRating : ${message.rating}\nRated by Gusti")
                intent.type = "text/plain"

                startActivity(Intent.createChooser(intent, "share to"))
            }


        }




    }
}
