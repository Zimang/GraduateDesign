package top.zimang.lifemodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import com.example.lifemodel.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast
import top.zimang.lifemodel.model.Location

class CreateLivingModelActivity : BaseActivity() {
    private lateinit var livingModelName: EditText
    private lateinit var livingModeDescription: EditText
    private lateinit var isAutoGenerateExpanse: CheckBox
    private lateinit var countryLocationSpinner: Spinner
    private lateinit var countryLocationSpinnerAdapter: LocationSpinnerAdapter
    private lateinit var cityLocationSpinner: Spinner
    private lateinit var cityLocationSpinnerAdapter:  LocationSpinnerAdapter

    private var countrylocation: Location?=null
    private var citylocation: Location?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_living_model)

        countryLocationSpinner=findViewById(R.id.country_location)
        cityLocationSpinner=findViewById(R.id.city_location)
        livingModeDescription=findViewById(R.id.living_mode_description)
        isAutoGenerateExpanse=findViewById(R.id.is_auto_generate_expanse_item)
    }

    override fun onStart() {
        super.onStart()
        initCountrySpinnerItems()
    }

    fun initCountrySpinnerItems(){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                countrylocationList=dbsource.getCountries()
            }
            countryLocationSpinnerAdapter= LocationSpinnerAdapter(this@CreateLivingModelActivity,
                countrylocationList as MutableList<Location>
            )
            Log.i("love",countrylocationList.toString())
            countryLocationSpinner.adapter=countryLocationSpinnerAdapter
            countryLocationSpinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedItem=parent?.getItemAtPosition(position) as Location
                    updateCitySpinner(selectedItem)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

        }
    }

    fun updateCitySpinner(countrySelected: Location){
        CoroutineScope(Dispatchers.Main).launch {
            if(countrySelected.locationList==null){
                countrylocation=countrySelected
                countrylocation= withContext(Dispatchers.IO){
                    dbsource.updateWithCitiesToCountry(countrylocation)
                }
            }
            cityLocationSpinnerAdapter=LocationSpinnerAdapter(this@CreateLivingModelActivity,
                countrylocation?.locationList as MutableList<Location>
            )
            cityLocationSpinner.adapter=cityLocationSpinnerAdapter
            cityLocationSpinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedItem=parent?.getItemAtPosition(position) as Location
                    citylocation=selectedItem
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }
    }
    fun onClickSaveLivingModel(v:View){
        val name =livingModelName.text.toString().trim()

    }



}