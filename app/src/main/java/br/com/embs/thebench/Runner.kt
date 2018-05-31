package br.com.embs.thebench

sealed class Runner {

    /**
     * Main function to run an algorithm
     */
    abstract fun run()
}

class Algorithm1Runner(private val runnerListener: RunnerListener) : Runner() {
    override fun run() {
        runnerListener.onStartRunning()
        //TODO start execution of algorithm 1
        //TODO (high level calls only, code should be in specific directory)
        runnerListener.onEndRunning()
    }
}

class Algorithm2Runner(private val runnerListener: RunnerListener) : Runner() {
    override fun run() {
        runnerListener.onStartRunning()
        //TODO start execution of algorithm 2
        //TODO (high level calls only, code should be in specific directory)
        runnerListener.onEndRunning()
    }
}
