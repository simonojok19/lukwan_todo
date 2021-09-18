package com.lukwan.todo.ui.theme.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukwan.todo.data.models.TodoTask
import com.lukwan.todo.data.repositories.TodoRepository
import com.lukwan.todo.utils.RequestState
import com.lukwan.todo.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<RequestState<List<TodoTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<TodoTask>>> = _allTasks;

    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                todoRepository.getAllTasks.collect {
                    _allTasks.emit(RequestState.Success(it))
                }
            }

        } catch (e: Exception) {
            _allTasks.value = RequestState.Error(e)
        }
    }
}