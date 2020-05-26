package com.example.mykotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlin.MyAdapter.CallBack
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo_list.view.*

fun myToast(context: Context, toast: String) {
    makeText(context, toast, Toast.LENGTH_LONG).show()
}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var context = this


        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyAdapter(object : CallBack {
            override fun callBack(position: Int) {
                myToast(context, position.toString())
            }
        })
    }
}


class MyAdapter(private val callBack: CallBack) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    open interface CallBack {
        open fun callBack(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tv_item.text = position.toString()
        holder.itemView.setOnClickListener(View.OnClickListener {
            callBack.callBack(position)
        })

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}

