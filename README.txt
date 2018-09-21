Keywords android custtom view attrs.xml attributes button

My problem was that I needed to add an attribute to a button that was accessed through a style.  The app I'm working on has abou5 250 buttons of 4 types that are in a grid and all very similar.  I can easly initialize each using a custom style but I wanted an easy way to tell what type each button is in it's onClick method.  I thought I could do this in styles but it turned out not to be the case.

I finally solved the problem using a "custom button" ie: a button with one (or more) custom attributes.

This involved
1)  A class that extended the Button class for my custom button and the custom attribute I want to add.
2)  Defining a styleable in attrs.xml that describes the custom attribute(s).
3)  Creating a layout with the different styles that also set the "type" attribute string I added.
