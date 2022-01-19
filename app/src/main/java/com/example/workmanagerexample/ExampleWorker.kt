package com.example.workmanagerexample

import android.content.Context
import androidx.work.*
import java.time.Duration

class ExampleWorker(
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    companion object{
        val myWorkerRequest = OneTimeWorkRequestBuilder<ExampleWorker>()
            .setInputData(Data.Builder().build())
            .addTag("THIS IS MY WORK")
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, Duration.ofSeconds(30))
            .build()
    }

    override fun doWork(): Result {
        // perform any action
        val isSuccessfulCall = true

        if (isSuccessfulCall){
            return Result.success()
        } else{
            // when using failure, this is going to fail all enqueued workers
            return Result.retry()
        }
    }

}