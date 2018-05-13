package net.apptimystic.lifeutils

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.apptimystic.lifeutils.ui.launch.LaunchFragment

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LaunchFragment.newInstance())
                    .commitNow()
        }
    }

}
