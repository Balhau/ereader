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

## Example of usage

By calling the following code

    annotationRootPath --> Path for your annotation folder files
    sqlitePath --> path for sqlite database

    CybookAnnotationsImporter annotationImporter = new CybookAnnotationsImporter(annotationRootPath);
    SQLiteImporter sqlImporter = new SQLiteImporter(sqlitePath);
    CybookAPI api = new CybookAPI(annotationImporter,sqlImporter);
    List<CybookBook> readingBooksOnlyWithAnnotations=api.getOnlyBooksWithAnnotations();
    readingBooksOnlyWithAnnotations.get(0).toJSON()

you end up with something like this

    {
      "readed": false,
      "bookID": 287,
      "bookURI": "/mnt/sd/Malcolm, Gladwell,/Outliers_ The Story of Success - Gladwell, Malcolm.epub",
      "pages": 256,
      "currpage": 172,
      "lastread": "May 26, 2016 7:53:42 AM",
      "publicationDate": "2010-06-03T04:00:00+00:00",
      "publisher": "",
      "annotations": {
        "value": {
          "bookURI": "/home/vitorfernandes/IdeaProjects/balhau/ereader/target/test-classes/cybook/annotations/Malcolm, Gladwell,/Outliers_ The Story of Success - Gladwell, Malcolm.epub.annot",
          "annotation": [
            " And whyBecause we cling to \n        the idea that success is a simple function of individual merit and that the world in \n        which we all grow up and the rules we choose to write as a society don't matter at all.",
            " He compared the \n        ages when they started walking and talking and what their precise IQ scores were in \n        elementary and high school. In the end, only one thing mattered: family background.\n       The As overwhelmingly came from the middle and the upper class. Their homes were filled \n        with books. Half the fathers of the A group had a college degree or beyond, and this at a time when a \n        university education was a rarity. The Cs, on the other hand, were from the other side \n        of the tracks. Almost a third of them had a parent who had dropped out of school before \n        the eighth grade.",
            "In nineteen eighty, if you went to the Business Roundtable [the association of major \n        American corporate executives] and took surveys about whether hostile takeovers should be \n        allowed, two-thirds would have said no,” Flom said. “Now, the vote would be almost \n        unanimously yes.” Companies needed to be defended against lawsuits from rivals. Hostile \n        suitors needed to be beaten back. Investors who wanted to devour unwilling targets needed help with their legal strategy, and shareholders \n        needed formal representation. The dollar figures involved were enormous. From the mid-1970s to the end of the 1980s, the amount of money involved in mergers and acquisitions every year on Wall Street \n        increased 2,000 percent, peaking at almost a quarter of a trillion dollars",
            "Bill Gates had that same feeling when he \n        first sat down at the keyboard at Lakeside. And the Beatles didn't recoil in horror when \n        they were told they had to play eight hours a night, seven days a week. They jumped at the \n        chance. Hard work is a prison sentence only if it does not have meaning. Once it does, it \n        becomes the kind of thing that makes you grab your wife around the waist and dance a jig"
          ]
        }
      },
      "documentTime": "Apr 5, 2015 1:41:10 PM",
      "title": "Outliers: The Story of Success",
      "description": "",
      "author": "Gladwell, Malcolm"
    }
