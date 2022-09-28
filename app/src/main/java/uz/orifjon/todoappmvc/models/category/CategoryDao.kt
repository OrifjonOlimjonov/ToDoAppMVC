package uz.orifjon.todoappmvc.models.category

import androidx.room.*
import io.reactivex.rxjava3.core.Flowable

@Dao
interface CategoryDao {

    @Insert
    fun add(category: Category)

    @Update
    fun update(category: Category)

    @Delete
    fun delete(category: Category)

    @Query("SELECT * FROM category")
    fun list():Flowable<List<Category>>


}