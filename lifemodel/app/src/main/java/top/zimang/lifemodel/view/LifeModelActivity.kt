package top.zimang.lifemodel.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifemodel.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import top.zimang.lifemodel.model.LifeModel
import top.zimang.lifemodel.model.LivingModel
import top.zimang.lifemodel.utils.WithGson

class LifeModelActivity :BaseActivity(), LifeModelAdapter.OnLivingModelItemClickListener {
    lateinit var lifeModel:LifeModel
    lateinit var lifeModelInvestExpanse:TextView
    lateinit var lifeModelSocialExpanse:TextView
    lateinit var lifeModelLiExpanse:TextView
    lateinit var lifeModelSavingExpanse:TextView
    lateinit var addLivingModelFab:FloatingActionButton


    private lateinit var livingModelRecyclerView: RecyclerView
    private lateinit var noLivingModelView: LinearLayout

    private var livingModelList:MutableList<LivingModel>?=null
    private var adapter:LifeModelAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeModel= intent?.getStringExtra("life_model")
            ?.let { WithGson.fromJson(it) }!!

        setContentView(R.layout.activity_life_model)
        setUp()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayLifeModels() {
        if (livingModelList==null|| livingModelList!!.size == 0) {
            Log.d("love ", "No LifeModel to display")
            livingModelRecyclerView.visibility = View.INVISIBLE
            noLivingModelView.visibility= View.VISIBLE
        } else {
            if (adapter==null) {
                adapter = LifeModelAdapter(livingModelList!!, this@LifeModelActivity, this@LifeModelActivity)
                livingModelRecyclerView.adapter = adapter
            }else{
                adapter!!.livingModelList= livingModelList as MutableList<LivingModel>
                adapter!!.notifyDataSetChanged()
            }

            livingModelRecyclerView.visibility = View.VISIBLE
            noLivingModelView.visibility= View.INVISIBLE
        }
    }

    override fun onStart() {
        super.onStart()


    }
    fun setUp(){
        supportActionBar?.title=lifeModel.lifeModelName
        lifeModelInvestExpanse=findViewById(R.id.item_life_life_model_invest_expanse)
        lifeModelSocialExpanse=findViewById(R.id.item_life_life_model_social_expanse)
        lifeModelLiExpanse=findViewById(R.id.item_life_life_model_li_expanse)
        lifeModelSavingExpanse=findViewById(R.id.item_life_life_model_saving_expanse)
        addLivingModelFab=findViewById(R.id.add_living_model_fab)
//        lifeModelName=findViewById(R.id.item_life_life_model_name)

        lifeModelInvestExpanse.text=lifeModel.investmentPortion.toString()
        lifeModelSocialExpanse.text=lifeModel.socialRelationshipPortion.toString()
        lifeModelLiExpanse.text=lifeModel.livingPortion.toString()
        lifeModelSavingExpanse.text=lifeModel.savingPortion.toString()
    }



    fun createLivingModel(v:View){
        val myIntent = Intent(this@LifeModelActivity, CreateLivingModelActivity::class.java)
        startActivityForResult(myIntent, CREATE_LIVING_MODEL_REQUEST_CODE)
    }

    override fun goToLivingModelActivity(item: LivingModel) {
        TODO("Not yet implemented")
    }

    override fun onMenuDeleteClick(item: LivingModel) {
        TODO("Not yet implemented")
    }


    companion object {
        const val CREATE_LIVING_MODEL_REQUEST_CODE = 3
        const val LIVING_MODEL_REQUEST_CODE = 4
    }
}