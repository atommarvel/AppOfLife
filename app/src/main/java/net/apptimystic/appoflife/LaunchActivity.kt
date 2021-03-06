package net.apptimystic.appoflife

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.apptimystic.appoflife.core.App
import net.apptimystic.appoflife.feature.directory.DirectoryView

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        (application as App).component?.inject(this)

        val intent = Intent(this, DirectoryView::class.java)
        startActivity(intent)
    }
}
