package com.moizaandroid.moiza.ui.component

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizaandroid.moiza.ui.theme.Gray300
import com.moizaandroid.moiza.ui.theme.Orange
import com.moizaandroid.moiza.ui.theme.Typography

@Composable
fun MoizaCheckBox(
    text: String,
    onCheckOn: () -> Unit,
    onCheckOff: () -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }

    Row{
        if(isChecked) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(24.dp)
                    .border(
                        width = 1.dp,
                        shape = CircleShape,
                        color = Gray300
                    )
                    .padding(4.8.dp)
                    .clip(CircleShape)
                    .background(Orange)
                    .clickable { isChecked = !isChecked }
            ) {
                onCheckOn()
            }
        } else {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(24.dp)
                    .border(
                        width = 1.dp,
                        shape = CircleShape,
                        color = Gray300
                    )
                    .clickable { isChecked = !isChecked }
            ) {
                onCheckOff()
            }
        }

        Spacer(modifier = Modifier.size(10.dp))

        Text(text = text, style = Typography.body1, modifier = Modifier.align(CenterVertically))
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCheckBox() {
    MoizaCheckBox("hello", {}) {}
}