package com.ozancanguz.motivate_me_app.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.models.Quote
import com.ozancanguz.motivate_me_app.data.models.QuoteItem
import com.ozancanguz.motivate_me_app.data.models.quote2.Quote2
import com.ozancanguz.motivate_me_app.data.models.quote2.Quote2Item
import kotlinx.android.synthetic.main.quote_row_layout.view.*

class QuoteAdapter:RecyclerView.Adapter<QuoteAdapter.MyViewHolder>() {
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {


    }

    var quoteList= emptyList<Quote2Item>()

    fun setData(newData: Quote2){
        this.quoteList=newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.quote_row_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentQuote=quoteList[position]
        holder.itemView.quoteTextView.text=currentQuote.text

    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

}