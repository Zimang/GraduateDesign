package top.zimang.lifemodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import top.zimang.lifemodel.model.db.LifeModelSource

open class BaseActivity : AppCompatActivity() {
    fun getLifeModelSource(): LifeModelSource {
        return LifeModelSource(this.application)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun showToast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

}