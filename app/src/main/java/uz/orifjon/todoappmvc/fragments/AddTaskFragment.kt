package uz.orifjon.todoappmvc.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.orifjon.todoappmvc.databinding.FragmentAddTaskBinding
import uz.orifjon.todoappmvc.models.tasker.Task
import uz.orifjon.todoappmvc.models.tasker.TaskDatabase

class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private lateinit var date1: String
    private lateinit var date2: String
    private lateinit var category: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        date1 = ""
        date2 = ""
        category = "Work"
        binding.alarm.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { timePicker: TimePicker?, i: Int, i1: Int ->
                    Toast.makeText(
                        requireContext(),
                        "$i:$i1",
                        Toast.LENGTH_LONG
                    ).show()
                    if(i > 9){
                        date1 = if(i1 > 9) {
                            "$i $i1"
                        }else{
                            "$i 0$i1"
                        }
                    }else{
                        if(i1 > 9) {
                            date1 = "0$i $i1"
                        }else{
                            date1 = "0$i 0$i1"
                        }
                    }

                }, 12, 12, true
            )
            timePickerDialog.show()
        }
        binding.calendar.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { datePicker: DatePicker?, i: Int, i1: Int, i2: Int ->
                    Toast.makeText(
                        requireContext(),
                        "$i2 $i1 $i",
                        Toast.LENGTH_SHORT
                    ).show()
                    if(i1 > 9) {
                        if(i2 > 9){
                            date2 = "$i  $i1 $i2 $date1"
                        }else {
                            date2 = "$i  $i1 0$i2 $date1"
                        }
                    }else{
                        if(i2 > 9){
                            date2 = "$i  0$i1 $i2 $date1"
                        }else {
                            date2 = "$i  0$i1 0$i2 $date1"
                        }
                    }
                }, 2022, 11, 6
            )
            datePickerDialog.show()
        }

        binding.category.setOnClickListener {
            Toast.makeText(requireContext(), date2, Toast.LENGTH_SHORT).show()
        }

        binding.cancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSave.setOnClickListener {
            if (date2 != "" && category != "") {
                val task = Task(
                    taskDescription = binding.editText1.text.toString(),
                    taskTime = date2,
                    taskCategory = category
                ,check = 1)
                TaskDatabase.getDatabase(requireContext()).taskDao().add(task)
                Toast.makeText(requireContext(), "Saqlandi!!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }else{
                Toast.makeText(requireContext(), "OOOOOOMMMMMMMMMMMGGGGGGG!", Toast.LENGTH_SHORT).show()
            }
        }





        return binding.root
    }


}