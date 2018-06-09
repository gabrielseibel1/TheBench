package br.com.embs.thebench

import android.app.Activity
import android.widget.Toast

interface RunnerListener {
    fun onStartRunning()
    fun onEndRunning(milliseconds: Long)
}

class DeafRunnerListener : RunnerListener {
    override fun onStartRunning() {}
    override fun onEndRunning(milliseconds: Long) {}
}

class ToasterRunnerListener(private val activity: Activity, private val algorithm: Algorithm) : RunnerListener {
    override fun onStartRunning() = activity.toast("Starting $algorithm")
    override fun onEndRunning(milliseconds: Long) = activity.toast("Finished $algorithm in $milliseconds ms")
}

fun Activity.toast(message: CharSequence) = this.runOnUiThread {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}