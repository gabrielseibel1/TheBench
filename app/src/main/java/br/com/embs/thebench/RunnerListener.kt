package br.com.embs.thebench

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
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

    private fun Activity.toast(message: CharSequence) = this.runOnUiThread {
        kotlin.repeat(3, {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }
}

class ProgressBarRunnerListener(private val activity: Activity, private val progressBar: ProgressBar,
                                private val form: List<View>) : RunnerListener {

    override fun onStartRunning() {
        activity.runOnUiThread {
            progressBar.apply {
                visibility = View.VISIBLE
                isIndeterminate = true
            }
            form.forEach { view -> view.visibility = View.GONE }
        }
    }
    override fun onEndRunning(milliseconds: Long) {
        activity.runOnUiThread {
            progressBar.visibility = View.GONE
            form.forEach { view -> view.visibility = View.VISIBLE }
        }
    }
}

class ProgressBarAndToastRunnerListener(private val activity: Activity,
                                        private val progressBar: ProgressBar,
                                        private val form: List<View>,
                                        algorithm: Algorithm) : RunnerListener {

    private val toasterRunnerListener = ToasterRunnerListener(activity, algorithm)

    override fun onStartRunning() {
        toasterRunnerListener.onStartRunning()
        activity.runOnUiThread {
            progressBar.apply {
                visibility = View.VISIBLE
                isIndeterminate = true
            }
            form.forEach { view -> view.visibility = View.GONE }
        }
    }
    override fun onEndRunning(milliseconds: Long) {
        activity.runOnUiThread {
            progressBar.visibility = View.GONE
            form.forEach { view -> view.visibility = View.VISIBLE }
        }
        toasterRunnerListener.onEndRunning(milliseconds)
    }
}

