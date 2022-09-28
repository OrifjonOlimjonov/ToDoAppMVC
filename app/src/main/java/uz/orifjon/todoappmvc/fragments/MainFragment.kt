package uz.orifjon.todoappmvc.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import uz.orifjon.todoappmvc.R
import uz.orifjon.todoappmvc.adapters.RecyclerViewAdapter
import uz.orifjon.todoappmvc.databinding.CategoryDialogBinding
import uz.orifjon.todoappmvc.databinding.DialogBinding
import uz.orifjon.todoappmvc.databinding.FragmentMainBinding
import uz.orifjon.todoappmvc.models.category.Category
import uz.orifjon.todoappmvc.models.category.CategoryDao
import uz.orifjon.todoappmvc.models.category.CategoryDatabase
import uz.orifjon.todoappmvc.models.tasker.Task
import uz.orifjon.todoappmvc.models.tasker.TaskDatabase

class MAinFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var list: ArrayList<Task>
    private lateinit var listCategory: ArrayList<Category>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        adapter = RecyclerViewAdapter()
        binding.rvTask.adapter = adapter
        list = arrayListOf()
       TaskDatabase.getDatabase(requireContext()).taskDao().list()
            .subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.io())
            .subscribe {
                list = it as ArrayList<Task> /* = java.util.ArrayList<uz.orifjon.todoappmvc.models.tasker.Task> */
            }
        adapter.submitList(list)
        binding.btnAdd.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext())
            val binding: DialogBinding = DialogBinding.inflate(layoutInflater)
            alertDialog.setView(binding.root)
            val alertDialog1 = alertDialog.create()
            alertDialog1.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            binding.AddTask.setOnClickListener { view1 ->
                findNavController().navigate(R.id.addTaskFragment)
                alertDialog1.dismiss()
            }
            binding.AddList.setOnClickListener { view12 ->

                val alertDialog2 = AlertDialog.Builder(requireContext())
                val binding = CategoryDialogBinding.inflate(layoutInflater)
                alertDialog2.setView(binding.root)
                val alertDialog3 = alertDialog2.create()
                alertDialog3.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                binding.btnCancel.setOnClickListener {
                    // TaskDatabase.getDatabase(requireContext()).taskDao().add()
                    //  findNavController().popBackStack()
                    alertDialog3.dismiss()
                }
                binding.btnAdd.setOnClickListener {

                    val name = binding.input.text.toString()
                    val category = Category(name = name)
                    CategoryDatabase.getDatabase(requireContext()).categoryDao().list().subscribeOn(AndroidSchedulers.mainThread()).
                        observeOn(Schedulers.io()).subscribe {
                            listCategory = it as ArrayList<Category> /* = java.util.ArrayList<uz.orifjon.todoappmvc.models.category.Category> */
                    }

                    alertDialog3.dismiss()
                }
                alertDialog3.show()

            }
            alertDialog1.show()
        }








        return binding.root

    }

    external fun timePeriod(time1: String, time2: String): String


    companion object {
        init {
            System.loadLibrary("todoappmvc")
        }
    }

}