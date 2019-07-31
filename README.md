# NyTimesMovieReviews

For this app, I used the NY Times API to display movie reviews (used this API: https://api.nytimes.com/svc/movies/v2/reviews/dvd-picks.json)

Things I chose to spend time on:

Clean MVP architecture (including Dagger injection)
Parsing the endpoint and displaying the movie title, byline, movie rating, headline, short summary, published date, and image
Paginating using offset
Using the adapter to display the UI
Creating a NetworkInterceptor to check for internet connection
Created a caching mechanism for when there's no internet
Showed snackbars for when there's no internet or cache

Things I could have done if I had more time:

Stored the API key more securely (potentially using KeyStore)
Placeholder image for when there's no multimedia URLs
