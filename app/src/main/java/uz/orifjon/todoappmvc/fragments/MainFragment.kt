package uz.orifjon.todoappmvc.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.orifjon.todoappmvc.R
import uz.orifjon.todoappmvc.databinding.CategoryDialogBinding
import uz.orifjon.todoappmvc.databinding.DialogBinding
import uz.orifjon.todoappmvc.databinding.FragmentMainBinding
import uz.orifjon.todoappmvc.models.TaskDatabase
import uz.orifjon.todoappmvc.timer.BataTime

class MAinFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)


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

                val alertDialog2 = android.app.AlertDialog.Builder(requireContext())
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
                    alertDialog3.dismiss()
                }
                alertDialog3.show()

            }
            alertDialog1.show()
        }








        return binding.root

    }

}