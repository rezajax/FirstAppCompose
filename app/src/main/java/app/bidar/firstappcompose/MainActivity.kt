package app.bidar.firstappcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.bidar.firstappcompose.ui.theme.FirstAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthDayWhitImage(message = stringResource(id = R.string.happy_birthday_text), from = "Reza")
                }
            }
        }

    }
}

@Composable
fun BirthDayWhitImage (message: String, from: String) {
    var image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthDay(message = message, from = from)

    }
}

@Composable
fun BtnChangeLanguage () {
    Button(
        onClick = {
                  Toast.makeText(MainActivity(), "hi", Toast.LENGTH_SHORT).show()
        },
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
//        ),
//        modifier = Modifier
//            .wrapContentWidth(Alignment.Top)
    ) {
        // Inner content including an icon and a text label
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}


@Composable
fun BirthDay(message: String, from: String) {
    Column() {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
                .padding(start = 16.dp, end = 16.dp)
        )

        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .padding(start = 16.dp, end = 16.dp)
        )

        BtnChangeLanguage()
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstAppComposeTheme {
        BirthDayWhitImage(message = stringResource(R.string.happy_birthday_text), from = "Reza")
    }
}
