package com.nanemo.composesample.presentation.heroes

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nanemo.composesample.ui.theme.ComposeSampleTheme


@Composable
@Preview
@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
@Preview(name = "landscape", device = "spec:shape=Normal,width=640,height=360,unit=dp,dpi=480")
@Preview(name = "tablet", device = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=480")
fun HeroCardPreview() {
    ComposeSampleTheme {
        Surface {
            HeroCard(
                hero = HeroState(1, "Maxim", "", "", isSaved = false, isSelected = false),
                {}) {}
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroCard(
    hero: HeroState,
    onItemClick: () -> Unit,
    onLongClick: () -> Unit,

    ) {
    var expanded by remember { mutableStateOf(hero.isExpanded) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
            .background(color = MaterialTheme.colors.primaryVariant)
            .combinedClickable(
                onClick = { expanded = true },
                onLongClick = { onLongClick() },
            )
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column {
            AsyncImage(
                model = hero.icon,
                contentDescription = "Hero icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
            )
            if (expanded) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = (hero.description)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .weight(1f)
        ) {
            Text(
                text = hero.name,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}