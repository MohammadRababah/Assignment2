package com.example.carrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    var carMake="Nothing"
    var carType="Nothing"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment= Fragment1()
        val secondFragment= Fragment2()
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.mainFragment, firstFragment)
            commit()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mainMenu -> switch2prev()
            R.id.carMenu -> switch1()
        }

        return super.onOptionsItemSelected(item)
    }

    fun switch1(){
        supportFragmentManager.beginTransaction().apply{
            val secondFragment= Fragment2()
            replace(R.id.mainFragment, secondFragment)
            commit()
        }
    }

    fun switch2(flag1: String, flag2: String){
        supportFragmentManager.beginTransaction().apply{
            carMake=flag1
            carType=flag2
            val thirdFragment= Fragment3()
            replace(R.id.mainFragment, thirdFragment)
            commit()
        }
    }

    fun switch2prev(){
        supportFragmentManager.beginTransaction().apply{
            val firstFragment= Fragment1()
            replace(R.id.mainFragment, firstFragment)
            commit()
        }
    }
    fun getCarTypef(): String {
        return carType
    }
    fun getCarMakef(): String{
        return carMake
    }
}