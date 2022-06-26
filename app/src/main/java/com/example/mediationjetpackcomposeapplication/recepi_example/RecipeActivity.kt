package com.example.mediationjetpackcomposeapplication.recepi_example

import android.icu.number.Scale
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mediationjetpackcomposeapplication.recepi_example.ui.theme.MediationJetpackComposeApplicationTheme
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import kotlin.math.max
import kotlin.math.min
import com.example.mediationjetpackcomposeapplication.R
import com.example.mediationjetpackcomposeapplication.collaps_toolbar.ui.theme.GradientOne
import com.example.mediationjetpackcomposeapplication.collaps_toolbar.ui.theme.GradientTwo
import com.example.mediationjetpackcomposeapplication.meditation_example.FeatureItem
import com.example.mediationjetpackcomposeapplication.recepi_example.ui.theme.Pink

class RecipeActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MediationJetpackComposeApplicationTheme {
                ProvideWindowInsets {
                    Surface(color = White) {
                        MainFragment(strawberryCake)
                    }
                }
            }
        }


    }

}


@Composable
fun MainFragment(recipe: Recipe) {
    val scrollState = rememberLazyListState()

    Box {
        Contents(scrollState, recipe)
        ProfileToolBar(scrollState, recipe)
    }
}

@Composable
fun ProfileToolBar(scrollState: LazyListState, recipe: Recipe) {
    val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight

    val maxOffset = with(LocalDensity.current) {
        imageHeight.roundToPx()
    } - LocalWindowInsets.current.systemBars.layoutInsets.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.White,
        modifier = Modifier
            .height(
                AppBarExpendedHeight
            )
            .offset {
                IntOffset(x = 0, y = -offset)
            },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
//        elevation = 0.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight)
                    .graphicsLayer {
                        alpha = 1f - offsetProgress
                    }
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                GradientOne, GradientTwo
                            )
                        )
                    )


            ) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.makeiteasy),
                            contentDescription = "Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(100.dp)
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "@Make it Easy",
                            fontSize = 25.sp,
                            color = Color.White,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "makeiteasy@abc.com",
                            fontSize = 15.sp,
                            color = Color.White,
                            maxLines = 1,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(2.dp)
                        )


                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Contact Info",
                    fontSize = 25.sp,
                    color = Color.Black,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = (16 + 28 * offsetProgress).dp)
                        .scale(1f - 0.25f * offsetProgress)
                )
            }
        }
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(9.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularButton(R.drawable.ic_arrow_back)
//        CircularButton(R.drawable.ic_favorite)
        LikeButton(R.drawable.ic_favorite)
    }


}

@Composable
fun LikeButton(likeIcon: Int) {

    var selectedLike by remember {
        mutableStateOf(false)
    }

    Button(
        onClick = {
            selectedLike = !selectedLike
        },
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(10.dp),
        colors = if(selectedLike) ButtonDefaults.buttonColors(backgroundColor = Red, contentColor = White)
        else ButtonDefaults.buttonColors(backgroundColor = White, contentColor = Gray),
        elevation = null,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    )
    {
        Icon(painterResource(id = likeIcon), null)
    }

}


@Composable
fun CircularButton(

    @DrawableRes iconResouce: Int,
    color: Color = Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = White, contentColor = color),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painterResource(id = iconResouce), null)
    }
}


@Composable
fun Contents(scrollState: LazyListState, recipe: Recipe) {
    LazyColumn(contentPadding = PaddingValues(top = AppBarExpendedHeight), state = scrollState) {
        item {
            BasicInfo(recipe)
            DescriptionInfo(recipe)
            ServingCalculator()
            IngredientsHeader(listOf("Ingredients", "Tools", "Steps"))
            IngredientsList(strawberryCake)
            ShoppingListButton()
            Reviews(recipe)
            ImagesReview(recipe)
        }
    }
}

@Composable
fun ImagesReview(recipe: Recipe) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(160.dp)

    ) {

        Image(
            painter = painterResource(id = recipe.ingredients[0].image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Image(
            painter = painterResource(id = recipe.ingredients[1].image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
        )
    }
}

@Composable
fun Reviews(recipe: Recipe) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Reviews")
            Text(text = recipe.reviews)
        }

        Button(
            onClick = {},
            elevation = null,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Transparent,
                contentColor = Pink
            ),

            )
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "See all")
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
fun ShoppingListButton() {

    Button(onClick = {},
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = LightGray,
            contentColor = Color.Black,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
    )
    {
        Text(text = "Add to shopping list", modifier = Modifier.padding(8.dp))
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IngredientsList(recipe: Recipe) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
//        contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
        modifier = Modifier
            .height(400.dp)
            .padding(16.dp)
    )
    {
        items(recipe.ingredients.size) {
            IngredientItem(recipe.ingredients[it])
        }
    }
}

@Composable
fun IngredientItem(ingredient: Ingredient) {

    Box(
        modifier = Modifier
            .height(160.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(id = ingredient.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
        )
    }
}

@Composable
fun IngredientsHeader(list: List<String>) {

    var selectedItemClicked by remember {
        mutableStateOf(0)
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(LightGray)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        items(list.size) {

            Box(modifier = Modifier

                .clip(RoundedCornerShape(20.dp))
                .background(if (selectedItemClicked == it) Green else Transparent)
                .padding(16.dp)
                .clickable {
                    selectedItemClicked = it
                }
            ) {
                Text(text = list[it])
            }

        }
    }
}

@Composable
fun ServingCalculator() {

    var value by remember {
        mutableStateOf(6)
    }

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(LightGray)
            .fillMaxWidth()
            .padding(16.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "Serving", modifier = Modifier.weight(1f), fontWeight = FontWeight.Medium)
        CircularButton(iconResouce = R.drawable.ic_minus, elevation = null, color = Pink) {
            if (value <= 0) {
                value = 0
            } else {
                value--
            }

        }
        Text(
            text = "$value",
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        CircularButton(iconResouce = R.drawable.ic_plus, elevation = null, color = Pink) {
            if (value >= 9) {
                value = 9
            } else {
                value++
            }

        }

    }
}

@Composable
fun DescriptionInfo(recipe: Recipe) {

    Text(
        text = recipe.description,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun BasicInfo(recipe: Recipe) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        InfoColumn(R.drawable.ic_clock, recipe.cookingTime)
        InfoColumn(R.drawable.ic_flame, recipe.energy)
        InfoColumn(R.drawable.ic_star, recipe.rating)
    }
}

@Composable
fun InfoColumn(icon: Int, cookingTime: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = Pink,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = cookingTime,
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
        )
    }
}


@Preview(showBackground = true, widthDp = 380, heightDp = 1400)
@Composable
fun DefaultPreview() {
    MediationJetpackComposeApplicationTheme {
        MainFragment(strawberryCake)
    }

}
