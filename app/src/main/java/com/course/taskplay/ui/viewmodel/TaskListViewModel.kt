package com.course.taskplay.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.course.taskplay.ui.model.Task
import com.course.taskplay.ui.model.TaskListScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TaskListScreenUIState())
    val uiState = _uiState.asStateFlow()

    fun onClickAddTask() {
        _uiState.update { it.copy(addTaskState = true) }
    }

    fun onDone() {
        if (_uiState.value.task?.name?.isNotBlank() != false) {
            _uiState.update { state ->
                state.copy(
                    tasks = buildList {
                        addAll(state.tasks)
                        state.task?.let { add(it) }
                    }
                )
            }
        }
        _uiState.update { it.copy(addTaskState = false, task = null) }
    }

    fun onBack() {
        _uiState.update { it.copy(addTaskState = false) }
    }

    fun onChangeTaskStatus(
        task: Task,
        checked: Boolean
    ) {
        _uiState.update { state ->
            state.copy(
                tasks = state.tasks.map {
                    if (it == task) {
                        it.copy(isChecked = checked)
                    } else {
                        it
                    }
                }
            )
        }
    }

    fun onValueChange(name: String) {
        if (name.length <= 20)
            _uiState.update { it.copy(task = Task(name = name, isChecked = false)) }
    }

    fun onFocusChange(isFocused: Boolean) {
        _uiState.update { it.copy(isFocused = isFocused) }
    }

    fun requestFocus() {
        _uiState.value.focusRequester.requestFocus()
    }

    fun removeTask(task: Task) {
        _uiState.update { state ->
            state.copy(
                tasks = state.tasks.filter { it != task }
            )
        }
    }
}