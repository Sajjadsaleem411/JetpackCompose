package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
              var text by remember {
                  mutableStateOf("")
              }
                var list by remember {
                    mutableStateOf(listOf<String>())
                }
                /*var count by remember {
                  mutableStateOf(0)
              }
              Column(
                  modifier = Modifier.fillMaxSize(),
                  verticalArrangement = Arrangement.Center,
                  horizontalAlignment = Alignment.CenterHorizontally
              ) {
                  Text(text = count.toString())
                  Button(onClick = {count++}) {
                      Text(text = "Click me!")
                  }

              }*/
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            modifier = Modifier.weight(1f),
                            value = text, onValueChange = { text = it }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if (text.isNotBlank())
                                list = list + text
                            text = ""
                        }) {
                            Text(text = "Add")
                        }
                    }
                    showList(list)
                }
            }
        }
    }

    @Composable
    fun showList(
        names: List<String>,
        modifier: Modifier = Modifier
    ) {
        LazyColumn(modifier) {
            items(names) {
                Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }
        }
    }
}

