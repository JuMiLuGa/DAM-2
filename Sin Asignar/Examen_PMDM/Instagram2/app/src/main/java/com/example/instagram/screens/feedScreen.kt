@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.instagram.screens

import android.app.Dialog
import android.icu.text.CaseMap.Title
import android.icu.text.CaseMap.toTitle
import android.service.autofill.OnClickAction
import android.service.quicksettings.Tile
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.navigation.NavController
import com.example.instagram.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(navController: NavController){
   Scaffold(
       topBar = { MyTopAppBar(navController) },
       bottomBar = { MyBottomAppBar() },
   ) { contentPadding ->
       // Screen content
       Column(modifier = Modifier.padding(contentPadding) ){
           MainContent()
       }
   }
}

/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
@Composable
fun MainContent(){
    /* Puntuación: 1 punto
    *       Implementar la estructura del scroll.
    * */

    Column(Modifier.verticalScroll(rememberScrollState())) {
        PostStructure()
        PostStructure()
    }

}

/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
@Composable
fun PostStructure() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        PostUserInfo()
        PostContent()
        PostSocialInfo()
        PostCommentSection()
    }
}
/**************************************************************************************************/
@Composable
fun PostUserInfo() {
    /*
    *   Puntuación: 2.5 puntos
    *   Recursos:
    *       Imagen: ies_logo (40.dp circular)
    *       "IES Antón Losada" - 18.sp Bold
    *       "A estrada, Pontevedra" - 14.sp
    *       Icono: ic_more
    * */
    Column() {
        CenterAlignedTopAppBar(
            title = { Text(text = "") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.White

            ),
            actions = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ies_logo),
                        contentDescription = "user image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .border(0.dp, Color.Transparent, CircleShape)

                    )
                    Text(
                        text = "IES Antón Losada",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_more),
                        contentDescription = "More",
                    )
                }

            }
        )


    }
}


/**************************************************************************************************/
@Composable
fun PostContent(){
    /*
        Puntuación: 1 punto
        Recursos:
            Utiliza la imagen "troll"
            Borde = 1.dp y Color= Color(0xFFB2B2B2)
    */
    Column() {
        Image(
            painter = painterResource(id = R.drawable.troll),
            contentDescription = "feed image",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .border(1.dp, Color(0xFFB2B2B2))
                .fillMaxWidth()


        )

    }
}
/**************************************************************************************************/
@Composable
fun PostSocialInfo(){
    /*
        Puntuación: 2,5 puntos
        Recursos:
            ic_like_outline(25.dp)
            ic_comment(25.dp)
            ic_send(25.dp)
            ic_save(25.dp)
    */
    CenterAlignedTopAppBar(
        title = { Text(text = "") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        ),

        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_outline),
                    contentDescription = "Like",
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = "Comments",
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = "Send",
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = "Save",
                    Modifier.clickable {

                    }
                )

            }

        }
    )


}


/**************************************************************************************************/
@Composable
fun PostCommentSection(){
    /*
    * Puntuación: 1 punto
    * Recursos:
    *   Padding = 10.dp
    *   "IES Antón Losada" - Negrita
    *   "View all 15 comments" -  13.sp Color DarkGray
    * */

    CenterAlignedTopAppBar(
        title = { Text(text = "") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White

        ),
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "IES Antón Losada",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )

                }

            }
    )

    CenterAlignedTopAppBar(
        title = { Text(text = "") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White

        ),
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "View all 15 comments",
                    fontSize = 10.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Left
                )

            }

        }
    )
}
/**************************************************************************************************/
@Composable
fun PostSaveDialog(show: Boolean, onDismiss: () -> Unit){
    /*
    * Puntuación: 2 punto
    * Recursos:
    *   Para salir del dialogo, vale con pulsar el botón atrás en android o clickar fuera
    *  */

    if (show) {
        Dialog(
            onDismissRequest = { onDismiss()},
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
        ) {
                Text(
                    text = "Añadido a coleccion Personal.",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
        }
    }




/**************************************************************************************************/
/******************************************* TOP APP BAR ******************************************/
/**************************************************************************************************/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavController){
    TopAppBar(
        title = { ImageLogo(modifier = Modifier.height(30.dp)) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {  navController.popBackStack()  }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Notificaciones" )
            }
            IconButton(onClick = { /**/ }) {
                Icon(painter = painterResource(id = R.drawable.enviar), contentDescription = "Mensajes", modifier = Modifier.size(24.dp,24.dp) )
            }
        }
    )
}


/**************************************************************************************************/
/************************************* BOTTOM APP BAR *********************************************/
/**************************************************************************************************/
@Composable
fun MyBottomAppBar() {
    var index by remember { mutableStateOf(0)}
    NavigationBar(
        contentColor = Color.Black,
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = {index = 0 },
            icon = {
                Icon(painter = painterResource(id = R.drawable.ic_home_filled) , contentDescription ="Video",modifier = Modifier.size(24.dp,24.dp) )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(painter = painterResource(id = R.drawable.ic_search) , contentDescription ="Video",modifier = Modifier.size(24.dp,24.dp), tint = Color.Black )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(painter = painterResource(id = R.drawable.ic_add) , contentDescription ="Video",modifier = Modifier.size(24.dp,24.dp), tint = Color.Black )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
        NavigationBarItem(
            selected = index == 3,
            onClick = { index = 3 },
            icon = {
                Icon(painter = painterResource(id = R.drawable.video) , contentDescription ="Video",modifier = Modifier.size(24.dp,24.dp) )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
        NavigationBarItem(
            selected = index == 4,
            onClick = { index = 4 },
            icon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Star")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
    }
}