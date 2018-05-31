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

        radioGroup.check(radioButtonAlgorithm1.id)

        fab.setOnClickListener {
            val selectedAlgorithm = when (radioGroup.checkedRadioButtonId) {
                radioButtonAlgorithm1.id -> Algorithm.ALGORITHM1
                else -> Algorithm.ALGORITHM2
            }
            val runnerListener = ToasterRunnerListener(this, selectedAlgorithm)
            RunnerFactory().create(selectedAlgorithm, runnerListener).run()
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
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
