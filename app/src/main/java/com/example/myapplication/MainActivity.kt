package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Menu
import com.example.myapplication.model.dummyBestSellerMenu
import com.example.myapplication.model.dummyCategory
import com.example.myapplication.model.dummyMenu
import com.example.myapplication.ui.componentcategory.CategoryItem
import com.example.myapplication.ui.componentmenu.MenuItem
import com.example.myapplication.ui.components.SectionText
import com.example.myapplication.ui.componentsbar.SearchBar
import com.example.myapplication.ui.theme.JetzCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetzCoffeeTheme {
                JetCoffeeApps()
                // A surface container using the 'background' color from the theme
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
                */
            }
        }
    }
}
@Composable
fun JetCoffeeApps(){
    Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
        Banner()
        SectionText(stringResource(R.string.section_category))
        CategoryRow()
        SectionText(stringResource(R.string.section_favorite_menu))
        MenuRow(dummyMenu)
        SectionText(stringResource(R.string.section_best_seller_menu))
        MenuRow(dummyBestSellerMenu)
    }

}
@Composable
fun Banner(
    modifier: Modifier= Modifier,
){
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription ="Image Banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(165.dp)
        )
        SearchBar()
    }
}
@Composable
fun CategoryRow(
    modifier: Modifier =Modifier
){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(16.dp)
    ){
        items(dummyCategory, key={ it.textsCategory}) {
            category->
            CategoryItem(category = category)
        }
    }
}
@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier= Modifier
){
    LazyRow(
        contentPadding =  PaddingValues(horizontal = 18.dp),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(18.dp),
    ){
        items(listMenu, key = {it.title}) {
            menu->
            MenuItem(menu = menu)
        }
    }

}
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeAppPreview(){
    JetzCoffeeTheme {
        JetCoffeeApps()
    }
}
/*
@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    JetzCoffeeTheme {
        CategoryRow()
    }
}
*/
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetzCoffeeTheme {
        Greeting("Android")
    }
}