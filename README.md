# Top Down Shooter - Aliens vs Humans 

## Project Pitch

[Pitct Pitch with Slides](https://docs.google.com/presentation/d/1v3ea9qtfltWQ06R84yk-NwTmRux-YME8crWoAlW89lM/edit#slide=id.p)
## Object: 
Our goal was to create an Old-Fashion 2D shooter game that has an easy-to-operate GUI and competent interactive features between the user and the enemy. 
The objective of the game will be to stay alive for as long as possible, using your three lives.
This program will be operated by the user’s mouse using their left click. 

## Proces:
Our work was broken down as:
* Creating a user-friendly GUI,
* Developing the algorithm that randomly spawns the enemies and checks the levels,
* Implementing a strong collision detection system that interacts responsively between the player, bullet, and enemy classes,
* Arithmetically calculating through trigonometric identities a functional method for determining the current angle of rotation on the JavaFX planes and bullets.


## Problems Encountered and solutions. 

* Git conflicts → *Solution*: Troubleshoot using online tools as well as forums
* Angles of rotation for the bullet and enemies → *Solution*: Utilized the arctan function between the position of the player, cursor and randomly spawned enemy
* Rendering issues → *Solution*: Moved all the graphical nodes into the main JavaFx thread. 
* Enemies freezing when spawned → *Solution*: The speed was being initialized to 0 when the random numbers were being created, so we had to add a small increment
* Making Collision intuitive → *Solution*: Used hidden collision aligned boundaries under the images of bullets, enemies and player so when these two nodes intersect, the collision returns true and the nodes are removed from screen.

### Features to be added:

- [x] Main CleanUp
- [x] Code Refactor
- [x] Presentation Mode Ready
- [x] GUI
- [x] Collision System
- [x] Spawning Algorithm
- [x] Hidden levels
- [ ] Instructions Screen.


## Video Walkthrough

Here is a walkthrough of our progress.

### Final Product:

<img src='http://g.recordit.co/Sy0215pwHy.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

## First Steps:
<img src='http://g.recordit.co/5zfsdIXkmM.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />


