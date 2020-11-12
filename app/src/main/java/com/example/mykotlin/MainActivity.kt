package com.example.mykotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlin.MyAdapter.CallBack
import com.example.mykotlin.ui.weather.WeatherHomeActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo_list.view.*

//fun Toast.myToast(context: Context, toast: String) {
//    makeText(context, toast, Toast.LENGTH_LONG).show()
//}
fun myToast(context: Context, toast: String) {
    makeText(context, toast, Toast.LENGTH_LONG).show()
}


class MainActivity : AppCompatActivity() {

    var list: ArrayList<MyBean> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = this


        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyAdapter(list, object : CallBack {
            override fun callBack(position: Int) {
                myToast(context, position.toString())
            }
        })

        btn_add.setOnClickListener {

            var intent = Intent(context, TodoAddActivity::class.java)
            //Activity 跳转替换方案
            val launcher: ActivityResultLauncher<Intent> =
                registerForActivityResult(
                    ActivityResultContracts.StartActivityForResult()
                ) {
                    if (it.resultCode == Activity.RESULT_OK) {

                        //run 内敛函数
                        it.data?.run {
                            val name = getStringExtra("name")
                            val mobile = getStringExtra("mobile")
                            val address = getStringExtra("address")
                            list.add(MyBean(name, mobile, address))
                            recycler_view.adapter?.notifyDataSetChanged()
                        }


                    }
                }
            launcher.launch(intent)
        }

        btn_test.setOnClickListener {
            when (it.id) {
                R.id.btn_test -> startActivity(WeatherHomeActivity.newInstance(this, ""))
            }

        }

    }
}

data class MyBean(val name: String?, val mobile: String?, val address: String?)


class MyAdapter(var list: ArrayList<MyBean>, private val callBack: CallBack) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    interface CallBack {
        fun callBack(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myBean = list[position]
        holder.itemView.tv_item.text = myBean.name + "\n" + myBean.mobile + "\n" + myBean.address
        holder.itemView.setOnClickListener(View.OnClickListener {
            callBack.callBack(position)
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}

