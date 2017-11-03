# QuotesTrevorTiffany

## App Overview

## Contributors
- [Tiffany Le-Nguyen](github.com/sirmerr)
- [Trevor Eames]
Hello world baseline code for Assignment 1

Begin by creating a branch of the Master, coordinate with your teammate to modify the code and merge pull requests.

Eventually you must replace this README with one that contains:
* your app name
* your names
* what the app does

Be sure to follow the [Protected Branch Workflow](https://github.com/Android518-2017/git-workflow)

## Review 
* [git-workflow](https://github.com/Android518-2017/git-workflow)
* [general](https://drive.google.com/open?id=1lo4pILADxl4YcSrMcl0JJDyq4w9tEtgzDTO7Xyr1ZmU)

* [code guidelines](https://drive.google.com/open?id=16JAWKc7wJUgX-tk7aZ12anViPTENov1Svd9kkTmpUiw)

You will follow this codelabs tutorial that creates a chat application with individual sign up and authentication, notifications and other cool stuff  in order to learn how to use firebase (firebase is a cloud hosted NoSQL database where data is stored as JSON.)  (nice one for the CV!)

## Overview
Tutorial:   [https://codelabs.developers.google.com/codelabs/firebase-android](https://codelabs.developers.google.com/codelabs/firebase-android)/

This tutorial needs Android api v 26. which is not installed in the lab (so will have to be installed every time you use it).  You may want to Instead work with A ToDo app with authentication: [https://www.sitepoint.com/creating-a-cloud-backend-for-your-android-app-using-firebase/](https://www.sitepoint.com/creating-a-cloud-backend-for-your-android-app-using-firebase/)

You will create an app that uses   [firebase](https://firebase.google.com/docs/android/setup).  The database will not require user authentication (you will do authentication without user intervention, so one id/password, done by code without asking the user), you will not update the database from the app\*.

It will be read only and the database will be populated through the firebase console, manually.

For more on reading & writing to firebase in Android see [https://firebase.google.com/docs/database/android/read-and-write](https://firebase.google.com/docs/database/android/read-and-write)

Using images in Android & firebase see:

[https://firebase.google.com/docs/storage/android/download-files#downloading\_images\_with\_firebaseui](https://firebase.google.com/docs/storage/android/download-files#downloading_images_with_firebaseui)

## Database

You will define the firebase JSON / database as having:

- [ ] Category (for example: sci fi, romance, computer science, science, celebrities, politicians, fictional characters, etc)

* [ ] Small Image for each category (smaller than 10MB due to firebase spec)

* [ ] Multiple quotes per category, for each quote have:
    - [ ] Attributed (name of the person the quote is attributed to)
    - [ ] Date of birth (of person who said the quote)
    - [ ] Blurb  (one sentence of information about the person who said the quote)
    - [ ] Quote short (30 char)
    - [ ] Quote full ( the quote text itself )
    - [ ] Reference (url of the site where you found the quote)
    - [ ] Date (date added)  YYYY-MM-DD

[Suggested ERD](https://drive.google.com/file/d/0B-CHlg81QPjfU25PbWI0VGYtbzQ/view?usp=sharing)   but firebase is NOSQL so see [how to structure firebase including best practices](https://firebase.google.com/docs/database/web/structure-data)

To populate the database decide on minimum 5 categories and have minimum 4 quotes for each. Get real quotes from the web for example from   [https://en.wikiquote.org/wiki/Main\_Page](https://en.wikiquote.org/wiki/Main_Page)

Populate the database via the console: [http://mariechatfield.com/tutorials/firebase/step2.html](http://mariechatfield.com/tutorials/firebase/step2.html)

## Behaviour

- [ ] `MainActivity` on launch will show  ListView or RecyclerView populated with the categories from firebase.  When a user clicks on the category launch QuoteListActivity

- [ ] `QuoteListActivity` will show a ListView or RecyclerView and display the short quote for all quotes in that category.  When a user clicks on the short quote launch QuoteActivity

- [ ] `QuoteActivity` display all of the information associated with the quote, except the blurb.  Include the image for the category. Design it nicely, the URI must be clickable, name it refernce    Format the Views nicely.  The name attributed is clickable and will show a dialogue containing the blurb information with one button to dismiss.

[Dialog](https://developer.android.com/guide/topics/ui/dialogs.html)

All activites are to have the same options menu with the following (do not duplicate code, see the Menus ppts, use the name MenuActivity)

- [ ] About: it will launch a single AboutActivity.

- [ ] Random: it will choose a random category & random quote and display it.
- [ ] Last: it will show the last quote from the previous runtime

You will have to save the last quote for the next runtime.

AboutActivity must contain information about the app, your names and an image (your photo(s))

## App Name

Make the app name Quotes<name1><name2>  so that it will be unique when I install. Use the first name only, for each team member.  For example if Ada Lovelace was working with Grace Hopper  the name would be QuotesAdaGrace

## Collaboration (you may NOT do this solo)

You will do this assignment with a [teacher assigned partner.](https://docs.google.com/spreadsheets/d/1S3rkvnp0wGZkONimtI9jGYbM77eEcgN-g74v6uQF6AI/edit?usp=sharing)  Use the protected branch workflow from git lab 3 [READ the workflow overview again](https://github.com/Android518-2017/git-workflow)

I will create a repo and assign you and your partner access.

Before you do anything create a separate staging branch and a branch for each teammate.  (Ex:  Ada & Grace team99, branches:  master, staging, ada, grace)    Never push to master,  never push to staging.   Each of you must perform a code review on the other&#39;s pull requests.   Most expectations are in the workflow overview but see also [collaboration expectations](https://docs.google.com/document/d/1lo4pILADxl4YcSrMcl0JJDyq4w9tEtgzDTO7Xyr1ZmU/edit?usp=sharing).

There are issue & PR templates, they are a starting point, you may add more and remove what you don&#39;t need.

Due in two weeks,  I will clone master once the deadline expires, ensure all of your changes are applied to it via a merged pull request. [
](https://docs.google.com/document/d/1lo4pILADxl4YcSrMcl0JJDyq4w9tEtgzDTO7Xyr1ZmU/edit)

## Learning Objectives

* Firebase Realtime NoSQL Database

* UI layouts, widgets
* State, SharedPreferences
* Activity lifecycle
* Views and ViewGroups

* Drawable resources
* Adapters and AdapterViews

* String resources
* Explicit Intents
* Collaboration using git/github

## Extras/Bonus

If you complete this part of the project too quickly and want a challenge  you may implement an Activity that adds quotes to the database and a delete for individual quotes. **DO NOT attempt this untill your app is fully functional per the preceeding spec.**

## References

* [Reading & writing to firebase in Android](https://firebase.google.com/docs/database/android/read-and-write)
* [Using images in Android & firebase](https://firebase.google.com/docs/storage/android/download-files#downloading_images_with_firebaseui)

* [Firebase Storage](https://firebase.google.com/docs/storage/)
* [Creating a Dialog](https://developer.android.com/guide/topics/ui/dialogs.html)
* [ToDo app with authentication](https://www.sitepoint.com/creating-a-cloud-backend-for-your-android-app-using-firebase/)
* [Firebase Setup with Android](https://firebase.google.com/docs/android/setup)
* [Tutorial on using firebase (no mobile)](https://github.com/mchat/tutorials/tree/master/firebase)
