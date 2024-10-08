package com.azrinurvani.newsapicompose.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azrinurvani.newsapicompose.domain.model.NewsArticle

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    article : NewsArticle?,
    onCardClick : (NewsArticle?) -> Unit
){
    Card (
        modifier = modifier
            .clickable {
                if (article != null) {
                    onCardClick(article)
                }
            }
    ){
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            ImageHolder(
                article?.urlToImage
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = article?.title ?: "",
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = article?.sourceName ?: "",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    text = article?.publishedAt ?: "",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NewsCardPrev(){
    val newsArticle = NewsArticle(
        author = "Azri Nurvani",
        description = "kanflkansfklasnfklnasklfnklasnflkaskfnakslfnasklnfasknflkasnfklanf",
        category = "business",
        url = "https://www.example.com/azi_nurvani",
        title = "Title Article kanflkansfklasnfklnasklfnklasnflkaskfnakslfnasklnfasknflkasnfklanf",
        sourceName = "internet",
        urlToImage = "https://www.instagram.com/",
        publishedAt = "08 Agustus 2024",
        content = "ashtlaksfnlkasflkaslknf"
    )
    NewsCard(
        article = newsArticle
    ) {

    }
}