package net.apptimystic.appoflife

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.apptimystic.appoflife.todo.TodoActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        (application as App).component?.inject(this)

        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}
