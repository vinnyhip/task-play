package com.course.taskplay.ui.model

import androidx.compose.ui.focus.FocusRequester

data class TaskListScreenUIState(
    val tasks: List<Task> = emptyList(),
    val addTaskState: Boolean = false,
    val task: Task? = null,
    val focusRequester: FocusRequester = FocusRequester(),
    val isFocused: Boolean = false
)