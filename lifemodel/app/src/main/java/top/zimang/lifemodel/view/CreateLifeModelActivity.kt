package top.zimang.lifemodel.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.lifemodel.R
import com.google.android.material.textfield.TextInputEditText
import top.zimang.lifemodel.model.LifeModel
import top.zimang.lifemodel.model.db.LifeModelSource

class CreateLifeModelActivity : BaseActivity() {
    private lateinit var lifeModelName: EditText
    private lateinit var livingPortion: EditText
    private lateinit var investmentPortion: EditText
    private lateinit var savingPortion: EditText
    private lateinit var socialRelationshipPortion: EditText
    private lateinit var lifeModelSource: LifeModelSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_life_model)

        lifeModelSource=LifeModelSource(application)
        setupViews()
    }
    fun setupViews() {
        lifeModelName = findViewById(R.id.life_model_name)
        livingPortion = findViewById(R.id.living_portion)
        investmentPortion = findViewById(R.id.investment_portion)
        savingPortion = findViewById(R.id.saving_portion)
        socialRelationshipPortion = findViewById(R.id.social_relationship_portion)
    }

    fun onClickSaveLifeModel(view: View) {

        val name=lifeModelName.text.toString().trim()
        if (TextUtils.isEmpty(name)) {
            showToast("LifeModel名称不能为空")
        }else if(!checkNameLen(name)){
            showToast("LifeModel名称不能多于16位")
        }else {
            val liPortion=livingPortion.text.toString().trim().toInt()
            val inPortion=investmentPortion.text.toString().trim().toInt()
            val saPortion=savingPortion.text.toString().trim().toInt()
            val soPortion=socialRelationshipPortion.text.toString().trim().toInt()

            if (checkNumber(liPortion,inPortion,saPortion,soPortion)) {
                val lifeModel = LifeModel(null, name, liPortion, inPortion, saPortion, soPortion)
                lifeModelSource.insert(lifeModel)

                setResult(Activity.RESULT_OK)
                finish()
            }
        }}

    private fun checkNumber(a:Int, b:Int, c:Int, d:Int): Boolean {
        if (a<0||b<0||c<0||d<0) {
            showToast("占比不能为负数")
            return false
        }else if (a+b+c+d!=100){
            showToast("占比总和应为100")
            return false
        }
        return true
    }

    private fun checkNameLen(name:String):Boolean{
        val count=name.trim().count()
        val len=name.trim().length
        Log.i("love and peace", "$count  $len")
        if(count>16)
            return false
        return true
    }

}