package com.example.roomdatos059.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface TaskDao {

    // insertar una tarea
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserTask(task:Task)


 // insertar multiples tareas
    @Insert
    fun insertMultipleTask(list: List<Task>)

    // actualizar
    @Update
    fun updateTask(task:Task)


    // eliminar
    @Delete
    fun deleteOneTask(task: Task)

    @Query("SELECT * FROM TASK_TABLE")
   fun getAllTask1() : List<Task>

   @Query("SELECT * FROM TASK_TABLE ORDER BY idTask ASC")
   fun getAllTask() : List<Task>


  // @Query(" SELECT * FROM TASK_TABLE WHERE idTask = idTask Limit 1")
  //fun getTaskById(idTask: Int): Task
}