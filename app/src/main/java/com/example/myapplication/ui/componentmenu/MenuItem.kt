package com.example.myapplication.ui.componentmenu

import android.view.MenuItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Menu

@Composable
fun MenuItem(
    menu : Menu,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.width(141.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {

            Image(
                painter = painterResource(id = menu.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(127.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Column(modifier = Modifier.padding(8.dp)){
                Text(
                    text = menu.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    text = menu.price,
                    style = MaterialTheme.typography.subtitle2,
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuItemPreview() {
    MaterialTheme {
        MenuItem(
            menu = Menu(com.example.myapplication.R.drawable.menu1 , "Hot Pump up kins Spice Latte Premium", "Rp 16.000"),
            modifier = Modifier.padding(8.dp)
        )
    }
}