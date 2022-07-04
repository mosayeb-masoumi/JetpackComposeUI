package com.example.mediationjetpackcomposeapplication.grocery_shop

import android.os.Bundle
import android.preference.PreferenceActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mediationjetpackcomposeapplication.R
import com.example.mediationjetpackcomposeapplication.grocery_shop.ui.theme.MediationJetpackComposeApplicationTheme
import com.example.mediationjetpackcomposeapplication.meditation_example.HomeScreen
import com.example.mediationjetpackcomposeapplication.recepi_example.ImagesReview

class GroceryShopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediationJetpackComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen2()
                }
            }
        }
    }
}

@Composable
fun HomeScreen2() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    )
    {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )

        Column() {
            AppBar()
            Content2()
        }

    }

}


@Composable
fun AppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(48.dp)


    ) {

        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text(
                    text = "Search Food, Vegetable, etc.",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    tint = Color.Black
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
                tint = Color.White
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "",
                tint = Color.White
            )
        }

    }
}


@Composable
fun Content2() {

    Column {
        GroceryHeader()
        Spacer(modifier = Modifier.height(16.dp))
        Promotions()
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(16.dp))
        BestSellerSection()
    }
}


@Composable
fun GroceryHeader() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(5.dp))
            .height(64.dp)
            .background(color = Color.White),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {

            QrButton()
            VerticalDivider()

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 5.dp, end = 5.dp)
                    .weight(1f)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.ic_money),
                    contentDescription = "",
                    tint = Color(0xFF6FCF97)
                )
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = "$120",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(text = "Top Up", color = MaterialTheme.colors.primary, fontSize = 12.sp)
                }
            }

            VerticalDivider()

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 5.dp)
                    .weight(1f)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {

                Icon(
                    painter = painterResource(id = R.drawable.ic_coin),
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary
                )
                Column(modifier = Modifier.padding(5.dp)) {
                    Text(
                        text = "$10",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(text = "Points", color = Color.LightGray, fontSize = 12.sp)
                }
            }
        }

    }
}

@Composable
fun VerticalDivider() {

    Divider(
//        color = Color.Gray,
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}

@Composable
fun QrButton() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
    )
    {
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = "",
            tint = Color.Black
        )
    }
}


@Composable
fun Promotions() {

    LazyRow(
        modifier = Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.promotion),
                title = "Fruit",
                subtitle = "Start @",
                header = "$1",
                backgroundColor = MaterialTheme.colors.primary
            )
        }

        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.promotion),
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
                backgroundColor = Color(0xff6EB6F5)
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {

    Card(
        modifier = Modifier.width(300.dp),
        backgroundColor = backgroundColor,
        elevation = 8.dp
    ) {

        Row {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(
                    text = subtitle,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = header,
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                painter = imagePainter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alignment = Alignment.CenterEnd,
            )
        }
    }
}


@Composable
fun CategorySection() {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Category",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            TextButton(onClick = {}) {
                Text(text = "more", fontSize = 14.sp, color = MaterialTheme.colors.primary)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            CategoryButton(
                title = "Fruits",
                icon = painterResource(id = R.drawable.ic_orange),
                backgroundColor = Color(0xffFEF4E7),
            )
            CategoryButton(
                title = "Vegetables",
                icon = painterResource(id = R.drawable.ic_veg),
                backgroundColor = Color(0xffF6FBF3)
            )
            CategoryButton(
                title = "Dairy",
                icon = painterResource(id = R.drawable.ic_cheese),
                backgroundColor = Color(0xffFFFBF3)
            )
            CategoryButton(
                title = "Meats",
                icon = painterResource(id = R.drawable.ic_meat),
                backgroundColor = Color(0xffF6E6E9)
            )
        }
    }
}

@Composable
fun CategoryButton(title: String, icon: Painter, backgroundColor: Color) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(backgroundColor),
            contentAlignment = Alignment.Center,
        ) {
            Image(painter = icon, contentDescription = "")
        }

        Text(text = title)
    }
}


@Composable
fun BestSellerSection() {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Best Sellers",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            TextButton(onClick = {}) {
                Text(text = "more", fontSize = 14.sp, color = MaterialTheme.colors.primary)
            }
        }

        BestSellerItems()
    }
}

@Composable
fun BestSellerItems() {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 10.dp)
    ) {

        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_lettuce),
                title = "Iceberg Lettuce",
                price = "1.99",
                discountPercent = 10
            )


            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_apple),
                title = "Apple",
                price = "2.64",
                discountPercent = 0
            )


            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_meat),
                title = "Meat",
                price = "4.76",
                discountPercent = 20
            )


        }
    }
}

@Composable
fun BestSellerItem(imagePainter: Painter, title: String, price: String, discountPercent: Int) {

    Card(
        modifier = Modifier
            .width(160.dp)
            .height(200.dp)
            .padding(end = 8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(
                    text = "$title",
                    fontSize = 17.sp,
                    color = Color.Black,
                
                )
                Row(modifier = Modifier.fillMaxWidth()) {

                    Text(
                        text = "$${price}",
                        textDecoration = if (discountPercent > 0)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                        color = if(discountPercent >0) Color.Gray else Color.Black


                    )

                    Text(text = "[$discountPercent%]", color = MaterialTheme.colors.primary)
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MediationJetpackComposeApplicationTheme {
        HomeScreen2()
    }
}