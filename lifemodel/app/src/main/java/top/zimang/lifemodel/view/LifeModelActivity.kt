package top.zimang.lifemodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.lifemodel.R
import top.zimang.lifemodel.model.LifeModel
import top.zimang.lifemodel.utils.WithGson

class LifeModelActivity : AppCompatActivity() {
    lateinit var lifeModel:LifeModel
    lateinit var lifeModelInvestExpanse:TextView
    lateinit var lifeModelSocialExpanse:TextView
    lateinit var lifeModelLiExpanse:TextView
    lateinit var lifeModelSavingExpanse:TextView
//    lateinit var lifeModelName: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeModel= intent?.getStringExtra("life_model")
            ?.let { WithGson.fromJson(it) }!!


        setContentView(R.layout.activity_life_model)
        setUp()
    }
    fun setUp(){
        supportActionBar?.title=lifeModel.lifeModelName
        lifeModelInvestExpanse=findViewById(R.id.item_life_life_model_invest_expanse)
        lifeModelSocialExpanse=findViewById(R.id.item_life_life_model_social_expanse)
        lifeModelLiExpanse=findViewById(R.id.item_life_life_model_li_expanse)
        lifeModelSavingExpanse=findViewById(R.id.item_life_life_model_saving_expanse)
//        lifeModelName=findViewById(R.id.item_life_life_model_name)

        lifeModelInvestExpanse.text=lifeModel.investmentPortion.toString()
        lifeModelSocialExpanse.text=lifeModel.socialRelationshipPortion.toString()
        lifeModelLiExpanse.text=lifeModel.livingPortion.toString()
        lifeModelSavingExpanse.text=lifeModel.savingPortion.toString()

    }
}