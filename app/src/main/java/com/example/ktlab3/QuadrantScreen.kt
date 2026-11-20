package com.example.ktlab3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/** Задание 3: Compose Quadrant. */
@Composable
fun QuadrantScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCell(
                title = stringResource(R.string.quadrant_text_title),
                body = stringResource(R.string.quadrant_text_body),
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            QuadrantCell(
                title = stringResource(R.string.quadrant_image_title),
                body = stringResource(R.string.quadrant_image_body),
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCell(
                title = stringResource(R.string.quadrant_row_title),
                body = stringResource(R.string.quadrant_row_body),
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            QuadrantCell(
                title = stringResource(R.string.quadrant_column_title),
                body = stringResource(R.string.quadrant_column_body),
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun QuadrantCell(
    title: String,
    body: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = body, textAlign = TextAlign.Justify)
    }
}
