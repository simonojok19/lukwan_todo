package com.lukwan.todo.data.repositories

import com.lukwan.todo.data.TodoDao
import com.lukwan.todo.data.models.TodoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val todoDao: TodoDao
) {
    val getAllTasks: Flow<List<TodoTask>> = todoDao.getAllTasks()
    val sortByLowPriority: Flow<List<TodoTask>> = todoDao.sortByLowerPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = todoDao.sortByHighPriority()


    fun getSelectedTask(taskId: Int) = todoDao.getSelectedTask(taskId = taskId)

    suspend fun addTask(todoTask: TodoTask) {
        todoDao.addTask(todoTask)
    }

    suspend fun updateTask(todoTask: TodoTask) {
        todoDao.updateTask(todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTask) {
        todoDao.deleteTask(todoTask)
    }

    suspend fun deleteTasks() {
        todoDao.deleteTasks()
    }

    fun searchDatabase(query: String) = todoDao.searchDatabase(query = query)
}