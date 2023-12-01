package com.yap.myancare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yap.myancare.R
import com.yap.myancare.constant.Resource
import com.yap.myancare.response.Beer

class BeerAdapter(private val beerList: List<Beer>, private val context: Context):
    RecyclerView.Adapter<BeerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.beer_item_list_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = beerList[position]
        holder.textView.text = item.name
        holder.txtTagline.text = item.tagline
        holder.txtDescription.text = item.description
        Glide.with(context)
            .load(item.imageUrl)
            .into(holder.imgView)

    }

    override fun getItemCount(): Int {
        return beerList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.txtName)
        val imgView: ImageView = itemView.findViewById(R.id.beerImg)
        val txtTagline: TextView = itemView.findViewById(R.id.txtTagline)
        val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
    }
}
