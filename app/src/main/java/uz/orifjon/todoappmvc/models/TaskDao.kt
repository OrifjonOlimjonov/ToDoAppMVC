package uz.orifjon.todoappmvc.models

import androidx.room.*

@Dao
interface TaskDao {


    @Insert
    fun add(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM task")
    fun list(): List<Task>

}