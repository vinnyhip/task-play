package com.course.taskplay.ui.model

data class TaskListScreenUIState(
    val tasks: List<Task> = emptyList(),
    val addTaskState: Boolean = false,
    val task: Task? = null
)