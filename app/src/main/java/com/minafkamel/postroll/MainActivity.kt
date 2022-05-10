package com.minafkamel.postroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.minafkamel.postroll.ui.allposts.AllPostsScreen
import com.minafkamel.postroll.ui.theme.PostRollTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostRollTheme {
                // A surface container using the 'background' color from the theme

                    AllPostsScreen()
            }
        }
    }
}
