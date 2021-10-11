

/*
 *  UCF COP3330 Fall 2021 Exercise 43 Solution
 *  Copyright 2021 Timothy Azinord
 */

package com.company;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class WebsiteGenerator {

    //Create attributes of the website to be set by the user.
    String siteName;
    String author;
    String path;

    //Create function to create the website folder.
    public String createWebsite() {

//Set our directory and create the file with that path
        String directory = path + siteName;
        File newFolder = new File(directory);

//Create the folder and return the directory for testing purposes
        newFolder.mkdirs();
        return directory;


    }

    //Create function to create the JS folder
    public String createJSFolder() {

//Set our directory and create the file with that path
        String directory = path + siteName + "/js";
        File newFolder = new File(directory);

//Create the folder and return the directory for testing purposes
        newFolder.mkdirs();
        return directory;


    }

    //Create a function to create the CSS folder
    public String createCSSFolder() {

//Set our directory and create the file with that path
        String directory = path + siteName + "/css";
        File newFolder = new File(directory);

//Create the folder and return the directory for testing purposes
        newFolder.mkdirs();
        return directory;

    }

    //Create a function to create the HTML file
    public String createHTMl() {

//Establish path
        String directory = path + siteName + "/index.html";

//Create whatever is going to go inside the file
        String htmlContent = "<title> " + siteName + " </title>\n<meta> " + author + " </meta>";

//Create the file
        File file = new File(directory);

        try {

//Write on the file.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(htmlContent);
            writer.close();
            return directory;

//Exit if any exceptions are found.
        } catch(Exception ex) {

            return "Failure";
        }

    }
    public static void main(String[] args) {

//Input
        Scanner newScan = new Scanner(System.in);

        String siteName;
        String author;
        String wantCSS;
        String wantJS;

        System.out.print("Site name: ");
        siteName = newScan.nextLine();
        System.out.print("Author: ");
        author = newScan.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        wantJS = newScan.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        wantCSS = newScan.nextLine();


//Create a website generator
        WebsiteGenerator newWebsite = new WebsiteGenerator();

//Set the attributes for the website
        newWebsite.siteName = siteName;
        newWebsite.author = author;
        newWebsite.path = "src/main/java/ex43/";

//Create the website and the HTML file
        System.out.println("Created " + newWebsite.createWebsite());
        System.out.println("Created " + newWebsite.createHTMl());


    }
}
