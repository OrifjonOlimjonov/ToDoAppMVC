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
import uz.orifjon.todoappmvc.databinding.DialogBinding
import uz.orifjon.todoappmvc.databinding.FragmentMainBinding
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


                alertDialog1.dismiss()
            }
            alertDialog1.show()
        }








        return binding.root

    }

}