# Julia_Sosnowski_MAD

Diary 1 Tasks:

Learning Diary 1
Kotlin Intro + Android Studio
Watch the Kotlin Crashcourse Video in Moodle or complete the tutorials “Introduction to programming in Kotlin” and “Kotlin fundamentals”:
- https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1
- https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1

Please answer the following questions and submit this document as your learning diary 1.
Link to your public GitHub Repository:
https://github.com/Sayunix/Julia_Sosnowski_MAD

Kotlin Tutorial (1/3)
1. Describe how Kotlin handles null safety. What are nullable types and non-null types in Kotlin? (1 point)

Kotlin simply doesn’t use null values. Kotlin still allows setting values to null, but it must be explicitly set, for those Kotlin has its own features for exception handling:
Nullable types have a ‘?’ at the end of the type name for example ‘String?’. So ‘String’ without question mark only can hold a String, a not-nullable type.

2. How are functions structured in Kotlin? Explain named and default arguments. (1 point)

Functions are initialized with the keyword ’fun’ and then the function name for example ‘main’.
Named and default arguments are features that can make function calls
easier to read.
Default arguments help to fill the value passed to the function a default
value; in this default argument we have given the default value “Google”
to the String searchEngine.
Named arguments allow specifying the name of the function parameter
with its value when calling a function, instead of relying on the order of
the parameters. So, it allows passing arguments to a function in any
order.

3. What are lambda expressions and higher order functions in Kotlin?

Why would you store a function inside a variable? (1 point)
Lambda expression is simplified representation of a function. It can be
passed as a parameter, stored in a variable or even returned as a value.
This is how a lambda expression can look like:
Storing a function inside a variable in Kotlin is a common technique used
in programming for several reasons. It can be useful when you want to
reuse the same function in multiple places in your code, or when you want
to pass the function as an argument to another function. Additionally,
storing functions inside variables is essential for creating higher-order
functions, which are functions that take other functions as arguments or
return functions as results.

4. Implement the following number guessing game in Kotlin and submit your
source code (.kt file) in the GitHub Repository. (2 points)

Generate a random 4-digit number. The number must not contain
repeating digits. Ask the user to guess the 4-digit number. The output
should be in the format "n:m", where "n" is the number of digits guessed
correctly regardless of their position, and "m" is the number of digits
guessed correctly at their correct position. Here are some examples:
Generated number: 8576
• User input: 1234, Output: 0:0
• User input: 5678, Output: 4:1
• User input: 5555, Output: 1:1
• User input: 3586, Output: 3:2
Once the user guesses the correct number, the game is over.


Diary 2 Tasks:

Learning Diary 2
Composables, Layouts, Lists and State

Please answer the following questions and submit this document as your learning diary 2. You can find helpful resources and links below.

Link to your Github Repository:


MovieApp (1/2)

1.	Describe your top 3 learnings from implementing the exercises with the MovieApp in lecture. 
(1 point)
Composables and Modifiers to decorate them;
Layouts in compose: Columns and Rows;
Lists in compose;

3.	Extend your app with a TopAppBar that contains a DropdownMenu and a single DropdownMenuItem (Favorites). Use a remember state variable to toggle the DropDownMenu when the IconButton from the AppBar is clicked. (1 point)


4.	Make movie details (director, release year, plot, …) expandable. When the arrow icon is clicked show/hide movie details. Furthermore, the icon should toggle between up and down. (2 Points)

Hints: Use AnimatedVisibility or animateContentSize to collapse the details. To toggle the arrow icon you can use animations (turn the arrow) or switch the ImageVector from KeyboardArrowDown to KeyboardArrowUp.
  

5.	Use Coil library to load images from Movie.kt URLs (images). Adapt the MovieRow to show an image from each movie (1 point)

Hint: you need to add the internet permission to your manifest.xml to use Coils image loading feature.

Helpful Resources: 
-	Animating Lists in Compose: https://www.youtube.com/watch?v=TMaIMctI7oo
-	Animations: https://developer.android.com/jetpack/compose/animation
-	Coil Compose Documentation: https://coil-kt.github.io/coil/compose/
-	Use Coil in Compose: https://youtu.be/pbcAVtqZ8bg 


