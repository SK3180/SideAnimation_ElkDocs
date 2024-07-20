package com.evencargo.sideanimation.ui.theme

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import kotlin.math.sin

@Composable
fun SideLights() {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite_Animation")
    val animatedOffset1 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "Animation"
    )
    val animatedOffset2 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val animatedOffset3 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val animatedOffset4 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2100, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // Draw wavy lines on the left side
        drawWavyLine(
            color = Color.Magenta,
            xOffset = 0f,
            canvasHeight = canvasHeight,
            animatedOffset = animatedOffset1
        )
        drawWavyLine(
            color = Color.Blue,
            xOffset = 0f,
            canvasHeight = canvasHeight,
            animatedOffset = animatedOffset2
        )
        drawWavyLine(
            color = Color.Red,
            xOffset = 0f,
            canvasHeight = canvasHeight,
            animatedOffset = animatedOffset3
        )
        drawWavyLine(
            color = Color(160,32,240),
            xOffset = 0f,
            canvasHeight = canvasHeight,
            animatedOffset = animatedOffset4
        )

        // Draw wavy lines on the right side
        drawWavyLine(
            color = Color.Magenta,
            xOffset = canvasWidth,
            canvasHeight = canvasHeight,
            animatedOffset = animatedOffset1
        )
        drawWavyLine(
            color = Color.Cyan,
            xOffset = canvasWidth,
            canvasHeight = canvasHeight,
            animatedOffset = animatedOffset2
        )
        drawWavyLine(
            color = Color.Red,
            xOffset = canvasWidth,
            canvasHeight = canvasHeight,
            animatedOffset = animatedOffset3
        )
        drawWavyLine(
            color = Color(160,32,240),
            xOffset = canvasWidth,
            canvasHeight = canvasHeight,
            animatedOffset = animatedOffset4
        )
    }
}
fun androidx.compose.ui.graphics.drawscope.DrawScope.drawWavyLine(
    color: Color,
    xOffset: Float,
    canvasHeight: Float,
    animatedOffset: Float
) {
    val waveFrequency = 1f // Number of waves
    val waveAmplitude = 10.dp.toPx() // Height of waves

    for (y in 0 until canvasHeight.toInt() step 5) {
        val waveOffset = sin((y / canvasHeight.toFloat() + animatedOffset) * waveFrequency * 2 * Math.PI).toFloat()
        drawLine(
            color = color,
            start = Offset(xOffset + waveOffset * waveAmplitude, y.toFloat()),
            end = Offset(xOffset + waveOffset * waveAmplitude, (y + 5).toFloat()),
            strokeWidth = 2.dp.toPx(),
            cap = StrokeCap.Round
        )
    }
}
