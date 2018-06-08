package br.com.embs.thebench

enum class Algorithm {
    BILBO, FLEXNET
}

enum class DatasetPercentage {
    PCT100, PCT75, PCT50, PCT25
}

class RunnerFactory {

    fun create(whatToRun: Algorithm, datasetPercentage: DatasetPercentage,
               listener: RunnerListener): Runner = when (whatToRun) {

        Algorithm.BILBO ->
            BilboRunner(listener, datasetPercentage.toBilboDatasetPercentage())
        Algorithm.FLEXNET ->
            FlexNetRunner(listener, datasetPercentage.toFlexNetDatasetPercentage())
    }

    private fun DatasetPercentage.toBilboDatasetPercentage() = when (this) {
        DatasetPercentage.PCT100 -> bilbo.randomforestensemble.DatasetPercentage.PCT100
        DatasetPercentage.PCT75 -> bilbo.randomforestensemble.DatasetPercentage.PCT75
        DatasetPercentage.PCT50 -> bilbo.randomforestensemble.DatasetPercentage.PCT50
        DatasetPercentage.PCT25 -> bilbo.randomforestensemble.DatasetPercentage.PCT25
    }

    private fun DatasetPercentage.toFlexNetDatasetPercentage() = when (this) {
        DatasetPercentage.PCT100 -> network.DatasetPercentage.PCT100
        DatasetPercentage.PCT75 -> network.DatasetPercentage.PCT75
        DatasetPercentage.PCT50 -> network.DatasetPercentage.PCT50
        DatasetPercentage.PCT25 -> network.DatasetPercentage.PCT25
    }
} 