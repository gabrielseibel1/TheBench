package br.com.embs.thebench

import bilbo.randomforestensemble.BilboBenchmark
import kotlinx.coroutines.experimental.launch
import network.FlexNetBenchmark
import kotlin.system.measureTimeMillis

sealed class Runner {

    /**
     * Main function to run an algorithm
     */
    abstract fun run()
}

class Algorithm1Runner(private val runnerListener: RunnerListener) : Runner() {
    override fun run() {
        launch {
            runnerListener.onStartRunning()
            val time = measureTimeMillis {
                BilboBenchmark(10).run()
            }
            runnerListener.onEndRunning(time)
        }
    }
}

class Algorithm2Runner(private val runnerListener: RunnerListener) : Runner() {
    override fun run() {
        launch {
            runnerListener.onStartRunning()
            val milliSeconds = measureTimeMillis {
                FlexNetBenchmark(10).run()
            }
            runnerListener.onEndRunning(milliSeconds)
        }
    }
}
