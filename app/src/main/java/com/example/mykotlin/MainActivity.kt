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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo_list.view.*

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
            //替换方案
            val launcher: ActivityResultLauncher<Intent> =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()
                ) {
                    if (it.resultCode == Activity.RESULT_OK) {
                        val data = it.data
                        val name = data?.getStringExtra("name")
                        val mobile = data?.getStringExtra("mobile")
                        val address = data?.getStringExtra("address")
                        list.add(MyBean(name, mobile, address))
                        recycler_view.adapter?.notifyDataSetChanged()
                    }
                }
            launcher.launch(intent)


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

