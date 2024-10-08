package com.azrinurvani.newsapicompose.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.azrinurvani.newsapicompose.R
import com.azrinurvani.newsapicompose.domain.model.NewsArticle

@Composable
fun HeadlineCard(
    modifier: Modifier = Modifier,
    article : NewsArticle
){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row {
                AsyncImage(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    model = article.urlToImage,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = article.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.scrim
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = article.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Text(
                            text = "By : ${article.author}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = article.publishedAt,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                    }


                }
            }

        }
    }

}

@Composable
@Preview(showBackground = true)
fun HeadlineCardPreview(
    modifier: Modifier = Modifier
){
    val newsArticle = NewsArticle(
        author = "Azri Nurvani",
        description = "kanflkansfklasnfklnasklfnklasnflkaskfnakslfnasklnfasknflkasnfklanf",
        category = "business",
        url = "https://www.example.com/azi_nurvani",
        title = "Title Article",
        sourceName = "internet",
        urlToImage = "https://www.instagram.com/",
        publishedAt = "08 Agustus 2024",
        content = "ashtlaksfnlkasflkaslknf"
    )
    HeadlineCard(
        modifier,
        newsArticle
    )
}