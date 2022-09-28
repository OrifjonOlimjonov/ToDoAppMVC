package uz.orifjon.todoappmvc.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.orifjon.todoappmvc.databinding.ItemTaskBinding
import uz.orifjon.todoappmvc.models.tasker.Task

class RecyclerViewAdapter:ListAdapter<Task, RecyclerViewAdapter.VH>(MyDiffUtils()) {

    inner class VH(var binding: ItemTaskBinding):RecyclerView.ViewHolder(binding.root){
            fun onBind(task: Task, position: Int){
                binding.tvTask.text = task.taskDescription
                binding.time.text = timePerioad(task.taskTime)
                binding.tvTime.text = timePerioad(task.taskTime)
            }
    }

    class MyDiffUtils:DiffUtil.ItemCallback<Task>(){
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            return VH(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
            holder.onBind(getItem(position),position)
    }

    external fun timePerioad(time1:String):String


    companion object {
        init {
            System.loadLibrary("todoappmvc")
        }
    }
}