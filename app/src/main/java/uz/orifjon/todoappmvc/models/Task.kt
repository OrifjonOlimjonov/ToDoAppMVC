package uz.orifjon.todoappmvc.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "task_description")
    val taskDescription:String,
    @ColumnInfo(name = "task_time")
    val taskTime:String,
    @ColumnInfo(name = "task_category")
    val taskCategory:String
)