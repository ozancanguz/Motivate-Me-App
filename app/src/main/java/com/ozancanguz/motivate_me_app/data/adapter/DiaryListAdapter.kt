package com.ozancanguz.motivate_me_app.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.models.diary.Diary
import kotlinx.android.synthetic.main.list_row_layout.view.*

class DiaryListAdapter: RecyclerView.Adapter<DiaryListAdapter.MyViewHolder>() {


    var todolist= emptyList<Diary>()


    // update ui
    fun updateData(newData:List<Diary>){
        this.todolist=newData
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.list_row_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem=todolist[position]
        holder.itemView.title_txt.text=currentItem.title
        holder.itemView.description_txt.text=currentItem.description

    }

    override fun getItemCount(): Int {
        return todolist.size
    }


}