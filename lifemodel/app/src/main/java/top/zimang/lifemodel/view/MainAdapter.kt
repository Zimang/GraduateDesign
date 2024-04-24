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
import top.zimang.lifemodel.model.LifeModel
import java.lang.Exception

class MainAdapter(internal var lifeModelList: MutableList<LifeModel>,internal var context:Context,internal  var itemListener:OnLifeModelItemClickListener)
    :RecyclerView.Adapter<MainAdapter.LifeModelHolder>(){
    interface OnLifeModelItemClickListener{
        fun goToLifeModelActivity(item: LifeModel)
        fun onMenuDeleteClick(item: LifeModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeModelHolder {
        val v=LayoutInflater.from(context).inflate(R.layout.item_life_model_main,parent,false)

        return LifeModelHolder(v)
    }

    override fun getItemCount(): Int {
        return  lifeModelList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LifeModelHolder, position: Int) {
        holder.itemMainLifeModelName.text=lifeModelList[position].lifeModelName
        holder.itemMainLifeModelLiExpanse.text=lifeModelList[position].livingPortion.toString()+"%"
        holder.itemMainLifeModelInvestExpanse.text=lifeModelList[position].investmentPortion.toString()+"%"
        holder.itemMainLifeModelSavingExpanse.text=lifeModelList[position].savingPortion.toString()+"%"
        holder.itemMainLifeModelSocialExpanse.text=lifeModelList[position].socialRelationshipPortion.toString()+"%"
//        holder.position=position
     }


    @SuppressLint("DiscouragedPrivateApi", "NotifyDataSetChanged")
    inner class LifeModelHolder(v:View):RecyclerView.ViewHolder(v){
        internal var itemMainLifeModelName:TextView
        internal var itemMainLifeModelLiExpanse:TextView
        internal var itemMainLifeModelInvestExpanse:TextView
        internal var itemMainLifeModelSavingExpanse:TextView
        internal var itemMainLifeModelSocialExpanse:TextView
//        var position:Int=-1

        init {
            itemMainLifeModelInvestExpanse=v.findViewById(R.id.item_main_life_model_invest_expanse)
            itemMainLifeModelSocialExpanse=v.findViewById(R.id.item_main_life_model_social_expanse)
            itemMainLifeModelLiExpanse=v.findViewById(R.id.item_main_life_model_li_expanse)
            itemMainLifeModelSavingExpanse=v.findViewById(R.id.item_main_life_model_saving_expanse)
            itemMainLifeModelName=v.findViewById(R.id.item_main_life_model_name)


            val popupMenu=PopupMenu(context,v)
            popupMenu.inflate(R.menu.life_model_popup_manu)

            v.setOnClickListener{
                itemListener.goToLifeModelActivity(lifeModelList[layoutPosition])
            }
            v.setOnLongClickListener{
                try {
                    val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                    popup.isAccessible = true
                    val menu = popup.get(popupMenu)
                    menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                        .invoke(menu,true)
                }catch (e:Exception){
                    Log.d("error", e.toString())
                }finally {
                    popupMenu.show()
                }
                true
            }
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.delete_life_model->{
                        itemListener.onMenuDeleteClick(lifeModelList[layoutPosition])
                        lifeModelList.removeAt(layoutPosition)
                        notifyDataSetChanged()
                        true
                    }
                    R.id.goto_life_model->{
                        itemListener.goToLifeModelActivity(lifeModelList[layoutPosition])
                        true
                    }
                    else ->true
                }
            }
        }


    }

}