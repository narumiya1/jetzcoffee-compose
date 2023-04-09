package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeSections(
    title: String,
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
){
    Column(modifier) {
        SectionText(title, modifier)
        content()
    }
}