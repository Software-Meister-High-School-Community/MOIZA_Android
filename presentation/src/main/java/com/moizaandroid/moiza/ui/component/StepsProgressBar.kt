package com.moizaandroid.moiza.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizaandroid.moiza.ui.theme.Blue
import com.moizaandroid.moiza.ui.theme.Gray300

@Composable
fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 1..numberOfSteps) {
            Step(
                modifier = Modifier.weight(1F),
                isCompete = step <= currentStep,
                isCurrent = step == currentStep,
                isFirst = step == 1
            )
        }
    }
}

@Composable
fun Step(modifier: Modifier = Modifier, isCompete: Boolean, isCurrent: Boolean, isFirst: Boolean) {
    val color = if (isCompete) Blue else Gray300
    val viewSize = if (isCurrent) 11.dp else 7.dp

    if (isFirst) {
        Box(
            modifier = Modifier
                .size(viewSize)
                .clip(shape = CircleShape)
                .background(color)
        )
    } else {
        Box(modifier = modifier) {

            //Line
            Divider(
                modifier = Modifier.align(Alignment.CenterStart),
                color = color,
                thickness = 2.dp
            )

            //Circle
            Box(
                modifier = Modifier
                    .size(viewSize)
                    .align(Alignment.CenterEnd)
                    .clip(shape = CircleShape)
                    .background(color)
            )
        }
    }
}

@Preview
@Composable
fun StepsProgressBarPreview() {
    val currentStep = remember { mutableStateOf(2) }
    StepsProgressBar(
        modifier = Modifier.fillMaxWidth(),
        numberOfSteps = 3,
        currentStep = currentStep.value
    )
}