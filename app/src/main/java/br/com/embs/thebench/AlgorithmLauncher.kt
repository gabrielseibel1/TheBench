package br.com.embs.thebench

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_algorithm_launcher.*
import kotlinx.android.synthetic.main.content_algorithm_launcher.*

class AlgorithmLauncher : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm_launcher)
        setSupportActionBar(toolbar)

        radioGroup.check(radioButtonBilbo100.id)

        fab.setOnClickListener {

            //select algorithm and dataset percentage
            var selectedAlgorithm: Algorithm = Algorithm.BILBO
            var datasetPercentage: DatasetPercentage = DatasetPercentage.PCT100

            when (radioGroup.checkedRadioButtonId) {
                radioButtonBilbo100.id -> {
                    selectedAlgorithm = Algorithm.BILBO
                    datasetPercentage = DatasetPercentage.PCT100
                }
                radioButtonBilbo75.id -> {
                    selectedAlgorithm = Algorithm.BILBO
                    datasetPercentage = DatasetPercentage.PCT75
                }
                radioButtonBilbo50.id -> {
                    selectedAlgorithm = Algorithm.BILBO
                    datasetPercentage = DatasetPercentage.PCT50
                }
                radioButtonBilbo25.id -> {
                    selectedAlgorithm = Algorithm.BILBO
                    datasetPercentage = DatasetPercentage.PCT25
                }
                radioButtonFlexNet100.id -> {
                    selectedAlgorithm = Algorithm.FLEXNET
                    datasetPercentage = DatasetPercentage.PCT100
                }
                radioButtonFlexNet75.id -> {
                    selectedAlgorithm = Algorithm.FLEXNET
                    datasetPercentage = DatasetPercentage.PCT75
                }
                radioButtonFlexNet50.id -> {
                    selectedAlgorithm = Algorithm.FLEXNET
                    datasetPercentage = DatasetPercentage.PCT50
                }
                radioButtonFlexNet25.id -> {
                    selectedAlgorithm = Algorithm.FLEXNET
                    datasetPercentage = DatasetPercentage.PCT25
                }
            }
            val runnerListener = ProgressBarAndToastRunnerListener(
                    activity = this,
                    progressBar = progressBar,
                    form = listOf(radioGroup, textView, fab),
                    algorithm = selectedAlgorithm
            )
            RunnerFactory().create(selectedAlgorithm, datasetPercentage, runnerListener).run()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //TODO add authors action/menu item to display a dialog with the developers's names
        menuInflater.inflate(R.menu.menu_algorithm_launcher, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
