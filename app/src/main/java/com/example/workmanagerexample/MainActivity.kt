package com.example.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    val workerManager by lazy {
        WorkManager.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workerManager.enqueue(ExampleWorker.myWorkerRequest)

        workerManager.enqueueUniqueWork("your_work_name", ExistingWorkPolicy.REPLACE, ExampleWorker.myWorkerRequest)
    }
}