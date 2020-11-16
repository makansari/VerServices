package com.example.verservices

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_my_async.*

class MyAsyncAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_async)
progressBar.visibility = View.GONE
        buttonaysn.setOnClickListener {

            var task = MyAscyTask()
            task.execute()

        }
    }

    inner class MyAscyTask : AsyncTask<String, Int, String>(){


        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
        }
        override fun doInBackground(vararg params: String?): String {
            for(i in 1..5){
                Thread.sleep(1000)
                publishProgress(i)
            }
            return "Image is downloaded"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

              var data = values[0]
            textViewResultAsync.setText(""+ data)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            progressBar.visibility = View.GONE
            textViewResultAsync.setText(result)

        }

    }
}