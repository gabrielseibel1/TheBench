package br.com.embs.thebench

import android.content.Context
import android.widget.Toast

interface RunnerListener {
    fun onStartRunning()
    fun onEndRunning()
}

class ToasterRunnerListener(private val context: Context, private val algorithm: Algorithm) : RunnerListener {
    override fun onStartRunning() = context.toast("Starting $algorithm")
    override fun onEndRunning() = context.toast("Finished $algorithm")
}

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()