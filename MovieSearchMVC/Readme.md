the project is used to learn MVC in android



![image-20240327112219054](http://www.zimang.top:779/i/2024/03/27/66039111aa8a7.png)

# USEFUL TMDB APIs

## [详情](https://developer.themoviedb.org/reference/movie-details)

按 ID 获取电影详细信息。

```kotlin
val client = OkHttpClient()

val request = Request.Builder()
  .url("https://api.themoviedb.org/3/movie/238?language=zh-CN")
  .get()
  .addHeader("accept", "application/json")
  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MWIwMTk3MTViZjdiOWI2NzkwMzQ2MWVhNGMyMTBlYiIsInN1YiI6IjY1N2JiZWE1ZTkzZTk1MjE5MDBlMTdhOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Ye7wCxdAQeBTXCxFk0kmZq_r90-Vk635QWTnSeHG3BA")
  .build()

val response = client.newCall(request).execute()
```

```json
{
  "adult": false,
  "backdrop_path": "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
  "belongs_to_collection": {
    "id": 230,
    "name": "教父（系列）",
    "poster_path": "/zqV8MGXfpLZiFVObLxpAI7wWonJ.jpg",
    "backdrop_path": "/mDMCET9Ens5ANvZAWRpluBsMAtS.jpg"
  },
  "budget": 6000000,
  "genres": [
    {
      "id": 18,
      "name": "剧情"
    },
    {
      "id": 80,
      "name": "犯罪"
    }
  ],
  "homepage": "",
  "id": 238,
  "imdb_id": "tt0068646",
  "original_language": "en",
  "original_title": "The Godfather",
  "overview": "40年代的美国，“教父”维托·唐·柯里昂是黑手党柯里昂家族的首领，带领家族从事非法的勾当，但同时他也是许多弱小平民的保护神，深得人们爱戴。因为拒绝了毒枭索洛索的毒品交易要求，柯里昂家族和纽约其他几个黑手党家族的矛盾激化、圣诞前夕，索洛索劫持了“教父”的参谋汤姆，并派人暗杀“教父”；因为内奸的出卖，“教父”的大儿子逊尼被仇家杀害；小儿子麦克也被卷了进来，失去爱妻。黑手党家族之间的矛盾越来越白热化。年老的“教父”面对丧子之痛怎样统领全局？黑手党之间的仇杀如何落幕？谁是家族的内奸？谁又能够成为新一代的“教父”？血雨腥风和温情脉脉，在这部里程碑式的黑帮史诗巨片里真实上演。",
  "popularity": 95.059,
  "poster_path": "/y03tzUKvkRCYwJ5NWys4W4bnS9m.jpg",
  "production_companies": [
    {
      "id": 4,
      "logo_path": "/gz66EfNoYPqHTYI4q9UEN4CbHRc.png",
      "name": "Paramount",
      "origin_country": "US"
    },
    {
      "id": 10211,
      "logo_path": null,
      "name": "Alfran Productions",
      "origin_country": "US"
    }
  ],
  "production_countries": [
    {
      "iso_3166_1": "US",
      "name": "United States of America"
    }
  ],
  "release_date": "1972-03-14",
  "revenue": 245066411,
  "runtime": 175,
  "spoken_languages": [
    {
      "english_name": "English",
      "iso_639_1": "en",
      "name": "English"
    },
    {
      "english_name": "Italian",
      "iso_639_1": "it",
      "name": "Italiano"
    },
    {
      "english_name": "Latin",
      "iso_639_1": "la",
      "name": "Latin"
    }
  ],
  "status": "Released",
  "tagline": "",
  "title": "教父",
  "video": false,
  "vote_average": 8.695,
  "vote_count": 19619
}
```



## 寻找电影