package br.com.embs.thebench

import bilbo.randomforestensemble.BilboBenchmark
import kotlinx.coroutines.experimental.launch
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
            val time = measureTimeMillis { BilboBenchmark().run() }
            runnerListener.onEndRunning(time)
        }
    }
}

class Algorithm2Runner(private val runnerListener: RunnerListener) : Runner() {
    override fun run() {
        launch {
            runnerListener.onStartRunning()
            //TODO start execution of algorithm 2
            //TODO (high level calls only, code should be in jar)
            val milliSeconds = measureTimeMillis {
                /* do stuff */
            }
            runnerListener.onEndRunning(milliSeconds)
        }
    }
}
