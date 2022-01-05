# Proiect1

## Design patterns used:

I used strategy pattern to override the method
getAverageScore for every type of child.
For example, when a child is less than 5 years old => it is a baby
we return an object of BabyAverageScoreStrategy type that has the method getAverageScore
implemented for the specific type of child. I used factory pattern to define a function that
returns the right type of child strategy object. ChildFactory class contains a function that creates a
specific type of child. The function takes two parameters, an AgeCategory object, that specifies
the type of child we want to create and a list of scores that will be assigned to the child
that we create.
In Main class we will just call the getAverageScore method without verifying the age category of the
child, this aspect is verified by the factory and strategy patterns.

## Parse the input from json file

To parse the input from json files I used Jackson. I created a class for every type
of object that can be found in the input files.

##InputData contains the numberOfYears, santaBudget, and also information about
initialData and the list with annualChanges.

##InitialData contains the information needed at the first round
- a list of children
- a list with gifts
- a list of cities

##AnnualChanges : A change specifies new data that needs to replace old data.
- newSantaBudget
- List with new gifts that need to be added
- list with new children that need to be added
- updates for children

##ChildUpdate : Contains as parameters the properties of an object of child type
that need to be changed
- id, that specifies the child that we apply the updates on
- niceScore, a new value for the niceScore of the child
- giftsPreferences, a list with new preferences for gifts

##Write the output to json file

I used separated classes to write the output into json files

##ChildOutput : Contains all the information about a child that need to be written in
the json file.

##CompleteOutput : Contains a list with objects of ChildOutput type.

##AnnualChildren : Contains a list with objects of CompleteOutput type.
An object of CompleteOutput type represents the list of children and their information
specific for a certain round.
