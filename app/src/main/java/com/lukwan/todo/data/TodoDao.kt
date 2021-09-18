package com.lukwan.todo.data

import androidx.room.*
import com.lukwan.todo.data.models.TodoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo ORDER BY id ASC")
    fun getAllTasks(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<TodoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoTask: TodoTask)

    @Update
    suspend fun updateTask(todoTask: TodoTask)

    @Delete
    suspend fun deleteTask(todoTask: TodoTask)

    @Query("DELETE FROM todo")
    suspend fun deleteTasks()

    @Query("SELECT * FROM todo WHERE title LIKE :query OR description LIKE :query")
    fun searchDatabase(query: String): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN  2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowerPriority(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN  2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<TodoTask>>
}