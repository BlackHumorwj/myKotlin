package com.kotlin.kotlinenhance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private suspend fun getInfo() {
        val user = getUserInfo()

        val friendList = getFriendList(user)

        val feedList = getFeedList(friendList)

        Log.e("xxxx", feedList)

    }

    suspend fun getUserInfo(): String {
        withContext(Dispatchers.IO) {
            delay(1000L)
        }
        return "BoyCoder"
    }

    suspend fun getFriendList(user: String): String {
        withContext(Dispatchers.IO) {
            delay(1000L)
        }
        return "tom,jack"
    }

    suspend fun getFeedList(list: String): String {
        withContext(Dispatchers.IO) {
            delay(1000L)
        }
        return "{feed List}"
    }


}




suspend fun main() {

}

