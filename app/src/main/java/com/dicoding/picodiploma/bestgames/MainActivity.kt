package com.dicoding.picodiploma.bestgames
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var rvGames: RecyclerView //inisialisasi variabel recyclerview games
    private val list = ArrayList<Game>() //variabel untuk menampung data Game.kt dalam bentuk arraylist


    //menambahkan intent beserta datanya pada bagian onClick
    override fun onClick(v : View) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowCustomEnabled(true)

        rvGames = findViewById(R.id.rv_games)
        rvGames.setHasFixedSize(true)

        list.addAll(getListGames())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_page -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }
        return true
    }

    private fun getListGames(): ArrayList<Game> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataRating = resources.getStringArray(R.array.data_rating)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataProfile = resources.obtainTypedArray(R.array.data_profile_creator)
        val dataCreator = resources.getStringArray(R.array.data_creator)
        val listGame = ArrayList<Game>()
        for (i in dataName.indices) {
            val game = Game(dataName[i], dataDescription[i], dataRating[i],dataPhoto.getResourceId(i, -1),dataProfile.getResourceId(i, -1), dataCreator[i])
            listGame.add(game)
        }
        return listGame
    }

    private fun showRecyclerList() {
        rvGames.layoutManager = LinearLayoutManager(this)
        val listGameAdapter = ListGameAdapter(list)
        rvGames.adapter = listGameAdapter
    }


}

