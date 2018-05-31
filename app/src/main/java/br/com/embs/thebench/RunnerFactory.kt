package br.com.embs.thebench

enum class Algorithm {
    ALGORITHM1, ALGORITHM2
}

class RunnerFactory {
    fun create(whatToRun: Enum<Algorithm>, listener: RunnerListener): Runner = when (whatToRun) {
        Algorithm.ALGORITHM1 -> Algorithm1Runner(listener)
        else -> Algorithm2Runner(listener)
    }
} 