package uz.orifjon.todoappmvc.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.orifjon.todoappmvc.databinding.ItemCategoryBinding
import uz.orifjon.todoappmvc.models.category.Category
import uz.orifjon.todoappmvc.models.tasker.Task

class RecyclerViewCategoryAdapter(var itemClick:(Category)->Unit):ListAdapter<Category, RecyclerViewCategoryAdapter.VH>(CategoryDiffUtils()) {

    inner class VH(var binding:ItemCategoryBinding):RecyclerView.ViewHolder(binding.root){
            fun onBind(category: Category){
                binding.tvCategoryName.text = category.name
                binding.tvCategorySize.text = category.size.toString()

                itemView.setOnClickListener {
                    itemClick(category)
                }
            }
    }

    class CategoryDiffUtils:DiffUtil.ItemCallback<Category>(){
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            return VH(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
            holder.onBind(getItem(position))
    }

}