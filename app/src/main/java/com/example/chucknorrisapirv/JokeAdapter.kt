package com.example.chucknorrisapirv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chucknorrisapirv.databinding.ItemJokeBinding
import com.example.chucknorrisapirv.models.Result

class JokeAdapter(
    private var items: List<Result>
) : RecyclerView.Adapter<JokeAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(ItemJokeBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    inner class Holder(private val view: ItemJokeBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(item: Result) {
            view.apply {
                Glide.with(mainIV)
                    .load(item.icon_url)
                    .into(mainIV)

                mainTV.text = item.value
            }
        }
    }

}