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
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.*
import com.example.myapplication.ui.componentcategory.CategoryItem
import com.example.myapplication.ui.componentmenu.MenuItem
import com.example.myapplication.ui.components.HomeSections
import com.example.myapplication.ui.components.SectionText
import com.example.myapplication.ui.componentsbar.SearchBar
import com.example.myapplication.ui.theme.JetzCoffeeTheme
import com.example.myapplication.ui.theme.LightGray

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
    Scaffold(
        bottomBar = { BottomBar() }
        ){ innerPadding->
    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())
            .padding(innerPadding)
    ) {
        Banner()
//        SectionText(stringResource(R.string.section_category))
//        CategoryRow()
//        Ganti dengan HomeSection, dengan cara named parameter.
        HomeSections(
            title = stringResource(R.string.section_category),
            content = { CategoryRow() }
        )
//        SectionText(stringResource(R.string.section_favorite_menu))
//        MenuRow(dummyMenu)
//       Ganti dengan HomeSection, argument satu per satu.
        HomeSections(stringResource(R.string.section_best_seller_menu), Modifier, {
            MenuRow(dummyMenu)
        })
//        SectionText(stringResource(R.string.section_best_seller_menu))
//        MenuRow(dummyBestSellerMenu)
//       HomeSection, parenthesis
        HomeSections(stringResource(R.string.section_best_seller_menu), Modifier) {
            MenuRow(dummyBestSellerMenu)
        }
    }
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

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
){
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary,
        modifier=Modifier
    ) {
        val navigationItems = listOf(
            BottomBarItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountBox
            ),
        )
        navigationItems.map {
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                label={
                    Text(it.title)
                },
                selected = it.title==navigationItems[0].title,
                unselectedContentColor = LightGray,
                onClick = {  }
            )
        }
    }
}