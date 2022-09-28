package uz.orifjon.todoappmvc.models.tasker

import androidx.room.*
import io.reactivex.rxjava3.core.Flowable

@Dao
interface TaskDao {


    @Insert
    fun add(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM task")
    fun list(): Flowable<List<Task>>

}