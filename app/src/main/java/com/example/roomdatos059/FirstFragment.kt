package com.example.roomdatos059

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.roomdatos059.Model.Task
import com.example.roomdatos059.Model.TaskDataBase
import com.example.roomdatos059.Model.TaskDao
import com.example.roomdatos059.databinding.FragmentFirstBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


        val dataBase = Room.databaseBuilder(
            requireContext().applicationContext,

            TaskDataBase::class.java,
            "task_Database2")
                //obligo a insertar en el hilo principal
           // .allowMainThreadQueries()
            .build()



       val newTask1 = Task(

            task = "Prueba BD 59",
            descripcion = " Prueba de inserción de datos",
            date = "18/07/2023"

       )

        GlobalScope.launch(Dispatchers.IO) {
            dataBase.getTaskDao().inserTask(newTask1)
            Log.d("Result: Ok", newTask1.toString())
        }










    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}