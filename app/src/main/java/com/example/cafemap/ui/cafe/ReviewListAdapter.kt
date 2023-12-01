package com.example.cafemap.ui.cafe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cafemap.api.Review
import com.example.cafemap.databinding.ItemCafeReviewBinding

class ReviewListAdapter() : RecyclerView.Adapter<ReviewListAdapter.ViewHolder>() {

    var items = arrayListOf<Review>()

    var itemClickListener: OnItemClickListener? = null
    interface OnItemClickListener {
        fun onItemClicked(reviewId: Int)
    }

    inner class ViewHolder(val binding: ItemCafeReviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Review) {
            binding.tvCrSeeMore.setOnClickListener {
                binding.tvCrSeeMore.visibility = View.GONE
                binding.tvCrReviewContent.ellipsize = null
                binding.tvCrReviewContent.maxLines = Int.MAX_VALUE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCafeReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(list: List<Review>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}