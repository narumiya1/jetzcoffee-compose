package com.example.myapplication.model

import com.example.myapplication.R

data class Menu(
    val image: Int,
    val title: String,
    val price: String,
)

val dummyMenu = listOf(
    Menu(R.drawable.menu1, "Tiramiszu Coffee Milk", "Rp 28.000"),
    Menu(R.drawable.menu2, "Pumpupkins Spice Latte", "Rp 18.000"),
    Menu(R.drawable.menu3, "Light Yagami Cappuccino", "Rp 20.000"),
    Menu(R.drawable.menu4, "Chocodot Creamy Latte", "Rp 16.000"),
)

val dummyBestSellerMenu = dummyMenu.shuffled();


