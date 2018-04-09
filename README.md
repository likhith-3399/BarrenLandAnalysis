##    **Barren Land Analysis**

##### **Problem statement**

You have a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399, 599). A portion of the farm is barren, and all the barren land is in the form of rectangles. Due to these rectangles of barren land, the remaining area of fertile land is in no particular shape. An area of fertile land is defined as the largest area of land that is not covered by any of the rectangles of barren land.

Read input from STDIN. Print output to STDOUT  

###### **Input** :
You are given a set of rectangles that contain the barren land. These rectangles are defined in a string, which consists of four integers separated by single spaces, with no additional spaces in the string. The first two integers are the coordinates of the bottom left corner in the given rectangle, and the last two integers are the coordinates of the top right corner.
###### **Output**
Output all the fertile land area in square meters, sorted from smallest area to greatest, separated by a space.

    
 | Sample Input | Sample Output           |          
 | ------------- |:-------------:|      
 | {“0 292 399 307”} | 116800  116800 |             
 | {“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”} | 22816 192608       |          
  
  #### System Requirements:
 1. Any system with Java 1.8

 
 #### Conceptualization:
  1. The idea behind the code was to traverse through each cell of the field. 
  2. This can be thought of path traversal search for connected cells
  3. BFS was one of the way to taverse the nodes where in bordering nodes act as its children
  4. It can be thought as disconnected BFS as different areas are not connected  
 
 ### Installing Application

A step by step series of examples that tell you how to get a development env running in local machine

1. Clone the repo from GitHub using gitcli command,

```
git clone https://github.com/likhith-3399/BarrenLandAnalysis.git
```

2. Build the application
```
mvn clean install (runs junit tests)
mvn clean install -DskipTests (to ignore/ skip junits)
```

3. Run the Application
```
Run the application, by adding the main class to Run Configuration.
```
 
### Built With

* [Maven](https://maven.apache.org/) - Dependency Management


### Versioning

For the versions available, see the [tags on this repository](https://github.com/likhith-3399/BarrenLandAnalysis/releases). 


### Authors & Contributing

* **Likhith Matta**

See also the list of [contributors](https://github.com/likhith-3399/BarrenLandAnalysis/contributors) who participated in this project.
