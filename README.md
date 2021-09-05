---------------------------------------------------------------------------------------
  
Outline
---------
1. This is an interactive map designed with the help of Unfolding maps library, Processing library.
2. Two different types of data has been included in this, earthquake dataset and airport dataset. Earthquakes have been drawn in the shape of markers, color coded with extra keys for recent, high magnitude, low magnitude, in the sea and on the land. 
3. Map key has been added on the left of the map.
4. Second data is the Airport dataset, all the airports are shown in the map. if one airport is clicked, all other airports will dissappear until yet another click. All the routes out of an airports are shown when an aiport is clicked. A particular airport can be searched based on the input to the program. All th airports in a country can be searhed as well
5. Labels have been added to the markers(Airports, Earthquakes, cities) on the map, which are shown on hoover
6. 
------------------------------------------------------------------------------------------------------------- 
  
  
  
-------------------------------------------------------------------------------------------------------------
Description
-----------------


  Two datasets have been used in this program i-e Earthquake dataset and Airport dataset. Airport dataset has been implemented in the extension(Described below)

Earthquake data has been plotted on the map. The magnitude of earthquake has been color coded in three colors i-e red, yellow and blue.   
All the cities have been plotted in triangular shape on the map.  
Methods have been implemented to determine if the earthquake is on land or in the sea
Earthquake key has been added on the top left side of the map.  
Earthquakes which have recently occured have been distinguished with an 'X' mark drawn on top of them.  
Hoover effect has been added to the appplication and a label is shown every time mouse hoovers over any marker   
Some output from the program is attached below
![](https://github.com/HamadKhushik/UCSD-UnfoldingMaps-Module5/blob/master/UCSDUnfoldingMaps/images/EarthquakeFinal.PNG)

Extension
----------------
The program has been extended to include the following features

1. If the users enter the name of the country at input prompt, only airports of that country will be shown or just press enter to view the airports of the world   
2. if the user clicks on any airport, the program will show all the routes out of that airport and the destination airports. Remaining airports will dissappear from the map.
3. on second click all the routes will dissappear and the remaining airports will re-appear.  
if the user clicks on any other airport, all the routes out of that airport are shown.
4. Some output from the program is shown below
![](https://github.com/HamadKhushik/UCSD-UnfoldingMaps-Module5/blob/master/UCSDUnfoldingMaps/images/UnfoldingMaps.png)
![](https://github.com/HamadKhushik/UCSD-UnfoldingMaps-Module5/blob/master/UCSDUnfoldingMaps/images/final%20assignment%20screenshot2.png)

NOTE: in some airports, there are no routes(in the dataset used)!
