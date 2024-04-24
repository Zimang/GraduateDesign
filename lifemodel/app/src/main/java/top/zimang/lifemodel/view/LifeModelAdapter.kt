package top.zimang.lifemodel.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifemodel.R
import top.zimang.lifemodel.model.LivingModel
import java.lang.Exception

class LifeModelAdapter(internal var livingModelList:MutableList<LivingModel>, internal var context: Context, internal  var itemListener: LifeModelAdapter.OnLivingModelItemClickListener)
    :RecyclerView.Adapter<LifeModelAdapter.LivingModelHolder>(){
    interface OnLivingModelItemClickListener{
        fun goToLivingModelActivity(item: LivingModel)
        fun onMenuDeleteClick(item: LivingModel)
    }

    @SuppressLint("DiscouragedPrivateApi", "NotifyDataSetChanged")
    inner class LivingModelHolder(v: View):RecyclerView.ViewHolder(v){
        internal var itemMainLifeModelName: TextView
        internal var itemMainLifeModelLiExpanse: TextView
        internal var itemMainLifeModelInvestExpanse: TextView
        internal var itemMainLifeModelSavingExpanse: TextView
        internal var itemMainLifeModelSocialExpanse: TextView
//        var position:Int=-1

        init {
            itemMainLifeModelInvestExpanse=v.findViewById(R.id.item_main_life_model_invest_expanse)
            itemMainLifeModelSocialExpanse=v.findViewById(R.id.item_main_life_model_social_expanse)
            itemMainLifeModelLiExpanse=v.findViewById(R.id.item_main_life_model_li_expanse)
            itemMainLifeModelSavingExpanse=v.findViewById(R.id.item_main_life_model_saving_expanse)
            itemMainLifeModelName=v.findViewById(R.id.item_main_life_model_name)


            val popupMenu= PopupMenu(context,v)
            popupMenu.inflate(R.menu.living_model_popup_manu)

            v.setOnLongClickListener{
                try {
                    val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                    popup.isAccessible = true
                    val menu = popup.get(popupMenu)
                    menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                        .invoke(menu,true)
                }catch (e: Exception){
                    Log.d("error", e.toString())
                }finally {
                    popupMenu.show()
                }
                true
            }
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.delete_living_model->{
                        itemListener.onMenuDeleteClick(livingModelList[layoutPosition])
                        livingModelList.removeAt(layoutPosition)
                        notifyDataSetChanged()
                        true
                    }
                    R.id.goto_living_model->{
                        itemListener.goToLivingModelActivity(livingModelList[layoutPosition])
                        true
                    }
                    else ->true
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivingModelHolder {
        val v= LayoutInflater.from(context).inflate(R.layout.item_living_model,parent,false)

        return LivingModelHolder(v)
    }

    override fun getItemCount(): Int {
        return  livingModelList.size
    }

    override fun onBindViewHolder(holder: LivingModelHolder, position: Int) {
        TODO("Not yet implemented")
    }
}