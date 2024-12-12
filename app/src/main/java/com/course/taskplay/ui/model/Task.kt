package com.course.taskplay.ui.model

import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val isChecked: Boolean
)