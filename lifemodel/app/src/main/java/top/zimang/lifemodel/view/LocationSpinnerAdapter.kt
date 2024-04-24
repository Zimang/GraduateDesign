package top.zimang.lifemodel.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.lifemodel.R
import top.zimang.lifemodel.model.Location

class LocationSpinnerAdapter(context: Context,private val locations: MutableList<Location>)
    :ArrayAdapter<Location>(context, R.layout.item_location,locations){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view=super.getView(position, convertView, parent)
        val textView=view.findViewById<TextView>(R.id.item_location)
        textView.text=locations[position].locationName
        return view
    }
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view=super.getView(position, convertView, parent)
        val textView=view.findViewById<TextView>(R.id.item_location)
        textView.text=locations[position].locationName
        return view
    }
}