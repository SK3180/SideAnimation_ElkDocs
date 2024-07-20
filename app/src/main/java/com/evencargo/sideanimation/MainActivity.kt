package com.evencargo.sideanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.evencargo.sideanimation.ui.theme.SideAnimationTheme
import com.evencargo.sideanimation.ui.theme.SideLights

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SideAnimationTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(text = "Side Braids Animation",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center, fontSize = 25.sp)
                    }

                    SideLights()
                }

            }
        }
    }
}

