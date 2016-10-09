# EReader Utilities

## Introduction

### What is this?

This project is a component whose main purpose is to manage information presented in several (in this case two) ereader platforms. For the most immediate objective is to integrate cybook annotations and statistical information presented in the SQLite database contained in the flash memory and/or sd card that holds the data of the ereader.

### Why ?

I like to read. I spend lots of time with my E-Reader (I've got two but nowadays I just use my cybook ocean) and as all we know ereader devices store lots of interesting information. Somewhere inside this little device we know that it is stored how many books I read, how many pages per book, when the book was added to the device, the last time I read a specific book. Well lots of hidden information is hidden somewhere in these amazing devices.

### So whats next?
So my purpose is simple. Just provide a way to extract and serve this information. The idea is to develop several components, being some of them:

* Creation of an data extraction API and datastore injection component (this one)
* Creation of a webservice that will extract the data previously injected in the datastore
* Creation of web application that will render all the interesting information previously extracted and stored.
