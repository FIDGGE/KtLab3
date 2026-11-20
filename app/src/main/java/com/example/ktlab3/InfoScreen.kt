package com.example.ktlab3

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Задание 4: My Information. */
@Composable
fun InfoScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_avatar),
                contentDescription = stringResource(R.string.info_avatar_desc),
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = stringResource(R.string.info_name),
                fontSize = 36.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = stringResource(R.string.info_title),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                ContactRow(R.drawable.ic_phone, R.string.info_phone_desc, stringResource(R.string.info_phone))
                ContactRow(R.drawable.ic_share, R.string.info_social_desc, stringResource(R.string.info_social))
                ContactRow(R.drawable.ic_email, R.string.info_email_desc, stringResource(R.string.info_email))
            }
        }
    }
}

@Composable
private fun ContactRow(@DrawableRes icon: Int, @StringRes descRes: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(icon),
            contentDescription = stringResource(descRes),
            modifier = Modifier.size(24.dp)
        )
        Text(text = text, modifier = Modifier.padding(start = 16.dp))
    }
}
