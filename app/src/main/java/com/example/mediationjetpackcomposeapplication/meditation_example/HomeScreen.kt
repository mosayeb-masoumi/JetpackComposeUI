package com.example.mediationjetpackcomposeapplication.meditation_example

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mediationjetpackcomposeapplication.R
import com.example.mediationjetpackcomposeapplication.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {

        Column() {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                listOf(
                    Feature(
                        title = "Day island",
                        R.drawable.ic_videocam,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),

                    Feature(
                        title = "Day island",
                        R.drawable.ic_videocam,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),

                    ) , context
            )
        }

        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate",R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ) , modifier = Modifier.align(Alignment.BottomCenter) , context)
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    context: Context,
    activeHighlightColor : Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {

    var selectedItemIndex by remember{
        mutableStateOf(initialSelectedItemIndex)
    }

   Row(
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.SpaceAround,

       modifier = modifier
           .fillMaxWidth()
           .background(DeepBlue)
           .padding(15.dp)
   ) {

       items.forEachIndexed{
           index , item ->
           BottomMenuItem(
              item = item,
              isSelected = index == selectedItemIndex,
              index = index ,
               activeHighlightColor = activeHighlightColor,
               activeTextColor = activeTextColor,
               inactiveTextColor = inactiveTextColor ,
               context = context,
           ){
             selectedItemIndex = index
           }
       }

   }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    index : Int = 0,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    context: Context,

    onItemClick: () -> Unit,

)
{
   Column(
       verticalArrangement = Arrangement.Center ,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.clickable {

//           if(index == 4){
//               context.startActivity(Intent(context , DetailedActivity::class.java))
//           }

       }
   ){

       Box(
           modifier = Modifier
               .clip(RoundedCornerShape(10.dp))
               .background(if (isSelected) activeHighlightColor else Color.Transparent)
               .padding(10.dp),
           contentAlignment = Alignment.Center
       ){
          
           Icon(
               painter = painterResource(id = item.iconId),
               contentDescription = item.title ,
               tint = if (isSelected) activeTextColor else inactiveTextColor,
               modifier = Modifier.size(20.dp)
           )
       }
       
       Text(
           text = item.title,
           color = if(isSelected)  activeTextColor else inactiveTextColor
       )
   }
}


@Composable
fun GreetingSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = "Helloo mosayeb", style = MaterialTheme.typography.h2)
            Text(text = "We wish you have a good day!", style = MaterialTheme.typography.body1)
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search), contentDescription = "search",
            modifier = Modifier
                .size(24.dp)
                .padding(end = 5.dp),
            tint = Color.White
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {

    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow() {
        items(chips.size) {
            Box(modifier = Modifier
                .padding(start = 15.dp, bottom = 15.dp, top = 15.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable { selectedChipIndex = it }
                .background(if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue)
                .padding(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = chips[it], color = Color.White)
            }
        }
    }

}

@Composable
fun CurrentMeditation(color: Color = LightRed) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 15.dp)
    )
    {
        Column() {
            Text(text = "Daily Thought", style = MaterialTheme.typography.h2)
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.h2,
                color = TextWhite
            )
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(ButtonBlue)
                .clip(CircleShape)
                .background(Color.Red)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }


}

@ExperimentalFoundationApi
@Composable
fun FeatureSection(features: List<Feature>, context: Context) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = "Feature",
            style = MaterialTheme.typography.h1,
            color = Color.White
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {

            items(features.size) {
                FeatureItem(feature = features[it] , context)
            }
        }

    }
}

@Composable
fun FeatureItem(feature: Feature, context: Context) {

    Box(
        modifier = Modifier
            .width(100.dp)
            .height(150.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(feature.darkColor)
            .clickable {
                val intent = Intent(context, DetailedActivity::class.java)
                intent.putExtra("TITLE", feature.title)
                context.startActivity(intent)
            }
            .padding(10.dp)
    ) {

        Text(
            text = feature.title,
            style = MaterialTheme.typography.h2,
            lineHeight = 20.sp,
            modifier = Modifier.align(Alignment.TopStart)
//            modifier = Modifier.align(Alignment.TopStart)
        )
        Icon(
            painter = painterResource(id = feature.iconId),
            contentDescription = feature.title,
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(20.dp)
        )
        Text(
            text = "Start", color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, DetailedActivity::class.java)
                    intent.putExtra("TITLE", feature.title)
                    context.startActivity(intent)
                }
                .clip(RoundedCornerShape(5.dp))
                .background(ButtonBlue)
                .padding(5.dp)
                .align(Alignment.BottomEnd)
                .padding(horizontal = 5.dp)

        )
    }
}
