MonacoFX
==========

[![Build Status](https://travis-ci.org/tom91136/MonacoFX.svg?branch=master)](https://travis-ci.org/tom91136/MonacoFX)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Download](https://api.bintray.com/packages/tom91136/maven/monacofx/images/download.svg)](https://bintray.com/tom91136/maven/monacofx/_latestVersion)

Embedded VisualStudioCode editor(monaco) for JavaFX
 
Features

 * Fully configurable Java interfaces, no TypeScript/JavaScript required
 * Works in Swing via JFXPanel
 * Mostly works in SceneBuilder*
 * Zero dependency

## How to use

For Maven users, add the following to pom
```xml
<dependency>
    <groupId>net.kurobako.monacofx</groupId>
    <artifactId>monacofx</artifactId>
    <version>0.1.0</version>
</dependency>
```
You also need to add jcenter repo to your pom:
```xml
<repositories>
    <repository>
        <id>jcenter</id>
        <url>https://jcenter.bintray.com/</url>
    </repository>
</repositories>
```

For SBT
```scala
"net.kurobako.monacofx" % "monacofx" % "0.1.0"    
```
And also jcenter:
```scala
resolvers ++= Seq(Resolver.jcenterRepo)
```

Alternatively, you can download the jar [here](https://dl.bintray.com/tom91136/maven/net/kurobako/monacofx/monacofx/0.1.0/monacofx-0.1.0.jar)
 and add it to your classpath. This library has no dependencies so you do not need to download 
anything else.
 
Version history in available in [CHANGELOG.md](CHANGELOG.md)

## Quick start

// TODO 

For more interesting examples, take a look at the [samples](monacofx-sample/src/main/java/net/kurobako/monacofx/sample).

## Samples

Several samples have been included demoing interesting uses of the gesture pane.

You can download the sample jar [here](https://dl.bintray.com/tom91136/maven/net/kurobako/monacofx/monacofx-sample/0.2.0/monacofx-sample-0.2.0-jar-with-dependencies.jar) 
or clone the project and run:

    ./mvnw install
    ./mvnw exec:java -pl monacofx-sample

## How to build

Prerequisites:

 * JDK 8 

Clone the project and then in project root:

    # *nix:
    ./mvnw clean package 
    # Windows:
    mvnw clean package

This project uses maven wrapper so you do not need to install maven
beforehand.

For testing on new platforms, it is recommended to run tests headful. Add the headful flag to test
with real window:

    mvnw test -Dheadful

**NOTE: Be aware that running the tests headful will spawn actual windows and take over the mouse 
and keyboard; you will see the test window flicker while different unit tests are invoked.**

## Motivation

We currently have [RickTextFX](https://github.com/FXMisc/RichTextFX) but sometimes you just want a 
quick and easy side-by-side diff view or perhaps a quick JSON editor embedded inside your app.


## Licence

    Copyright 2018 WEI CHEN LIN
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.