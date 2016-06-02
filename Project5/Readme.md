#Project 5
Stephen Calabro
CS387 Game Ai

##Overview
For this project I used Kruskals algorithim to generate the map content.

First, I started with a list of walls for the map generation. Next I made a map of nodes 0-(width*height). I then created an object called Edge whcih would hold the value of 2 nodes by name (ex 3-6) and assign a random weight to the edge upon creation. Next, I sorted this new list of edges and applied the Kruskal algorithim to them. This then gave me a list of edges that a wall needed to be removed from. Once I removed them I was left with a basic map.

Next, I scanned the newly calculated map and randomly changed walls to floors. This created an effect of random "rooms/hallways" rather than the maze effect I was getting before. After this, I added random values that would randomly place boulders and houses where walls were to make the map look a little different and dynamic.

All of these values were eventually sent to my FilActions class which would first paint a green layer as the first layer of "grass" and then paint the walls and new floors ontop of that. This class directly edited the files that would be output. This class also had a function that allowed me to send in the starting positon of the player. 
