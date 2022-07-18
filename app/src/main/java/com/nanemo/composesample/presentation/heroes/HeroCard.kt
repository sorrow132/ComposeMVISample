package com.nanemo.composesample.presentation.heroes

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.nanemo.composesample.R
import com.nanemo.composesample.presentation.theme.ComposeSampleTheme
import com.nanemo.composesample.utils.MockData

@Composable
@Preview
@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
@Preview(name = "landscape", device = "spec:shape=Normal,width=640,height=360,unit=dp,dpi=480")
@Preview(name = "tablet", device = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=480")
fun HeroCardPreview() {
    ComposeSampleTheme {
        HeroCard(
            hero = MockData.heroItem,
            onItemClick = {},
            onLongClick = {},
            onExpandCardClick = {})
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroCard(
    hero: HeroState,
    onItemClick: (HeroState) -> Unit,
    onLongClick: (Pair<Boolean, HeroState>) -> Unit,
    onExpandCardClick: (Pair<Boolean, HeroState>) -> Unit
) {
    Surface {
        Card(
            shape = if (hero.isSelected) RoundedCornerShape(topStart = 30.dp)
            else RoundedCornerShape(topStart = 0.dp),
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .fillMaxWidth()
                .fillMaxWidth()
                .combinedClickable(
                    onClick = {
                        onItemClick.invoke(hero)
                    },
                    onLongClick = {
                        onLongClick.invoke(!hero.isSelected to hero)
                    },
                )
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        AsyncImage(
                            model = hero.icon,
                            contentDescription = "Hero icon",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(120.dp)
                        )
                    }
                    Column(
                        modifier = Modifier.weight(2f)
                    ) {
                        Text(
                            text = hero.name,
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp)
                        )
                    }
                    IconButton(
                        onClick = { onExpandCardClick.invoke(!hero.isExpanded to hero) }) {
                        Icon(
                            imageVector = if (hero.isExpanded) Icons.Outlined.KeyboardArrowUp
                            else Icons.Outlined.KeyboardArrowDown,
                            contentDescription = if (hero.isExpanded) {
                                stringResource(R.string.show_less)
                            } else {
                                stringResource(R.string.show_more)
                            }

                        )
                    }
                }
                if (hero.isExpanded) {
                    Text(
                        modifier = Modifier.padding(all = 5.dp),
                        text = (hero.description),
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}