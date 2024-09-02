package com.example.customlayout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

class CircularLayout {
    @Composable
    fun CircularLayoutExample(
        modifier: Modifier = Modifier,
        radius: Dp = 100.dp,
        backgroundColor: Color = Color.LightGray,
        itemColor: Color = Color.Red,
        itemSize: Dp = 50.dp,
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = modifier
                .size(radius * 2)
                .drawBehind {
                    // Draw a background circle
                    drawCircle(
                        color = backgroundColor,
                        radius = radius.toPx()
                    )
                }
        ) {
            Layout(
                content = content
            ) { measurables, constraints ->
                // Measure children
                val placeables = measurables.map { measurable ->
                    measurable.measure(constraints)
                }

                val centerX = constraints.maxWidth / 2
                val centerY = constraints.maxHeight / 2
                val radiusPx = radius.toPx()

                layout(constraints.maxWidth, constraints.maxHeight) {
                    // Place children in a circle
                    val step = 360f / placeables.size
                    placeables.forEachIndexed { index, placeable ->
                        val angle = step * index
                        val x = centerX + (radiusPx * cos(Math.toRadians(angle.toDouble()))).toInt() - placeable.width / 2
                        val y = centerY + (radiusPx * sin(Math.toRadians(angle.toDouble()))).toInt() - placeable.height / 2
                        placeable.placeRelative(x.toInt(), y.toInt())
                    }
                }
            }
        }
    }
}
