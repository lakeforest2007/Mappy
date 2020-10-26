package com.example.mappy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mappy.models.UserMap

class MapsAdapter(private val context: Context, private val userMaps: List<UserMap>,
                  private val onClickListener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>()
{
    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_map, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userMaps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.bind(userMap.title)
        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(position)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle = view.findViewById<TextView>(R.id.tvMapTitle)
         fun bind(title: String) {
             textViewTitle.text = title
         }
    }
}
