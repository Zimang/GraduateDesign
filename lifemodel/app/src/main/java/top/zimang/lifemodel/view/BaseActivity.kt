package top.zimang.lifemodel.view

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.lifemodel.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast
import top.zimang.lifemodel.model.Location
import top.zimang.lifemodel.model.db.LifeModelSource
import top.zimang.lifemodel.model.db.NumbeoDataSource

open class BaseActivity : AppCompatActivity() {
    open lateinit var rdb: NumbeoDataSource
    open lateinit var dbsource:LifeModelSource
    open var countrylocationList: MutableList<Location?>?=null
    override fun onBackPressed() {
        super.onBackPressed()
    }
    override fun onStart() {
        super.onStart()
        rdb= NumbeoDataSource()
        dbsource=getLifeModelSource()
    }

    fun getLifeModelSource(): LifeModelSource {
        return LifeModelSource(this.application)
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
    fun showToast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update_numbeo_data,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val source=getLifeModelSource()
        val numbeoScope= CoroutineScope(Dispatchers.Main)
        Log.i("love","clicked")
        when(item.itemId){
            R.id.updateNumbeoCityAndCountry ->{
                Log.i("love","begin")
                numbeoScope.launch{
                    withContext(Dispatchers.IO){
                        source.updateCountryList()
                        countrylocationList=source.getCountries()
                    }
                    toast("Numbeo数据更新完成")
                }
                return true
            }
            R.id.saveNumbeoCityAndCountry->{
                numbeoScope.launch {
                    withContext(Dispatchers.IO){
                        source.saveCountryList(countrylocationList)
                    }
                    toast("保存完毕")
                }
            }
            else->{
                return true
            }
        }
        return false
    }

}