## About Build It Bigger
Joke telling app made as part of Udacity android nanodegree, intended for learning purposes.

## Features
- shows jokes about Chuck Norris
- shows banner ad as well as interstitial ad
- ad free paid flavor

## Notable technical details
- google cloud enpoint as a joke source
- two flavor dimensions: `cost` (free/paid) and `api_location` (local/remote)
- `joker` java library
- `jokeviewer` android library
- `autoCheck` gradle task that automaticaly spins up local API server and runs tests

## Build
This is pure gradle project. You can build it using Android Studio (select `Import project`) or with [gradle CLI](http://developer.android.com/tools/building/building-cmdline.html).

## License
TODO
