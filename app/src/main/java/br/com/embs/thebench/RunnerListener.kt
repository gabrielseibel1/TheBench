package br.com.embs.thebench

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast

interface RunnerListener {
    fun onStartRunning()
    fun onEndRunning(milliseconds: Long)
}

class DeafRunnerListener(): RunnerListener {
    override fun onStartRunning() {}
    override fun onEndRunning(milliseconds: Long) {}
}

class ToasterRunnerListener(private val context: Context, private val algorithm: Algorithm) : RunnerListener {
    override fun onStartRunning() = context.toast("Starting $algorithm")
    override fun onEndRunning(milliseconds: Long) = context.toast("Finished $algorithm in $milliseconds ms")
}

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()