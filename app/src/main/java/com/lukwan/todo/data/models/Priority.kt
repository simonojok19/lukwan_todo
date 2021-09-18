package com.lukwan.todo.data.models

import androidx.compose.ui.graphics.Color
import com.lukwan.todo.ui.theme.HighPriorityColor
import com.lukwan.todo.ui.theme.LowPriorityColor
import com.lukwan.todo.ui.theme.MediumPriorityColor
import com.lukwan.todo.ui.theme.NonePriorityColor

enum class Priority(
    val color: Color
) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}