# Android Chatting app Using Socket IO

A simple project that uses Socket IO to connect to a Heroku hosted web server to create bidirectional communication

### Prerequisites

Minimum Android SDK version : 21 Lollipop

### Installing

1. Clone this repo and open it in Android Studio
2. Run the app on any connected device

## Built With

* [Android Studio](https://developer.android.com/studio/)

## MVP Architecture

One of the main advantages of MVP is that it decouples the view from the business logic. This makes modifications to the view easier to implement and allows unit testing of views
A real situation that the architecture helped with was when I had to convert a android.widget based view to a [Preferences](https://developer.android.com/guide/topics/ui/settings/) based view.
I was able to reuse all my existing code in the Presenter even though the View file was redesigned.

## Acknowledgments

* PurpleBooth for the README template [Link](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
