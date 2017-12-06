# PopcornTime II
Movie suggestion app

## Set-up Instructions
1. Clone or Download the `130Project` folder
2. Open the IntelliJ IDE and select `Import Project`
	1. Navigate to the folder location and select to open it.
	2. Keep selecting `Next` and make sure to **overwrite** any files if prompted with the question.
3. Once the project is open in IntelliJ IDE, open `Recommended.java` by double-clicking the file in left `Project` tab.
	1. In the `Project` tab, right-click on `Recommended.txt` and select `Copy Path`.
	2. On lines `57, 59, 60,` & `106` of `Recommended.java`, replace the path of `Recommended.txt` & `tempFile.txt` with the path you just copied to you clipboard.
4. Repeat step 3 for `AllMovies.java`
	1. The corrections must be made on lines `125, 127, 128,` & `174`
5. Make sure `Recommended.txt` is empty.


## Run Instructions
1. Right-click on `Main.java` and select `Run 'Main.main()'`
2. The app should load in a new window.
3. Click on the `Recommended Movies` button to confirm that there are currently no recommendations (we'll work on populating this panel in the steps below)
	1. Click on the `Go Back` button to go back to the homescreen.
4. Clock on the `Show All Movies` button
	1. Select a movie you like from the panel on the left.
	2. Click the `Like` button
	3. Repeat steps 4.1 & 4.2 a couple more times
	4. Click the `Go Back` button to return to the homescreen.
5. Click the `Recommended Movies` button to view the movies being recommended to you!
6. Click the `Exit` button to exit the app.