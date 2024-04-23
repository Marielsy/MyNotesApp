import android.annotation.SuppressLint
import android.os.Bundle


import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynotesapp2.R
import com.example.mynotesapp2.databinding.FragmentDashboardBinding


class Dashboard : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                DashboardContent()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun DashboardContent() {
    Scaffold(
    ) {
        ContentDash()
    }

}

@Composable
fun ContentDash() {

    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.rosa))
            .fillMaxSize()
    ) {
        Row {
            Text(
                text = "MyNotes",
                modifier = Modifier
                    .padding(start = 100.dp, top = 27.dp)
                    .size(width = 245.dp, height = 83.dp),

                style = TextStyle(
                    fontFamily = FontFamily.Companion.SansSerif,
                    fontWeight = FontWeight(1000),
                    fontSize = 50.sp,
                    color = Color(0xFFf4f8fb)
                ),
                lineHeight = 60.sp
            )
            IconButton(
                onClick = { },
                modifier = Modifier.size(width = 200.dp, height = 100.2.dp),

                ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Icon"
                )
            }
        }
        Buttons()
        Search()
        cardNotes()


    }
}

@Composable
fun CustomButton(text: String) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(1.dp),
    ) {
        Text(text = text)
    }
}
@Composable
fun Buttons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        CustomButton(text = "Todo")
        CustomButton(text = "Libretas")
        CustomButton(text = "Categoria")
    }
}
@Composable
fun Search() {
    var text by remember { mutableStateOf(TextFieldValue()) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .weight(1f)
                .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                .padding(20.dp)
                .height(6.dp),
            textStyle = TextStyle.Default.copy(color = Color.Black),
            cursorBrush = SolidColor(Color.Black)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.List,
            contentDescription = "Lista",
            tint = Color.Black,
            modifier = Modifier.size(36.dp)
        )
    }
}
@Composable
fun cardNotes() {
    var text by remember { mutableStateOf(TextFieldValue()) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(18.dp)
    ) {
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .weight(1f)
                .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                .padding(70.dp)
                .height(6.dp),
            textStyle = TextStyle.Default.copy(color = Color.Black),
            cursorBrush = SolidColor(Color.Black)
        )
        Spacer(modifier = Modifier.width(8.dp))

    }
}
