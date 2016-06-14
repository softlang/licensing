/* The MIT License (MIT)

Copyright (c) 2016 Kevin Schmidt

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. */

DISCLAIMER: Project is still in the planning phase. Only some testing will be going on here for the next few months. 
Functionality not guaranteed. Usage at own risk.

@author: schmidtkevin
@mail: schmidtkevin@uni-koblenz.de

TODO:
=====
- Optimization issues (it is working, but not pretty)
- Exception handling
- In-File TODO's
- solve known bugs
- Delete empty projects


Project description:
====================
This project is part of a masters thesis in computer science. It aims to collect open source projects from GitHub via the API and clones them locally.
There are some unsolved issues that will be solved later on, however, it is working. In case you want to use this program, you may have to adapt the 
defines given in the main package. The default defines are optimized to my computer (DSL 6000, 4GB Ram, Intel Q6600, 7300rpm HDD).
Please inform me about any exception that occurs during the runtime. 
In case, note that it is fine to just continue the cloning process (remember to not start all over again - comment out in method main)


Package descriptions:
=====================

Package searchCrawler:
	A crawler using the GitHub API v3 to generate a repository list.
	It searches for all existent projects, but GitHub limitations are strict.
	- Request Limitation
	- Search Page Limitation


Package main
	Main method to run the application and defines to set parameters


Package gitClowner
	Clones Repositories from GitHub using the list created from the searchCrawler
	

Package RetrievedData
	Source folder where the list of the search results is saved (and some temp. data)	


Known bugs:
===========
UNSOLVED EXCEPTION: Occured after 53 Projects from the start

	java.util.concurrent.ExecutionException: org.eclipse.jgit.dircache.InvalidPathException: Invalid path: routes/topic/*id.js
	at java.util.concurrent.FutureTask.report(Unknown Source)
	at java.util.concurrent.FutureTask.get(Unknown Source)
	at gitCloner.RepositoryCloner.cloneWithTimeout(RepositoryCloner.java:46)
	at gitCloner.RepositoryCloner.cloneWithTimeout(RepositoryCloner.java:48)
	at gitCloner.RepositoryCloner.cloneWithTimeout(RepositoryCloner.java:48)
	at main.Main.main(Main.java:51)
	Caused by: org.eclipse.jgit.dircache.InvalidPathException: Invalid path: routes/topic/*id.js
	at org.eclipse.jgit.dircache.DirCacheCheckout.checkValidPathSegment(DirCacheCheckout.java:1231)
	at org.eclipse.jgit.dircache.DirCacheCheckout.checkValidPath(DirCacheCheckout.java:1202)
	at org.eclipse.jgit.dircache.DirCacheCheckout.processEntry(DirCacheCheckout.java:314)
	at org.eclipse.jgit.dircache.DirCacheCheckout.prescanOneTree(DirCacheCheckout.java:293)
	at org.eclipse.jgit.dircache.DirCacheCheckout.doCheckout(DirCacheCheckout.java:410)
	at org.eclipse.jgit.dircache.DirCacheCheckout.checkout(DirCacheCheckout.java:396)
	at org.eclipse.jgit.api.CloneCommand.checkout(CloneCommand.java:258)
	at org.eclipse.jgit.api.CloneCommand.call(CloneCommand.java:136)
	at gitCloner.RepositoryCloner.cloneRepository(RepositoryCloner.java:82)
	at gitCloner.RepositoryCloner$1.call(RepositoryCloner.java:41)
	at java.util.concurrent.FutureTask.run(Unknown Source)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
	at java.lang.Thread.run(Unknown Source)
	Caused by: org.eclipse.jgit.errors.CorruptObjectException: name contains '*'
	at org.eclipse.jgit.lib.ObjectChecker.scanPathSegment(ObjectChecker.java:461)
	at org.eclipse.jgit.lib.ObjectChecker.checkPathSegment(ObjectChecker.java:522)
	at org.eclipse.jgit.dircache.DirCacheCheckout.checkValidPathSegment(DirCacheCheckout.java:1228)
	... 13 more	