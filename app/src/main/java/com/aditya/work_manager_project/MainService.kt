package com.aditya.work_manager_project

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.core.app.NotificationCompat
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainService():Service() {


val call=MainViewModel()

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){
            Controller.START.name->start()
            Controller.STOP.name-> stop()
        }


        return super.onStartCommand(intent, flags, startId)
    }


    private fun start(){
   CoroutineScope(Dispatchers.IO).launch {
    call.getData().collect{

         for (i in it.iterator()){
             notification(i.name)
         }
        Log.i("KELA",it.toString())
    }
}



    }

    private fun stop(){
       call.stop()
        stopSelf()

    }

    fun notification(name:String){

val channerId="aditya"
val userNotification=NotificationCompat
    .Builder(this,channerId)
    .setSmallIcon(R.drawable.ic_launcher_foreground)
    .setContentTitle("user-info")
    .setContentText(name)
    .setStyle(NotificationCompat.BigTextStyle())
    .build()
        startForeground(1,userNotification)


    }



    enum class Controller{
        START,STOP
    }

}