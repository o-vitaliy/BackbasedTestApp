package ru.ovi.backbased.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import ru.ovi.backbased.R

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        with(findNavController(R.id.nav_host_fragment)) {
            addOnDestinationChangedListener { controller, _, _ ->
                runOnUiThread { title = controller.currentDestination?.label }
            }
        }
    }
}
