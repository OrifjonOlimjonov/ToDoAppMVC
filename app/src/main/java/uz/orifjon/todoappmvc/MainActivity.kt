package uz.orifjon.todoappmvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.orifjon.todoappmvc.databinding.ActivityMainBinding
import uz.orifjon.todoappmvc.databinding.ItemTaskBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}