package br.com.embs.thebench

import bilbo.randomforestensemble.BilboBenchmark
import bilbo.randomforestensemble.DatasetPercentage
import kotlinx.coroutines.experimental.launch
import network.FlexNetBenchmark
import kotlin.system.measureTimeMillis

sealed class Runner {

    /**
     * Main function to run an algorithm
     */
    abstract fun run()
}

class BilboRunner(private val runnerListener: RunnerListener,
                  private val datasetPercentage: bilbo.randomforestensemble.DatasetPercentage) : Runner() {

    override fun run() {
        launch {
            runnerListener.onStartRunning()
            val time = measureTimeMillis {
                BilboBenchmark(10, datasetPercentage).run()
            }
            runnerListener.onEndRunning(time)
        }
    }
}

class FlexNetRunner(private val runnerListener: RunnerListener,
                    private val datasetPercentage: network.DatasetPercentage) : Runner() {

    override fun run() {
        launch {
            runnerListener.onStartRunning()
            val milliSeconds = measureTimeMillis {
                FlexNetBenchmark(10, datasetPercentage).run()
            }
            runnerListener.onEndRunning(milliSeconds)
        }
    }
}
