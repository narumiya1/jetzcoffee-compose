package com.example.myapplication.ui.componentcategory

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.Category
import com.example.myapplication.ui.theme.JetzCoffeeTheme

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(category.imageCategory),
            contentDescription = null,
            modifier = Modifier
                .size(67.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(category.textsCategory),
            fontSize = 11.sp,
            modifier = Modifier.paddingFromBaseline( top = 16.dp, bottom = 8.dp)


        )
    }

}

@Composable
@Preview(showBackground = true)
fun CategoryItemPreview(){
    JetzCoffeeTheme {
        CategoryItem(category = Category(
            R.drawable.icon_category_cappuccino,
            R.string.category_cappuccino,
        ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}