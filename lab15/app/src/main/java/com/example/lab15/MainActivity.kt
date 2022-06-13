package com.example.lab15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
class MyMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.e("Firebase", "onNewToken $token")
    }

    override fun onMessageReceived(msg: RemoteMessage?) {
        super.onMessageReceived(msg)
        Log.e("Firebase","onMessageReceived")
        msg?.let {
            Log.e("Firebase",it.from)
            for(entry in it.data.entries)
                Log.e("message","${entry.key}/${entry.value}")
        }
    }
}