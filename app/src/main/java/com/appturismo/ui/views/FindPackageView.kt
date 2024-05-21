package com.appturismo.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.appturismo.domain.models.Package
import com.appturismo.network.remote.factories.PackageRepositoryFactory
import com.appturismo.ui.theme.AppTurismoTheme
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindPackageView(
    goToMenu: () -> Unit
)
{
    val (selectedPlace, setSelectedPlace) = remember { mutableStateOf("S001") }
    val packageTypes = listOf("Touring", "Accommodation")
    val selectedIndex = remember { mutableIntStateOf(0) }
    val places = listOf("S001", "S002", "S003", "S004", "S005")
    val placeNames = listOf("Machu Picchu", "Ayacucho", "Chichen Itza", "Cristo Redentor", "Islas Malvinas", "Muralla China")


    val packageRepository = PackageRepositoryFactory.getPackageRepository()

    val packages = remember {
        mutableStateOf(emptyList<Package>())
    }
    packageRepository.getPackages(site = selectedPlace, type = (selectedIndex.intValue + 1), callback = {
        packages.value = it
    })

    AppTurismoTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Find packages") },
                    navigationIcon = {
                        IconButton(onClick = { goToMenu() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    })
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(top = 0.dp, bottom = 0.dp, start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                LazyRow (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(places) { place ->
                        val index = places.indexOf(place)
                        FilterChip(selected = place == selectedPlace, onClick = { setSelectedPlace(place) }, label = { Text(placeNames[index])})
                    }
                }
                SingleChoiceSegmentedButtonRow (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    packageTypes.forEachIndexed { index, label ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(index = index, count = packageTypes.size),
                            onClick = { selectedIndex.intValue = index },
                            selected = index == selectedIndex.intValue
                        ) {
                            Text(label)
                        }
                    }
                }
                LazyColumn (
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(packages.value) { item ->
                        PackageCard(item = item)
                    }
                }
            }
        }
    }
}

@Composable
fun PackageCard(item: Package) {
    ElevatedCard {
        Column {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    imageModel = { item.imageUrl },
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Icon(
                        Icons.Outlined.FavoriteBorder,
                        tint = Color.White,
                        contentDescription = "Is favourite",
                        modifier = Modifier.size(64.dp)
                    )
                }
            }
            Column (
                modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(text = item.name, style = MaterialTheme.typography.headlineSmall)
                Text(text = item.location, style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}